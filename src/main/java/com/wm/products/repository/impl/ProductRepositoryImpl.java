package com.supercon.repository.impl;

import com.supercon.model.Product;
import com.supercon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {


    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Product>  searchProduct(final String name) {
        List<Criteria> criterias = new ArrayList<>();

        Criteria criteriaBrand = Criteria.where("brand").regex(name);
        Criteria criteriaDescription = Criteria.where("description").regex(name);
        criterias.add(criteriaBrand);
        criterias.add(criteriaDescription);

        if(isLong(name)){
            long id = Long.parseLong(name);
            Criteria criteriaId = Criteria.where("id").is(id);
            criterias.add(criteriaId);
        }

        Criteria[] criteriaArrays = criterias.stream().toArray(Criteria[]::new);

        List<Product> products = mongoTemplate.find(
                Query.query(new Criteria().orOperator(criteriaArrays)), Product.class);

        return products;
    }


    private boolean isLong(String name){

        boolean isLong = true;

        try {

            Long.parseLong(name);
        }
        catch (NumberFormatException nfe){
            isLong = false;
        }

        return isLong;
    }

}
































