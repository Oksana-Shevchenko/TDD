package com.epam.divider;

import com.epam.ConstantMessage;

public class DivisorOnThreeOfNumber implements DivisorOfNumber {

	@Override
	public String print(int number) {
		return isDivideForThree(number) ? ConstantMessage.FIZZ: ConstantMessage.EMPTY;
	}
	
	private boolean isDivideForThree(int number) {
		return number%3==0;
	}
}
