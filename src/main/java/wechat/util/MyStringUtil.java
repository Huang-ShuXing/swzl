package wechat.util;
/**
 *@author Huang_Shuxing
 *2016年8月21日 下午4:39:53
 */
public class MyStringUtil {
	
	public static boolean isEmpty(String value){
		return null == value || "".equals(value.trim()) ;
 	}
	
	
	public static String getId(){
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}
}
