package wechat.util.pojo;

/**
 * @author Huang_Shuxing 2016年6月29日 下午10:44:47
 */
public class ComplexButton extends Button {
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
