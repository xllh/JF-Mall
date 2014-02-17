package route;

import com.jfinal.config.Routes;

import controller.LoginController;

public class AdminRoutes extends Routes {

	@Override
	public void config() {
		this.add("/login", LoginController.class);
	}

}
