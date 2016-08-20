package wechat.util;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import wechat.model.Wechat;
import wechat.util.pojo.AccessToken;

/**
 * @author Huang_Shuxing 2016年7月1日 下午9:17:27
 */
public class OauthCode {

	// web授权
	// 获取code后，请求以下链接获取access_token：
	public static String access_token_by_code = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	// 获取第二步的refresh_token后，请求以下链接获取access_token：
	public static String refresh_access_token_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	//拉取用户信息(需scope为 snsapi_userinfo)
	public static String userinfo_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	//验证授权是否还有效
	//http：GET（请使用https协议）
	public static String access_token_is_value ="https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
	private static Logger log = LoggerFactory.getLogger(OauthCode.class);

	/**
	 * 通过网页授权获取的code查询accessToken
	 * 
	 * @author Huang_Shuxing 2016年6月30日 下午11:34:28
	 * @param code
	 * @return
	 */
	public static AccessToken getAccessToken(String code) {

		String pathUrl = "/wechat.properties";
		Properties pro = PropertiesUtil.getProperties(pathUrl);

		AccessToken accessToken = null;

		String requestUrl = access_token_by_code.replace("APPID", pro.get("appid").toString())
				.replace("SECRET", pro.get("appsecret").toString()).replace("CODE", code);

		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
				accessToken.setRefresh_token(jsonObject.getString("refresh_token"));
				accessToken.setOpenid(jsonObject.getString("openid"));
				accessToken.setScope(jsonObject.getString("scope"));
				if (jsonObject.containsKey("unionid")) {
					accessToken.setUnionid(jsonObject.getString("unionid"));
				}
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}

	/**
	 * 刷新access_token
	 * 
	 * @author Huang_Shuxing 2016年7月1日 下午10:00:03
	 * @param refreshToken
	 * @return
	 */
	public static AccessToken refreshAccessToken(String refreshToken) {

		String pathUrl = "/wechat.properties";
		Properties pro = PropertiesUtil.getProperties(pathUrl);

		AccessToken accessToken = null;

		String requestUrl = refresh_access_token_url.replace("APPID", pro.get("appid").toString())
				.replace("REFRESH_TOKEN", refreshToken);

		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
				accessToken.setRefresh_token(jsonObject.getString("refresh_token"));
				accessToken.setOpenid(jsonObject.getString("openid"));
				accessToken.setScope(jsonObject.getString("scope"));
				if (jsonObject.containsKey("unionid")) {
					accessToken.setUnionid(jsonObject.getString("unionid"));
				}
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	
	}
	/**
	 * 拉取用户信息
	 * @author Huang_Shuxing
	 * 2016年7月1日 下午10:34:30
	 * @param accessToken
	 * @param openId
	 * @return
	 */
public static Wechat getWechatUser(String accessToken,String openId){
		Wechat wechat = null;
		String requestUrl = userinfo_url.replace("OPENID",openId).replace("ACCESS_TOKEN", accessToken);
		System.out.println(requestUrl);
		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
		System.out.println(jsonObject);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				wechat = new Wechat();
				wechat.setOpenid(jsonObject.getString("openid"));
				wechat.setNickname(jsonObject.getString("nickname"));
				wechat.setSex(jsonObject.getInt("sex"));
				wechat.setProvince(jsonObject.getString("province"));
				wechat.setCity(jsonObject.getString("city"));
				wechat.setCountry(jsonObject.getString("country"));
				wechat.setHeadimgurl(jsonObject.getString("headimgurl"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return wechat;
	}
	
	/**
	 * 检验凭证是否有效
	 * @author Huang_Shuxing
	 * 2016年7月1日 下午10:16:31
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	public static boolean isValue(String accessToken,String openId){
		
		
		String requestUrl = access_token_is_value.replace("OPENID",openId)
				.replace("ACCESS_TOKEN", accessToken);
		System.out.println(requestUrl);
		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
		System.out.println(jsonObject);
		// 如果请求成功
		if (null != jsonObject&&jsonObject.getInt("errcode")==0) {
			 return true;
		}else {
			return false;
		}
		
	}
}
