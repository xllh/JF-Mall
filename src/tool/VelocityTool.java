package tool;

import bean.Blog;
import bean.User;

public class VelocityTool {
	public static Blog getBlog(){
		return Blog.dao;
	}
	public static User getUser(){
		return User.dao;
	}
}
