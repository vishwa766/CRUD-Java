package com.dao;

import java.sql.*;

import javax.swing.JOptionPane;

import com.bean.EmployeeBean;

public class EmployeeDao {
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

	public static int addEmployee(EmployeeBean eb) {
		int i = 0;
		try {
			ps = con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, eb.getEid());
			ps.setString(2, eb.getEname());
			ps.setInt(3, eb.getEsal());
			i = ps.executeUpdate();
		} catch (SQLException sql) {

		}
		return i;
	}

	public static int updateEmployee(EmployeeBean eb) throws SQLException {
		int i = 0;
		ps = con.prepareStatement("update employee set name=?, salary=? where id=?");
		ps.setString(1, eb.getEname());
		ps.setInt(2, eb.getEsal());
		ps.setInt(3, eb.getEid());
		i = ps.executeUpdate();
		return i;
	}

	public static int deleteEmployee(int empno) throws SQLException {
		int i = 0;
		ps = con.prepareStatement("delete from employee where id=?");
		ps.setInt(1, empno);
		i = ps.executeUpdate();
		return i;
	}

	public static void readAll() throws SQLException {
		ps = con.prepareStatement("select * from employee");
		rs = ps.executeQuery();
		String str = "";
		while (rs.next()) {
			str += rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getInt(3) + "\n";
		}
		JOptionPane.showMessageDialog(null, str);

	}

	public static void readOne(int empno) throws SQLException {
		ps = con.prepareStatement("select * from employee where id=?");
		ps.setInt(1, empno);
		rs = ps.executeQuery();
		String str = "";
		while (rs.next()) {
			str += rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getInt(3) + "\n";
		}
		JOptionPane.showMessageDialog(null, str);

	}
}
