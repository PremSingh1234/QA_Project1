package com.qa.order;

public class Order {
	private Long Order_ID;
	private Long Customers_ID;
	private Long Qty;
	private String item;
	private Long price_per_item;
	
	public Order(Long Order_ID, Long Customers_ID, Long Qty, String item, Long price_per_item) {
		this.Order_ID = Order_ID;
		this.Customers_ID = Customers_ID;
		this.Qty = Qty;
		this.item = item;
		this.price_per_item = price_per_item;
	}

	public Long getOrder_ID() {
		return Order_ID;
	}

	public void setOrder_ID(Long order_ID) {
		Order_ID = order_ID;
	}

	public Long getCustomers_ID() {
		return Customers_ID;
	}

	public void setCustomers_ID(Long customers_ID) {
		Customers_ID = customers_ID;
	}

	public Long getQty() {
		return Qty;
	}

	public void setQty(Long qty) {
		Qty = qty;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Long getPrice_per_item() {
		return price_per_item;
	}

	public void setPrice_per_item(Long price_per_item) {
		this.price_per_item = price_per_item;
	}

}
