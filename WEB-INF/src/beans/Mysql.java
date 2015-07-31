package beans;

public class Mysql{
	
	private String driver_url = null;
	private String driver_name = null;
	private String user_name = null;
	private String password = null;
	
	public Mysql() {
		// TODO Auto-generated constructor stub
	}
	
	public Mysql(String driver_url, String driver_name, String user_name,
			String password) {
		
		this.driver_url = driver_url;
		this.driver_name = driver_name;
		this.user_name = user_name;
		this.password = password;
	}

	public String getDriver_url() {
		return driver_url;
	}

	public void setDriver_url(String driver_url) {
		this.driver_url = driver_url;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}