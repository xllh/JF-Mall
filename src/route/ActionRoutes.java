package route;

import com.jfinal.config.Routes;

import controller.ActionController;

public class ActionRoutes extends Routes {

	@Override
	public void config() {
		this.add("/action", ActionController.class);
	}

}
