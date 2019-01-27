package com.internousdev.ecsiteadmin.action;

import com.opensymphony.xwork2.ActionSupport;

import com.internousdev.ecsiteadmin.dao.UserListGeneralDeleteCompleteDAO;

public class UserListGeneralDeleteCompleteAction extends ActionSupport{

	public String execute(){
		UserListGeneralDeleteCompleteDAO ulgdcDAO=new UserListGeneralDeleteCompleteDAO();
		ulgdcDAO.UserListGeneralDelete();
		return SUCCESS;
	}
}
