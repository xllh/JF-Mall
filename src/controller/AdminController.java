package controller;

import org.apache.commons.lang.StringUtils;
import interceptor.AdminInterceptor;
import com.jfinal.aop.Before;

@Before(AdminInterceptor.class)
public class AdminController extends CoreController {
	public void index(){
		String pageName = getPara(0);
		if(StringUtils.isBlank(pageName)){
			pageName = "index";
		}
		setAttr("page", pageName);
		renderVelocity("/manager/index.vm");
	}
}
