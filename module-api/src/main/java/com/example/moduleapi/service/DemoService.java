package com.example.moduleapi.service;

import com.example.moduleapi.exception.CustomException;
import com.example.modulecommon.domain.Member;
import com.example.modulecommon.enums.CodeEnum;
import com.example.modulecommon.repository.MemberRepository;
import com.example.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

//    private final CommonDemoService commonDemoService;

    @Value("${profile-name}")
    private String name;

    private final MemberRepository memberRepository;

    public String save() {
        System.out.println("name : " + name);
        memberRepository.save(Member.builder()
                .name(Thread.currentThread().getName())
                .build());

        return "save";
    }

    public String find() {
        int size = memberRepository.findAll().size();
        System.out.println("DB Size : " + size);
        System.out.println("name : " + name);
        return "find";
    }

    public String exception() {
        if(true)
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);

        return "exception";
    }
}
