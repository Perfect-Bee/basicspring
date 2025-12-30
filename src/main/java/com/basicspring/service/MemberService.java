package com.basicspring.service;

import com.basicspring.dto.MemberCreateRequest;
import com.basicspring.dto.MemberCreateResponse;
import com.basicspring.dto.MemberGetResponse;
import com.basicspring.repository.MemberRepository;
import com.basicspring.entity.Member;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    // MemberController에서 findAll(전체조회) 기능 추가
    @Transactional(readOnly = true)
    public List<MemberGetResponse> findAll() {
        List<Member> members = memberRepository.findAll();
        //List<Member> 타입 MemberGetResponse 타입으로 바꾸기
        // 그릇 필요
        List<MemberGetResponse> dtos = new ArrayList<>();
        for (Member member : members) {
            MemberGetResponse response = new MemberGetResponse(
                    member.getId(),
                    member.getName(),
                    member.getCreatedAt(),
                    member.getModifiedAt()
            );
            dtos.add(response);
        }
        return dtos;
    }

    // 맴버 Respository에서 memberId를 찾을거임(findAll에서는 전부 찾는 거였고)
    // findAll은 빈 리스트가 존재했음. 근데, 이건 없음(null : 위험)
    @Transactional(readOnly = true)
    public MemberGetResponse findOne(Long memberId) {
        // null 대신 던져 ->  Optional 맴버 없으면 던져(orElseThrow)
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalStateException("없는 맴버입니다.")
        );
        return new MemberGetResponse(
                member.getId(),
                member.getName(),
                member.getCreatedAt(),
                member.getModifiedAt()
        );
    }
}
