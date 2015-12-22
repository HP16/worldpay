package com.worldpay;


import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.worldpay.formatter.NumberToTextImpl;
import com.worldpay.formatter.validation.InvalidParameterException;

public class NumberFormatterTest {

	private NumberConverter formatter;
	
	@Before
	public void before()
	{
		formatter = new NumberConverter();	
	}
	
	

	@Test
	public void testValid() {
		try {
			assertEquals("one hundred" ,formatter.convertToText(100, new NumberToTextImpl()));
		}  catch (InvalidParameterException e) {
			Assert.assertTrue(false);
		}
	}

}
