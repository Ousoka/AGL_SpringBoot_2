package uam.dsti.sb_online_shop.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
    // Any custom query methods can be added here if needed
}
