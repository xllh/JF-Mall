package controller;

import com.jfinal.core.Controller;
import com.jfinal.render.VelocityRender;

import extension.MyVelocityRender;

public class CoreController extends Controller {
	public void renderVelocity(String view){
		render(new MyVelocityRender(view));
	}
}
