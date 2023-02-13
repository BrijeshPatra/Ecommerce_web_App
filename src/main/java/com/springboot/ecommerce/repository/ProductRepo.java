package com.springboot.ecommerce.repository;

import com.springboot.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {

    List<Product> findAllByCategory_Id(long id);

}
