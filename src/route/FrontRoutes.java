package route;

import com.jfinal.config.Routes;

import controller.BlogController;
import controller.IndexController;

public class FrontRoutes extends Routes {

	@Override
	public void config() {
		add("/", IndexController.class);
		add("/blog", BlogController.class);
	}
}
