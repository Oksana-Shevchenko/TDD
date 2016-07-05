package com.epam.divider;

import com.epam.ConstantMessage;

public class DivisorOnFiveOfNumber implements DivisorOfNumber {

	@Override
	public String print(int number) {
		return isDivideForFive(number) ? ConstantMessage.BUZZ: ConstantMessage.EMPTY;
	}
	
	private boolean isDivideForFive(int number) {
		return number%5==0;
	}
}
