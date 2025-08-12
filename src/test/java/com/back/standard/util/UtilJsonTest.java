package com.back.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilJsonTest {

    @Test
    @DisplayName("Map을 Json으로 바꿀 수 있다.")
    void t1() {

        Map<String, Object> map = new HashMap();

        map.put("name", "홍길동");
        map.put("age", 20);
        map.put("home", "서울");

        // 변환
        String json = Util.json.toString(map);

        // json에 값이 있는지 확인
        assertThat(json).isEqualTo(
                """
                        {
                            "name": "홍길동",
                            "age": 20,
                            "home": "서울"
                        }"""
        );

    }

}


