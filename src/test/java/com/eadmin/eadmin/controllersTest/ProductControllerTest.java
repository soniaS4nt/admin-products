package com.eadmin.eadmin.controllersTest;

import com.eadmin.eadmin.controllers.ProductController;
import com.eadmin.eadmin.models.Product;
import com.eadmin.eadmin.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductControllerTest {

    @MockBean
    private ProductService productService;
    @InjectMocks
    private ProductController productController;


    @Test
    void shouldCreateProduct() {
        // Arrange
        Product productToCreate = new Product("1", "Product 1", 1000);
        when(productService.createProduct(Mockito.any(Product.class))).thenReturn(productToCreate);
        ProductController productController = new ProductController(productService);

        // Act
        ResponseEntity<Product> response = productController.createProduct(productToCreate);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Product createdProduct = response.getBody();
        assertNotNull(createdProduct);
        assertEquals("1", createdProduct.getId());
        assertEquals("Product 1", createdProduct.getName());
        assertEquals(1000, createdProduct.getPrice());
    }




    @Test
    void shouldGetAllProducts() {
        // Arrange
        ProductService productService = mock(ProductService.class);
        ProductController productController = new ProductController(productService);

        List<Product> products = Arrays.asList(
                new Product("1", "Product 1", 1000),
                new Product("2", "Product 2", 2000),
                new Product("3", "Product 3", 3000)
        );
        when(productService.getAllProducts()).thenReturn(products);

        // Act
        ResponseEntity<List<Product>> response = productController.getAllProducts();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
    }
}




