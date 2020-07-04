package com.bl.demo.service;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityConversionService implements IQuantityConversionService {

    @Override
    public List<Quantity> getListOfQuantity() {
        return Arrays.stream(Quantity.values()).collect(Collectors.toList());
    }
}
