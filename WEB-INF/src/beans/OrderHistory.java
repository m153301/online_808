package beans;

import java.util.Date;

public class OrderHistory {
	private int orderId;
	private String userId;
	private int itemId;
	private int orderQuantity;
	private Date orderDate;
	
	public OrderHistory(){}

	public OrderHistory(int orderId, String userId, int itemId, int orderQuantity,
			Date orderDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.itemId = itemId;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
}
