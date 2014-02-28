package dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import bean.User;

public class UserDAO {
	//检查邮箱是否存在
	public static boolean isExistEmail(String email){
		if(StringUtils.isBlank(email)){
			return false;
		}
		List<User> userList = User.dao.find("SELECT * FROM adou_user WHERE email = ?", email);
		if(userList.size()==1){
			return true;
		}else{
			return false;
		}
	}
	//检查邮箱和密码是否存在
	public static boolean CheckLogin(User user){
		String email = user.getStr("email").trim();
		String password = user.getStr("password").trim();
		if(StringUtils.isBlank(email) || StringUtils.isBlank(password)){
			return false;
		}
		List<User> userList = User.dao.find("SELECT * FROM adou_user WHERE email = ? AND password = ?", email, password);
		if(userList.size()==1){
			return true;
		}else{
			return false;
		}
	}
}