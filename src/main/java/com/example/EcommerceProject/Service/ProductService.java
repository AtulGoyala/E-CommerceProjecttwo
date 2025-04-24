package com.example.EcommerceProject.Service;

import com.example.EcommerceProject.Model.Product;
import com.example.EcommerceProject.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepo productrepo;

    public List<Product> getAllProduct(){
        return productrepo.findAll();
    }

    public Product getProductById(Long id){
        return productrepo.findById(id).orElseThrow(()->new RuntimeException("Product with id " + id + " not found"));
    }

    public void createProduct(Product Product){
        productrepo.save(Product);
    }

    public void updateProduct(Product Product){
        productrepo.findById(Product.getId()).orElseThrow(()-> new RuntimeException("Product with id" + Product.getId()+ " not Found"));
        productrepo.save(Product); // Ensure you save the updated entity
    }

    public void deleteProduct(Long id){
        productrepo.findById(id).orElseThrow(()-> new RuntimeException("Product with id" + id + " not Found"));
        productrepo.deleteById(id);
    }

    public Product findProductByName(String  name){
        return productrepo.findByName(name);
    }
}