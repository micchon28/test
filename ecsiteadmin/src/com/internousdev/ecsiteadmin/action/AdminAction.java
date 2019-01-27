package com.internousdev.ecsiteadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware; //0127

public class AdminAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	public String execute(){
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session=session;
	}

}
