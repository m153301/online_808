package beans;

public class Creditcard {
	private int creditcardId;
	private int creditcardType;
	private String creditcardNumber;

	public Creditcard() {}
	public Creditcard(int creditcardId, int creditcardType,
			String creditcardNumber) {
		super();
		this.creditcardId = creditcardId;
		this.creditcardType = creditcardType;
		this.creditcardNumber = creditcardNumber;
	}

	public int getCreditcardId() {
		return creditcardId;
	}

	public void setCreditcardId(int creditcardId) {
		this.creditcardId = creditcardId;
	}

	public int getCreditcardType() {
		return creditcardType;
	}

	public void setCreditcardType(int creditcardType) {
		this.creditcardType = creditcardType;
	}

	public String getCreditcardNumber() {
		return creditcardNumber;
	}

	public void setCreditcardNumber(String creditcardNumber) {
		this.creditcardNumber = creditcardNumber;
	}

}
