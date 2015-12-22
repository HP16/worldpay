package com.worldpay.formatter.validation;

import static com.worldpay.formatter.constants.InputRange.MAX_VALUE;
import static com.worldpay.formatter.constants.InputRange.MIN_VALUE;

import com.worldpay.formatter.Converter;

public class InputValidator 
{
	
	 public static void checkInputParameter(int number) throws InvalidParameterException 
	 {
        if (number < MIN_VALUE.getValue()) 
        {
            throw new InvalidParameterException("Number must not be less than: " + MIN_VALUE.getValue());
        } 
        else if (number > MAX_VALUE.getValue()) 
        {
            throw new InvalidParameterException("Number must not be greater than: " + MAX_VALUE.getValue());
        }
	 }
	 
	 
	 public static void checkConverter(Converter converter) throws InvalidParameterException {
	        if (converter == null) {
	            throw new InvalidParameterException("You must pass in a valid converter");
	        }
	    }
}
