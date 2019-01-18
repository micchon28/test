package com.internousdev.ecsiteadmin.action;

import com.opensymphony.xwork2.ActionSupport;

import com.internousdev.ecsiteadmin.dao.UserListDeleteCompleteDAO;

public class UserListDeleteCompleteAction extends ActionSupport{

	public String execute(){
		UserListDeleteCompleteDAO uldcDAO=new UserListDeleteCompleteDAO();
		uldcDAO.UserListDelete();
		return SUCCESS;
	}
}
