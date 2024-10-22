package aiin.backend.dispute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aiin.backend.dispute.entity.AudioRecord;

public interface AudioRepository extends JpaRepository<AudioRecord, Long> {
}
