package aiin.backend.domains.member.domain;

import lombok.Getter;

@Getter
public enum MemberRole {
    USER("USER"),
    ADMIN("ADMIN");

    private final String value;

    MemberRole(String value) {
        this.value = value;
    }
}
