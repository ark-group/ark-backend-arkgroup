package com.arkbackendarkgroup.controller;

import com.arkbackendarkgroup.exception.ProductNotFoundException;
import com.arkbackendarkgroup.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setProductId("1");
        honey.setProductName("Honey");
        productRepo.put(honey.getProductId(), honey);

        Product almond = new Product();
        almond.setProductId("2");
        almond.setProductName("Honey");
        productRepo.put(honey.getProductId(), almond);
    }

    @GetMapping("/products")
    public ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>(productRepo.values(),HttpStatus.OK);
    }

    @PutMapping("/products/{productId")
    public ResponseEntity<Object> updateProduct(@PathVariable("productId") String productId,
                                                @RequestBody Product product){

        if(!productRepo.containsKey(productId)){
            throw new ProductNotFoundException();
        }

        productRepo.remove(productId);
        product.setProductId(productId);

        productRepo.put(productId,product);

        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("productId") String productId){

        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }
}
