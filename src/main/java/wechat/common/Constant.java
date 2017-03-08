package wechat.common;
/**
 * 页面常量类
 * html页面可以直接使用的常量
 * springmvc 的 beetl 中配置
 * 这样使用  如 ${constant.ctx}
 * @author Huang_Shuxing
 *
 */
public class Constant {
	public static String ctx = "/localhost:8080/ssm_wechat";
	public static String projectName = "/ssm_wechat";
	public static int success = 1;
	public static int fail = 1;
	
	public String getCtx(){
		return ctx;
	}
	public String getProjectName(){
		return projectName;
	}
	
	public static int getSuccess() {
		return success;
	}
	public static int getFail() {
		return fail;
	}
	
	
	
}
