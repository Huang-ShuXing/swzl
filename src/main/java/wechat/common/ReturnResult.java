package wechat.common;

import java.util.HashMap;
import java.util.Map;
/**
 * 返回结果公用类
 * 可以参考userController 的ajaxLogin方法
 * @author Huang_Shuxing
 *
 */
public class ReturnResult {
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	
	private int state;
	private String msg ;
	public Map<String,Object> data ;
	private Object obj;
	
	public ReturnResult(int state, String msg, Map<String, Object> data) {
		super();
		this.state = state;
		this.msg = msg;
		this.data = data;
	}
	public ReturnResult() {
		super();
		state = FAIL;//默认为0
		data = new HashMap<String, Object>();
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
	
}
