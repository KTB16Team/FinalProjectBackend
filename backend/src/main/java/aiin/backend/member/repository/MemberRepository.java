package aiin.backend.member.repository;

import aiin.backend.member.entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    void deleteMemberByEmail(String email);
}
