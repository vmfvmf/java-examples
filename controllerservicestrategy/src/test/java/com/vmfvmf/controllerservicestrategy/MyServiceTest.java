package com.vmfvmf.controllerservicestrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MyServiceTest {

    @InjectMocks
    private MyService myService;

    @Mock
    private MyRepository repository;

    @Mock
    private MyMapper mapper;

    @Test
    void testCreate_shouldReturnDto() {
        MyEntityDto dto = new MyEntityDto(null, "Test");
        MyEntity entity = new MyEntity("Test");
        MyEntity saved = new MyEntity(1L, "Test");
        MyEntityDto resultDto = new MyEntityDto(1L, "Test");

        Mockito.when(mapper.toEntity(dto)).thenReturn(entity);
        Mockito.when(repository.save(entity)).thenReturn(saved);
        Mockito.when(mapper.toDto(saved)).thenReturn(resultDto);

        MyEntityDto result = myService.create(dto);
        assertEquals(1L, result.id());
    }
}