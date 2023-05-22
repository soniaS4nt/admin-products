package com.eadmin.eadmin.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigInteger;

@Document(collection = "products")
    public class Product {

       /*    @Id
         private UUID id = UUID.randomUUID();*/
        @Id
        @Getter @Setter
        private  String id;

        @Getter @Setter
        private  String name;

        @Getter @Setter
        private  BigInteger price;

    }
