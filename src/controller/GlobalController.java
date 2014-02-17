package controller;

import com.jfinal.core.Controller;

public class GlobalController extends Controller{
	public void index(){
		if(getPara(0)==null){
			render("/welcome.html");
		}
	}
}
