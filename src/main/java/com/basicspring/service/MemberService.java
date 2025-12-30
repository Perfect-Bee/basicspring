package com.basicspring.service;

import com.basicspring.dto.MemberCreateRequest;
import com.basicspring.dto.MemberCreateResponse;
import com.basicspring.repository.MemberRepository;
import com.basicspring.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;

    // MemberController의 return값 body 중...
    @Transactional
    public MemberCreateResponse save(MemberCreateRequest request){
        Member member = new Member(request.getName());
        Member savedMamber = memberRepository.save(member);
        return new MemberCreateResponse(
                savedMamber.getId(),
                savedMamber.getName(),
                savedMamber.getCreatedAt(),
                savedMamber.getModifiedAt()
        );
    }
}
