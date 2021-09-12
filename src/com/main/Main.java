package com.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.bean.EmployeeBean;
import com.dao.EmployeeDao;

public class Main {
	public static void addEmployee() {
		int empno = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID to add"));
		String empname = JOptionPane.showInputDialog("Enter Employee Name to add");
		int empsal = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Salary to add"));
		EmployeeBean eb = new EmployeeBean();
		eb.setEid(empno);
		eb.setEname(empname);
		eb.setEsal(empsal);
		JOptionPane.showMessageDialog(null, EmployeeDao.addEmployee(eb) + " record added successfully");
	}

	public static void updateEmployee() throws SQLException {
		int empno = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID to update"));
		String empname = JOptionPane.showInputDialog("Enter the new Employee Name");
		int empsal = Integer.parseInt(JOptionPane.showInputDialog("Enter the new Employee Salary"));
		EmployeeBean eb = new EmployeeBean();
		eb.setEid(empno);
		eb.setEname(empname);
		eb.setEsal(empsal);
		JOptionPane.showMessageDialog(null, EmployeeDao.updateEmployee(eb) + " record updated successfully");
	}

	public static void deleteEmployee() throws SQLException {
		int empno = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID to delete"));
		JOptionPane.showMessageDialog(null, EmployeeDao.deleteEmployee(empno) + " record deleted successfully");
	}

	public static void readAll() throws SQLException {
		EmployeeDao.readAll();
	}

	public static void readOne() throws SQLException {
		int empno = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID to show"));
		EmployeeDao.readOne(empno);
	}

	public static void main(String[] args) throws SQLException {
		int choice = Integer
				.parseInt(JOptionPane.showInputDialog("1.Add\n2.Update\n3.Delete\n4.Read All\n5.Read any one"));
		switch (choice) {
		case 1:
			Main.addEmployee();
			break;
		case 2:
			Main.updateEmployee();
			break;
		case 3:
			Main.deleteEmployee();
			break;
		case 4:
			Main.readAll();
			break;
		case 5:
			Main.readOne();
			break;
		default:
			System.out.println("Enter number between 1 and 5");
		}

	}
}
