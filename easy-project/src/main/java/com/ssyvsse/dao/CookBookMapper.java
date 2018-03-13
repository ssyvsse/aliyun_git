package com.ssyvsse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssyvsse.pojo.CookBook;

/**
 * @author llb
 *
 * @Date 2018年3月13日 下午9:07:29
 */
public interface CookBookMapper {

	List<CookBook> getHotestCookBookLimit(@Param("start") int start, @Param("limit") int limit);

	List<String> getCookAlbumById(@Param("id") Integer id);
}
