package com.ssyvsse.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssyvsse.pojo.User;

/**
 * @author llb
 *
 * @Date 2018年3月24日 上午11:49:29
 */
@RestController
@RequestMapping("/cache")
public class TestCacheController {

	@Autowired
	private CacheService cacheService;

	@GetMapping("/findByName-{name}")
	public User findByName(@PathVariable("name") String name) {
		return cacheService.findByName(name);
	}
	
	@GetMapping("/findAll")
	public List<User> findAll() {
		return cacheService.findAll();
	}

	@GetMapping("/updateUser")
	public String updateUser(User user) {
		if(cacheService.updateUser(user)==null){
			return "修改失败";
		}
		return "修改成功";
	}
	
	@GetMapping("/findUserWithNoCache-{name}")
	public User findUserWithNoCache(@PathVariable("name") String name){
		return cacheService.findUserWithNoCache(name);
	}
	
	@GetMapping("/clearAllCache")
	public void clearAllCache(){
		cacheService.clearAllCache();
	}
	
	@GetMapping("/addUser")
	public String addUser(User user){
		return cacheService.addUser(user);
	}
}
