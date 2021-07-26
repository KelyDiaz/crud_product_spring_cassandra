package com.example.crud_product_spring_cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    @PrimaryKey
    private int id;
    private String name;
}
