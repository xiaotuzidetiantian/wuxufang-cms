package com.wuxufang.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wuxufang.cms.domain.Links;

public interface LinksService {

	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加
	 * @param links
	 * @return
	 * @return: int
	 */
	boolean insert(Links links);
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 列表
	 * @return
	 * @return: PageInfo<Links>
	 */
	PageInfo<Links> selects(Integer page,Integer pageSize);
}
