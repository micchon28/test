package com.internousdev.ecsiteadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;


public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{

	private String newItemName;
	private int newItemPrice;
	private int newItemStock;
	public Map<String, Object> session;
	private String newItemCreateErrorMessage;

	public String execute(){

		String result=SUCCESS;
		if(!(newItemName.equals(""))
				&& (newItemPrice > 0)
				&& (newItemStock > 0)){

			session.put("newItemName", newItemName);
			session.put("newItemPrice", newItemPrice);
			session.put("newItemStock", newItemStock);

		} /* else if((newItemName.equals(""))
				&& (newItemPrice > 0)
				&& (newItemStock > 0)){

			//newItemName（商品名）が空欄だった場合、エラーを返す。
			setNewItemCreateErrorMessage("新規商品名が未入力です。");
			result=ERROR;

		} else if(!(newItemName.equals(""))
				&& (newItemPrice > 0)
				&& !(newItemStock > 0)){

			//newItemPrice（単価）が空欄もしくは正の整数値でない値であった場合、エラーを返す。
			setNewItemCreateErrorMessage("新規商品単価を正しく入力してください");
			result=ERROR;

		} else if(!(newItemName.equals(""))
				&& !(newItemPrice > 0)
				&& (newItemStock > 0)){

			//newItemStock（在庫数）が空欄もしくは正の整数値でない値であった場合、エラーを返す。
			setNewItemCreateErrorMessage("新規商品在庫数を正しく入力してください");
			result=ERROR;
		} else if{
			(!(newItemName.equals(""))
					&& !(newItemPrice > 0)
					&& (newItemStock > 0))
			result=ERROR;
		} */
		else{
			//いずれかの入力項目に空欄や不正な値があった場合、エラーを返す。
			setNewItemCreateErrorMessage("空欄または正しく入力が行われていない項目があります。");
			result=ERROR;
		}
		return result;
	}

	public String getNewItemName() {
		return newItemName;
	}



	public void setNewItemName(String newItemName) {
		this.newItemName = newItemName;
	}



	public int getNewItemPrice() {
		return newItemPrice;
	}



	public void setNewItemPrice(int newItemPrice) {
		this.newItemPrice = newItemPrice;
	}



	public int getNewItemStock() {
		return newItemStock;
	}



	public void setNewItemStock(int newItemStock) {
		this.newItemStock = newItemStock;
	}



	public String getNewItemCreateErrorMessage() {
		return newItemCreateErrorMessage;
	}



	public void setNewItemCreateErrorMessage(String newItemCreateErrorMessage) {
		this.newItemCreateErrorMessage = newItemCreateErrorMessage;
	}



	public Map<String, Object> getSession() {
		return session;
	}


	@Override
	public void setSession(Map<String, Object> session){
		this.session=session;
	}
}
