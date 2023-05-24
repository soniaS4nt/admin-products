package com.eadmin.eadmin.controllers;

import com.eadmin.eadmin.models.Product;
import com.eadmin.eadmin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(("/api/products"))
public class ProductController {
    @Autowired
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PatchMapping("updateBy/{id}")
    public ResponseEntity<String> updateOne(@PathVariable String id, @RequestBody Product productUpdated) {
        Product optionalProduct = productService.updateProduct(id, productUpdated);
        return  ResponseEntity.ok("Product updated successfully!");
    }

    @GetMapping("getBy/{id}")
    public Product getProduct(@PathVariable String id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK).getBody();
    }

    @DeleteMapping("deleteBy/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id){
        Product product = productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully!");
    }
}
