package com.example.bookservice.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.IDynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class DynamoDBConfig {

    @Autowired
    AWSCredentialsProvider awsCredentialsProvider;

    AmazonDynamoDB getAmazonDynamoDB (){
        final AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(awsCredentialsProvider)
                .withRegion(Regions.US_EAST_1)
                .build();

        return amazonDynamoDB;

    }
    DynamoDBMapper getDynamoDBMapper(){
        return  new DynamoDBMapper(getAmazonDynamoDB());
    }

}
