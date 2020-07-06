package com.bl.demo.dto;

import com.bl.demo.enumeration.QuantityUnits;

public class ConversionDto {
    public Double value;
    public QuantityUnits quantityUnits;

    public ConversionDto(){}

    public ConversionDto(Double value, QuantityUnits quantityUnits) {
        this.value = value;
        this.quantityUnits = quantityUnits;
    }
}
