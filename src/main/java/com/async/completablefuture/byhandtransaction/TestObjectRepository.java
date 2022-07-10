package com.async.completablefuture.byhandtransaction;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestObjectRepository extends CrudRepository<TestObject, Long> {
}
