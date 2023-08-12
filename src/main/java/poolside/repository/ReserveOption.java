package poolside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveOption extends JpaRepository<ReserveOption, Long> {
}
