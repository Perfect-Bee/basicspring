package com.basicspring.controller;

import com.basicspring.repository.MemberRepository;
import com.basicspring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
}
