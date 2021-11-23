package ge.softlab.store.service;

import ge.softlab.store.model.Sales;
import ge.softlab.store.repository.SaleRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService{

    SaleRepositroy saleRepositroy;
    @Autowired
    SalesServiceImpl(SaleRepositroy saleRepositroy){

        this.saleRepositroy=saleRepositroy;
    }

    @Override
    public void add(Sales sales) {
        saleRepositroy.save(sales);
    }
@Override
    public List<Sales> getByDate(LocalDateTime date) {;


        return saleRepositroy.findAllBySellDate(date);
    }
}
