package com.internousdev.ecsiteadmin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
import java.util.List;
import java.util.ArrayList;
*/

import com.internousdev.ecsiteadmin.util.DBConnector;
import com.internousdev.ecsiteadmin.util.DateUtil;

public class BuyItemCompleteDAO {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private DateUtil dateUtil=new DateUtil();
	private String sql="INSERT INTO user_buy_item_transaction(item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) VALUES(?, ?, ?, ?, ?, ?)";
	//user_buy_item_transactionテーブルへ商品購入画面で入力した品名、数量等の情報を挿入する。
	//一行ずつしか購入データは入らない。

	public void buyItemInfo(String item_transaction_id, String total_price, String total_count, String user_master_id, String pay) throws SQLException{

		try{

			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()){

				preparedStatement.setString(1, item_transaction_id);
				preparedStatement.setString(2, total_price);
				preparedStatement.setString(3, total_count);
				preparedStatement.setString(4, user_master_id);
				preparedStatement.setString(5, pay);
				preparedStatement.setString(6, dateUtil.getDate());

			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			connection.close();
		}

	}
}
