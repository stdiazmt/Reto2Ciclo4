package com.usa.ciclo4.reto2ciclo4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String reference;
    private String category;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;
}
