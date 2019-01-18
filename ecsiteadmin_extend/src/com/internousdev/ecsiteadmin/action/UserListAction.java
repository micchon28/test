package com.internousdev.ecsiteadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.internousdev.ecsiteadmin.dao.UserListDAO;
import com.internousdev.ecsiteadmin.dto.UserInfoDTO;

public class UserListAction extends ActionSupport implements SessionAware{

	private List<UserInfoDTO> uiDTOList=new ArrayList<UserInfoDTO>();
	private Map<String, Object> session;

	public String execute(){
		//登録済みの商品情報をitemList.jspへ送るためのコードを書く。

		UserListDAO ulDAO=new UserListDAO();
		uiDTOList=ulDAO.getUserInfo();
		session.put("uiDTOListJSP", uiDTOList);
		//jsp上でのvalue"uiDTOListJSP"に、変数uiDTOListの値を格納する。

		return SUCCESS;
	}


	@Override
	public void setSession(Map<String, Object> session){
		this.session=session;
	}

}
