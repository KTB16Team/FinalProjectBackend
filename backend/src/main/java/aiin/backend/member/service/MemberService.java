package aiin.backend.member.service;

import aiin.backend.auth.exception.ApiException;
import aiin.backend.auth.exception.ErrorCode;
import aiin.backend.member.dto.DeleteRequest;
import aiin.backend.member.dto.SignUpRequest;
import aiin.backend.member.entity.Member;
import aiin.backend.member.entity.RefreshToken;
import aiin.backend.member.mapper.MemberMapper;
import aiin.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final RefreshTokenService refreshTokenService;

    // 이메일로 멤버 조회
    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    // 회원 가입
    @Transactional
    public void signUp(SignUpRequest signUpRequest) {
        Member member = MemberMapper.signUpMemberEntity(signUpRequest);
        memberRepository.save(member);
    }


    //로그아웃
    @Transactional
    public void logoutMember(Member member, String accessToken, String refreshToken) {
        // 회원의 refreshToken 만료 처리
        RefreshToken expiredToken = new RefreshToken(accessToken, refreshToken);
        refreshTokenService.save(expiredToken);
    }

    @Transactional
    public void deleteMember(DeleteRequest deleteRequest) {
        Member member = memberRepository
            .findByEmail(deleteRequest.email())
            .orElseThrow(()-> ApiException.from(ErrorCode.MEMBER_NOT_FOUND));

        memberRepository.delete(member);
    }
}
