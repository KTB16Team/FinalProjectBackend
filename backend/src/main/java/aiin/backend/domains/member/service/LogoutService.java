package aiin.backend.domains.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aiin.backend.domains.member.domain.Logout;
import aiin.backend.domains.member.repository.LogoutRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LogoutService {

	private final LogoutRepository logoutRepository;

	public Boolean existsByAccessToken(String token) {
        return logoutRepository.existsByAccessToken(token);
    }

	public void save(Logout logoutToken) {
		logoutRepository.save(logoutToken);
	}
}
