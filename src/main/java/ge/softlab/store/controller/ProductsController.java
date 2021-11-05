package ge.softlab.store.controller;

import ge.softlab.store.model.Products;
import ge.softlab.store.service.ProductService;
import ge.softlab.store.service.ProductServiceImpl;
import javassist.NotFoundException;
import org.apache.commons.lang3.tuple.MutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductsController {
    ProductService productService;

    @Autowired
    ProductsController(ProductService productService) {

        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Products> addProduct(@RequestBody Products products) {
        products.setEanCode(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.add(products));
    }


    @GetMapping
    public List<Products> getProducts() {
        return productService.get();
    }


    @PatchMapping("{id}/sales")
    public ResponseEntity<String> sellProduct(@PathVariable Long id) {
        try {
            productService.sellProducts(id);
            return ResponseEntity.ok().body("Thanks for the purchase");
        } catch (NotFoundException e) {
            if (e.getMessage().equals("not found"))
                return ResponseEntity.badRequest().body("Product not found");
            else return ResponseEntity.badRequest().body("Product is out of stock");
        }
    }

    @PatchMapping("{id}/purchases")
    public ResponseEntity<String> purchaseProduct(@PathVariable Long id) {
        try {
            productService.buyProducts(id);
            return ResponseEntity.ok().body("product purchased");
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body("Product doesnt exist");
        }
    }



}

