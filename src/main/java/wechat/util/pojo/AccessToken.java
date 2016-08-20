package wechat.util.pojo;
/**
 *@author Huang_Shuxing
 *2016年6月29日 下午10:43:01
 */
public class AccessToken {
	// 获取到的凭证  
    private String token;  
    // 凭证有效时间，单位：秒  
    private int expiresIn;  
    
    private String access_token;
    private String refresh_token;
    private String openid;
    private String scope;
    private String unionid;
    
    public AccessToken(String token, int expiresIn, String access_token, String refresh_token, String openid,
			String scope, String unionid) {
		super();
		this.token = token;
		this.expiresIn = expiresIn;
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.openid = openid;
		this.scope = scope;
		this.unionid = unionid;
	}
    
    public AccessToken() {
		super();
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getToken() {  
        return token;  
    }  
  
    public void setToken(String token) {  
        this.token = token;  
    }  
  
    public int getExpiresIn() {  
        return expiresIn;  
    }  
  
    public void setExpiresIn(int expiresIn) {  
        this.expiresIn = expiresIn;  
    }  
}
