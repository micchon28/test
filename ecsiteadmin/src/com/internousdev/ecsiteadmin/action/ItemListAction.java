package com.internousdev.ecsiteadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.internousdev.ecsiteadmin.dao.ItemListDAO;
import com.internousdev.ecsiteadmin.dto.ItemInfoDTO;

public class ItemListAction extends ActionSupport implements SessionAware{

	private List<ItemInfoDTO> iiDTOList=new ArrayList<ItemInfoDTO>();
	private Map<String, Object> session;

	public String execute(){
		//登録済みの商品情報をitemList.jspへ送るためのコードを書く。

		ItemListDAO ilDAO=new ItemListDAO();
		iiDTOList=ilDAO.getItemInfo();
		session.put("iiDTOListJSP", iiDTOList);
		//jsp上でのvalue"iiDTOListJSP"に、変数iiDTOListの値を格納する。

		return SUCCESS;
	}


	@Override
	public void setSession(Map<String, Object> session){
		this.session=session;
	}



}
