# Technical Challenge
## Problem Description

Create a Java library, suitable for use in a server-side application, that can take a Java int in the range 0 to 999,999,999 inclusive and returns the equivalent number, as a String, in British English words.

	Sample Data
	Input	Output
	0	zero
	1	one
	21	twenty one
	105	one hundred and five
	123	one hundred and twenty three
	1005	one thousand and five
	1042	one thousand and forty two
	1105	one thousand one hundred and five
	56945781	fifty six million nine hundred and forty five thousand seven hundred and eighty one
	999999999	nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine.


## Guidelines
1. The solution must be correct. Please pay attention to the specific conventions of British English, particularly concerning the use of ‘and’ between certain phrases. 
2. The solution is not expected to involve a command line or GUI application – we’re looking for an object-oriented Java library that could be packaged as a jar and used in a larger application.
3. The solution should not make use of external libraries other than for testing purposes.
4. The solution should demonstrate a candidate’s abilities as a software engineer including, for example, TDD principles, general object-oriented principles and domain modeling principles. 
5. Please submit a solution that captures the business domain for the problem


## **Usage**


		NumberConverter formatter = new NumberConverter();
		try {        
			formatter.convertToText(100, new NumberToTextImpl());
		} catch (InvalidParameterException e) {
			e.printStackTrace();
		}
