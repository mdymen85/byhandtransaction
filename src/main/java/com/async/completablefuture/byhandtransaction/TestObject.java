package com.async.completablefuture.byhandtransaction;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "test_object")
@ToString
public class TestObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    public TestObject() {}

    @Builder
    public  TestObject(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
