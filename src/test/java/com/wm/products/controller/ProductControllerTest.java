package com.wm.products.controller;

import com.wm.products.model.FoundProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import com.wm.products.service.ProductService;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class ProductControllerTest {

    private ProductController productController;

    private ProductService productService;

    @Before
    public void setUp(){
        productController = new ProductController();
        productService = Mockito.mock(ProductService.class);
        productController.setProductService(productService);
    }
    @Test
    public void test1(){

        String search = "test1";

        FoundProduct foundProduct = new FoundProduct(new ArrayList<>(), true);
        Mockito.when(productService.searchProduct(search)).thenReturn(foundProduct);

        ResponseEntity<FoundProduct> response = productController.searchProduct(search);

        Assert.assertEquals(foundProduct, response.getBody());
        Assert.assertTrue(response.getBody().isPalindromo());

    }
}
