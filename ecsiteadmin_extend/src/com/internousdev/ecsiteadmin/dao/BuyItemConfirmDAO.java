package com.internousdev.ecsiteadmin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsiteadmin.dto.BuyItemConfirmDTO;
import com.internousdev.ecsiteadmin.util.DBConnector;

public class BuyItemConfirmDAO {
	List <BuyItemConfirmDTO> buyItemConfirmDTOList=new ArrayList<BuyItemConfirmDTO>();

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();


	public List<BuyItemConfirmDTO> getBuyItemConfirmInfo(){
		String sql="SELECT id, item_name, item_price FROM item_info_transaction";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()){
				/* private */ BuyItemConfirmDTO buyItemConfirmDTO = new BuyItemConfirmDTO(); //もともとはBuyItemDAOクラス直下にあった。
				buyItemConfirmDTO.setId(resultSet.getInt("id"));
				buyItemConfirmDTO.setItemName(resultSet.getString("item_name"));
				buyItemConfirmDTO.setItemTotalPrice(resultSet.getString("item_price"));
				buyItemConfirmDTOList.add(buyItemConfirmDTO);
			}

		} catch(Exception e){
			e.printStackTrace();
		}

		return buyItemDTOList;


	session.put("itemName", itemName);
	int intCount=Integer.parseInt(session.get("count").toString());
	int intPrice=Integer.parseInt(session.get("ItemPrice").toString());


}
