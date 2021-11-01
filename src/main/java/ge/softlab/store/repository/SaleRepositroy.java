package ge.softlab.store.repository;

import ge.softlab.store.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepositroy extends JpaRepository<Sales,Long> {

    List<Sales> findAllBySellDate(String string);
}
