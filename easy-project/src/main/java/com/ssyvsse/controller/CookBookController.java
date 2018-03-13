package com.ssyvsse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssyvsse.pojo.CookBook;
import com.ssyvsse.pojo.JsonResult;
import com.ssyvsse.service.CookBookService;

/**
 * @author llb
 *
 * @Date 2018年3月13日 下午9:00:04
 */
@RequestMapping("/cook")
@Controller
public class CookBookController {

	@Autowired
	private CookBookService cookBookService;

	@RequestMapping("/getHotest")
	@ResponseBody
	public JsonResult getCookBooks() {
		List<CookBook> list = cookBookService.getHostCookBook();
		if (list == null || list.size() == 0) {
			return JsonResult.failure("暂无数据");
		}
		return JsonResult.success(list);
	}

}
