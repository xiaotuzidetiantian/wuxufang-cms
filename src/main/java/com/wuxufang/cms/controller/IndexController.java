package com.wuxufang.cms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wuxufang.cms.domain.Article;
import com.wuxufang.cms.domain.Category;
import com.wuxufang.cms.domain.Channel;
import com.wuxufang.cms.domain.Compent;
import com.wuxufang.cms.domain.Slide;
import com.wuxufang.cms.domain.User;
import com.wuxufang.cms.service.ArticleService;
import com.wuxufang.cms.service.ChannelService;
import com.wuxufang.cms.service.CompentService;
import com.wuxufang.cms.service.SlideService;
import com.wuxufang.util.DateUtil;

@Controller
public class IndexController {
	
	@Resource
	private ChannelService channelService;
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private SlideService slideService;
	@Resource
	private CompentService compentService;
	
	@RequestMapping(value = {"","/","index"})
	public String index(Model model,Article article,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "5")Integer pageSize) {
		article.setStatus(1);//查询审核过的文章
		article.setDeleted(0);//未删除
		//查询出所有的栏目
		List<Channel> channels = channelService.selects();
		model.addAttribute("channels", channels);
		
		
		if(article.getChannelId()!=null) {//如果栏目不为空空则显示栏目及分类下文章
		//根据栏目查询其下所有分类
		List<Category> categorys = channelService.selectsByCid(article.getChannelId());
		model.addAttribute("categorys", categorys);
		model.addAttribute("article", article);
		//根据栏目或分类查询文章
		PageInfo<Article> info = articleService.selects(article, page, pageSize);
		model.addAttribute("info", info);
		}else {
	       //显示热点文章
			PageInfo<Article> hotInfo = articleService.selects(article, page, pageSize);
			model.addAttribute("info", hotInfo);
			//查询广告
			List<Slide> slides = slideService.selects();
			model.addAttribute("slides",slides);
		}
		
		
		//查询出最新的5篇文章
		
		Article lastArticle = new Article();
		lastArticle.setStatus(1);//只能查询最新的并且审过的文章
		lastArticle.setDeleted(0);//未删除
		PageInfo<Article> lastInfo = articleService.selects(null, 1, 5);
		model.addAttribute("lastInfo", lastInfo);
		
		
		//查询24小时热文
		
		Article hot24Article = new Article();
		hot24Article.setStatus(1);//审核过的
		hot24Article.setHot(1);//热门文章
		
		hot24Article.setCreated(DateUtil.subDate(new Date()));//调用工具类，系统时间向前推荐24个小时
		PageInfo<Article> hot24ArticleInfo = articleService.selects(hot24Article, 1, 4);//24小时热文，默认显示4条
		model.addAttribute("hot24ArticleInfo", hot24ArticleInfo);
		return "index/index";
		
	}
	
	/**
	 * 
	 * @Title: articleDetail 
	 * @Description:文章详情和文章对应的评论
	 * @param model
	 * @param id  文章ID 
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("articleDetail")
	public String articleDetail(Model model ,Integer id,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "5")Integer pageSize) {
		//文章内容
		Article article = articleService.select(id);
		model.addAttribute("article", article);
		
		//文章对应的评论
		PageInfo<Compent> compentInfo = compentService.selects(id, page, pageSize);
		model.addAttribute("info", compentInfo);
		
		return "index/article";
	}
	/**
	 * 
	 * @Title: addContent 
	 * @Description: 增加评论
	 * @param compent
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("addContent")
	public boolean addContent(Compent compent,HttpServletRequest request) {
	
		
		HttpSession session = request.getSession();//获取session
		User user = (User) session.getAttribute("user");//从session 获取登录人的信息
		
		if(null==user) {//如果sesssion没有登录信息，则不能评论
			return false;
		}
		//评论人
		compent.setUser(user);
		//评论时间
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		compent.setCreated(fmt.format(new Date()));
		
		return compentService.insert(compent) >0;
		
	}

}
