package web;

public class LoginBean {
	private int user_id;
	private String user_name;
	private String login_cd;
	private String login_pw;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getLogin_cd() {
		return login_cd;
	}
	public void setLogin_cd(String login_cd) {
		this.login_cd = login_cd;
	}
	public String getLogin_pw() {
		return login_pw;
	}
	public void setLogin_pw(String login_pw) {
		this.login_pw = login_pw;
	}

}
