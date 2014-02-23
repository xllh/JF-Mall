package controller;

import org.apache.commons.lang.StringUtils;

import com.jfinal.core.Controller;

public class LoginController extends Controller {
	public void index(){
		if(StringUtils.isBlank(getSession(true).getAttribute("email").toString())){
			render("/login.jsp");
		}else{
			String email = getPara("email");
			String password = getPara("password");
			if(StringUtils.equals(email, "123@qq.com")){
				getSession(true).setAttribute("email", email);
				render("/admin/index.jsp");
			}else{
				render("/login.jsp");
			}
		}
	}
}
