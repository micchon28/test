package com.internousdev.ecsiteadmin.action;

import com.internousdev.ecsiteadmin.dto.BuyItemDTO;
import com.internousdev.ecsiteadmin.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

import com.internousdev.ecsiteadmin.dao.BuyItemDAO;
import com.internousdev.ecsiteadmin.dto.BuyItemDTO;

public class BuyItemAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session; //もともとはpublicだった
	private int count;
	private String pay;
	private BuyItemDAO buyItemDAO=new BuyItemDAO();

	public String execute(){
		String result=SUCCESS;




		//if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			//result=SUCCESS;
			List<BuyItemDTO> buyItemDTOList=buyItemDAO.getBuyItemInfo();

			//session.put("login_user_id", loginDTO.getLoginId());
			session.put("buyItemDTOListJSP", buyItemDTOList);

			//return result;
		//}


		session.put("count", count); //buyItemConfirm.jspのpropertyの"count"へ、
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("itemPrice").toString());
		session.put("totalPrice", intCount * intPrice); //buyItemConfirm.jspのpropertyの"totalPrice"へ、個数*単価の積を記憶させる。
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
	} //sessionで受け取ったbuyItem.jspのチェックボックスcountの値を
	  //上記private int countへ格納する。（SessionAwareの働き？）

	public void setPay(String pay){
		this.pay=pay;
	} //sessionで受け取ったbuyItem.jspのチェックボックスcountの値を
	  //上記private int countへ格納する。（SessionAwareの働き？）

	@Override
	public void setSession(Map<String, Object> session){
		this.session=session;
	}

}
