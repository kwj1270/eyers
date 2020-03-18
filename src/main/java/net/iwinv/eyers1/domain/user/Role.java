package net.iwinv.eyers1.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("USER", "일반 사용자"),
    ADMIN("ADMIN", "관리자");

    private final String key;
    private final String title;

    public String getKey(){
        return this.key;
    }

    public String getTitle(){
        return this.title;
    }
}
