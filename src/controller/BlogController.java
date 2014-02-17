package controller;

import java.util.ArrayList;
import java.util.List;

import bean.Blog;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheKit;
import com.jfinal.plugin.ehcache.CacheName;

public class BlogController extends Controller{
	public void index(){
		List<String> blogs = new ArrayList<String>();
		blogs.add("blog1");
		blogs.add("blog2");
		blogs.add("blog3");
		CacheKit.put("blog", "blogAllList", blogs);
		List<String> blogList = CacheKit.get("blog", "blogAllList");
		setAttr("blogs", blogList);
		render("/blog/index.jsp");
	}
	
	@Before(CacheInterceptor.class)
	@CacheName("blog_list")
	public void list(){
		List<Blog> blogs = new ArrayList<Blog>();
		blogs = Blog.dao.find("select * from osc_blogs where id < ?", 5);
		setAttr("blogs", blogs);
		render("/blog/list.jsp");
	}
}