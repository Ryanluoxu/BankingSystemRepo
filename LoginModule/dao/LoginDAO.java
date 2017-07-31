package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class LoginDAO {
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public boolean loginValidate(User user) throws SQLException, ClassNotFoundException {

		con= DBConnection.myConnection();		
		pst = con.prepareStatement("select * from admin where userID=? and password=?");
		pst.setInt(1,user.getUserID());
		pst.setString(2,user.getPassword());

		rs = pst.executeQuery();
		boolean status = rs.next();
		
		return status;
		
	}

	public String getUserType(User user) throws SQLException, ClassNotFoundException {
		
		con = DBConnection.myConnection();
		pst = con.prepareStatement("select userType from admin where userID=?");
		pst.setInt(1,user.getUserID());
		
		rs = pst.executeQuery();
		
		rs.next();	// move cursor to 1st row.
		
		String userType = rs.getString(1);
		
		return userType;

	}

}

