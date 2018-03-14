package com.ssyvsse.service;

import java.util.List;

import com.ssyvsse.pojo.CookBook;
import com.ssyvsse.pojo.JsonResult;

/**
 * @author llb
 *
 * @Date 2018年3月13日 下午9:22:25 
 */
public interface CookBookService {

	public List<CookBook> getHostCookBook();
	
	public CookBook cookBook(Integer id);
	
}
