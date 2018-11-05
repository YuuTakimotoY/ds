package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cart2Dao {

	public void cad2(int cartid, CartBean cb) {
		// TODO 自動生成されたメソッド・スタブ
		String url ="jdbc:mysql://localhost/ec";
		String id ="root";
		String pass ="password";

		Connection con =null;
		PreparedStatement pre =null;
		ResultSet rs =null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url,id,pass);
			String quary ="insert into cart(pro_cd,pro_name,pro_kosu,pro_price) values(?,?,?,?)";
			pre = con.prepareStatement(quary);
			pre.setInt(1,cb.getPro_id());
			pre.setString(2, cb.getPro_name());
			pre.setInt(3, cartid);
			pre.setInt(4, cb.getPro_price());
			pre.executeUpdate();

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pre!=null)pre.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

	public ArrayList<Cart2Bean> cad3(int se) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Cart2Bean> acb2 = new ArrayList<Cart2Bean>();

		String url = "jdbc:mysql://localhost/ec";
		String ids ="root";
		String pass ="password";

		Connection con =null;
		PreparedStatement pre =null;
		ResultSet rs =null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url,ids,pass);
			String quary ="select * from cart where pro_cd = ?";
			pre = con.prepareStatement(quary);
			pre.setInt(1,se);
			rs=pre.executeQuery();

			while(rs.next()) {
				Cart2Bean cb2 = new Cart2Bean();
				cb2.setPro_id(rs.getInt("pro_id"));
				cb2.setPro_name(rs.getString("pro_name"));
				cb2.setPro_price(rs.getInt("pro_price"));
				cb2.setPro_kosu(rs.getInt("pro_kosu"));

			}

		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pre!=null)pre.close();
				if(rs !=null)rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return acb2;
	}

}
