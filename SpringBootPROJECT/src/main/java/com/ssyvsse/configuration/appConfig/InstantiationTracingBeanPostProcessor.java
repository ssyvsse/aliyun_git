package com.ssyvsse.configuration.appConfig;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ssyvsse.cache.CacheService;

/**
 * SpringBoot initial class.
 * 
 * @author llb
 *
 * @Date 2018年3月21日 下午7:40:49
 */
@Component
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ServletContext servletContext;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			System.out.println("=====================================");
			System.out.println("==========spring 初始化完成==========");
			System.out.println("==========spring 初始化完成==========");
			System.out.println("=====================================");
		}

		com.ssyvsse.pojo.User user = new com.ssyvsse.pojo.User();
		user.setName("ssyvsse");
		user.setAge(26);
		com.ssyvsse.pojo.User user2 = new com.ssyvsse.pojo.User();
		user2.setName("llb");
		user2.setAge(27);
		CacheService.USERS.put(user.getName(), user);
		CacheService.USERS.put(user2.getName(), user2);

	}

}
