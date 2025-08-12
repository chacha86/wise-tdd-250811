package com.back.standard.dto;

import com.back.domain.wiseSaying.entity.WiseSaying;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageDto {

    private int page; //현재 페이지
    private int pageSize; // 페이지당 아이템 수
    private int totalItems; // 전체 아이템 수
    private List<WiseSaying> content;

    public int getTotalPages() {
        return (int) Math.ceil((double) totalItems / pageSize);
    }
}
