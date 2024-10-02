package aiin.backend.domains.member.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aiin.backend.domains.member.domain.Logout;

@Repository
public interface LogoutRepository extends CrudRepository<Logout, String> {

	boolean existsByAccessToken(String accessToken);
}
