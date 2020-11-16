package com.wm.products.service.impl;

import com.wm.products.model.FoundProduct;
import com.wm.products.model.Product;
import com.wm.products.repository.ProductRepository;
import com.wm.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public FoundProduct searchProduct(final String name) {

        List<Product> products = productRepository.searchProduct(name);

        boolean isPalindromo = isPalindromo(name);
        FoundProduct foundProduct = new FoundProduct(products, isPalindromo);
        return foundProduct;
    }

    private boolean isPalindromo(String name){
        boolean isPalindromo = false;

        if(name != null && name.length() >= 0){

            boolean passing = true;
            int init = 0;
            int end = name.length() - 1;

            while(passing && init <= end){

                if(name.charAt(init) != name.charAt(end)){
                    passing = false;
                }

                init++;
                end--;
            }

            isPalindromo = passing;

        }


        return isPalindromo;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
































