package ge.softlab.store.service;

import ge.softlab.store.model.Products;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Products add(Products products);

    public List<Products> get();

    public Products getProduct(Long id) throws NotFoundException;

    public void sellProducts(Long id) throws NotFoundException;

    public void buyProducts(Long id) throws NotFoundException;
}
