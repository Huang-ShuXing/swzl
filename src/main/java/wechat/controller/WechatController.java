package wechat.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import wechat.common.ReturnResult;
import wechat.model.Wechat;
import wechat.service.IUserService;
import wechat.service.IWechatService;

/**
 *@author Huang_Shuxing
 *2016年6月28日 下午10:53:47
 */
@Controller
@RequestMapping("/wechat")
@SessionAttributes("wechat")
public class WechatController {
	
	
	@Resource
	private IWechatService wechatService;
	@Resource
	private IUserService userService;
	/**
	 * 验证该wechat是否已经通过验证了
	 * @author Huang_Shuxing
	 * 2016年7月18日 下午11:28:02
	 * @param wechat
	 * @return
	 */
	@RequestMapping("/isAttestation")
	@ResponseBody
	public ReturnResult isAttestation(@ModelAttribute("wechat")Wechat wechat,Model model){
		ReturnResult result = new ReturnResult();
		wechat = wechatService.getByOpenId(wechat.getOpenid());
		model.addAttribute("wechat", wechat);
		if(wechat.getIsAttestation() == Wechat.HAS_ATTESTATION){
			result.setState(ReturnResult.SUCCESS);
		}else{
			result.setMsg("您还未验证，请先验证您的身份才能使用此功能");
		}
		return result;
	}
	@RequestMapping("/toAttestation")
	@ResponseBody
	public ReturnResult toAttestiation(@ModelAttribute("wechat")Wechat wechat,Model model){
		ReturnResult result = new ReturnResult();
		wechat = wechatService.getByOpenId(wechat.getOpenid());
		if(wechat.getIsAttestation() == Wechat.HAS_ATTESTATION){
			result.setMsg("您已经验证过了");
		}else if(wechat.getIsAttestation()==Wechat.ATTESTATION_ING){
			result.setMsg("您已经提交过验证，请等待管理员审核");
		}else{
			if(!userService.isAll(wechat.getOpenid())){
				//验证信息完全不 如果完全。。
				result.setMsg("请先完善您的个人信息之后再申请验证(学院专业必填)");
			}else {
				wechat.setIsAttestation(Wechat.ATTESTATION_ING);
				wechatService.update(wechat);
				result.setState(ReturnResult.SUCCESS);
				model.addAttribute("wechat", wechat);
				result.setMsg("已经申请验证，请等但管理员审核");
			}
		}
		return result;
	}

	
	
}
