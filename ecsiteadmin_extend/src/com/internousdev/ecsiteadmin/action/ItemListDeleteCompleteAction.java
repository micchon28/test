package com.internousdev.ecsiteadmin.action;

import com.opensymphony.xwork2.ActionSupport;

import com.internousdev.ecsiteadmin.dao.ItemListDeleteCompleteDAO;

public class ItemListDeleteCompleteAction extends ActionSupport{

	public String execute(){

		ItemListDeleteCompleteDAO ildcDAO=new ItemListDeleteCompleteDAO();
		ildcDAO.ItemListDelete();
		return SUCCESS;

	}

}
