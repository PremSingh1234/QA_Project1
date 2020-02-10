package com.qa.item;

public class Item {
	private Long Item_ID;
	private Long Order_ID;
	private String name;
	private Long price_per_item;
	
	public Item(Long Item_ID, Long Order_ID, String name, Long price_per_item) {
		this.Item_ID = Item_ID;
		this.Order_ID = Order_ID;
		this.name = name;
		this.price_per_item = price_per_item;
		
}

	public Long getItem_ID() {
		return Item_ID;
	}

	public void setItem_ID(Long item_ID) {
		Item_ID = item_ID;
	}

	public Long getOrder_ID() {
		return Order_ID;
	}

	public void setOrder_ID(Long order_ID) {
		Order_ID = order_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice_per_item() {
		return price_per_item;
	}

	public void setPrice_per_item(Long price_per_item) {
		this.price_per_item = price_per_item;
	}
	
} 