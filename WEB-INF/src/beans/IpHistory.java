package beans;

public class IpHistory {
	private String ip = null;
	private int failCount = 0;
	
	public IpHistory(){}
	
	public IpHistory(String ip, int failCount) {
		this.ip = ip;
		this.failCount = failCount;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getFail_count() {
		return failCount;
	}

	public void setFail_count(int failCount) {
		this.failCount = failCount;
	}
}
