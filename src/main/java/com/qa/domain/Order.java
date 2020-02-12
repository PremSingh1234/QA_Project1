package com.qa.domain;

public class Order {
	private Long order_id;
	private Long customers_id;
	private Double total_price;
	
	public Order(Long order_id, Long customers_id ) {
		this.order_id = order_id;
		this.customers_id = customers_id;
		this.total_price = total_price;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomers_id() {
		return customers_id;
	}

	public void setCustomers_id(Long customers_id) {
		this.customers_id = customers_id;
	}

	public Double getToatl_price() {
		return total_price;
	}

	public void setToatl_price(Double total_price) {
		this.total_price = total_price;
	}

public String toString() {
		
		return " OrderId: " + order_id + "CustomerId: " + customers_id + " TotalPrice " + total_price;
	}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
	result = prime * result + ((customers_id == null) ? 0 : customers_id.hashCode());
	result = prime * result + ((total_price == null) ? 0 : total_price.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Order other = (Order) obj;
	if (order_id == null) {
		if (other.order_id != null)
			return false;
	} else if (!order_id.equals(other.order_id))
		return false;
	if (customers_id == null) {
		if (other.customers_id != null)
			return false;
	} else if (!customers_id.equals(other.customers_id))
		return false;
	if (total_price == null) {
		if (other.total_price != null)
			return false;
	} else if (!total_price.equals(other.total_price))
		return false;
	return true;
}

}
