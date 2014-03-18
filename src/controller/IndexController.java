package controller;

import org.apache.commons.lang.StringUtils;

public class IndexController extends CoreController {
	public void index(){
		String param0 = getPara(0);
		if(StringUtils.isBlank(param0)){
			render("/welcome.html");
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
	
	public void test(){
		setAttr("para0", getPara(0));
		renderVelocity("/test.vm");
	}
	
	public void regist(){
		renderVelocity("regist.vm");
	}
	
	public void login(){
		renderVelocity("login.vm");
	}
}
