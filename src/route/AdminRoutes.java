package route;

import com.jfinal.config.Routes;

import controller.AdminController;

public class AdminRoutes extends Routes {

	@Override
	public void config() {
		this.add("/admin", AdminController.class);
	}
}
