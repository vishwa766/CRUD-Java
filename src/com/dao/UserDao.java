package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserBean;

public class UserDao {
	public static Connection con = getCon();
	public static PreparedStatement ps;
	public static ResultSet rs;

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root123");
			System.out.println("Connected Successfully...");
		} catch (ClassNotFoundException cnf) {

		} catch (SQLException sql) {

		}
		return con;
	}

	public static String validate(UserBean ub) {
		String b = "Invalid User";
		try {
			ps = con.prepareStatement("select * from User2 where Name=? and Password=?");
			ps.setString(1, ub.getUname());
			ps.setString(2, ub.getPass());
			rs = ps.executeQuery();
			if (rs.next()) {
				b = "Valid User";
				return b;
			}

		} catch (SQLException sql) {

		}
		return b;
	}

}
