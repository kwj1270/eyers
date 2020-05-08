package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 로그인시에 필요한 User 정보만 모아둔 클래스

@Getter // getter 메소드 자동 생성
@Setter // setter 메소드 자공 생성
@NoArgsConstructor // 생성자 의존성 주입
public class UserLoginRequestDto {

    private String userId;
    private String userPw;

    @Builder
    public UserLoginRequestDto(String userId, String userPw){
        this.userId = userId;
        this.userPw = userPw;
    }

}
