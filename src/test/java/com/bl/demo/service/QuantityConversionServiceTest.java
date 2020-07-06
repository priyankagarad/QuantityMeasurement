package com.bl.demo.service;
import com.bl.demo.enumeration.Quantity;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuantityConversionService.class)
public class QuantityConversionServiceTest {

    @Autowired
    IQuantityConversionService quantityConversionService;

    @Test
    public void givenQunatity_whenCountInQuantityList_shouldRequiredCountOfQuantity(){
        int size = quantityConversionService.getListOfQuantity().size();
        Assert.assertEquals(4,size);
    }

    @Test
    public void givenQunatityUnit_whenCountInQuantityUnitList_shouldRequiredCountOfQuantityUnit(){
        int size = quantityConversionService.getListOfQuantityUnits(Quantity.LENGTH).size();
        Assert.assertEquals(4,size);
    }
}



