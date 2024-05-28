package com.dao;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bo.User_bo;

public class User_dao {
	public static List<User_bo> list=new ArrayList<>();
	public static String email,city,name;
	String s;
	/*--------------------------------------------------------------------------------*/
	public static Connection getConnection() {
		Connection con = null;

		try {
			String url = "jdbc:mysql://localhost:3306/WeatherApp";
			String user = "root";
			String pwd = "Sng@3267";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);

		} catch (Exception e) {
			System.out.println(e);

		}
		return con;
	}
	
	
//	AddUser
	
/*--------------------------------------------------------------------------------*/
	public static boolean adduser(User_bo e) {
		boolean status = false;

		try (Connection con = getConnection()){
			
			String sql = "insert into user(username,email,city,pass) values(?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getUsername());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getCity());
			ps.setString(4, e.getPassword());

			status= ps.executeUpdate()!=0;
			System.out.println("inserted user : "+status);// testing
		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return status;

		
	}

//	LoginCheck	
/*--------------------------------------------------------------------------------*/
	public static boolean userLogin(String email,String pass) {
	boolean status = false;

	try (Connection con = getConnection()){
		
		String sql = "SELECT * FROM user WHERE email = ? AND pass = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, pass);
		ResultSet rs =ps.executeQuery();
		status=rs.next();		
		System.out.println(email+" "+pass);
		System.out.println("Login : "+status);

	} catch (SQLException e) {

		e.printStackTrace();
	}

	return status;
}
	
//	public static ResultSet getDetails(String email,String pass){
//
//		try (Connection con = getConnection()){
//			
//			String sql = "SELECT distinct * FROM user WHERE email = ? AND pass = ? ;";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, email);
//			ps.setString(2, pass);
//			ResultSet rs  = ps.executeQuery();
//			
//			return rs;
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//		return null;
//		
//
//	}
	

//	LoginCheck	
/*--------------------------------------------------------------------------------*/
		public static List<User_bo> userData(String email,String pass) throws SQLException{
			ArrayList<User_bo> li=new ArrayList<>();
		try	(Connection con = getConnection()){	
			String sql = "SELECT * FROM user WHERE email = ? AND pass = ? ;";
			PreparedStatement ps = con.prepareStatement(sql);
		java.sql.Statement st=con.createStatement();

			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs  = ps.executeQuery();
		System.out.println(rs.next());
				User_bo eb = new User_bo();
						rs.getInt(1);
		            eb.setUsername(rs.getString(2));
		            eb.setEmail(rs.getString(3));
		            eb.setCity(rs.getString(4));
		            eb.setPassword(rs.getString(5));
		            li.add(eb);
		            System.out.println(eb);
		System.out.println(rs.getString(3));
//		            User_dao.email=email;
//		            User_dao.city=eb.getCity();
//		            User_dao o=new User_dao();
//		            o.s=eb.getCity();;
//		            User_dao.name=eb.getUsername();
		} catch (Exception e) {

			System.out.println(e+" userDATA ");
		}
//		list.addAll(li);
			return li;
		}	
	
		
	
}
