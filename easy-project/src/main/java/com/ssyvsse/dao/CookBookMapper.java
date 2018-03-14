package com.ssyvsse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.ssyvsse.pojo.CookBook;
import com.ssyvsse.pojo.CookStep;

/**
 * @author llb
 *
 * @Date 2018年3月13日 下午9:07:29
 */
public interface CookBookMapper {

	List<CookBook> getHotestCookBookLimit(@Param("start") int start, @Param("limit") int limit);

	@Cacheable(value="cookBookCache",keyGenerator="myKey")
	List<String> getCookAlbumById(@Param("id") Integer id);

	CookBook selectCookBookById(@Param("id") Integer id);

	List<CookStep> getCookSteps(@Param("id") Integer id);

	@CacheEvict(value="cookBookCache",keyGenerator="myKey")
	int updateClickRate(@Param("id") int id, @Param("count") int count);
}
