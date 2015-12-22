package com.worldpay;

import com.worldpay.formatter.Converter;
import com.worldpay.formatter.validation.InputValidator;
import com.worldpay.formatter.validation.InvalidParameterException;

public class NumberConverter {	
      
    public String convertToText(final int number, Converter converter) throws InvalidParameterException {
    	//check converter has been supplied
    	InputValidator.checkConverter(converter);    	
    		    	    	
    	//convert value
        return converter.convertValue(number);
    }    
}
