package com.internousdev.ecsiteadmin.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

import com.internousdev.ecsiteadmin.dao.ItemCreateCompleteDAO;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{

	private String newItemName;
	private int newItemPrice;
	private int newItemStock;
	public Map<String, Object> session;
	private ItemCreateCompleteDAO iccDAO=new ItemCreateCompleteDAO();

	public String execute(){

		String newItemNameFetch=session.get("newItemName").toString();
		String newItemPriceFetchStr=session.get("newItemPrice").toString();
		String newItemStockFetchStr=session.get("newItemStock").toString();

		int newItemPriceFetchInt=new Integer(newItemPriceFetchStr);
		int newItemStockFetchInt=new Integer(newItemStockFetchStr);

		iccDAO.itemCreateInfo(newItemNameFetch, newItemPriceFetchInt, newItemStockFetchInt);

		String result=SUCCESS;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
