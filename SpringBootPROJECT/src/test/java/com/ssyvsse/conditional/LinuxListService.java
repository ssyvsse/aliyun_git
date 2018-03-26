package com.ssyvsse.conditional;

/**
 * @author llb
 *
 * @Date 2018年3月24日 下午7:49:28
 */
public class LinuxListService implements ListService {

	@Override
	public String showListCmd() {
		return "ls";
	}

}
