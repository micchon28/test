package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

public class BuyItemAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private int count;
	private String pay;

	public String execute(){
		String result=SUCCESS;

		session.put("count", count);
		int intCount=

	}

}
