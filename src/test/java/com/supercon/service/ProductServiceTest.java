package com.supercon.service;

import com.supercon.service.impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductServiceTest {

    private ProductServiceImpl productService;

    @Before
    public void setup() throws Exception {
        productService = new ProductServiceImpl();
    }

    @Test
    public void isPalindromo_true() {
        assertTrue(productService.isPalindromo("ada"));
        assertTrue(productService.isPalindromo("adda"));
        assertTrue(productService.isPalindromo("adjda"));
        assertTrue(productService.isPalindromo("cadac"));
        assertTrue(productService.isPalindromo("bellolleb"));
    }

    @Test
    public void isPalindromo_false() {
        assertFalse(productService.isPalindromo("adaa"));
        assertFalse(productService.isPalindromo("asdda"));
        assertFalse(productService.isPalindromo("caldac"));
        assertFalse(productService.isPalindromo("belslolleb"));
        assertFalse(productService.isPalindromo(""));
        assertFalse(productService.isPalindromo("a"));
        assertFalse(productService.isPalindromo("ab"));
        assertFalse(productService.isPalindromo("aaabaa"));
    }

}