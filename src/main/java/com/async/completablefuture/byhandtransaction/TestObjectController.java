package com.async.completablefuture.byhandtransaction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class TestObjectController {

    private final TestObjectService testObjectService;

    @RequestMapping(path = "/v1/test", method = RequestMethod.POST)
    public ResponseEntity<TestObject> create(@RequestBody TestObject testObject) throws ExecutionException, InterruptedException {

        log.info("starting with the object {}", testObject);

        final var response = this.testObjectService.save(testObject);

        log.info("response {}", response);

        return ResponseEntity.ok(response);
    }

}
