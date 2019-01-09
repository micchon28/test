package com.internousdev.ecsiteadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

import com.internousdev.ecsiteadmin.dao.ItemListDAO;
import com.internousdev.ecsiteadmin.dto.ItemInfoDTO;

public class ItemListAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute(){
		//登録済みの商品情報をitemList.jspへ送るためのコードを書く。

		ItemListDAO ilDAO=new ItemListDAO();
		ilDAO.getItemInfo(
				session.get("id").,
				session.get("item_name").toString(),
				session.get("item_price"),
				session.get("item_stock"),
				session.get("insert_date").toString(),
				session.get("update_date").toString());
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session=session;
	}


}
