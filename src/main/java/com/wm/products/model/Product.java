package com.wm.products.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class Product {

    private  Double price;

    @Id
    private ObjectId _id;
    private  Long id;
    private  String productCode;
    private  String name;
    private  String brand;
    private  String description;
    private  String image;

    public Product(){

    }
    public Product(Long id, Double price, String brand, String description, String image){
        this.price = price;
        this.id = id;
        this.brand = brand;
        this.description = description ;
        this.image = image;
    }

    public Product(Double price, String productCode, String name) {
        this.price = price;
        this.productCode = productCode;
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() { return price; }

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }


}
