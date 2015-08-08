package beans;

import java.util.Date;

public class Recommend {
	private int itemId;
	private String userId;
	private Date date;

	public Recommend(){}
	public Recommend(int itemId, String userId, Date date) {
		super();
		this.itemId = itemId;
		this.userId = userId;
		this.date = date;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
