package controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import bean.User;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

public class ActionController extends Controller {
	public void login(){
		String email = getPara("email").trim();
		String password = getPara("password").trim();
		User user = new User();
		user.set("email", email);
		user.set("password", password);

		if(StringUtils.isBlank(email)){
			renderText("请输入邮箱地址");
		}
		if(StringUtils.isBlank(password)){
			renderText("请输入密码");
		}
		
		if(!User.isExistEmail(email)){
			renderText("邮箱不存在");
			return;
		}
		if(!User.CheckLogin(user)){
			renderText("密码错误");
			return;
		}
		
		getSession(true).setAttribute("adou_user", user);
		renderVelocity("/manager/index.vm");
	}
	
	public void logout(){
		HttpSession httpSess = getSession();
		if(httpSess == null){
			return;
		}
		User user = (User)httpSess.getAttribute("adou_user");
		if(user != null){
			httpSess.setAttribute("adou_user", null);
		}
		render("/index.jsp");
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
