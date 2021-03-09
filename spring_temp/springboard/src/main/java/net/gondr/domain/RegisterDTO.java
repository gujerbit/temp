package net.gondr.domain;

import org.springframework.web.multipart.MultipartFile;

public class RegisterDTO {
	
	private String userid;
	private String username;
	private String password;
	private String passwordConfirm;
	private MultipartFile profileImg;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public MultipartFile getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(MultipartFile profileImg) {
		this.profileImg = profileImg;
	}
	
	@Override
	public String toString() {
		return "RegisterDTO [userid=" + userid + ", username=" + username + ", password=" + password
				+ ", passwordConfirm=" + passwordConfirm + ", profileImg=" + profileImg + "]";
	}
	
}
