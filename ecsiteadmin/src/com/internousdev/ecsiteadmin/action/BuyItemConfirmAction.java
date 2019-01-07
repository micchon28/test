package com.internousdev.ecsiteadmin.action;

import com.internousdev.ecsiteadmin.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.SQLException;
import java.util.Map;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO=new BuyItemCompleteDAO();

	public String execute() throws SQLException{
		buyItemCompleteDAO.buyItemInfo(
			session.get("id").toString(), //item_transaction_id（商品番号）
			session.get("total_price").toString(),
			session.get("count").toString(),
			session.get("login_user_id").toString(),
			session.get("pay").toString());

		String result=SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session=session;
	}

}
