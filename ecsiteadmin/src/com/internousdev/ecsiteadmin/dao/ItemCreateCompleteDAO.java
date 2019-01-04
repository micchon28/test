package com.internousdev.ecsiteadmin.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.internousdev.ecsiteadmin.util.DBConnector;
import com.internousdev.ecsiteadmin.util.DateUtil;

public class ItemCreateCompleteDAO {

	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private DateUtil newItemCreateDate=new DateUtil();

	String sql="INSERT INTO item_info_transaction(item_name, item_price, item_stock, insert_date) VALUES(?, ?, ?, ?)";

	public void itemCreateInfo(String newItemName, int newItemPrice, int newItemStock){
		//このitemCreateInfoメソッドは、ItemCreateCompleteAction（session経由）から得た情報をitem_info_transactionテーブルに登録（=SQL文の"?"に挿入）するメソッド。
		//ItemCreateCompleteActionへは情報を返す必要がないため、void型（一方通行）となっている。
		//newItemCreateDate（登録日時）はこのクラス内で取得→挿入が完了するため、引数に入れる必要がない。

		try{

			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, newItemName);
			ps.setInt(2, newItemPrice);
			ps.setInt(3, newItemStock);
			ps.setString(4, newItemCreateDate.getDate());
			ps.execute();
			//PreparedStatement.execute();⇒「このPreparedStatementオブジェクトの、あらゆる種類のSQL文を実行します。」
			//ただ、boolean型。結果はどのように扱われる？？

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
