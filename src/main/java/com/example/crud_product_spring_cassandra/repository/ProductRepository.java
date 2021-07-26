package com.example.crud_product_spring_cassandra.repository;

import com.example.crud_product_spring_cassandra.model.ProductModel;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProductRepository extends CassandraRepository<ProductModel, Integer> {
}
