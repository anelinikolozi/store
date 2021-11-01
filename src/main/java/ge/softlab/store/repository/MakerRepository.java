package ge.softlab.store.repository;

import ge.softlab.store.model.Makers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends JpaRepository<Makers,Long> {
}
