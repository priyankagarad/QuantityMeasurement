package com.bl.demo.service;
import static com.bl.demo.service.Quantity.*;

public enum QuantityUnits {
    FEET(12.0,LENGTH),INCH(1.0,LENGTH),
    YARD(36.0,LENGTH),CM(0.4,LENGTH),

    ML(0.001,VOLUME),LITRE(1,VOLUME),
    GALLON(3.78,VOLUME);

    double baseUnitConversion;
    Quantity quantity;

    QuantityUnits(double baseUnitConversion,Quantity quantity){
        this.baseUnitConversion=baseUnitConversion;
        this.quantity=quantity;
    }

}
