package com.wojdylak.productmanager.repository;

import com.wojdylak.productmanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {


}
