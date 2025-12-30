package com.basicspring.dto;
// MemberController의 MemberCreateResponse을 위해 생성

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberCreateResponse {
    // 응답은 DB 갔다 온 뒤
    private final Long id;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public MemberCreateResponse(Long id, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
