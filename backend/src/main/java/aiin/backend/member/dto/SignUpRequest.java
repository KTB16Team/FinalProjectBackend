package aiin.backend.member.dto;

import java.time.LocalDateTime;

import aiin.backend.member.model.Gender;
import aiin.backend.member.model.MemberRole;
import aiin.backend.member.model.Provider;

public record SignUpRequest(
	String username,
	String email,
	String password,
	Gender gender,
	String phoneNumber,
	LocalDateTime birth)
{
}
