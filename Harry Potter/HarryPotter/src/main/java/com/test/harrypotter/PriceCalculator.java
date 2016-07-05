package com.test.harrypotter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.test.harrypotter.bean.Book;
import com.test.harrypotter.enumeration.Discount;

public class PriceCalculator {

	public double calculate(List<Book> books) {
		return calculateTotalPrice(agregateUniqItems(books));
	}

	private Map<Book, Integer> agregateUniqItems(List<Book> books) {
		Map<Book, Integer> container = new HashMap<Book, Integer>();

		for (Book book : books)
			addBookToContainer(book, container);

		return container;
	}

	private void addBookToContainer(Book book, Map<Book, Integer> bookContainer) {
		if (bookContainer.containsKey(book)) {
			bookContainer.put(book, bookContainer.get(book) + 1);
		} else {
			bookContainer.put(book, 1);
		}
	}

	private double calculateTotalPrice(Map<Book, Integer> container) {
		double totalPrice = 0;

		while (isUniqItemsLeft(container)) 
			totalPrice += calculateInterimItemsPrice(container);

		return totalPrice;
	}

	private double calculateInterimItemsPrice(Map<Book, Integer> container) {
		return calculateBooksPriceWithDiscount(getUniqItems(container));
	}

	private Set<Book> getUniqItems(Map<Book, Integer> container) {
		Set<Book> uniqBooks = new HashSet<Book>();
		
		for (Map.Entry<Book, Integer> entry : container.entrySet())
			if (isUncauntedItemLeft(entry)) {
				uniqBooks.add(entry.getKey());
				decreaseItemQuantity(entry, container);
			}
		
		return uniqBooks;
	}

	private boolean isUncauntedItemLeft(Map.Entry<Book, Integer> entry) {
		return entry.getValue() > 0;
	}

	private void decreaseItemQuantity(Map.Entry<Book, Integer> entry, Map<Book, Integer> bookContainer) {
		bookContainer.put(entry.getKey(), entry.getValue() - 1);
	}

	private double calculateBooksPriceWithDiscount(Set<Book> books) {
		return applyDiscount(calculateBooksTotalPrice(books), getDiscount(books));
	}

	private double calculateBooksTotalPrice(Set<Book> uniqBooks) {
		double totalPrice = 0;

		for (Book book : uniqBooks)
			totalPrice += book.getPrice();

		return totalPrice;
	}

	private double applyDiscount(double totalPrice, double totalDiscount) {
		if (totalDiscount != 0)
			totalPrice *= getDiscountMultiplier(totalDiscount);

		return totalPrice;
	}

	private boolean isUniqItemsLeft(Map<Book, Integer> container) {
		int alreadyCountedItems = 0;

		for (Map.Entry<Book, Integer> entry : container.entrySet()) 
			if (entry.getValue() <= 0) 
				alreadyCountedItems++;

		return isNotAllItemsCounted(container, alreadyCountedItems);
	}

	private boolean isNotAllItemsCounted(Map<Book, Integer> container, int alreadyCountedItems) {
		return alreadyCountedItems < container.entrySet().size();
	}

	private int getDiscount(Set<Book> uniqBooks) {
		return Discount.getDiscountByItemQuantity(uniqBooks.size());
	}

	private double getDiscountMultiplier(double totalDiscount) {
		return 1 - totalDiscount / 100;
	}

}
