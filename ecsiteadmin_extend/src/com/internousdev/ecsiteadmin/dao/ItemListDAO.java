package com.internousdev.ecsiteadmin.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsiteadmin.dto.ItemInfoDTO;
import com.internousdev.ecsiteadmin.util.DBConnector;


public class ItemListDAO {

	List<ItemInfoDTO> iiDTOList=new ArrayList<ItemInfoDTO>();
	private DBConnector db=new DBConnector(); //DBConnectorクラスをインスタンス化
	private Connection con=db.getConnection();
	//Connectionクラスの変数conに、DBConnectorクラス内のgetConnection()メソッドの
	//実行結果を格納する。データベースに接続できたかどうか。

	public List<ItemInfoDTO> getItemInfo(){

		String sql="SELECT * FROM item_info_transaction";
		//iitテーブルからすべての情報を選択（取得）する。

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				ItemInfoDTO iiDTO=new ItemInfoDTO();
				iiDTO.setId(rs.getString("id"));//rs.getString("テーブルの列=Columnの名前")
				iiDTO.setItemName(rs.getString("item_name"));
				iiDTO.setItemPrice(rs.getString("item_price"));
				iiDTO.setItemStock(rs.getString("item_stock"));
				iiDTO.setInsertDate(rs.getString("insert_date"));
				iiDTO.setUpdateDate(rs.getString("update_date"));
				iiDTOList.add(iiDTO);
			}

		} catch(SQLException e){
			e.printStackTrace();
		}

		return iiDTOList;

	}





}
