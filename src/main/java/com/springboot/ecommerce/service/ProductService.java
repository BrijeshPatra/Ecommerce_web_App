package com.springboot.ecommerce.service;
import com.springboot.ecommerce.model.Product;
import com.springboot.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    public void addProduct(Product product){
        productRepo.save(product);
    }
    public void removeProductById(long id){
        productRepo.deleteById(id);
    }
    public Optional<Product>getProductById(long id){
        return productRepo.findById(id);
    }
    public List<Product>getAllProductsByCategoryId(long id){
        return productRepo.findAllByCategory_Id(id);
    }
}
