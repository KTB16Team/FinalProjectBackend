package aiin.backend.common.security.filter.loginFilter;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aiin.backend.domains.member.domain.Member;
import aiin.backend.domains.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final MemberService memberService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberService.findByEmail(username)
			.orElseThrow(() -> new UsernameNotFoundException("해당하는 회원을 찾을 수 없습니다."));

		String pw = member.getPw();
		String role = member.getMemberRole().getValue();

		return User.builder()
			.username(username)
			.password(pw)
			.roles(role)
			.build();
	}
}
