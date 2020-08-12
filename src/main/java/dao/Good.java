package dao;

public class Good {
	private String number;
	private String account;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Good(String number, String account) {
		super();
		this.number = number;
		this.account = account;
	}
	public Good() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Good [number=" + number + ", account=" + account + "]";
	}
	
}
