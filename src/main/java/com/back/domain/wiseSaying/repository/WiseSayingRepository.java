package com.back.domain.wiseSaying.repository;

import com.back.standard.dto.PageDto;
import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public WiseSaying save(WiseSaying wiseSaying) {
        if (wiseSaying.isNew()) {
            wiseSaying.setId(++lastId);
            wiseSayings.add(wiseSaying);
        }

        return wiseSaying;
    }

    public boolean delete(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public WiseSaying findByIdOrNull(int id) {

        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public PageDto findByContentContainingDesc(String kw, int pageSize, int pageNo) {
        List<WiseSaying> filteredContent = wiseSayings.reversed().stream()
                .filter(w -> w.getSaying().contains(kw))
                .toList();

        return pageOf(filteredContent, pageNo, pageSize);
    }

    public PageDto findByAuthorContainingDesc(String kw, int pageSize, int pageNo) {

        List<WiseSaying> filteredContent =  wiseSayings.reversed().stream()
                .filter(w -> w.getAuthor().contains(kw))
                .toList();

        return pageOf(filteredContent, pageNo, pageSize);
    }

    public PageDto findByContentContainingOrAuthorContainingDesc(String kw, int pageSize, int pageNo) {
        List<WiseSaying> filteredContent = wiseSayings.reversed().stream()
                .filter(w -> w.getAuthor().contains(kw) || w.getSaying().contains(kw))
                .toList();

        return pageOf(filteredContent, pageNo, pageSize);
    }


    public PageDto pageOf(List<WiseSaying> content, int pageNo, int pageSize) {
        int totalItems = content.size();
        List<WiseSaying> paginatedContent = content.stream()
                .skip((pageNo - 1) * pageSize)
                .limit(pageSize)
                .toList();

        return new PageDto(pageNo, pageSize, totalItems, paginatedContent);

    }
}
