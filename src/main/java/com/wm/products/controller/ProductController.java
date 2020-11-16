package com.wm.products.controller;

import com.wm.products.model.FoundProduct;
import com.wm.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/v1/product/search/{name}")
    public ResponseEntity<FoundProduct> searchProduct(@PathVariable final String name) {
        final FoundProduct foundProduct = productService.searchProduct(name);
        return new ResponseEntity<>(foundProduct, HttpStatus.OK);
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
