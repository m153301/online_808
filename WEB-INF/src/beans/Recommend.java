package beans;

import java.util.Date;

public class Recommend {
	private int itemId;
	private String workerId;
	private Date date;

	public Recommend(){}
	public Recommend(int itemId, String workerId, Date date) {
		super();
		this.itemId = itemId;
		this.workerId = workerId;
		this.date = date;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
