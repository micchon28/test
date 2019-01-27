package com.internousdev.ecsiteadmin.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.internousdev.ecsiteadmin.util.DBConnector;

public class UserListGeneralDeleteCompleteDAO {
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();

	public void UserListGeneralDelete(){
		String sql="DELETE FROM login_user_transaction WHERE admin_flg='0' ";

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
