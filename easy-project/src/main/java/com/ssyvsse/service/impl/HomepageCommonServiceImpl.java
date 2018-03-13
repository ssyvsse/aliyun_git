package com.ssyvsse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ssyvsse.dao.HomepageCommonMapper;
import com.ssyvsse.pojo.HomepageCommon;
import com.ssyvsse.service.HomepageCommonService;

/**
 * @author llb
 *
 * @Date 2018年3月13日 下午8:13:31 
 */
@Service
public class HomepageCommonServiceImpl implements HomepageCommonService{

	@Autowired
	private HomepageCommonMapper HomepageCommonMapper;
	
	@Override
	public List<HomepageCommon> getNavication() {
		return HomepageCommonMapper.selectByTypeAndParentId("navigation", 10);
	}

}
