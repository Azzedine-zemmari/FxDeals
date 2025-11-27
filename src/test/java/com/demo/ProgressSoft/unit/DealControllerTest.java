package com.demo.ProgressSoft.unit;

import com.demo.ProgressSoft.controller.DealController;
import com.demo.ProgressSoft.dto.DealDto;
import com.demo.ProgressSoft.service.DealService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DealController.class)
public class DealControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DealService dealService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createDeal_sucess() throws Exception{
        DealDto dto = new DealDto();
        dto.setId(2L);
        dto.setTimestamp(LocalDateTime.now());
        dto.setFromCurrency("USD");
        dto.setToCurrency("EUR");
        dto.setAmount(300.2);

        Mockito.when(dealService.importDeal(any(DealDto.class))).thenReturn("Deal imported successfully");

        mockMvc.perform(post("/api/v1/deal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto))
        ).andExpect(status().isOk())
                .andExpect(content().string("Deal imported successfully"));

    }
    @Test
    void createDeal_badRequest() throws Exception{
        DealDto dto = new DealDto();
        dto.setTimestamp(LocalDateTime.now());
        dto.setFromCurrency("USD");
        dto.setToCurrency("EUR");
        dto.setAmount(300.2);


        mockMvc.perform(post("/api/v1/deal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto))
        ).andExpect(status().isBadRequest());
    }
}
