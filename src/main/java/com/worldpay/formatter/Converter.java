package com.worldpay.formatter;

import com.worldpay.formatter.validation.InvalidParameterException;

public interface Converter {	
	    String convertValue(int number) throws InvalidParameterException;		
}
