package controller;

import interceptor.AdminInterceptor;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(AdminInterceptor.class)
public class AuthorityController extends Controller {
	public void index(){
		render("/manager/index.jsp");
	}
}
