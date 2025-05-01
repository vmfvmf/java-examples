package com.vmfvmf.controllerservicestrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyMapperTest {

	@Autowired
    private MyMapper mapper;

    @Test
    void testToDto_shouldMapFieldsCorrectly() {
        MyEntity entity = new MyEntity(1L, "Test");
        MyEntityDto dto = mapper.toDto(entity);

        assertNotNull(dto);
        assertEquals("Test", dto.something());
        assertEquals(1L, dto.id());
    }

    @Test
    void testToEntity_shouldMapFieldsCorrectly() {
    	MyEntityDto dto = new MyEntityDto(1L, "Test");
        MyEntity entity = mapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals("Test", entity.getSomething());
        assertEquals(1L, entity.getId());
    }
}