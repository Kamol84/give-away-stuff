package pl.kamol84.giveawaystuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamol84.giveawaystuff.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
