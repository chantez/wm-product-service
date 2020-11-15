package com.wm.products.config;


import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoConfig {

    @Value("${mongo.username}")
    private String username;

    @Value("${mongo.password}")
    private String password;

    @Value("${mongo.connectionString}")
    private String connection;

    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString(connection);

        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(username, "admin", password.toCharArray());
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
               .credential(mongoCredential)

                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "promotions");
    }
}
