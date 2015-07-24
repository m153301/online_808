package beans;

import java.util.Date;

public class SaleHistory {
	private String itemName;
	private Date buyDate;
	private int purchaseQuantity;
	private int itemPrice;



	public SaleHistory(){}
	public SaleHistory(String itemName, Date buyDate,
			int purchaseQuantity, int itemPrice) {
		super();
		this.itemName = itemName;
		this.buyDate = buyDate;
		this.purchaseQuantity = purchaseQuantity;
		this.itemPrice = itemPrice;
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

	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

}
