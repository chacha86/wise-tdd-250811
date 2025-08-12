package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.standard.util.Util;

import java.util.Map;

public class WiseSayingFileRepository {

    public static void clear() {
        Util.file.delete("db/wiseSaying");
    }

    private String getDbPath() {
        return "db/wiseSaying";
    }

    private String getFilePath(int id) {
        return String.format("%s/%d.json", getDbPath(), id);
    }

    public void save(WiseSaying wiseSaying) {
        if (wiseSaying.isNew()) {

            incrementLastId();
            wiseSaying.setId(getLastId());
            Map<String, Object> wiseSayingMap = wiseSaying.toMap();
            String wiseSayingJson = Util.json.toString(wiseSayingMap);

            Util.file.set(getFilePath(wiseSaying.getId()), wiseSayingJson);

        }
    }

    private void incrementLastId() {
        int lastId = getLastId() + 1;
        Util.file.set("%s/lastId.txt".formatted(getDbPath()), String.valueOf(lastId));
    }

    private int getLastId() {
        return Util.file.getAsInt("%s/lastId.txt".formatted(getDbPath()), 0);
    }



    public WiseSaying findByIdOrNull(int id) {
        String wiseSayingJson = Util.file.get(getFilePath(id), "");
        if (wiseSayingJson.isEmpty()) {
            return null;
        }
        Map<String, Object> wiseSayingMap = Util.json.toMap(wiseSayingJson);

        if (wiseSayingMap.get("id").equals(id)) {
            return WiseSaying.fromMap(wiseSayingMap);
        }

        return null;
    }

    public boolean delete(WiseSaying wiseSaying) {
        return Util.file.delete(getFilePath(wiseSaying.getId()));
    }
}
