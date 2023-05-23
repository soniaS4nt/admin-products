package com.eadmin.eadmin.controllersTest;

import com.eadmin.eadmin.controllers.ProductController;
import com.eadmin.eadmin.models.Product;
import com.eadmin.eadmin.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Test
    void shouldCreateProduct() {
        // Arrange
        Product productToCreate = new Product("1", "Product 1", 1000);
        Mockito.when(productService.createProduct(Mockito.any(Product.class))).thenReturn(productToCreate);
        ProductController productController = new ProductController(productService);

        // Act
        ResponseEntity<Product> response = productController.createProduct(productToCreate);

        // Assert
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Product createdProduct = response.getBody();
        Assertions.assertNotNull(createdProduct);
        Assertions.assertEquals("1", createdProduct.getId());
        Assertions.assertEquals("Product 1", createdProduct.getName());
        Assertions.assertEquals(1000, createdProduct.getPrice());
    }

}
