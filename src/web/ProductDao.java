package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao {

	public ProductBean sho(int id) {
		ProductBean sb= new ProductBean();

		Connection con =null;
		Statement stm =null;
		PreparedStatement pre =null;
		ResultSet rs =null;

		String url ="jdbc:mysql://localhost/ec";
		String ids  ="root";
		String pass ="password";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,ids,pass);
			String quary ="select * from product where pro_code=?";
			pre = con.prepareStatement(quary);
			pre.setInt(1,id);
			rs = pre.executeQuery();

			while(rs.next()) {
				sb.setPro_name(rs.getString("pro_name"));
				sb.setPro_cd(rs.getInt("pro_cd"));
				sb.setStock_no(rs.getInt("stock_no"));
				sb.setPro_price(rs.getInt("pro_price"));
				sb.setCat_id(rs.getInt("cat_id"));
				sb.setPro_msg(rs.getString("pro_msg"));
				sb.setPro_img(rs.getString("pro_img"));

			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(stm!=null)stm.close();
				if(rs!=null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sb;
	}

}
