package com.example.SpringEcomProject.repository;

import com.example.SpringEcomProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    //@Query("selecet * from Product where Product.name=Laptop")
    //List<Product> search(String keyword);
}
