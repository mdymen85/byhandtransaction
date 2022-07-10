package com.async.completablefuture.byhandtransaction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class TestObjectService {

    private final TestObjectRepository testObjectRepository;

    public TestObject save(TestObject testObject) throws ExecutionException, InterruptedException {

        log.info("going to start completable future...");

        final var asyncProcess = CompletableFuture.supplyAsync(() -> process(testObject));

        log.info("completable future had been thrown...");

        final var result = asyncProcess.get();

        log.info("getting result from completable future {}", result);

        return result;
    }

    private TestObject process(TestObject testObject) {

        log.info("completable future is executing...");

        for (int i = 0; i < 3; i++) {
            try {

                log.info("thread sleep in seconds = {}", i);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info("saving to database {}", testObject);

        return testObjectRepository.save(testObject);
    }
}
