package com.ssyvsse.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ssyvsse.dao.CookBookMapper;
import com.ssyvsse.pojo.CookBook;
import com.ssyvsse.pojo.CookStep;
import com.ssyvsse.service.CookBookService;

/**
 * @author llb
 *
 * @Date 2018年3月13日 下午9:41:06
 */
@Service
public class CookBookServiceImpl implements CookBookService {

	@Autowired
	private CookBookMapper cookBookMapper;

	@Override
	public List<CookBook> getHostCookBook() {
		List<CookBook> newList = new ArrayList<>();
		List<CookBook> list = cookBookMapper.getHotestCookBookLimit(0, 10);
		String album = null;
		List<String> albums = null;
		for (CookBook cookBook : list) {
			albums = cookBookMapper.getCookAlbumById(cookBook.getId());
			album = albums.size() > 0 ? albums.get(0) : null;
			cookBook.setAlbum(album);
			newList.add(cookBook);
		}
		return newList;
	}

	@Override
	@Cacheable(value="cookBookCache",keyGenerator="myKey")
	public CookBook cookBook(Integer id) {
		CookBook cookBook = cookBookMapper.selectCookBookById(id);
		List<CookStep> cookSteps = cookBookMapper.getCookSteps(id);
		Collections.sort(cookSteps, new Comparator<CookStep>() {  
            @Override  
            public int compare(CookStep cookStep1, CookStep cookStep2) {  
                if (cookStep1.getSort() > cookStep2.getSort()) {  
                    return 1;  
                }  
                if (cookStep1.getSort() == cookStep2.getSort()) {  
                    return 0;  
                }  
                return -1;  
            }  
        });  
		cookBook.setCookSteps(cookSteps);
		return cookBook;
	}

}
