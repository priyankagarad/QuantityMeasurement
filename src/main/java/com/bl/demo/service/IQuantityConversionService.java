package com.bl.demo.service;
import java.util.List;

public interface IQuantityConversionService {
    public List<Quantity> getListOfQuantity();
    public List<QuantityUnits> getListOfQuantityUnits(Quantity quantity);
}
