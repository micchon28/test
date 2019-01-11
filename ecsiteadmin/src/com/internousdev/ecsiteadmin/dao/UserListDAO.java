package com.internousdev.ecsiteadmin.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsiteadmin.dto.UserInfoDTO;
import com.internousdev.ecsiteadmin.util.DBConnector;


public class UserListDAO {

	List<UserInfoDTO> uiDTOList=new ArrayList<UserInfoDTO>();

	public List<UserInfoDTO> getUserInfo(){
		DBConnector db=new DBConnector(); //DBConnectorクラスをインスタンス化
		Connection con=db.getConnection();
		//Connectionクラスの変数conに、DBConnectorクラス内のgetConnection()メソッドの
		//実行結果を格納する。データベースに接続できたかどうか。

		String sql="SELECT * FROM login_user_transaction";
		//iitテーブルからすべての情報を選択（取得）する。

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				UserInfoDTO uiDTO=new UserInfoDTO();
				uiDTO.setId(rs.getString("id"));//rs.getString("テーブルの列=Columnの名前")
				uiDTO.setLoginId(rs.getString("login_id"));
				uiDTO.setLoginPass(rs.getString("login_pass"));
				uiDTO.setUserName(rs.getString("user_name"));
				uiDTO.setInsertDate(rs.getString("insert_date"));
				uiDTO.setUpdateDate(rs.getString("update_date"));
				uiDTOList.add(uiDTO);
			}

		} catch(SQLException e){
			e.printStackTrace();
		}

		return uiDTOList;

	}



}
