package com.bl.demo.controller;
import com.bl.demo.service.IQuantityConversionService;
import com.bl.demo.service.Quantity;
import com.bl.demo.service.QuantityUnits;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class QuantityConversionApplicationTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IQuantityConversionService quantityConversionService;
    List<Quantity> quantityList=new ArrayList<>();
    ObjectMapper objectMapper=new ObjectMapper();

    public QuantityConversionApplicationTests() {
        this.quantityList.add(Quantity.VOLUME);
        this.quantityList.add(Quantity.LENGTH);
    }

    @Test
    public void givenQuantity_whenSelect_shouldReturnListOfQuantity() throws Exception {
        when(quantityConversionService.getListOfQuantity()).thenReturn(this.quantityList);
        MvcResult mvcResult = this.mockMvc.perform(get("/quantity")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String quantitiesJson = mvcResult.getResponse().getContentAsString();
        Quantity[] quantities = objectMapper.readValue(quantitiesJson, Quantity[].class);
        System.out.println(quantities[0]);
        Assert.assertEquals(2, quantities.length);
    }
}