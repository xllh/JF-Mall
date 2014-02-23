package route;

import com.jfinal.config.Routes;

import controller.AuthorityController;
import controller.LoginController;

public class AdminRoutes extends Routes {

	@Override
	public void config() {
		this.add("/login", LoginController.class);
		this.add("/admin", AuthorityController.class);
	}

}
