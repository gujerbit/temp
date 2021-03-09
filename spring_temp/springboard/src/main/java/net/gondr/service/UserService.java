package net.gondr.service;

import net.gondr.domain.UserVO;

public interface UserService {
	public UserVO login(String userid, String password);
	
	public void register(UserVO user);
	
	public UserVO getUserInfo(String userid);
	
	public void updateEXP(UserVO user);
	
	public void updateLevel(UserVO user);
	
	public Integer getUserLevel(UserVO user);
	
	public Integer getLevelOnEXP(Integer level);
	
	public Integer getUserEXP(UserVO user);
	
	public void resetEXP(UserVO user);
}
