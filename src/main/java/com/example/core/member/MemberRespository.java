package com.example.core.member;

public interface MemberRespository {
    void save(Member member);
    Member findById(Long memberId);
}
