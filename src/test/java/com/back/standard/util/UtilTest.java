package com.back.standard.util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {

    @BeforeAll
    static void beforeAll() {
        Util.file.mkdir("temp");
    }

    @AfterAll
    static void afterAll() {
        Util.file.rmdir("temp");
    }

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

    @Test
    @DisplayName("파일 읽기/쓰기")
    void t2() {
        String filePath = "test.txt";

        // 파일 쓰기
        Util.file.set(filePath, "hello world");

        // 파일 읽기
        String content = Util.file.get(filePath, "");
        assertThat(content).isEqualTo("hello world");

        // 파일 삭제
        Util.file.delete(filePath);
    }

    @Test
    @DisplayName("파일 삭제")
    void t3() {
        String filePath = "test.txt";

        // 파일 생성
        Util.file.touch(filePath);

        // 파일 삭제
        Util.file.delete(filePath);

        // 파일 존재 여부 확인
        assertThat(Util.file.exists(filePath)).isFalse();

    }

    @Test
    @DisplayName("파일 생성 시, 경로에 해당하는 폴더가 없는 경우 폴더 생성")
    void t4() {
        String filePath = "temp/temp/test.txt";

        // 파일 생성
        Util.file.touch(filePath);

        // 파일 존재 여부 확인
        assertThat(Util.file.exists(filePath)).isTrue();

        // 파일 삭제
        Util.file.delete(filePath);

    }

}
