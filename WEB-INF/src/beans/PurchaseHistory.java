package beans;

import java.util.Date;

public class PurchaseHistory {
	private int purchaceId;
	private int itemId;
	private String itemName;
	private Date buyDate;
	private int purchaceQuantity;
	private String userId;
	
	public PurchaseHistory(){}
	public PurchaseHistory(int purchaceId, int itemId, String itemName, Date buyDate,
			int purchaceQuantity, String userId) {
		super();
		this.purchaceId = purchaceId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.buyDate = buyDate;
		this.purchaceQuantity = purchaceQuantity;
		this.userId = userId;
	}

	public int getPurchaceId() {
		return purchaceId;
	}
	public void setPurchaceId(int purchaceId) {
		this.purchaceId = purchaceId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public int getPurchaceQuantity() {
		return purchaceQuantity;
	}
	public void setPurchaceQuantity(int purchaceQuantity) {
		this.purchaceQuantity = purchaceQuantity;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
