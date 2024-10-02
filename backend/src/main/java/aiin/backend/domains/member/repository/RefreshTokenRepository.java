package aiin.backend.domains.member.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import aiin.backend.domains.member.domain.RefreshToken;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {

	Optional<RefreshToken> findByMemberId(Long memberId);

	void deleteByMemberId(Long MemberId);
}
