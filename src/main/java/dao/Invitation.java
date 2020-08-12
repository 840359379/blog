package dao;

public class Invitation {
	private String number;
	private String account;
	private String time;
	private String title;
	private String Subtitle;
	private String text;
	private String name;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return Subtitle;
	}
	public void setSubtitle(String subtitle) {
		Subtitle = subtitle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Invitation(String number, String account, String time, String title, String subtitle, String text,
			String name) {
		super();
		this.number = number;
		this.account = account;
		this.time = time;
		this.title = title;
		Subtitle = subtitle;
		this.text = text;
		this.name = name;
	}
	public Invitation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Invitation [number=" + number + ", account=" + account + ", time=" + time + ", title=" + title
				+ ", Subtitle=" + Subtitle + ", text=" + text + ", name=" + name + "]";
	}
	
	
}
