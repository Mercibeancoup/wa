package util;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DButil;

//去除诗词中的空格，换行符等
public class RemovePoetryBlank {
	public static void main(String[] args) throws SQLException, UnsupportedEncodingException {
		// 创建数据库连接
		Connection con = DButil.getCon();
		//SQL语句运行前这个对象是语句是可以被数据库解释
		Statement st = con.createStatement();
		String sql = "select id,content from basicpoetry";
		//执行SQL语句
		ResultSet rs = st.executeQuery(sql);
		
		//遍历结果集
		while(rs.next()){
			Statement st2 = con.createStatement();
			int id = rs.getInt("id");
			
			String content = rs.getString("content");
				
			String replace = content.replaceAll(" |\r|\n|　|  ", "");
			
			//test
			
			sql="update basicpoetry set content='"+replace+"'where id="+id;
			System.out.println(sql);
			st2.executeUpdate(sql);
			System.out.println("you see here ");
		}

	}
	
}