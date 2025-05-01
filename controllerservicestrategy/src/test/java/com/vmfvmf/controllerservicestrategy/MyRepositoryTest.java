package com.vmfvmf.controllerservicestrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MyRepositoryTest {

    @Autowired
    private MyRepository repository;

    @Test
    void testSaveAndFind() {
        MyEntity entity = new MyEntity("Test");
        MyEntity saved = repository.save(entity);

        Optional<MyEntity> found = repository.findById(saved.getId());
        assertTrue(found.isPresent());
        assertEquals("Test", found.get().getSomething());
    }
}