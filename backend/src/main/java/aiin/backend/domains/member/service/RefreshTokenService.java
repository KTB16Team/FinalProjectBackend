package aiin.backend.domains.member.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aiin.backend.domains.member.domain.RefreshToken;
import aiin.backend.domains.member.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RefreshTokenService {

	private final RefreshTokenRepository refreshTokenRepository;

	public Optional<RefreshToken> findByMemberId(Long memberId) {
		return refreshTokenRepository.findByMemberId(memberId);
	}

	public void save(RefreshToken refreshToken) {
		refreshTokenRepository.save(refreshToken);
	}

	public Optional<RefreshToken> findByToken(String token) {
		return refreshTokenRepository.findById(token);
	}

	public void deleteByMemberId(Long memberId) {
		refreshTokenRepository.deleteByMemberId(memberId);
	}
}
