package com.wojdylak.productmanager.repository;

import com.wojdylak.productmanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    void deleteById(Long id);

    Optional<Product> findById(Long id);
}
