package com.wm.products.service;

import com.wm.products.model.Product;
import com.wm.products.model.FoundProduct;
import com.wm.products.service.impl.ProductServiceImpl;
import com.wm.products.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceTest {

    private ProductServiceImpl productService;

    private ProductRepository productRepository;

    @Before
    public void setup() {
        productService = new ProductServiceImpl();
        productRepository = Mockito.mock(ProductRepository.class);
        productService.setProductRepository(productRepository);
    }

    @Test
    public void searchPalindromo() {

        String searchName = "esadase";

        List<Product> products = new ArrayList<>();
        Product product = createSampleProduct();
        products.add(product);

        Mockito.when(productRepository.searchProduct(searchName)).thenReturn(products);

        FoundProduct foundProduct = productService.searchProduct(searchName);
        Product productToCheck = foundProduct.getFoundProducts().get(0);

        assertEquals(products.size(), foundProduct.getFoundProducts().size());
        assertEquals(product.getBrand(), productToCheck.getBrand());
        assertEquals(product.getDescription(), productToCheck.getDescription());
        assertEquals(product.getImage(), productToCheck.getImage());
        assertTrue(foundProduct.isPalindromo());

        assertTrue(productService.searchProduct("ada").isPalindromo());
        assertTrue(productService.searchProduct("adda").isPalindromo());
        assertTrue(productService.searchProduct("adjda").isPalindromo());
        assertTrue(productService.searchProduct("cadac").isPalindromo());
        assertTrue(productService.searchProduct("bellolleb").isPalindromo());
        assertTrue(productService.searchProduct("a").isPalindromo());
    }

    @Test
    public void searchNoPalindromo() {

        String searchName = "esadnopase";

        List<Product> products = new ArrayList<>();
        Product product = createSampleProduct();
        products.add(product);

        Mockito.when(productRepository.searchProduct(searchName)).thenReturn(products);

        FoundProduct foundProduct = productService.searchProduct(searchName);
        Product productToCheck = foundProduct.getFoundProducts().get(0);

        assertEquals(products.size(), foundProduct.getFoundProducts().size());
        assertEquals(product.getBrand(), productToCheck.getBrand());
        assertEquals(product.getDescription(), productToCheck.getDescription());
        assertEquals(product.getImage(), productToCheck.getImage());
        assertFalse(foundProduct.isPalindromo());

        assertFalse(productService.searchProduct("adaa").isPalindromo());
        assertFalse(productService.searchProduct("asdda").isPalindromo());
        assertFalse(productService.searchProduct("caldac").isPalindromo());
        assertFalse(productService.searchProduct("belslolleb").isPalindromo());
        assertFalse(productService.searchProduct("ab").isPalindromo());
        assertFalse(productService.searchProduct("aaabaa").isPalindromo());
    }

    private Product createSampleProduct() {

        Product product = new Product();
        product.setId(1L);
        product.setBrand("sampleBrand");
        product.setDescription("sampleDescription");
        product.setImage("www.company.cl/catalogo/images/sample.svg");

        return product;
    }

}