package controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import parameter.PageParam;
import bean.Blog;
import bean.myPage;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheName;

public class BlogController extends Controller{
	@Before(CacheInterceptor.class)
	@CacheName("blog_uid")
	public void index(){
		String uid = getPara(0);
		if(StringUtils.isBlank(uid)){
			render("/blog/list.jsp");
		}else{
			setAttr("uid", uid);
			List<Blog> blogList = Blog.dao.find("SELECT * FROM adou_blog WHERE guid = ?", uid);
			if(blogList!=null){
				setAttr("singleBlog", blogList.get(0));
				render("/blog/index.jsp");
			}else{
				render("404.html");
			}
		}
	}
	
	@Before(CacheInterceptor.class)
	@CacheName("blog_page_list")
	public void list(String sqlExceptSelect){
		int pageNum = 1;
		int pageSize = PageParam.DEFAULT_PAGE_SIZE;
		try{
			if(StringUtils.isNotBlank(getPara(0))){
				pageNum = Integer.parseInt(getPara(0));
			}
			if(StringUtils.isNotBlank(getPara(1))){
				pageSize = Integer.parseInt(getPara(1));
			}
			System.out.println(pageNum+"-"+pageSize);
		}catch(Exception e){
			render("/blog/list.jsp");
		}
		myPage<Blog> blogs = (myPage<Blog>) Blog.dao.paginate(pageNum, pageSize, "SELECT * FROM adou_blog", sqlExceptSelect);
		System.out.println(blogs.getPageNumber()+"-"+blogs.getPageSize());
		setAttr("blogPageList", blogs);
		render("/blog/list.jsp");
	}
}