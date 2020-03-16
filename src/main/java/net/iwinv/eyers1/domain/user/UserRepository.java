package net.iwinv.eyers1.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    // DAO의 CRUD 기능을 알아서 만들어 준다.
}
