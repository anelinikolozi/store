package ge.softlab.store.service;

import ge.softlab.store.model.Sales;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface SalesService {
    public List<Sales> getByDate(Date date);

    public void add(Sales sales);
}
