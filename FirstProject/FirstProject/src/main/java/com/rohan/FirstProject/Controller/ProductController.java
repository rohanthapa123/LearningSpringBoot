package com.rohan.FirstProject.Controller;

import com.rohan.FirstProject.Model.Product;
import com.rohan.FirstProject.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductServices services ;

    @GetMapping("/products")
    public List<Product> getProduct(){
        return services.getProducts();
    }

    @GetMapping("/products/{prod_id}")
    public Product getProduct(@PathVariable int prod_id){
        return services.getProduct(prod_id);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product prod){
        services.addProduct(prod);
    }

//    @DeleteMapping("/product/${prod_id}")
//    public boolean deleteProduct(@PathVariable int prod_id){
//        return services.deleteProduct(prod_id);
//    }

}
