package com.example.jpaboard.service;

import com.example.jpaboard.dto.SignUpResponseDto;
import com.example.jpaboard.entity.Member;
import com.example.jpaboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String username, String password, Integer age) {

        Member member = new Member(username, password, age);
        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUserName(), savedMember.getAge());
    }

}
