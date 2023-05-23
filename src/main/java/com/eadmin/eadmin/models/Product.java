package com.eadmin.eadmin.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
    public class Product {
    /*    @Id
            private UUID id = UUID.randomUUID();*/
    @Id
    private  String id;
    private  String name;
    private  int price;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
