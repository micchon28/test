package com.internousdev.ecsiteadmin.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.internousdev.ecsiteadmin.util.DBConnector;

public class ItemListDeleteCompleteDAO {
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();

	public void ItemListDelete(){
		String sql="DELETE FROM item_info_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}

	}



}
