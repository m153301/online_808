package beans;

public class Worker extends User{
	private String userId;

	public Worker(){}
	public Worker(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	} 
}
