package ge.softlab.store.service;

import ge.softlab.store.model.Sales;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public interface SalesService {
    public List<Sales> getByDate(LocalDateTime date);

    public void add(Sales sales);
}
