package com.epam;

import java.util.List;

import com.epam.divider.DivisorOfNumber;

public class FizzBuzzConverter {
	private List<DivisorOfNumber> determinantOfDividers;
	
	public FizzBuzzConverter() {}
	
	public FizzBuzzConverter(List<DivisorOfNumber> determinantOfDividers) {
		this.determinantOfDividers = determinantOfDividers;
	}
	
	public void setDeterminantOfDividers(List<DivisorOfNumber> determinantOfDividers) {
		this.determinantOfDividers = determinantOfDividers;
	}
	
	public String print(int number) {
		String rezult = convertNumberWithDivisor(number);
		
		if(isEmptyResult(rezult)){
			return new DefaultNumber().print(number);
		}

		return rezult;
	}
	
	private String convertNumberWithDivisor(int number) {
		String rezult = "";
		for(DivisorOfNumber divider: determinantOfDividers) {
			rezult += divider.print(number);
		}
		return rezult;
	}
	
	private boolean isEmptyResult(String rezult){
		return rezult.equals("");
	}
}
