package com.test.harrypotter.creator;

import com.test.harrypotter.bean.Book;

public interface BookCreator {
	
	static final int DEFAULT_SINGLE_BOOK_PRICE = 8;
	
	public Book create();

}
