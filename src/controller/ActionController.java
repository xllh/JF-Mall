package controller;

import java.io.File;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

public class ActionController extends Controller {
	public void login(){
		String email = getPara("email");
		String password = getPara("password");
		System.out.println(email+password);
		getSession(true).setAttribute("email", email);
		setAttr("email", email);
		render("/admin/index.jsp");
	}
	public void uploadFile(){
		String WEB_ROOT_PATH = this.getRequest().getServletContext().getRealPath("/");
		UploadFile uploadFile = getFile("img",WEB_ROOT_PATH+File.separator+"upload"+File.separator+"file");
		String name = getPara("name");
		System.out.println(name);
		System.out.println(uploadFile.getFileName());
		File file = uploadFile.getFile();
		System.out.println(file.getAbsolutePath());
		renderText("上传成功");
	}
	public void downloadFile(){
		String WEB_ROOT_PATH = this.getRequest().getServletContext().getRealPath("/");
		String fileName = getPara("file");
		if(fileName!=""&&fileName.contains(".")){
			String file = WEB_ROOT_PATH+"upload"+File.separator+"file"+File.separator+fileName;
			System.out.println(file);
			renderFile("/upload/file/123.zip");
		}else{
			renderError(404, "/404.html");
		}
	}
}
