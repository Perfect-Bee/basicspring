package com.basicspring.controller;

import com.basicspring.dto.MemberCreateResponse;
import com.basicspring.dto.MemberCreateRequest;
import com.basicspring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
// CRUD : 생성(Created), 조회(Read), 업데이트(Update), 삭제(Delete)
    // 조회는 전체조회와 단건조회로 세부 분류

    // 생성
    // RestAPI니까 복수(s)
    @PostMapping("/members")
    public ResponseEntity<MemberCreateResponse> create(
            @RequestBody MemberCreateRequest request
    ){

    }

}
