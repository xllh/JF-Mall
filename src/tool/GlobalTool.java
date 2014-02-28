package tool;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

public class GlobalTool {
	public static String Guid(){
		return UUID.randomUUID().toString();
	}
	
	public static String md5_encode(String origin){
		if(StringUtils.isBlank(origin)){
			return null;
		}
		return DigestUtils.md5Hex(origin);
	}
	public static void main(String[] args) {
//		System.out.println(Guid());
		System.out.println(md5_encode("03290817"));
	}
}
