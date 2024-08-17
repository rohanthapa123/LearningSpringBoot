package com.rohan.FirstProject.Services;

import com.rohan.FirstProject.Model.Product;
import com.rohan.FirstProject.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServices {

    @Autowired
    ProductRepo repo;

//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101 , "Mobile", 15000.00 , 4),
//            new Product(120 , "Oven" , 35000.00 , 4)
//    ));


    public List<Product> getProducts(){
        return  repo.findAll();
    }

    public Product getProduct(int prod_id){
        return repo.findById(prod_id).orElse(new Product());
    }


    public void addProduct(Product prod){
        repo.save(prod);
    }

    public void updateProduct(Product prod){
        repo.save(prod);

    }

    public void deleteProduct(int prod_id){
        repo.deleteById(prod_id);

    }

}
