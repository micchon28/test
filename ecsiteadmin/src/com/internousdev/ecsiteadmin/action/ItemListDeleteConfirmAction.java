package com.internousdev.ecsiteadmin.action;

import com.opensymphony.xwork2.ActionSupport;

import com.internousdev.ecsiteadmin.dao.ItemListDeleteConfirmDAO;

public class ItemListDeleteConfirmAction extends ActionSupport{


	public String execute(){
		ItemListDeleteConfirmDAO ildcDAO=new ItemListDeleteConfirmDAO();


		return SUCCESS;
	}

}
