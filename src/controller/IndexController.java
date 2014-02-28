package controller;

import org.apache.commons.lang.StringUtils;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
	public void index(){
		String param0 = getPara(0);
		System.out.println("hehehhe");
		if(StringUtils.isBlank(param0)){
			render("/index.jsp");
		}
	}
	
	public void json(){
		setAttr("name", "ppt");
		setAttr("age", "23");
		renderJson();
	}
	
	public void error(){
		renderError(404, "/404.html");
	}
}
