package com.internousdev.ecsiteadmin.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsiteadmin.dao.BuyItemDAO;
import com.internousdev.ecsiteadmin.dao.LoginDAO;
import com.internousdev.ecsiteadmin.dto.BuyItemDTO;
import com.internousdev.ecsiteadmin.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();
	private BuyItemDAO buyItemDAO=new BuyItemDAO();

	public String execute(){
		String result=ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		//以下は、ログイン済みのユーザーの場合に、①result=SUCCESSを返す。②そのユーザーIDと登録済み商品情報を取得する。
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){ //セッションから取得したloginUserの値をLoginDTO型にキャスト

			if(((LoginDTO) session.get("loginUser")).getAdminFlg().equals("0")){

				result=SUCCESS;
				BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();

				session.put("login_user_id", loginDTO.getLoginId());
				session.put("id", buyItemDTO.getId());
				session.put("buyItem_name", buyItemDTO.getItemName());
				session.put("buyItem_price", buyItemDTO.getItemPrice());

				return result;

			} else{
				result="success_admin_login";
				session.put("login_user_id", loginDTO.getLoginId());
				session.put("is_admin", true);
				return result;
			}
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
