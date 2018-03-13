package com.ssyvsse.configuration;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author llb
 *
 * @Date 2018年3月13日 下午7:32:53 
 */
@Component
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

	//	@Autowired
	//	private ServletContext servletContext;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			System.out.println("=====================================");
			System.out.println("============spring 初始化完成===========");
			System.out.println("============spring 初始化完成===========");
			System.out.println("=====================================");
		}
	}

}
