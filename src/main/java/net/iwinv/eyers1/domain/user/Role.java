package net.iwinv.eyers1.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // getter 메소드 생성
@RequiredArgsConstructor // final 선언된 변수 의존성 주입
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
// 간단히 말해서 enum 은 같은 메모리에 사용가능한 여러 값을 사용토록 해준다.
// 사용 가능한 값들 중에서 가장 큰 값의 메모리만 사용하고 그보다 작은 메모리를 사용헤도 허용토록 해준다.

// 예를 들면 enum num 에는 3.14 or 1 이란 2개의 값만 들어 갈 수 있다.
// 이때 enum num 의 크기는 Double형인 3.14에 맞춰서 8bit를 할당 받는다.
// 4bit int값 1이 들어와도 8비트중 4비트만 사용하고 4비트는 남겨둔다.

// enum 을 사용하는 이유는 앞서 말했듯이 '사용가능한' 값들을 지정하는 것이다.
// 즉, 앞서 3.14 와 1만 사용가능 하다는 것은 2.14 나 2 는 변수의 값이 될 수 없다.
// 다시 우리 클래스를 보면 USER 와 ADMIN 만 사용 가능하도록 지정했다.
// 그러므로 그 이외의 값이 들어올 수도 없으며 들어오면 에러가 발생된다.