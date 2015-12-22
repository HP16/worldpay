package com.worldpay.formatter;

import com.worldpay.formatter.constants.EnglishStringValuesImpl;
import com.worldpay.formatter.constants.FormatterValues;
import com.worldpay.formatter.validation.InputValidator;
import com.worldpay.formatter.validation.InvalidParameterException;

public class NumberToTextImpl implements Converter {
	
	//we could externalise this to make this call more generic and you can pass it 
	//different value in different languages perhaps
	private FormatterValues<String>[] values = EnglishStringValuesImpl.values();
	

	
	public String convertValue(int number) throws InvalidParameterException {
		//check input range is valid
    	InputValidator.checkInputParameter(number);
    			
		String equivalentNumber = convertNumberToWords(number);
        return equivalentNumber.trim();		
	}

	 
	private String getStringNumber(int number) {
        String equivalentNumber = "";
        for (FormatterValues<String> sv : values) {
            if (sv.getNumber() == number) {
                equivalentNumber += sv.getValue();
            }
        }
        return equivalentNumber.trim();
    }
	

	private String convertNumberToWords(int inputNumber) {
		if (inputNumber >= 0 && inputNumber <= 99) {
			return convertTens(inputNumber);
        }
		else
		if (inputNumber > 99 && inputNumber <= 999) {
			return convertHundreds(inputNumber);
        }
        else        
        if (inputNumber >= 1000 && inputNumber <= 999999){
        	return convertThousands(inputNumber);
        } 
        if (inputNumber > 999999 ){
        	return convertMillions(inputNumber);
        }        
        return "";
    }
	
	
	private String convertMillions(int number) {
		StringBuilder outputText =new StringBuilder();      
     
        int length = Integer.toString(number).length();
              
        if (length==7)
        {    
        	//million
        	outputText.append(getStringNumber(number / 1000000) + EnglishStringValuesImpl.MILLION).append(" ");
        	outputText.append(convertThousands(Integer.parseInt(Integer.toString(number).substring(1, length) )));
        }
        else if (length==8)
        {   
        	//tens of millions
        	outputText.append(convertHundreds(Integer.parseInt(Integer.toString(number).substring(0, 2) )) + EnglishStringValuesImpl.MILLION).append(" ");
        	outputText.append(convertThousands(Integer.parseInt(Integer.toString(number).substring(2, length) )));
        }
        else if (length==9)
        {     
        	//hundreds of millions
        	outputText.append(convertHundreds(Integer.parseInt(Integer.toString(number).substring(0, 3) )) + EnglishStringValuesImpl.MILLION + " ");
        	outputText.append(convertHundreds(Integer.parseInt(Integer.toString(number).substring(3, 4) )) + EnglishStringValuesImpl.HUNDRED + " " + EnglishStringValuesImpl.AND).append(" ");
        	outputText.append(convertThousands(Integer.parseInt(Integer.toString(number).substring(4, length) )));
        }       
        return outputText.toString();        
    }
	
	
	private String convertThousands(int number) {
		StringBuilder outputText =new StringBuilder();      
     
        int length = Integer.toString(number).length();
              
        if (length==4)
        {    
        	//thousand
        	outputText.append(getStringNumber(number / 1000) + EnglishStringValuesImpl.THOUSAND).append(" ");
        	String hundreds = (Integer.toString(number).substring(1, length) );
        	if (hundreds.startsWith("0")) //adding this check as int gets rid of leading 0's
        	{
        		outputText.append(EnglishStringValuesImpl.AND +  " ");
        	}        	
        	outputText.append(convertHundreds(Integer.parseInt(Integer.toString(number).substring(1, length) )));
        }
        else if (length==5)
        {   
        	//tens of thousands
        	outputText.append(convertHundreds(Integer.parseInt(Integer.toString(number).substring(0, 2) )) + EnglishStringValuesImpl.THOUSAND).append(" ");
        	outputText.append(convertHundreds(Integer.parseInt(Integer.toString(number).substring(2, length) )));
        }
        else if (length==6)
        {     
        	//hundreds of thousands
        	outputText.append(convertHundreds(Integer.parseInt(Integer.toString(number).substring(0, 3) )) + EnglishStringValuesImpl.THOUSAND).append(" ");
        	outputText.append(convertHundreds(Integer.parseInt(Integer.toString(number).substring(3, length) )));
        }       
        return outputText.toString();        
    }
	
	private String convertHundreds(int number) {
        String numberString = getStringNumber(number / 100) + EnglishStringValuesImpl.HUNDRED;        
        String workingString = convertTens(number % 100);
        if (number <= 99) {
            return workingString;
        } else if (number % 100 == 0) {
            return numberString;
        } else {
            return numberString + " " + EnglishStringValuesImpl.AND + " " + workingString;
        }
    }

	
    private String convertTens(int number) {
        if (number < 20) {
            return getStringNumber(number);
        }
        
        if (Integer.parseInt(Integer.toString(number).substring(1) ) != 0) {
        	//not whole number. Get the number seperately
        	int firstDigit = Integer.parseInt(Integer.toString(number).substring(0, 1) + 0);
        	int secondDigit = Integer.parseInt(Integer.toString(number).substring(1) );
           	return getStringNumber(firstDigit) + " " +  getStringNumber(secondDigit);
        } else { 
        	//whole number
        	return getStringNumber(number);         	
        }              
    }
}
