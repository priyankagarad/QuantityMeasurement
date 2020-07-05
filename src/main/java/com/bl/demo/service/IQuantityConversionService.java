package com.bl.demo.service;
import com.bl.demo.dto.ConversionDto;
import java.util.List;

public interface IQuantityConversionService {
    public List<Quantity> getListOfQuantity();
    public List<QuantityUnits> getListOfQuantityUnits(Quantity quantity);
    public Double convertQuantityToUnit(ConversionDto conversionDto, QuantityUnits quantityUnits);
}
