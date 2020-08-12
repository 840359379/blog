package dao;

public class User {
	private String account;
	private String name;
	private String gender;
	private String birthday;
	private String mailbox;
	private String personality;
	private String portrait;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public User(String account, String name, String gender, String birthday, String mailbox, String personality,
			String portrait) {
		super();
		this.account = account;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.mailbox = mailbox;
		this.personality = personality;
		this.portrait = portrait;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [account=" + account + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday
				+ ", mailbox=" + mailbox + ", personality=" + personality + ", portrait=" + portrait + "]";
	}
	
}
