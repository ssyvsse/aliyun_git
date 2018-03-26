package com.ssyvsse;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author llb
 *
 * @Date 2018年3月21日 下午7:38:28
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@EnableScheduling
public class SpringBootApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootApp.class);
	}

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootApp.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootApp.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}
}
