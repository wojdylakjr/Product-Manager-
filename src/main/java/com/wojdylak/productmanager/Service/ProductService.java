package com.wojdylak.productmanager.Service;

import com.wojdylak.productmanager.exception.ProductNotFoundException;
import com.wojdylak.productmanager.model.Product;
import com.wojdylak.productmanager.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public Product findProductById(Long id) {
        return productRepo.findProductById(id).orElseThrow(() -> new ProductNotFoundException("Product by id: " + id + "was not found"));
    }


    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteProductById(id);
    }
}
