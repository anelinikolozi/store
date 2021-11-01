package ge.softlab.store.service;

import ge.softlab.store.model.Products;
import ge.softlab.store.model.Purchases;
import ge.softlab.store.model.Sales;
import ge.softlab.store.repository.ProductRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository;
    SalesService salesService;
    PurchaseServiceImpl purchaseServiceImpl;


    @Autowired
    ProductServiceImpl(ProductRepository productRepository, SalesService salesService, PurchaseServiceImpl purchaseServiceImpl){
        this.salesService = salesService;
        this.productRepository=productRepository;
        this.purchaseServiceImpl = purchaseServiceImpl;
    }

    @Override
    public Products add(Products products) {
        return productRepository.save(products);


    }

    @Override
    public List<Products> get() {
        return productRepository.findAll();
    }

    @Override
    public Products getProduct(Long id) throws NotFoundException {

        return productRepository.findById(id).orElseThrow(()->new NotFoundException("Customer with given id not found"));
    }

    @Override
    public void sellProducts(Long id) throws NotFoundException {


        Products products=productRepository.findById(id).orElseThrow(()->new NotFoundException("not found"));
        if(products.getRemaining()>0){
            products.setRemaining(products.getRemaining()-1);
            productRepository.save(products);
            Sales sales= new Sales();
            sales.setProductId(products.getEanCode());
            sales.setSellPrice(products.getSellPrice());
            Date date=new Date();
            SimpleDateFormat mdyFormat = new SimpleDateFormat("dd-MM-yyyy");
            sales.setSellDate(mdyFormat.format(date));
            salesService.add(sales);
        }
        else throw new NotFoundException("not enough");

    }

    @Override
    public void buyProducts(Long id) throws NotFoundException {
        Products products=productRepository.findById(id).orElseThrow(()->new NotFoundException(""));
        products.setRemaining(products.getRemaining()+1);
        productRepository.save(products);
        Purchases purchases=new Purchases();
        purchases.setProductId(products.getEanCode());
        purchases.setPurchasePrice(products.getSellPrice());
        Date date=new Date();
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd-MM-yyyy");
        purchases.setPurchaseDate(mdyFormat.format(date));

        purchaseServiceImpl.add(purchases);

    }
}
