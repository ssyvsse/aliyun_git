package com.ssyvsse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping({ "/welcome", "/" })
	public String welcome(Model model,HttpSession session) {
		List<HomepageCommon> list = homepageCommonService.getNavication();
		model.addAttribute("navigation",list);
		session.getServletContext().setAttribute("navigation",list);
		return "welcome";
	}
	
}
