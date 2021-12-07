package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.StringJoiner;

@Document(collection = "docs")
public class Doc {

    private ObjectId id;
    private AbstractBase a;

    public Doc(ObjectId id, AbstractBase a) {
        this.id = id;
        this.a = a;
    }

    public AbstractBase getA() {
        return a;
    }

    public void setA(AbstractBase a) {
        this.a = a;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Doc.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("a=" + a)
                .toString();
    }
}
