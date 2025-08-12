package com.back.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    @DisplayName("파일 생성")
    void t1() {
        String filePath = "test.txt";

        // 파일 생성
        Util.file.touch(filePath);

        // 파일 생성 여부 확인
        Util.file.exists(filePath);

        // 파일 삭제
        Util.file.delete(filePath);
    }
}
