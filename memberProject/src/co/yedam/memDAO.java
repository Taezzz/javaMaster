package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class memDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	private void getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, "jsp","jsp");
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
	}// end of getConn().
	
	// 회원목록기능
	List<Member> memList(){
		getConn();
		List<Member> list = new ArrayList<>();
		String sql = "select * from member order by mem_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Member mem = new Member();
				
				mem.setMemNo(rs.getInt("mem_no"));
				mem.setMemName(rs.getString("mem_name"));
				mem.setMemPhone(rs.getString("mem_phone"));
				mem.setMemBirth(rs.getString("mem_birth"));
				mem.setMemSex(rs.getString("mem_sex"));
				
				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 회원등록기능
	boolean insertMem(Member mem){
		getConn();
		String sql = "insert into member (mem_no, mem_name, mem_phone, mem_birth, mem_sex) "
			        + " values(mem_seq.nextval,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getMemName());
			psmt.setString(2, mem.getMemPhone());
			psmt.setString(3, mem.getMemBirth());
			psmt.setString(4, mem.getMemSex());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	// 정보수정기능
	boolean updateMem(Member mem) {
		getConn();
		String sql = "update member";
			   sql += " set mem_phone = ?";
			   sql += " where mem_no = ?";
			   
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getMemPhone());
			psmt.setInt(2, mem.getMemNo());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	// 정보삭제기능
	boolean deleteMem(Member mem) {
		getConn();
		String sql = "delete from member where mem_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mem.getMemNo());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
