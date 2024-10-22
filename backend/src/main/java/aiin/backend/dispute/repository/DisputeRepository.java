package aiin.backend.dispute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aiin.backend.dispute.entity.Dispute;

public interface DisputeRepository extends JpaRepository<Dispute, Long> {
}
