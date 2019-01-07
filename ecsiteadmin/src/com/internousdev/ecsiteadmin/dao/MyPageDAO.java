package com.internousdev.ecsiteadmin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsiteadmin.dto.MyPageDTO;
import com.internousdev.ecsiteadmin.util.DBConnector;

public class MyPageDAO {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id, String user_master_id) throws SQLException{
		//MyPageへアクセスしたユーザーの商品取引ID・ユーザーIDを取得するメソッド。
		//MyPageDTO型のArrayList"myPageDTO"を戻り値として受け取る。（String item_transaction_id, String user_master_idが入る。）

		ArrayList<MyPageDTO> myPageDTO=new ArrayList<MyPageDTO>();
		String sql="SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id=iit.id WHERE ubit.item_transaction_id=? AND ubit.user_master_id=? ORDER BY insert_date DESC";
		//テーブル"user_buy_item_transaction(略してubit)"から、
		//テーブル"item_info_transaction iit(略してiit)"の"iit.id"と値が同じ"ubit.item_transaction_id"に紐付く
		//"ubit.item_transaction_id"と" ubit.user_master_id"を降順で抽出する。（左外部結合）


		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, user_master_id);
			//上記sql文の?部分へ、MyPageへアクセスしたユーザーの"item_transaction_id"と"user_master_id"を挿入する。

			ResultSet resultSet=preparedStatement.executeQuery();
			//上記PS文を実行し、得られたsql文の結果※を受け取る。
			//※ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date

			while(resultSet.next()){
				MyPageDTO dto=new MyPageDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setTotalPrice(resultSet.getString("total_price"));
				dto.setTotalCount(resultSet.getString("total_count"));
				dto.setPayment(resultSet.getString("pay"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				//MyPageDTOクラスのインスタンス"dto"の各インスタンスメソッド（setter）に、
				//上記※の情報をセットする。情報が複数個ある場合も想定している。

				myPageDTO.add(dto);
				//空のArrayList"myPageDTO"に、MyPageDTOクラスのインスタンス"dto"にセットされた情報を記憶させる。

			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return myPageDTO;
		//本メソッド"getMyPageUserInfo"の引数へArrayList"myPageDTO"を戻す。

	}

	public int buyItemHistoryDelete(String item_transaction_id, String user_master_id) throws SQLException{
		String sql="DELETE FROM user_buy_item_transaction WHERE item_transaction_id=? AND user_master_id=?";
		PreparedStatement preparedStatement;
		int result=0;
		try{
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2,user_master_id);
			result=preparedStatement.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return result;
	}

}
