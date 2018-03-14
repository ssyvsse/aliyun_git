package com.ssyvsse.configuration.scheduer;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ssyvsse.constants.CookBookConstants;
import com.ssyvsse.dao.CookBookMapper;

/**
 * @author llb
 *
 * @Date 2018年3月14日 下午9:37:36
 */
@EnableScheduling
@Component
public class Scheduer {
	
	private Logger logger = LoggerFactory.getLogger(Scheduer.class);

	@Autowired
	private CookBookMapper cookBookMapper;
	

	@Scheduled(fixedDelay = 1000 * 60 * 20)
	public void updateClickRate() {
		Long start = System.currentTimeMillis();
		logger.info("=========>>>>>>>>>> 更新点击率 "+ start );
		Map<Integer, Integer> click_rate = CookBookConstants.CLICK_RATE;
		Set<Integer> keySet = click_rate.keySet();
		for (Integer id : keySet) {
			cookBookMapper.updateClickRate(id, click_rate.get(id));
		}
		CookBookConstants.CLICK_RATE.clear();
		logger.info("=========>>>>>>>>>> 更新点击率完毕 花费" + (System.currentTimeMillis() - start) + "ms");
	}

}
