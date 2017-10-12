package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DButil {
	public static final String driver = "com.mysql.jdbc.Driver";
	public static final String url = "jdbc:mysql://127.0.0.1:3306/autopoetry?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
	public static final String user = "root";
	public static final String password = "123456";

	public static Connection getCon() {

		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void closeCon(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null) {

				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
