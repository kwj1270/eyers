package net.iwinv.eyers.domain.user.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);
    Optional<User> findByUserId(String userId);
    Optional<User> findByStudentId(String studentId);
    Optional<User> findByNickName(String nickname);
    Optional<User> findByUserIdAndPassword(String userId, String password);

}
