package com.ssyvsse.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.ssyvsse.pojo.User;

/**
 * @author llb
 *
 * @Date 2018年3月24日 上午11:48:13
 */
@Service
public class CacheServiceImpl implements CacheService {

	private Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);
	
	@Override
	@Cacheable(value = "userCache", key = "#name")
	public User findByName(String name) {
		logger.error("1");
		User user = USERS.get(name);
		if (user == null) {
			return null;
		}
		return user;
	}

	@Override
	@Cacheable(value = "userCache", key = "0")
	public List<User> findAll() {
		logger.error("3");
		List<User> userList = new ArrayList<User>();
		Set<String> keySet = USERS.keySet();
		for (String string : keySet) {
			userList.add(USERS.get(string));
		}
		return userList;
	}

	@Override
	@CachePut(value = "userCache", key = "#user.name",unless="#result==null")
	public User updateUser(User user) {
		logger.error("5");
		User mapUser = USERS.get(user.getName());
		if (mapUser == null) {
			return null;
		}
		if(user.getAge()<0||user.getAge()>=100){
			return null;
		}
		mapUser.setAge(user.getAge());
		USERS.put(user.getName(), mapUser);
		return mapUser;
	}

	@Override
	public User findUserWithNoCache(String name) {
		logger.error("2");
		User user = USERS.get(name);
		if (user == null) {
			return null;
		}
		return user;
	}

	@Override
	@CacheEvict(value = "userCache", allEntries = true)
	public void clearAllCache() {
	}

	@Override
	@Caching(evict = { @CacheEvict(value = "userCache", key = "#user.name"),
			@CacheEvict(value = "userCache", key = "0")} )
	public String addUser(User user) {
		logger.error("4");
		User mapUser = USERS.get(user.getName());
		if (mapUser != null) {
			return "用户已存在";
		}
		USERS.put(user.getName(), user);
		return "添加成功";
	}

}
