package com.ajay.practice.config;

import com.mongodb.client.MongoClients;
import com.mongodb.MongoClientSettings;
import com.mongodb.ConnectionString;
import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexDefinition;



@Configuration
public class MongoConfig {

    @Value("${mongo.connectionString}")
    private String connectionString;

    @Value("${mongo.db_name}")
    private String myCricketAppDB;

    @Primary
    @Bean(name = "myCricketAppDB")
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDatabaseFactory(myCricketAppDB));
        initIndexes(mongoTemplate);
        return mongoTemplate;
    }

    private MongoDatabaseFactory mongoDatabaseFactory(String databaseName) {
        MongoClientSettings settings = MongoClientSettings.builder()
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .applyConnectionString(new ConnectionString(connectionString))
                .build();
        return new SimpleMongoClientDatabaseFactory(MongoClients.create(settings), databaseName);
    }

    private void initIndexes(MongoTemplate mongoTemplate) {
        IndexOperations indexOps = mongoTemplate.indexOps("team");
        IndexDefinition indexDef = new Index().on("teamName", Sort.Direction.ASC).unique();
        indexOps.ensureIndex(indexDef);
    }
}
