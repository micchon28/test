package com.internousdev.ecsiteadmin.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsiteadmin.dao.BuyItemDAO;
import com.internousdev.ecsiteadmin.dao.LoginDAO_backup;
import com.internousdev.ecsiteadmin.dto.BuyItemDTO;
import com.internousdev.ecsiteadmin.dto.LoginDTO_backup;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction_backup extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO_backup loginDAO_backup=new LoginDAO_backup();
	private LoginDTO_backup loginDTO_backup=new LoginDTO_backup();
	private BuyItemDAO buyItemDAO=new BuyItemDAO();

	public String execute(){
		String result=ERROR;
		loginDTO_backup=loginDAO_backup.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO_backup);

		//以下は、ログイン済みのユーザーの場合に、①result=SUCCESSを返す。②そのユーザーIDと登録済み商品情報を取得する。
		if(((LoginDTO_backup) session.get("loginUser")).getLoginFlg()){ //セッションから取得したloginUserの値をLoginDTO型にキャスト
			result=SUCCESS;
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();

			session.put("login_user_id", loginDTO_backup.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			return result;
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session=session;
	}

}
