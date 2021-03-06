package com.wuxufang.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxufang.cms.dao.ArticleMapper;
import com.wuxufang.cms.domain.Article;
import com.wuxufang.cms.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleMapper articleMapper;

	@Override
	public PageInfo<Article> selects(Article article, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Article> list = articleMapper.selects(article);
		return new PageInfo<Article>(list);
	}

	@Override
	public boolean update(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.update(article) >0;
	}

	@Override
	public Article select(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.select(id);
	}

	@Override
	public boolean insert(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.insert(article)>0;
	}

}
