package com.wm.products.model;

import java.util.ArrayList;
import java.util.List;

public class FoundProduct{

    private boolean isPalindromo;

    private List<Product> foundProducts = new ArrayList<>();

    public FoundProduct(List<Product> foundProducts , boolean isPalindromo){
        this.foundProducts = foundProducts;
        this.isPalindromo = isPalindromo;
    }

    public List<Product> getFoundProducts() {
        return foundProducts;
    }

    public void setFoundProducts(List<Product> foundProducts) {
        this.foundProducts = foundProducts;
    }

    public boolean isPalindromo() {
        return isPalindromo;
    }

    public void setPalindromo(boolean palindromo) {
        isPalindromo = palindromo;
    }
}
