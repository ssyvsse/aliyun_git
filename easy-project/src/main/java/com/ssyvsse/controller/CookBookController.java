package com.ssyvsse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssyvsse.constants.CookBookConstants;
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

	@GetMapping("/cookBook")
	public String getCookBook(Integer id,Model model){
		Integer count = CookBookConstants.CLICK_RATE.get(id);
		if(count!=null){
			count = count ++;
			CookBookConstants.CLICK_RATE.put(id, count);
		}else{
			CookBookConstants.CLICK_RATE.put(id, 1);
		}
		CookBook cookBook = cookBookService.cookBook(id);
		model.addAttribute("cookBook",cookBook);
		return "detail";
	}
}
