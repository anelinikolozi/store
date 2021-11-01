package ge.softlab.store.service;

import ge.softlab.store.model.Purchases;
import org.springframework.stereotype.Service;

@Service
public interface PurchaseService {
    public Purchases add (Purchases purchases);
}
