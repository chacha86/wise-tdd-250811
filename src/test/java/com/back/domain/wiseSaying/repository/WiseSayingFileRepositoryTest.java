package com.back.domain.wiseSaying.repository;

import com.back.AppContext;
import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.standard.util.Util;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingFileRepositoryTest {

    private final WiseSayingFileRepository wiseSayingFileRepository;

    public WiseSayingFileRepositoryTest() {
        wiseSayingFileRepository = AppContext.wiseSayingFileRepository;
    }

    @BeforeAll
    static void beforeAll() {
        AppContext.init();
    }

    @BeforeEach
    void beforeEach() {
        WiseSayingFileRepository.clear();
    }

    @Test
    @DisplayName("저장")
    void t1() {
        WiseSaying wiseSaying = new WiseSaying("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "괴테");
        wiseSayingFileRepository.save(wiseSaying);

        WiseSaying foundWiseSaying = wiseSayingFileRepository.findByIdOrNull(1);

        assertThat(
                foundWiseSaying
        ).isEqualTo(wiseSaying);
    }

    @Test
    @DisplayName("저장을 2번 하면 1,2번 명언이 저장된다.")
    void t2() {
        WiseSaying wiseSaying1 = new WiseSaying("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "괴테");
        WiseSaying wiseSaying2 = new WiseSaying("너 자신을 알라", "소크라테스");
        wiseSayingFileRepository.save(wiseSaying1);
        wiseSayingFileRepository.save(wiseSaying2);

        WiseSaying foundWiseSaying1 = wiseSayingFileRepository.findByIdOrNull(1);
        WiseSaying foundWiseSaying2 = wiseSayingFileRepository.findByIdOrNull(2);

        assertThat(
                foundWiseSaying1
        ).isEqualTo(wiseSaying1);

        assertThat(
                foundWiseSaying2
        ).isEqualTo(wiseSaying2);
    }

    @Test
    @DisplayName("명언 삭제")
    void t3() {
        WiseSaying wiseSaying1 = new WiseSaying("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "괴테");
        WiseSaying wiseSaying2 = new WiseSaying("너 자신을 알라", "소크라테스");
        wiseSayingFileRepository.save(wiseSaying1);
        wiseSayingFileRepository.save(wiseSaying2);

        wiseSayingFileRepository.delete(wiseSaying2);
        WiseSaying foundWiseSaying2 = wiseSayingFileRepository.findByIdOrNull(2);

        assertThat(
                foundWiseSaying2
        ).isNull();
    }
}
