package controller;

import com.jfinal.core.Controller;

public class LoginController extends Controller {
	public void index(){
		String email = getPara("email");
		String password = getPara("password");
		System.out.println(email+password);
		setAttr("email", email);
		render("/admin/index.jsp");
	}
}
