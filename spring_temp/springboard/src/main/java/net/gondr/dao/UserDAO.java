package net.gondr.dao;

import net.gondr.domain.UserVO;

public interface UserDAO {
	public UserVO getUser(String userid);
	
	public UserVO loginUser(String userid, String password);
	
	public void insertUser(UserVO user);
	
	public void updateEXP(UserVO user);
	
	public void updateLevel(UserVO user);
	
	public Integer getUserLevel(UserVO user);
	
	public Integer getLevelOnEXP(Integer level);
	
	public Integer getUserEXP(UserVO user);
	
	public void resetEXP(UserVO user);
}
