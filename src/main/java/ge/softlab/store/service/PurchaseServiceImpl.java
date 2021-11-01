package ge.softlab.store.service;

import ge.softlab.store.model.Purchases;
import ge.softlab.store.repository.PurchaseRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{
    PurchaseRepositroy purchaseRepositroy;
    @Autowired
    PurchaseServiceImpl(PurchaseRepositroy purchaseRepositroy){

        this.purchaseRepositroy=purchaseRepositroy;
    }
    @Override
    public Purchases add (Purchases purchases){
        return purchaseRepositroy.save(purchases);
    }
}
