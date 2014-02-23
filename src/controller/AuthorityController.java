package controller;

import org.apache.commons.lang.StringUtils;

import com.jfinal.core.Controller;

public class AuthorityController extends Controller {
	public void index(){
		if(StringUtils.isBlank(getSession().getAttribute("email").toString())){
			render("/login.jsp");
		}
	}
}
