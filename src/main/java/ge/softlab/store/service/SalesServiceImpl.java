package ge.softlab.store.service;

import ge.softlab.store.model.Sales;
import ge.softlab.store.repository.SaleRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
    public List<Sales> getByDate(Date date) {
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd-MM-yyyy");


        return saleRepositroy.findAllBySellDate(mdyFormat.format(date));
    }
}
