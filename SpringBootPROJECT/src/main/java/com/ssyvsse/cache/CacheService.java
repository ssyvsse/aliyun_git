package com.ssyvsse.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssyvsse.pojo.User;

/**
 * @author llb
 *
 * @Date 2018年3月24日 上午11:34:05
 */
public interface CacheService {

	public final static Map<String, User> USERS = new HashMap<String, User>();

	public List<User> findAll();
	
	public User findByName(String name);

	public User updateUser(User user);

	public User findUserWithNoCache(String name);
	
	public void clearAllCache();
	
	public String addUser(User user);
}
