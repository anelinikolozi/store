package ge.softlab.store.repository;

import ge.softlab.store.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PurchaseRepositroy extends JpaRepository<Purchases,Long> {
}
