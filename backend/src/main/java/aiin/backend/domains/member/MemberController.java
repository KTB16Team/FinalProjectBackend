package aiin.backend.domains.member;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aiin.backend.common.dto.DataResponse;
import aiin.backend.common.security.filter.jwtFilter.JwtTokenProvider;
import aiin.backend.common.util.memberLoader.MemberLoader;
import aiin.backend.domains.member.domain.Member;
import aiin.backend.domains.member.service.MemberService;
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

		memberService.logoutMember(member, accessToken);

		return ResponseEntity.ok(DataResponse.ok());
	}
}
