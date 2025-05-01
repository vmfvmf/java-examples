package com.vmfvmf.controllerservicestrategy;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(MyController.class)
class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MyService myService;

    @Test
    void testCreate_shouldReturn201() throws Exception {
        MyEntityDto inputDto = new MyEntityDto(null, "Example");
        MyEntityDto outputDto = new MyEntityDto(1L, "Example");

        Mockito.when(myService.create(any())).thenReturn(outputDto);

        mockMvc.perform(post("/my-entity")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(inputDto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1L));
    }

    private static String asJsonString(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}