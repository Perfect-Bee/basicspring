package com.basicspring.controller;

import com.basicspring.dto.MemberCreateResponse;
import com.basicspring.dto.MemberCreateRequest;
import com.basicspring.dto.MemberGetResponse;
import com.basicspring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        // body 괄호 안에 있는 건 아래 코드를 압축한 것
        // body(response) =
        // MemberCreateResponse response = memerService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.save(request));
    }

    // 조회
    // 전체조회
    @GetMapping("/members")
    public ResponseEntity<List<MemberGetResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findAll());
    }
}
