package com.test.harrypotter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.test.harrypotter.bean.Book;
import com.test.harrypotter.creator.BookCreator;
import com.test.harrypotter.creator.IdenticalBookCreator;
import com.test.harrypotter.creator.UniqBookCreator;

public class PriceCalculatorTest {

	private static final double DELTA = 1e-15;

	private PriceCalculator calculator;

	@Before
	public void createDiscounter() {
		calculator = new PriceCalculator();
	}

	@Test
	public void calculateTotalPriceForEmptyList() {
		List<Book> books = new ArrayList<Book>();
		assertEquals(0, calculator.calculate(books), DELTA);
	}

	@Test
	public void calculateTotalPriceFor1Book() {
		List<Book> books = getListOfSimilarBooks(1);
		assertEquals(8, calculator.calculate(books), DELTA);
	}

	@Test
	public void calculateTotalPriceFor2SimilarBooks() {
		List<Book> books = getListOfSimilarBooks(2);
		assertEquals(16, calculator.calculate(books), DELTA);
	}

	@Test
	public void calculateTotalPriceFor2UniqBooks() {
		List<Book> books = getListOfUniqBooks(2);
		assertEquals(15.2, calculator.calculate(books), DELTA);
	}
	
	@Test
	public void calculateTotalPriceFor3UniqBooks() {
		List<Book> books = getListOfUniqBooks(3);
		assertEquals(21.6, calculator.calculate(books), DELTA);
	}
	
	@Test
	public void calculateTotalPriceFor4UniqBooks() {
		List<Book> books = getListOfUniqBooks(4);
		assertEquals(25.6, calculator.calculate(books), DELTA);
	}
	
	@Test
	public void calculateTotalPriceFor5UniqBooks() {
		List<Book> books = getListOfUniqBooks(5);
		assertEquals(30, calculator.calculate(books), DELTA);
	}
	
	@Test
	public void calculateTotalPriceFor3UniqAnd2SimilarBooks() {
		List<Book> books = getListOfUniqBooks(3);
		books.addAll(getListOfSimilarBooks(2));
		assertEquals(33.6, calculator.calculate(books), DELTA);
	}
	
	@Test
	public void calculateTotalPriceFor2UniqAnd6SimilarBooks() {
		List<Book> books = getListOfUniqBooks(2);
		books.addAll(getListOfSimilarBooks(2));
		books.addAll(getListOfSimilarBooks(2));
		books.addAll(getListOfSimilarBooks(2));
		assertEquals(51.6, calculator.calculate(books), DELTA);
	}

	private List<Book> getListOfUniqBooks(int quantity) {
		UniqBookCreator bookCreator = new UniqBookCreator();
		return getListOfBooks(bookCreator, quantity);
	}

	private List<Book> getListOfSimilarBooks(int quantity) {
		IdenticalBookCreator bookCreator = new IdenticalBookCreator();
		return getListOfBooks(bookCreator, quantity);
	}

	private List<Book> getListOfBooks(BookCreator bookCreator, int quantity) {

		List<Book> books = new ArrayList<Book>();

		for (int i = 0; i < quantity; i++)
			books.add(bookCreator.create());

		return books;
	}

}
