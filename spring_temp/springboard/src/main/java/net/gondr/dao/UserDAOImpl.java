package net.gondr.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.gondr.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession session;
	
	private final String ns = "net.gondr.mappers.UserMapper";
	
	@Override
	public UserVO getUser(String userid) {
		return session.selectOne(ns + ".selectUser", userid);
	}
	
	@Override
	public UserVO loginUser(String userid, String password) {
		Map<String, String> loginMap = new HashMap<>();
		loginMap.put("userid", userid);
		loginMap.put("password", password);
		return session.selectOne(ns + ".loginUser", loginMap);
	}
	
	@Override
	public void insertUser(UserVO user) {
		session.insert(ns + ".insertUser", user);
	}
	
	@Override
	public void updateEXP(UserVO user) {
		session.update(ns + ".updateUserEXP", user.getUserid());
	}
	
	@Override
	public void updateLevel(UserVO user) {
		session.update(ns + ".updateUserLEVEL", user.getUserid());
	}
	
	@Override
	public Integer getUserLevel(UserVO user) {
		return session.selectOne(ns + ".userLevel", user.getUserid());
	}
	
	@Override
	public Integer getLevelOnEXP(Integer level) {
		return session.selectOne(ns + ".selectEXP", level);
	}
	
	@Override
	public Integer getUserEXP(UserVO user) {
		return session.selectOne(ns + ".selectUserEXP", user.getUserid());
	}
	
	@Override
	public void resetEXP(UserVO user) {
		session.update(ns + ".resetEXP", user.getUserid());
	}
	
}
