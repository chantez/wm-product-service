package com.supercon.repository;

import com.supercon.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> searchProduct(final String name);

}
































