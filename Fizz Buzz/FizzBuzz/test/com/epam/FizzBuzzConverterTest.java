package com.epam;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.epam.divider.DivisorOfNumber;
import com.epam.divider.DivisorOnFiveOfNumber;
import com.epam.divider.DivisorOnThreeOfNumber;

public class FizzBuzzConverterTest {
	FizzBuzzConverter fizzBuzz;
	
	private static final String FIZZ = "Fizz";
	private static final String BUZZ = "Buzz";
	private static final String FIZZ_BUZZ = "FizzBuzz";
	
	@Before
	public void initialize(){
		fizzBuzz = new FizzBuzzConverter();
		List<DivisorOfNumber> divisors = fillDivisorOfNumberList();
		fizzBuzz.setDeterminantOfDividers(divisors);
	}
	
	@Test
	public void shoudPrint1When1(){
		assertEquals("1", fizzBuzz.print(1));
	} 

	@Test
	public void shoudPrint2When2(){
		assertEquals("2", fizzBuzz.print(2));
	} 

	@Test
	public void shoudPrintFizzWhen3(){
		assertEquals(FIZZ, fizzBuzz.print(3));
	} 
	
	@Test
	public void shoudPrintBuzzWhen5(){
		assertEquals(BUZZ, fizzBuzz.print(5));
	}
	
	@Test
	public void shoudPrintFizzBuzzWhen15(){
		assertEquals(FIZZ_BUZZ, fizzBuzz.print(15));
	}

	@Test
	public void shoudPrintFizzBuzzWhen30(){
		assertEquals(FIZZ_BUZZ, fizzBuzz.print(30));
	}
	
	private List<DivisorOfNumber> fillDivisorOfNumberList() {
		List<DivisorOfNumber> divisors = new ArrayList<DivisorOfNumber>();
		divisors.add(new DivisorOnThreeOfNumber());
		divisors.add(new DivisorOnFiveOfNumber());
		return divisors;
	}
}
