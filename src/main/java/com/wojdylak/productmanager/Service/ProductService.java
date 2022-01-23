package com.wojdylak.productmanager.Service;

import com.wojdylak.productmanager.model.Product;
import com.wojdylak.productmanager.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product){
        return productRepo.save(product);
    }
}
