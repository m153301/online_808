package beans;

public class User {
	private String userId;
	private String password;
	private String userName;
	private String role;
	
	public User(){}

	public User(String userId, String password, String userName, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
