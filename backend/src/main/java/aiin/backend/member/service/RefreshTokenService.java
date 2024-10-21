package aiin.backend.member.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aiin.backend.member.entity.RefreshToken;
import aiin.backend.member.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RefreshTokenService {

	private final RefreshTokenRepository refreshTokenRepository;

	public Optional<RefreshToken> findByAccessToken(String accessToken) {
		return refreshTokenRepository.findByAccessToken(accessToken);
	}

	public void save(RefreshToken refreshToken) {
		refreshTokenRepository.save(refreshToken);
	}
	public Optional<RefreshToken> findByToken(String token) {
		return refreshTokenRepository.findById(token);
	}

	public void deleteByAccessToken(String accessToken) {
		refreshTokenRepository.deleteByAccessToken(accessToken);
	}

	public Boolean existsByAccessToken(String accessToken) { return refreshTokenRepository.existsByAccessToken(accessToken); }
}
