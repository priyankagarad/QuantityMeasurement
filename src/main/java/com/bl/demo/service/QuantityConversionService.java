package com.bl.demo.service;
import com.bl.demo.dto.ConversionDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static com.bl.demo.service.Quantity.TEMPERATURE;

@Service
public class QuantityConversionService implements IQuantityConversionService {

    @Override
    public List<Quantity> getListOfQuantity() {
        return Arrays.stream(Quantity.values()).collect(Collectors.toList());
    }

    @Override
    public List<QuantityUnits> getListOfQuantityUnits(Quantity quantity) {
        return Arrays.stream(QuantityUnits.values()).filter(qUnit -> qUnit.quantity.equals(quantity)).collect(Collectors.toList());
    }

    private static double farenheitToCelcius(double fahrenheit){
        return ((fahrenheit - 32)*(5.0/9.0));
    }

    private static double celciusToFarenheit(double celcius){
        return ((celcius*(9.0/5.0)) + 32);
    }

    public Double convertQuantityToUnit(ConversionDto conversionDto, QuantityUnits quantityUnits) {
        try {
            if (conversionDto.quantityUnits.quantity.equals(TEMPERATURE)) {
                if (conversionDto.quantityUnits.equals(QuantityUnits.FAHRENHEIT) && quantityUnits.equals(QuantityUnits.CELSIUS)) {
                    return farenheitToCelcius(conversionDto.value);
                } else if (conversionDto.quantityUnits.equals(QuantityUnits.CELSIUS) && quantityUnits.equals(QuantityUnits.FAHRENHEIT)) {
                    return celciusToFarenheit(conversionDto.value);
                } else {
                    return conversionDto.value;
                }
            }

            double result = (conversionDto.value * conversionDto.quantityUnits.baseUnitConversion) / quantityUnits.baseUnitConversion;
            return result;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}
