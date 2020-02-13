package com.qa.domain;

public class Order {
	private Long orderId;
	private Long customersId;
	
	public Order(Long orderId, Long customersId) {
		this.orderId = orderId;
		this.customersId = customersId;
	}

public Long getOrderId() {
		return orderId;
	}



	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}



	public Long getCustomersId() {
		return customersId;
	}



	public void setCustomersId(Long customersId) {
		this.customersId = customersId;
	}

public String toString() {
		
		return " OrderId: " + orderId + "CustomerId: " + customersId;
	}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
	result = prime * result + ((customersId == null) ? 0 : customersId.hashCode());
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
	if (orderId == null) {
		if (other.orderId != null)
			return false;
	} else if (!orderId.equals(other.orderId))
		return false;
	if (customersId == null) {
		if (other.customersId != null)
			return false;
	} else if (!customersId.equals(other.customersId))
		return false;
	return true;
}

}
