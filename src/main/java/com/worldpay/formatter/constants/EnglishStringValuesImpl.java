package com.worldpay.formatter.constants;

public enum EnglishStringValuesImpl implements FormatterValues<String> {

 	ZERO(0, "zero"),
    ONE(1, "one"),
    TWO(2, "two"),
    THREE(3, "three"),
    FOUR(4, "four"),
    FIVE(5, "five"),
    SIX(6, "six"),
    SEVEN(7, "seven"),
    EIGHT(8, "eight"),
    NINE(9, "nine"),
    TEN(10, "ten"),
    ELEVEN(11, "eleven"),
    TWELVE(12, "twelve"),
    THIRTEEN(13, "thirteen"),
    FOURTEEN(14, "fourteen"),
    FIFTEEN(15, "fifteen"),
    SIXTEEN(16, "sixteen"),
    SEVENTEEN(17, "seventeen"),
    EIGHTEEN(18, "eighteen"),
    NINETEEN(19, "nineteen"),
    TWENTY(20, "twenty"),
    THIRTY(30, "thirty"),
    FORTY(40, "forty"),
    FIFTY(50, "fifty"),
    SIXTY(60, "sixty"),
    SEVENTY(70, "seventy"),
    EIGHTY(80, "eighty"),
    NINETY(90, "ninety");
	
	
    public static final String MILLION = " million";
    public static final String THOUSAND = " thousand";
    public static final String HUNDRED = " hundred";
    public static final String AND = "and";
    public static final String ERROR_MESSAGE = "Text Enum has not been set.";
    
    
 	private int number;
    private String value;
    
    private EnglishStringValuesImpl(int number, String value) {
        this.number = number;
        this.value = value;
    }

	public int getNumber() {
		return number;
	}


	public String getValue() {
		return value;
	}
	
	
	

}
