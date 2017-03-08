
package wechat.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wechat.common.Constant;
import wechat.dao.UserInfoDao;
import wechat.dao.WechatDao;
import wechat.message.response.Article;
import wechat.message.response.NewsMessage;
import wechat.message.response.TextMessage;
import wechat.model.UserInfo;
import wechat.model.Wechat;
import wechat.service.ICoreService;
import wechat.util.MessageUtil;
import wechat.util.MyStringUtil;
import wechat.util.PropertiesUtil;
import wechat.util.WeixinUtil;
import wechat.util.pojo.AccessToken;

@Service("coreService")
public class CoreService implements ICoreService{  
	
	@Autowired
	private WechatDao wechatDao;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
    /** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
	@Override
    public String processRequest(HttpServletRequest request,HttpServletResponse response) {  
        String respMessage = null;  
        try {  
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";  
  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            /*CoreController.openId = fromUserName;*/
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            /*request.getSession().setAttribute("wechatOpenId", fromUserName);*/
            
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
       
            String content =requestMap.get("Content");
            // 回复文本消息  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);
            
            
            //回复图片信息
            NewsMessage newsMessage = new NewsMessage();
            newsMessage.setToUserName(fromUserName);  
            newsMessage.setFromUserName(toUserName);  
            newsMessage.setCreateTime(new Date().getTime());  
            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
            newsMessage.setFuncFlag(0);  
            
            List<Article> articleList = new ArrayList<Article>();
            Article article = new Article();  

            /*article.setTitle("微信公众帐号开发教程Java版");  
            article.setDescription("柳峰，80后，微信公众帐号开发经验4个月。为帮助初学者入门，特推出此系列教程，也希望借此机会认识更多同行！");  
            article.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/WJI5zSOY8KKPWZ0cBIOECZTc4pmGK5fWgrnvcAZMg32kPicZnF10fIprwd7aYVrDibqNarLWuDhO8Qbs3gfuGL0w/0?wx_fmt=jpeg");  
            article.setUrl("http://blog.csdn.net/lyq8479");  
            articleList.add(article);*/
            
            article = new Article();
            article.setTitle("广州大学陆丰同乡会");  
            article.setDescription("广州大学陆丰同乡会");  
            article.setPicUrl("");//图片链接  
            article.setUrl("http://m.lftongxh.cn/ssm_wechat/index.do?openId="+fromUserName);  
            /*http://testMyWeiXin.tunnel.qydev.com*/
            /*http://m.lftongxh.cn*/
            articleList.add(article);  
            
            //设置图文消息个数
            newsMessage.setArticleCount(articleList.size());  
            //设置图文消息包含的图文集合
            newsMessage.setArticles(articleList);  
            
           
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            	if(content.startsWith("#")){
            		respContent = manager(content);
            	}else if(content.equals("同乡会")||content.equals("陆丰同乡会")){
            		respMessage = MessageUtil.newsMessageToXml(newsMessage);
            		insertOrUpdateWechat(fromUserName);
            	}else{
            		respContent = "您发送的是文本消息！";
            	}
                
                
            }  
            // 图片消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "您发送的是图片消息！";  
            }  
            // 地理位置消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "您发送的是地理位置消息！";  
            }  
            // 链接消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "您发送的是链接消息！";  
            }  
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "您发送的是音频消息！";  
            }  
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    //respContent = "谢谢您的关注！";
                    //插入新订阅者信息
                    //也插入一个微信的信息
                	respMessage = MessageUtil.newsMessageToXml(newsMessage);
                    insertOrUpdateWechat(fromUserName);
                }  
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                }  
                // 自定义菜单点击事件  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                    // TODO 自定义菜单权没有开放，暂不处理该类消息  
                	 respContent = "您点击了自定义菜单！"; 
                	 
                }else if (eventType.equals(MessageUtil.EVENT_TYPE_VIEW)) {  
                    // TODO 自定义菜单权没有开放，暂不处理该类消息  
                	 respContent = "您点击了自定义菜单连接！";
                	 response.sendRedirect(Constant.projectName+"test/test.do?openId="+fromUserName);
                }
                
            }  
            if(respMessage == null){
            	textMessage.setContent(respContent);  
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
           /* textMessage.setContent(respContent);  
            respMessage = MessageUtil.textMessageToXml(textMessage);*/
            
            /*respMessage = MessageUtil.newsMessageToXml(newsMessage);*/
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return respMessage;  
    }  
    
	
	@Override
    public  void insertOrUpdateWechat(String openId){
		/*String pathUrl = "/wechat.properties";
		Properties pro = PropertiesUtil.getProperties(pathUrl);
    	AccessToken accessTken =  WeixinUtil.getAccessToken(pro.get("appid").toString(),pro.get("appsecret").toString());
    	Wechat wechat  =WeixinUtil.getWechat(openId, accessTken.getToken());
    	wechat.setIsAttestation(Integer.valueOf(pro.get("isAttention").toString()));
    	
    	UserInfo userInfo = new UserInfo();
    	userInfo.setId(wechat.getId());
    	userInfo.setUserWechatOpenId(wechat.getOpenid());
    	
    	wechatDao.insertOrUpdate(wechat);
    	userInfoDao.insert(userInfo);*/
		String pathUrl = "/wechat.properties";
		Properties pro = PropertiesUtil.getProperties(pathUrl);
		Wechat wechat  = new Wechat();
		wechat.setId(MyStringUtil.getId());
		wechat.setOpenid(openId);
    	wechat.setIsAttestation(Integer.valueOf(pro.get("isAttention").toString()));
    	
    	UserInfo userInfo = new UserInfo();
    	userInfo.setId(wechat.getId());
    	userInfo.setUserWechatOpenId(wechat.getOpenid());
    	
    	wechatDao.insertOrUpdate(wechat);
    	userInfoDao.insert(userInfo);
    	
		
    }
    
    /**
     * 处理管理员的命令
     * #order#
     * @author Huang_Shuxing
     * 2016年8月3日 下午11:15:12
     * @param order
     * @return
     */
	public String manager(String order){
		String orderFront = order.substring(order.indexOf("#")+1, order.lastIndexOf("#"));
		String orderLater =  order.substring(order.lastIndexOf("#")+1).trim();
		switch (orderFront) {
		case "审核名单":
			return "这是审核名单\n"+orderLater +"\n这是审核名单\n"+orderLater;
			
		case "审核":
			return "这是审核结果\n"+orderLater;
			
		default:
			return "错误指令\n"+orderLater;
		}
	}
}
