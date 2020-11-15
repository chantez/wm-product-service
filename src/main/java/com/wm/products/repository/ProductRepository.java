package com.wm.products.repository;

import com.wm.products.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> searchProduct(final String name);

}
































