package aiin.backend.domains.member.service;

import aiin.backend.domains.member.domain.Logout;
import aiin.backend.domains.member.domain.Member;
import aiin.backend.domains.member.repository.LogoutRepository;
import aiin.backend.domains.member.repository.MemberRepository;
import aiin.backend.domains.member.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final LogoutRepository logoutRepository;

    // 이메일로 멤버 조회
    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    //로그아웃
    @Transactional
    public void logoutMember(Member member, String accessToken) {
        Long memberId = member.getId();

        // 회원의 refreshToken 삭제
        refreshTokenRepository.deleteByMemberId(memberId);

        // 같은 accessToken으로 다시 로그인하지 못하도록 블랙리스트에 저장
        logoutRepository.save(new Logout(UUID.randomUUID().toString(), accessToken));
    }
}
