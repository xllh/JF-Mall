package bean;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import tool.GlobalTool;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final User dao = new User();
	
	public static String TableName(){
		return "adou_user";
	}
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
		String password_md5 = GlobalTool.md5_encode(password);
		if(StringUtils.isBlank(email) || StringUtils.isBlank(password)){
			return false;
		}
		List<User> userList = User.dao.find("SELECT * FROM adou_user WHERE email = ? AND password = ?", email, password_md5);
		if(userList.size()==1){
			return true;
		}else{
			return false;
		}
	}
}
