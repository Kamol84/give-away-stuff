package pl.kamol84.giveawaystuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamol84.giveawaystuff.entity.Gift;

public interface GiftRepository extends JpaRepository<Gift, Long> {
}
