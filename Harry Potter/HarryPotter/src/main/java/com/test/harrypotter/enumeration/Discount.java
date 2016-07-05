package com.test.harrypotter.enumeration;

public enum Discount {
	
	TWO_UNIQ_BOOKS_DISCOUNT(2, 5), 
	THREE_UNIQ_BOOKS_DISCOUNT(3, 10),
	FOUR_UNIQ_BOOKS_DISCOUNT(4, 20),
	FIVE_UNIQ_BOOKS_DISCOUNT(5, 25);

	private int itemQuantity;
	private int discountValue;

	private Discount(int itemQuantity, int discountValue) {
		this.itemQuantity = itemQuantity;
		this.discountValue = discountValue;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public int getValue() {
		return discountValue;
	}

	public static int getDiscountByItemQuantity(int itemQuantity) {
		for (Discount discount : Discount.values())
			if (discount.getItemQuantity() == itemQuantity)
				return discount.getValue();

		return 0;
	}

}
