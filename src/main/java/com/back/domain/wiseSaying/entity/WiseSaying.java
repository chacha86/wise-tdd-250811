package com.back.domain.wiseSaying.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class WiseSaying {
    private int id;
    private String saying;
    private String author;

    public WiseSaying(String saying, String author) {
        this.saying = saying;
        this.author = author;
    }

    public boolean isNew() {
        return id == 0;
    }

    public Map<String, Object> toMap() {
        return Map.of(
                "id", id,
                "saying", saying,
                "author", author
        );
    }

    public static WiseSaying fromMap(Map<String, Object> map) {
        WiseSaying wiseSaying = new WiseSaying(
                (String) map.get("saying"),
                (String) map.get("author")
        );
        wiseSaying.setId((Integer) map.get("id"));
        return wiseSaying;
    }
}
