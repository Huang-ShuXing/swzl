package wechat.controller;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wechat.util.WeixinUtil;
import wechat.util.pojo.AccessToken;
import wechat.util.pojo.Button;
import wechat.util.pojo.CommonButton;
import wechat.util.pojo.ComplexButton;
import wechat.util.pojo.Menu;
import wechat.util.pojo.ViewButton;

/**
 *@author Huang_Shuxing
 *2016年6月29日 下午10:48:14
 */
public class Test {
	private static Logger log = LoggerFactory.getLogger(Test.class);  
	  
    public static void main(String[] args) throws UnsupportedEncodingException {  
        // 第三方用户唯一凭证  
        /*String appId = "wx162c50b1fb4cb31d";*/  
        
        // 第三方用户唯一凭证密钥  
        /*String appSecret = "cad3ecaf9f57438b41841d66209c810b";*/
    	//浮云医疗
        String appId = "wx162c50b1fb4cb31d";  
        String appSecret = "cad3ecaf9f57438b41841d66209c810b";
        
        
        // 调用接口获取access_token  
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);  
  
        if (null != at) {  
            // 调用接口创建菜单  
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());  
  
            // 判断菜单创建结果  
            if (0 == result)  
                {log.info("菜单创建成功！");  
            	System.out.println("菜单创建成功！");}
            else  {
                log.info("菜单创建失败，错误码：" + result);
                System.out.println("菜单创建失败！" + result);    
            }  
        }  
    }  
  
    /** 
     * 组装菜单数据 
     *  
     * @return 
     * @throws UnsupportedEncodingException 
     */  
    private static Menu getMenu() throws UnsupportedEncodingException {  
        CommonButton btn11 = new CommonButton();  
        btn11.setName("天气预报");  
        btn11.setType("click");  
        btn11.setKey("11");  
  
        CommonButton btn12 = new CommonButton();  
        btn12.setName("公交查询");  
        btn12.setType("click");  
        btn12.setKey("12");  
  
        CommonButton btn13 = new CommonButton();  
        btn13.setName("周边搜索");  
        btn13.setType("click");  
        btn13.setKey("13");  
  
        CommonButton btn14 = new CommonButton();  
        btn14.setName("历史上的今天");  
        btn14.setType("click");  
        btn14.setKey("14");  
  
        CommonButton btn21 = new CommonButton();  
        btn21.setName("歌曲点播");  
        btn21.setType("click");  
        btn21.setKey("21");  
  
        CommonButton btn22 = new CommonButton();  
        btn22.setName("经典游戏");  
        btn22.setType("click");  
        btn22.setKey("22");  
  
        CommonButton btn23 = new CommonButton();  
        btn23.setName("美女电台");  
        btn23.setType("click");  
        btn23.setKey("23");  
  
        CommonButton btn24 = new CommonButton();  
        btn24.setName("人脸识别");  
        btn24.setType("click");  
        btn24.setKey("24");  
  
        CommonButton btn25 = new CommonButton();  
        btn25.setName("聊天唠嗑");  
        btn25.setType("click");  
        btn25.setKey("25");  
  
        CommonButton btn31 = new CommonButton();  
        btn31.setName("Q友圈");  
        btn31.setType("click");  
        btn31.setKey("31");  
  
        CommonButton btn32 = new CommonButton();  
        btn32.setName("电影排行榜");  
        btn32.setType("click");  
        btn32.setKey("32");  
  
        CommonButton btn33 = new CommonButton();  
        btn33.setName("幽默笑话");  
        btn33.setType("click");  
        btn33.setKey("33");  
  
        ComplexButton mainBtn1 = new ComplexButton();  
        mainBtn1.setName("生活助手");  
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });  
  
        ComplexButton mainBtn2 = new ComplexButton();  
        mainBtn2.setName("休闲驿站");  
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24, btn25 });  
  
        ComplexButton mainBtn3 = new ComplexButton();  
        mainBtn3.setName("更多体验");  
        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });  
  
        /** 
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br> 
         *  
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br> 
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        Menu menu = new Menu();
        
        ViewButton btn = new ViewButton();  
        btn.setName("通讯录收集");  
        btn.setType("view");  
        btn.setUrl("http://testMyWeiXin.tunnel.qydev.com/ssm_wechat/test/test.do");
        
        ViewButton btn2 = new ViewButton();  
        btn2.setName("广大陆丰同乡会");  
        btn2.setType("view");  
        
        // url进行编码
        String url = "http://m.lftongxh.cn/ssm_wechat/getCode.do";
        String url_encode = java.net.URLEncoder.encode(url, "utf-8");
        System.out.println(url_encode);
        btn2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx162c50b1fb4cb31d&"
        		+ "redirect_uri="+url_encode+"&" 
        		+ "response_type=code&scope=snsapi_base&state=1#wechat_redirect");
        
        //scopr=snsapi_userinfo
        	/*testMyWeiXin.tunnel.qydev.com/ssm_wechat*/
        	
        
        
        menu.setButton(new Button[] { btn2});
        /*menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });*/  
  
        return menu;  
    }  

}
