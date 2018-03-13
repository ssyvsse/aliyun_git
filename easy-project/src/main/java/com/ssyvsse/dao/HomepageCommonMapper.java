package com.ssyvsse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ssyvsse.pojo.HomepageCommon;

/**
 * @author llb
 *
 * @Date 2018年3月13日 下午8:05:15
 */
public interface HomepageCommonMapper {

	// @Cacheable(value="resourceCache",keyGenerator="myKey")
	@Select("select * from homepage_common where type=#{type} and parentid = #{pid}")
	List<HomepageCommon> selectByTypeAndParentId(@Param("type") String type, @Param("pid") Integer pid);
}
