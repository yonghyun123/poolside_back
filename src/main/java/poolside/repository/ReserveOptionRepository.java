package poolside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poolside.entity.ReserveOption;

@Repository
public interface ReserveOptionRepository extends JpaRepository<ReserveOption, Long> {
}
