package com.bl.demo.controller;
import com.bl.demo.service.IQuantityConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quantity")
public class QuantityConversionController {

    @Autowired
    private IQuantityConversionService quantityConversionService;

    @GetMapping
    public ResponseEntity getListOfQuantity(){
        return new ResponseEntity(quantityConversionService.getListOfQuantity(), HttpStatus.OK);
    }

}
