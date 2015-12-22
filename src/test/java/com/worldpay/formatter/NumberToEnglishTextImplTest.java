package com.worldpay.formatter;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.worldpay.formatter.validation.InvalidParameterException;
public class NumberToEnglishTextImplTest {

	private NumberToTextImpl conversionImpl;
	
	@Before
	public void before()
	{
		conversionImpl = new NumberToTextImpl();		
	}
	
	@Test
	public void test() throws Exception {
		 	assertEquals("zero", conversionImpl.convertValue(0));
	        assertEquals("one", conversionImpl.convertValue(1));
	        assertEquals("twenty one", conversionImpl.convertValue(21));
	        assertEquals("one hundred and five", conversionImpl.convertValue(105));
	        assertEquals("one hundred and twenty three", conversionImpl.convertValue(123));	  	        
	        assertEquals("one thousand and forty two", conversionImpl.convertValue(1042));	       	      
	       	    
	}
	
	@Test
	public void test50() throws Exception {
		 assertEquals("fifty",
	        		conversionImpl.convertValue(50));
	}
	
	@Test
	public void test100() throws Exception {
		 assertEquals("one hundred",
	        		conversionImpl.convertValue(100));
	}
	
	@Test
	public void test1000000() throws Exception {
		 assertEquals("one million",
	        		conversionImpl.convertValue(1000000));
	}
	
	@Test
	public void test999999999() throws Exception {
		 assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine",
	        		conversionImpl.convertValue(999999999));
	}
	
	@Test
	public void test1105() throws Exception {
		 assertEquals("one thousand one hundred and five", conversionImpl.convertValue(1105));
	}
	
	@Test
	public void test1005() throws Exception {
		assertEquals("one thousand and five", conversionImpl.convertValue(1005));
	}
	
	
	@Test
	public void test56945781() throws Exception{
		  assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one",
	        		conversionImpl.convertValue(56945781));
	}
	

	@Test
	public void test45781() throws Exception{
		  assertEquals("forty five thousand seven hundred and eighty one",
	        		conversionImpl.convertValue(45781));
	}
	
	@Test
	public void test845781() throws Exception{
 		  assertEquals("eight hundred and forty five thousand seven hundred and eighty one",
	        		conversionImpl.convertValue(845781));
	}
	
	@Test
	public void testMinNumber() {
		
 		  try {
			assertEquals("",
			    		conversionImpl.convertValue(-1));
		}  catch (InvalidParameterException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testMaxNumber() {
		
 		  try {
			assertEquals("",
			    		conversionImpl.convertValue(1000000000));
		}  catch (InvalidParameterException e) {
			Assert.assertTrue(true);
		}
	}
}
