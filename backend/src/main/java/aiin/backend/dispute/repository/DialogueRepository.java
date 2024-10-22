package aiin.backend.dispute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aiin.backend.dispute.entity.DialogueRecord;

public interface DialogueRepository extends JpaRepository<DialogueRecord, Long> {
}
