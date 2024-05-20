package bookProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class loanDAO {
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
	
	// 대출현황
	List<Loan> loanList() {
		getConn();
		List<Loan> list = new ArrayList<>();
		String sql = "select * from loan order by mNo";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {					
				Loan loan = new Loan();
				
				loan.setmNo(rs.getInt("mNo"));
				loan.setmName(rs.getString("mName"));
				loan.setbNo(rs.getInt("bNo"));
				loan.setbName(rs.getString("bName"));
		
				list.add(loan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 대출하기
	boolean insertLoan(Loan loan){
		getConn();
		String sql = "insert into loan(mNo, mName, bNo, bName) "
				+ "values(?, ?, ?, ?)";
		
	
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, loan.getmNo());
			psmt.setString(2, loan.getmName());
			psmt.setInt(3, loan.getbNo());
			psmt.setString(4, loan.getbName());
						
			int r1 = psmt.executeUpdate(); 
			if(r1 > 0) {
				return true;
			}
			
			
			 
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return false; // 예외발생하거나 처리된 건수가 0일 경우.
	}
	
	// stock 이 0이면 대출실패, stock 0보다 크면 stock = stock-1;
	boolean stockMinus(Loan loan) {
		getConn();
		String sql = "update book set stock = stock - 1 where bNo = ? and stock > 0";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, loan.getbNo());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 대출에 성공하면 대출여부를 O로 변경(미해결)
		
	void loanCheck(Loan loan){
			getConn();
			String sql = "update member set loan = 'O' where mNo = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, loan.getmNo());
				
				int r = psmt.executeUpdate();
				
				if(r>0) {
					System.out.println("대출상태변경");
				}
		          
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
	// 반납하기
	boolean deleteLoan(Loan loan){
		getConn();
		String sql = "delete from loan where mName = ? and bName = ?";
		
	
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, loan.getmName());
			psmt.setString(2, loan.getbName());
			
						
			int r1 = psmt.executeUpdate(); 
			if(r1 > 0) {
				return true;
			}
	
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return false; // 예외발생하거나 처리된 건수가 0일 경우.
	}
	
	// 반납할 때 대출현황에 회원명이 없으면 member 테이블에 대출현황을 X로 변경
	
	void loanCheckout(Loan loan){
		getConn();
		String sql = "update member set loan = 'X' where not exists(select * from loan where mNo = ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, loan.getmNo());
		
			int r = psmt.executeUpdate();
			
			
	          
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// 재고더하기
	boolean stockPlus(Loan loan) {
		getConn();
		String sql = "update book set stock = stock + 1 where bName = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, loan.getbName());
			
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
	
	
	




