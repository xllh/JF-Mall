package interceptor;

import bean.User;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

public class AdminInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		Controller controller = ai.getController();
		User adouUser = controller.getSessionAttr("adou_user");
		if(adouUser != null){
			ai.invoke();
		}else{
			controller.render("/login.jsp");
		}
	}

}
