package com.wuxufang.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxufang.cms.dao.SlideMapper;
import com.wuxufang.cms.domain.Slide;
import com.wuxufang.cms.service.SlideService;

@Service
public class SlideServiceImpl implements SlideService {
	@Resource
	private SlideMapper slideMapper; 

	@Override
	public List<Slide> selects() {
		// TODO Auto-generated method stub
		return slideMapper.selects();
	}

}
