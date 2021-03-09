package net.gondr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.gondr.dao.UserDAO;
import net.gondr.domain.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;
	
	@Override
	public UserVO getUserInfo(String userid) {
		return dao.getUser(userid);
	}
	
	@Override
	public UserVO login(String userid, String password) {
		return dao.loginUser(userid, password);
	}
	
	@Override
	public void register(UserVO user) {
		dao.insertUser(user);
	}
	
	@Override
	public void updateEXP(UserVO user) {
		dao.updateEXP(user);
	}
	
	@Override
	public void updateLevel(UserVO user) {
		dao.updateLevel(user);
	}
	
	@Override
	public Integer getUserLevel(UserVO user) {
		return dao.getUserLevel(user);
	}
	
	@Override
	public Integer getLevelOnEXP(Integer level) {
		return dao.getLevelOnEXP(level);
	}
	
	@Override
	public Integer getUserEXP(UserVO user) {
		return dao.getUserEXP(user);
	}
	
	@Override
	public void resetEXP(UserVO user) {
		dao.resetEXP(user);
	}
	
}
