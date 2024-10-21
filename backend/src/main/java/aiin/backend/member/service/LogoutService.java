package aiin.backend.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aiin.backend.member.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LogoutService {

	private final RefreshTokenRepository refreshTokenRepository;

	public Boolean existsByAccessToken(String accessToken) {
        return refreshTokenRepository.existsByAccessToken(accessToken);
    }
}
