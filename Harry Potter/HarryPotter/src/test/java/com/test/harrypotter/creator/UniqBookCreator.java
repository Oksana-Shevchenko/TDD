package com.test.harrypotter.creator;

import java.math.BigInteger;
import java.security.SecureRandom;

import com.test.harrypotter.bean.Book;

public class UniqBookCreator implements BookCreator {
	
	private static final int NUMBER_OF_BITS = 130;
	private static final int STRING_LENGTH = 32;
	
	private SecureRandom random;
	
	public UniqBookCreator() {
		random = new SecureRandom();
	}

	public Book create() {
		return new Book(generateRandomName(), DEFAULT_SINGLE_BOOK_PRICE);
	}
	
	private String generateRandomName() {
		return new BigInteger(NUMBER_OF_BITS, random).toString(STRING_LENGTH);
	}

}
