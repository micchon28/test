package com.internousdev.ecsiteadmin.action;

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
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price", intCount * intPrice);
		String payment;

		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay", payment);
		} else{
			payment="クレジットカード";
			session.put("pay", payment);
		}
		return result;

	}

	public void setCount(int count){
		this.count=count;
	}

	/*sessionで受け取ったbuyItem.jspのチェックボックスcountの値を
	上記private int countへ格納する。（SessionAwareの働き？）*/

	public void setPay(String pay){
		this.pay=pay;
	}

	/*sessionで受け取ったbuyItem.jspのラジオボタンpayの値を
	上記private String payへ格納する。（SessionAwareの働き？）*/

	@Override
	public void setSession(Map<String, Object> session){
		this.session=session;
	}

}
