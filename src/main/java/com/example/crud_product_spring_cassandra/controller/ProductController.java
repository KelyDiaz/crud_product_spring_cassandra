package com.example.crud_product_spring_cassandra.controller;

import com.example.crud_product_spring_cassandra.ResouceNotFoundException;
import com.example.crud_product_spring_cassandra.model.ProductModel;
import com.example.crud_product_spring_cassandra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("products")
    public ProductModel addProduct(@RequestBody ProductModel productModel){
        productRepository.save(productModel);
        return productModel;
    }

    @GetMapping("products/{id}")
    public ResponseEntity<ProductModel> findInd(@PathVariable("id") Integer productId){
        ProductModel productModel = productRepository.findById(productId).orElseThrow(() -> new ResouceNotFoundException("Producto no encontrado"+productId));
        return ResponseEntity.ok().body(productModel);
    }

    @GetMapping("/products")
    public List<ProductModel> getProducts(){
        return productRepository.findAll();
    }

    @PutMapping("products/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable(value = "id") Integer productId,
                                                 @RequestBody ProductModel productDetails) {
        ProductModel product = productRepository.findById(productId)
                .orElseThrow(() -> new ResouceNotFoundException("Product not found for this id :: " + productId));
        product.setName(productDetails.getName());
        final ProductModel updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Integer productId) {
        ProductModel product = productRepository.findById(productId).orElseThrow(
                () -> new ResouceNotFoundException("Product not found::: " + productId));
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
}
