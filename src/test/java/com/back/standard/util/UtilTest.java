package com.back.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {
    @Test
    @DisplayName("파일 생성")
    public void t1() {
        // given
        // file 경로가 주어지고
        String filePath = "temp/test.txt";

        // when
        // touch를 실행하면
        Util.file.touch(filePath);

        // then
        // 해당 경로에 파일이 생성되어 존재하는지 확인
        assertThat(
                Util.file.exists(filePath)
        ).isTrue();

        Util.file.delete(filePath);
    }

    @Test
    @DisplayName("")
    public void t2() {
        // given
        // file 경로가 주어지고
        String filePath = "temp/test.txt";

        // when
        // touch를 실행하면
        Util.file.touch(filePath);

        // then
        // 해당 경로에 파일이 생성되어 존재하는지 확인
        assertThat(
                Util.file.exists(filePath)
        ).isTrue();

        Util.file.delete(filePath);
    }

}
