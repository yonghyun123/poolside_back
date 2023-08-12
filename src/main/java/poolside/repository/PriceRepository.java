package poolside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poolside.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}
