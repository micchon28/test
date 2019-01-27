package com.internousdev.ecsiteadmin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.internousdev.ecsiteadmin.dto.LoginDTO_backup;
import com.internousdev.ecsiteadmin.util.DBConnector;

public class LoginDAO_backup {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private LoginDTO_backup loginDTO_backup=new LoginDTO_backup();


	public LoginDTO_backup getLoginUserInfo(String loginUserId, String loginPassword){
		String sql="SELECT * FROM login_user_transaction where login_id=? AND login_pass=?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet=preparedStatement.executeQuery();

			if(resultSet.next()){
				loginDTO_backup.setLoginId(resultSet.getString("login_id"));
				loginDTO_backup.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO_backup.setUserName(resultSet.getString("user_name"));

				if(!(resultSet.getString("login_id").equals(null))){
					loginDTO_backup.setLoginFlg(true);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return loginDTO_backup;

	}

	public LoginDTO_backup getLoginDTO_backup(){
		return loginDTO_backup;
	}

}
