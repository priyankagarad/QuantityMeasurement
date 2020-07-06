package com.bl.demo.enumeration;

import static com.bl.demo.enumeration.Quantity.*;
import static com.bl.demo.enumeration.Quantity.WEIGHT;

public enum QuantityUnits {
    FEET(12.0,LENGTH),INCH(1.0,LENGTH),
    YARD(36.0,LENGTH),CM(0.4,LENGTH),

    ML(0.001,VOLUME),LITRE(1,VOLUME),
    GALLON(3.78,VOLUME),

    FAHRENHEIT(1.0, TEMPERATURE), CELSIUS(1.0,TEMPERATURE),

    GRAM(0.001, WEIGHT), KG(1.0, WEIGHT),
    TONNE(1000.0, WEIGHT);

    public double baseUnitConversion;
    public Quantity quantity;

    QuantityUnits(double baseUnitConversion,Quantity quantity){
        this.baseUnitConversion=baseUnitConversion;
        this.quantity=quantity;
    }
}