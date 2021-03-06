package com.bl.demo.controller;
import com.bl.demo.dto.ConversionDto;
import com.bl.demo.service.IQuantityConversionService;
import com.bl.demo.enumeration.Quantity;
import com.bl.demo.enumeration.QuantityUnits;

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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class QuantityConversionApplicationTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IQuantityConversionService quantityConversionService;
    List<Quantity> quantityList=new ArrayList<>();
    List<QuantityUnits> quantityUnitsList = new ArrayList<>();
    ObjectMapper objectMapper=new ObjectMapper();

    public  QuantityConversionApplicationTests(){
        this.quantityList.add(Quantity.VOLUME);
        this.quantityList.add(Quantity.LENGTH);
        this.quantityUnitsList.add(QuantityUnits.INCH);
        this.quantityUnitsList.add(QuantityUnits.CM);
        this.quantityUnitsList.add(QuantityUnits.FEET);
    }

    @Test
    public void givenQuantity_whenSelect_shouldReturnListOfQuantity() throws Exception {
        when(quantityConversionService.getListOfQuantity()).thenReturn(this.quantityList);
        MvcResult mvcResult = this.mockMvc.perform(get("/unit/quantity")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String quantitiesJson = mvcResult.getResponse().getContentAsString();
        Quantity[] quantities = objectMapper.readValue(quantitiesJson, Quantity[].class);
        Assert.assertEquals(2, quantities.length);
    }

    @Test
    public void givenQuantityUnits_whenSelect_shouldReturnListOfQuantityUnits() throws Exception {
        when(quantityConversionService.getListOfQuantityUnits(Quantity.LENGTH)).thenReturn(this.quantityUnitsList);
        MvcResult mvcResult = this.mockMvc.perform(get("/unit/quantity/LENGTH")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String quantitiesJson = mvcResult.getResponse().getContentAsString();
        QuantityUnits[] quantityUnits = objectMapper.readValue(quantitiesJson, QuantityUnits[].class);
        Assert.assertEquals(3, quantityUnits.length);
    }

    @Test
    public void given2Feetvalue_whenConvertIntoInch_shouldReturn24Inch() throws Exception {
        ConversionDto conversionDto = new ConversionDto(2.0, QuantityUnits.FEET);
        String conversionDtoJson = objectMapper.writeValueAsString(conversionDto);
        when(quantityConversionService.convertQuantityToUnit(any(), any()))
                .thenReturn(conversionDto.value);
        MvcResult mvcResult = this.mockMvc.perform(post("/unit/quantity/conversion/INCH")
                .content(conversionDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String quantityResult = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(String.valueOf(conversionDto.value), quantityResult);
    }

    @Test
    public void given2Inchvalue_whenConvertIntoFeet_shouldReturn2Feet() throws Exception {
        ConversionDto conversionDto = new ConversionDto(2.0, QuantityUnits.INCH);
        String conversionDtoJson = objectMapper.writeValueAsString(conversionDto);
        when(quantityConversionService.convertQuantityToUnit(any(), any()))
                .thenReturn(conversionDto.value);
        MvcResult mvcResult = this.mockMvc.perform(post("/unit/quantity/conversion/FEET")
                .content(conversionDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String quantityResult = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(String.valueOf(conversionDto.value), quantityResult);
    }

    @Test
    public void given1Feetvalue_whenConvertIntoYard_shouldReturnYard() throws Exception {
        ConversionDto conversionDto = new ConversionDto(1.0, QuantityUnits.FEET);
        String conversionDtoJson = objectMapper.writeValueAsString(conversionDto);
        when(quantityConversionService.convertQuantityToUnit(any(), any()))
                .thenReturn(conversionDto.value);
        MvcResult mvcResult = this.mockMvc.perform(post("/unit/quantity/conversion/YARD")
                .content(conversionDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String quantityResult = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(String.valueOf(conversionDto.value), quantityResult);
    }

    @Test
    public void given2Mlvalue_whenConvertIntoLitre_shouldReturnLitreValue() throws Exception {
        ConversionDto conversionDto = new ConversionDto(2.0, QuantityUnits.ML);
        String conversionDtoJson = objectMapper.writeValueAsString(conversionDto);
        when(quantityConversionService.convertQuantityToUnit(any(), any()))
                .thenReturn(conversionDto.value);
        MvcResult mvcResult = this.mockMvc.perform(post("/unit/quantity/conversion/LITRE")
                .content(conversionDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String quantityResult = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(String.valueOf(conversionDto.value), quantityResult);
    }

    @Test
    public void given2Litrelvalue_whenConvertIntoMililitre_shouldReturnMililitreValue() throws Exception {
        ConversionDto conversionDto = new ConversionDto(2.0, QuantityUnits.LITRE);
        String conversionDtoJson = objectMapper.writeValueAsString(conversionDto);
        when(quantityConversionService.convertQuantityToUnit(any(), any()))
                .thenReturn(conversionDto.value);
        MvcResult mvcResult = this.mockMvc.perform(post("/unit/quantity/conversion/ML")
                .content(conversionDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String quantityResult = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(String.valueOf(conversionDto.value), quantityResult);
    }

}
