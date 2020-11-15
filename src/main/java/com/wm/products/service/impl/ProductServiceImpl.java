package com.supercon.service.impl;

import com.supercon.model.FoundProduct;
import com.supercon.model.Product;
import com.supercon.repository.ProductRepository;
import com.supercon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Simple source of products: would come from a database in the real world.
    private static final List<Product> ALL_PRODUCTS = new ArrayList<>();

    private List<Product> products;

    public FoundProduct searchProduct(final String name) {

        List<Product> products = productRepository.searchProduct(name);

        boolean isPalindromo = isPalindromo(name);
        FoundProduct foundProduct = new FoundProduct(products, isPalindromo);
        return foundProduct;
    }



    public boolean isPalindromo(String name){
        boolean isPalindromo = false;

        if(name != null && name.length() >= 3){

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
}
































