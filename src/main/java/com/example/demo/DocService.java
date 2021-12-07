package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

@Component
@Slf4j
public class DocService {

    private static final ObjectId ID1 = new ObjectId("61af48d7ad762c526fb29bdf");
    private static final ObjectId ID2 = new ObjectId("61af48d7ad762c526fb29be0");

    private final DocRepository repo;
    private final ExecutorService executor;

    public DocService(DocRepository repo, @Value("${demo.pool.forkjoin:true}") boolean isForkJoin) {
        this.repo = repo;
        repo.save(new Doc(ID1, new Concrete1(1)));
        repo.save(new Doc(ID2, new Concrete2("s2")));
        executor = isForkJoin ? new ForkJoinPool() : Executors.newFixedThreadPool(3);

    }

    @PostConstruct
    public void readDocs(){
        log.info("retrieving docs...");

        Future<?> future = executor.submit(() -> {
                repo.findAll().forEach(d -> {
                    log.info("found: {}", d);
                });
        });
        try{
            future.get();
        } catch (Exception e) {
            log.error("caught exception when retrieving docs", e);
        }
    }

}
