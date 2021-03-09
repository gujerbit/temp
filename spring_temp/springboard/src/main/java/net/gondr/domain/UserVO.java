package net.gondr.domain;

public class UserVO {
	
	private String userid;
	private String name;
	private String password;
	private Integer exp;
	private Integer level;
	private String img;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getExp() {
		return exp;
	}
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", name=" + name + ", password=" + password + ", exp=" + exp + ", level="
				+ level + ", img=" + img + "]";
	}
	
}
