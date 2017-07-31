package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.CustomerAccount;

public class AdminDAO {
	
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;
	PreparedStatement ps = null;

	public boolean register(CustomerAccount account) {
		
		// 1. get data from POJO
		String password = account.getPassword();
		String name = account.getName();
		long mobile = account.getMobileNumber();
		String email = account.getEmail();

		// get connection and pass values to database
		con = DBConnection.myConnection();
		String sql = "insert into account (balance) values(0)";
		
//		ps = con.prepareStatement(sql);
		
//		ps.setString(1, password);
//		ps.setString(2, firstName);
//		ps.setString(3, lastName);
//		ps.setString(4, email);
//		ps.setString(5, userName);
//		
//		ps.executeUpdate();
//
//		System.out.println(ref.getUserName() + " is added successful ..");
//
//		con.close();

		return true;
	}

}
