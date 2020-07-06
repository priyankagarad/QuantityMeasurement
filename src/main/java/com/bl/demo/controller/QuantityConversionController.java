package com.bl.demo.controller;
import com.bl.demo.dto.ConversionDto;
import com.bl.demo.enumeration.QuantityUnits;
import com.bl.demo.service.IQuantityConversionService;
import com.bl.demo.enumeration.Quantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unit")
public class QuantityConversionController {

    @Autowired
    private IQuantityConversionService quantityConversionService;

    @GetMapping("/quantity")
    public ResponseEntity getListOfQuantity(){
        return new ResponseEntity(quantityConversionService.getListOfQuantity(), HttpStatus.OK);
    }

    @GetMapping("/quantity/{quantityUnits}")
    public ResponseEntity getListOfQuantityUnits(@PathVariable Quantity quantityUnits) {
        return new ResponseEntity(quantityConversionService.getListOfQuantityUnits(quantityUnits), HttpStatus.OK);
    }

    @PostMapping("/quantity/conversion/{conversionUnit}")
    public ResponseEntity convertQuantityToUnit(@RequestBody ConversionDto conversionDto, @PathVariable QuantityUnits conversionUnit) {
        return new ResponseEntity(quantityConversionService.convertQuantityToUnit(conversionDto, conversionUnit), HttpStatus.CREATED);
    }
}

