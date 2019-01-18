package com.internousdev.ecsiteadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import java.util.List;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsiteadmin.dao.BuyItemDAO;
import com.internousdev.ecsiteadmin.dto.BuyItemDTO;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;

	public String execute(){
		String result="login";
		if(session.containsKey("id")){
			BuyItemDAO buyItemDAO=new BuyItemDAO();
			List<BuyItemDTO> buyItemDTOList=buyItemDAO.getBuyItemInfo();
			session.put("id", buyItemDTOList.get(0));
			session.put("buyItem_name", buyItemDTOList.get(1));
			session.put("buyItem_price", buyItemDTOList.get(2));
			result=SUCCESS;
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
