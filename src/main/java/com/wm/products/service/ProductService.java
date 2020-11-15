package com.supercon.service;

import com.supercon.model.FoundProduct;
import com.supercon.model.Product;

public interface ProductService {

    FoundProduct searchProduct(final String name);
}
