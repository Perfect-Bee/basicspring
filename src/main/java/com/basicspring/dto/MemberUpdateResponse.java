package com.basicspring.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberUpdateResponse {
    // 응답은 DB 갔다 온 뒤
    private final Long id;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public MemberUpdateResponse(Long id, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
