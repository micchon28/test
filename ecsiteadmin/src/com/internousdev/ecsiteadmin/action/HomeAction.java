package com.internousdev.ecsiteadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsiteadmin.dao.BuyItemDAO;
import com.internousdev.ecsiteadmin.dto.BuyItemDTO;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;

	public String execute(){
		String result="login";
		if(session.containsKey("id")){
			BuyItemDAO buyItemDAO=new BuyItemDAO();
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			result=SUCCESS;
		} else if(((Boolean) session.get("is_admin"))==null){
			session.put("is_admin", false);

		} else if(((Boolean) session.get("is_admin"))==true){
			result="success_admin_home";
		}
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public Map<String, Object> getSession(){
		return session;
	}

}
