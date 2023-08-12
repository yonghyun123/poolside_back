package poolside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poolside.entity.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

}
