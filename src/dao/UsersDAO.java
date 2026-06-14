package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.UsersDTO;
import utill.DBUtil;

public class UsersDAO {
	static Connection conn = null; //DB연결
	static Statement st = null; //SQL문보내는 통로, 바인딩변수 사용불가능 
	static PreparedStatement pst = null;
	static ResultSet rs = null; //Select문 결과가 들어온다. 
	
	public static UsersDTO selectById(String inputID) {
		UsersDTO user = null;
		String sql_select = "SELECT * FROM users WHERE user_id = ?";
		conn = DBUtil.dbConnect();
		try {
	        pst = conn.prepareStatement(sql_select);
	        pst.setString(1, inputID);
	        rs = pst.executeQuery();
	        if (rs.next()) {

	            user = UsersDTO.builder()
	                    .userId(rs.getString("USER_ID"))
	                    .password(rs.getString("PASSWORD"))
	                    .userName(rs.getString("USER_NAME"))
	                    .question(rs.getString("QUESTION"))
	                    .answer(rs.getString("ANSWER"))
	                    .gold(rs.getInt("GOLD"))
	                    .experience(rs.getInt("EXPERIENCE"))
	                    .build();
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return user;
	}

	public static boolean insertUser(UsersDTO user) {
		int result = 0;
		String sql_select = """
				INSERT INTO users( user_id,password,user_name,
									question,answer,gold,
									experience 
								) values ( ?,?,?,?,?,0,0 )
				""";
		conn = DBUtil.dbConnect();
		try {
			pst = conn.prepareStatement(sql_select);
		    pst.setString(1, user.getUserId());
		    pst.setString(2, user.getPassword());
		    pst.setString(3, user.getUserName());
		    pst.setString(4, user.getQuestion());
		    pst.setString(5, user.getAnswer());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, null);
		}
		if (result == 0)
			return false;
		return true;
	}

}
