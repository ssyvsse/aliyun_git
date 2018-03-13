package com.ssyvsse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssyvsse.pojo.HomepageCommon;
import com.ssyvsse.service.HomepageCommonService;

/**
 * @author llb
 *
 * @Date 2018年3月13日 下午2:00:40
 */
@Controller
public class IndexController {

	@Autowired
	private HomepageCommonService homepageCommonService;
	
	@RequestMapping({ "/welcome", "/" })
	public String welcome(Model model) {
		List<HomepageCommon> list = homepageCommonService.getNavication();
		model.addAttribute("navigation",list);
		return "welcome";
	}
}
