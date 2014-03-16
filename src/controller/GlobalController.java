package controller;

public class GlobalController extends CoreController{
	public void index(){
		if(getPara(0)==null){
			render("/welcome.html");
		}
	}
}
