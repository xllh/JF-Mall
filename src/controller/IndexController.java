package controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
	public void index(){
		String param0 = getPara(0);
		System.out.println(param0);
		int param1 = getParaToInt(1);
		System.out.println(param1);
//		renderText("Hello JFinal World3."+param);
		setAttr("name", "obama");
		render("/index.jsp");
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
