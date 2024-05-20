package bookProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class memberDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	private void getConn() {
		String url = "jdbc:oracle:thin:@192.168.0.49:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "jsp", "jsp");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	// 회원목록
		List<Member> memberList() {
			getConn();
			List<Member> list = new ArrayList<>();
			String sql = "select * from member order by mNo";
			
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				while(rs.next()) {					
					Member member = new Member();
					
					member.setmNo(rs.getInt("mNo"));
					member.setmName(rs.getString("mName"));
					member.setPhone(rs.getString("phone"));
					member.setSex(rs.getString("sex"));
					member.setBirthday(rs.getString("birthday"));
					member.setLoan(rs.getString("loan"));
					
					list.add(member);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	// 회원등록
		boolean insertMember(Member member){
			getConn();
			String sql = "insert into member(mNo, mName, phone, sex, birthday, loan) "
					+ "values(member_seq.nextval, ?, ?, ?, ?, 'X')";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, member.getmName());
				psmt.setString(2, member.getPhone());
				psmt.setString(3, member.getSex());
				psmt.setString(4, member.getBirthday());
				
				int r = psmt.executeUpdate(); // 처리된 건수 반환.
				if(r>0) {
					return true;
				}
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
			return false; // 예외발생하거나 처리된 건수가 0일 경우.
		}
		
		// 회원삭제
		boolean deleteMember(Member member) {
			getConn();
			String sql = "delete from member where mNo = ? and loan = 'X'";
			
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1, member.getmNo());
					int r = psmt.executeUpdate();
					if(r>0) {
						return true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			return false;
		}
		
		// 회원수정
		boolean updateMember(Member member) {
			getConn();
			String sql = "update member";
			sql += " 	  set mName = ?";
			sql += " 	  ,phone = ?";
			sql += " 	  ,sex = ?";
			sql += " 	  ,birthday = ?";
			sql += " 	  ,loan = ?";
			sql += "	  where mNo = ?";
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, member.getmName());
				psmt.setString(2, member.getPhone());
				psmt.setString(3, member.getSex());
				psmt.setString(4, member.getBirthday());
				psmt.setString(5, member.getLoan());
				psmt.setInt(6, member.getmNo());
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

