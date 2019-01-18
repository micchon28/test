package com.internousdev.ecsiteadmin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsiteadmin.dto.BuyItemDTO;
import com.internousdev.ecsiteadmin.util.DBConnector;

public class BuyItemDAO {
	List <BuyItemDTO> buyItemDTOList=new ArrayList<BuyItemDTO>();

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();


	public List<BuyItemDTO> getBuyItemInfo(){
		String sql="SELECT id, item_name, item_price FROM item_info_transaction";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()){
				/* private */ BuyItemDTO buyItemDTO = new BuyItemDTO(); //もともとはBuyItemDAOクラス直下にあった。
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				buyItemDTOList.add(buyItemDTO);
			}

		} catch(Exception e){
			e.printStackTrace();
		}

		return buyItemDTOList;
	}

	/*
	public BuyItemDTO getBuyItemDTO(){
		return buyItemDTO;
	}
	*/

}

