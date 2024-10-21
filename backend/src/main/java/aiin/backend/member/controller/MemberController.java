package aiin.backend.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aiin.backend.member.dto.DeleteRequest;
import aiin.backend.member.dto.SignUpRequest;
import aiin.backend.util.dto.DataResponse;
import aiin.backend.auth.security.jwtFilter.JwtTokenProvider;
import aiin.backend.member.memberLoader.MemberLoader;
import aiin.backend.member.entity.Member;
import aiin.backend.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private final JwtTokenProvider jwtTokenProvider;
	private final MemberLoader memberLoader;

	@PostMapping("/logout")
	public ResponseEntity<DataResponse<Void>> logoutMember(HttpServletRequest request) {
		Member member = memberLoader.getMember();
		String accessToken = jwtTokenProvider.extractAccessToken(request).orElse(null);
		String refreshToken = jwtTokenProvider.extractRefreshToken(request).orElse(null);

		memberService.logoutMember(member, accessToken, refreshToken);

		return ResponseEntity
			.ok(DataResponse.ok());
	}

	@PostMapping("/signup")
	public ResponseEntity<DataResponse<Void>> signupMember(@RequestBody SignUpRequest signUpRequest) {
		memberService.signUp(signUpRequest);

		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(DataResponse.created());
	}

	@PostMapping("/delete")
	public ResponseEntity<DataResponse<Void>> deleteMember(@RequestBody DeleteRequest deleteRequest) {
		memberService.deleteMember(deleteRequest);

		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(DataResponse.ok());
	}
}
