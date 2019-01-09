package com.internousdev.ecsiteadmin.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsiteadmin.dto.ItemInfoDTO;
import com.internousdev.ecsiteadmin.util.DBConnector;


public class ItemListDAO {

	private DBConnector db=new DBConnector(); //DBConnectorクラスをインスタンス化
	private Connection con=db.getConnection();
	//Connectionクラスの変数conに、DBConnectorクラス内のgetConnection()メソッドの
	//実行結果を格納する。データベースに接続できたかどうか。

	private ItemInfoDTO iiDTO=new ItemInfoDTO();

	public ItemInfoDTO getItemInfo(int id, String itemName, int itemPrice, int itemStock, String insertDate, String updateDate){
		String sql="SELECT * FROM item_info_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				iiDTO.setId(rs.getInt("id"));
				iiDTO.setItemName(rs.getString("itemName"));
				iiDTO.setItemPrice(rs.getInt("itemPrice"));
				iiDTO.setItemStock(rs.getInt("itemStock"));
				iiDTO.setInsertDate(rs.getString("insertDate"));
				iiDTO.setUpdateDate(rs.getString("updateDate"));
			}

		} catch(SQLException e){
			e.printStackTrace();
		}

		return iiDTO;

	}
}
