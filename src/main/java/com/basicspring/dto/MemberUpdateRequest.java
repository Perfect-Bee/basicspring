package com.basicspring.dto;

import lombok.Getter;
// request에는 final, 생성자 X
@Getter
public class MemberUpdateRequest {

    private String name;
}
