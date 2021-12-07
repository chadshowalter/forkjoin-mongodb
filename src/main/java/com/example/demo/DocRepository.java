package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface DocRepository extends CrudRepository<Doc, ObjectId> {
}
