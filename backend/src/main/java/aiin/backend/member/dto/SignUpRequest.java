package aiin.backend.member.dto;

import java.time.LocalDate;

import aiin.backend.member.model.Gender;

public record SignUpRequest(
	String username,
	String email,
	String password,
	Gender gender,
	String phoneNumber,
	LocalDate birth)
{
}
