package wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import wechat.model.Wechat;
import wechat.service.IAccessTokenService;
import wechat.service.ICoreService;
import wechat.service.IUserService;
import wechat.util.OauthCode;
import wechat.util.SignUtil;
import wechat.util.pojo.AccessToken;

@Controller
@SessionAttributes("wechatOpenId")
public class CoreController {
	@Resource
	private ICoreService coreService;
	@Resource
	private IUserService userService;
	@Resource
	private IAccessTokenService acService;
	/*public static String openId ="";*/
	/*private String token = "sunlight";
	private String encodingAESKey = "s8vFF4f6AWay3uAdJh79WD6imaam4BV6Kl4eL4UzgfM";
	private String corpId = "此处修改为你的企业ID";*/

	@RequestMapping(value = { "/ssm_wechat" }, method = RequestMethod.GET)
	public void coreJoinGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		
		/*  下面的东西在测试的时候屏蔽*/
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		System.out.println("request=" + request.getRequestURL());

		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		
		out.close();
		out = null;
		
	}

	@RequestMapping(value = { "/ssm_wechat" }, method = RequestMethod.POST)
	public void coreJoinPost(HttpServletRequest request,
			HttpServletResponse response,Model model) throws IOException {
		 request.setCharacterEncoding("UTF-8");  
	        response.setCharacterEncoding("UTF-8");  
	        System.out.println("post请求");
	  
	        // 调用核心业务类接收消息、处理消息  
	        String respMessage = coreService.processRequest(request,response);
	        
	        /*ModelAndView mav = new  ModelAndView();
	        model.addAttribute("wechatOpenId", request.getSession().getAttribute("wechatOpenId"));*/
	        /*mav.addObject("wechatOpenId", request.getSession().getAttribute("wechatOpenId"));*/
	        //mav.addObject("wechat",)
	        /*System.out.println(request.getSession().getAttribute("wechatOpenId"));*/
	        
	        // 响应消息  
	        PrintWriter out = response.getWriter();
	        System.out.println(respMessage.toString());
	        out.print(respMessage);  
	        out.close();  

	}
	@RequestMapping("/getCode")
    public ModelAndView weiXinOauth(
            @RequestParam(value = "code", required = true) String code,
            @RequestParam(value = "state",
            required = true) String state) {
		ModelAndView mav = new ModelAndView();
        System.out.println("Code============="+code+"==========state======="+state);
        AccessToken accessToken =OauthCode.getAccessToken(code);
        if(accessToken == null){
            accessToken =OauthCode.getAccessToken(code);        	
        }
        
        System.out.println(accessToken.getOpenid());
        System.out.println(accessToken.getToken());
        System.out.println(accessToken.getExpiresIn());
        System.out.println(accessToken.getRefresh_token());
        System.out.println(accessToken.getScope());
        
        /*accessToken = OauthCode.refreshAccessToken(accessToken.getRefresh_token());
        
        
        System.out.println(accessToken.getOpenid());
        System.out.println(accessToken.getToken());
        System.out.println(accessToken.getExpiresIn());
        System.out.println(accessToken.getRefresh_token());
        System.out.println(accessToken.getScope());*/
        
       /*Wechat wechat = OauthCode.getWechatUser(accessToken.getToken(), accessToken.getOpenid());
        System.out.println("city:"+wechat.getCity());
        System.out.println("headurl"+wechat.getHeadimgurl());*/
        
        
       /* System.out.println(OauthCode.isValue(accessToken.getToken(),"sss"));
        System.out.println(OauthCode.isValue(accessToken.getToken(),accessToken.getOpenid()));
       */
        mav.setViewName("redirect:/index.do?openId="+accessToken.getOpenid());
        return mav;
        
        
    }

}