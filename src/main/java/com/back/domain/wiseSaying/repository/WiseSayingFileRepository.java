package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.standard.util.Util;

import java.util.Map;

public class WiseSayingFileRepository {

    public void save(WiseSaying wiseSaying) {

        if(wiseSaying.isNew()) {

            incrementLastId();
            int lastId = getLastId();
            wiseSaying.setId(lastId);
            String jsonStr = Util.json.toString(wiseSaying.toMap());
            Util.file.set("db/wiseSaying/%d.json".formatted(wiseSaying.getId()), jsonStr);
        }

    }

    private void incrementLastId() {
        Util.file.set("db/wiseSaying/lastId.txt", String.valueOf(getLastId() + 1));
    }

    private int getLastId() {

       return Util.file.getAsInt("db/wiseSaying/lastId.txt", 0);
    }

    public WiseSaying findByIdOrNull(int id) {
        String jsonStr = Util.file.get("db/wiseSaying/%d.json".formatted(id), "");

        if(jsonStr.isEmpty()) {
            return null;
        }

        Map<String, Object> map = Util.json.toMap(jsonStr);
        WiseSaying wiseSaying = new WiseSaying(map);

        return wiseSaying;
    }
}
