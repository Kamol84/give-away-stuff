package pl.kamol84.giveawaystuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamol84.giveawaystuff.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
