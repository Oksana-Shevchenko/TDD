package com.test.harrypotter.creator;

import java.math.BigInteger;
import java.security.SecureRandom;

import com.test.harrypotter.bean.Book;

public class IdenticalBookCreator implements BookCreator {
	
	private static final int NUMBER_OF_BITS = 130;
	private static final int STRING_LENGTH = 32;
	
	private String name;
	
	public IdenticalBookCreator() {
		name = generateRandomName(new SecureRandom());
	}
	
	public Book create() {
		return new Book(name, DEFAULT_SINGLE_BOOK_PRICE);
	}
	
	private String generateRandomName(SecureRandom random) {
		return new BigInteger(NUMBER_OF_BITS, random).toString(STRING_LENGTH);
	}

}
