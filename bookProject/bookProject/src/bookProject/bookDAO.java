package bookProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bookDAO {
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

	} // end of getConn().
	
	// 도서목록기능
	List<Book> bookList(){
		getConn();
		List<Book> list = new ArrayList<>();
		String sql = "select * from book order by bNo";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				
				book.setbNo(rs.getInt("bNo"));
				book.setbName(rs.getString("bName"));
				book.setWriter(rs.getString("writer"));
				book.setPrice(rs.getInt("price"));
				book.setStock(rs.getInt("stock"));
				
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		}
	// 도서추가(있는지없는지)
	boolean isBook(String bName) {
		getConn();
		String sql = "SELECT * FROM book WHERE bName = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bName);
			
			ResultSet rs = psmt.executeQuery();
		        if (rs.next()) {
		            return true; 
		        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
    	return false;
	}
	// 도서조회(새로운책)
	boolean insertBook2(Book book) {
		
		getConn();
		String sql = "insert into book(bNo, bName, writer, price, stock) "
				+ "values(book_seq.nextval,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getbName());
			psmt.setString(2, book.getWriter());
			psmt.setInt(3, book.getPrice());
			psmt.setInt(4, book.getStock());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	// 도서추가(있는책은 재고수량만 받아서 update)
	boolean updateBook2(Book book) {
		getConn();
		String sql = "update book";
		sql += " 	   set stock = stock + ?";
		sql += " 	   where bName = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, book.getStock());
			psmt.setString(2, book.getbName());
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	// 도서삭제
	boolean deleteBook(Book book) {
		getConn();
		String sql = "delete from book where bName = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, book.getbName());
				int r = psmt.executeUpdate();
				if(r>0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return false;
	}
	
	// 도서수정
	boolean updateBook(Book book) {
		getConn();
		String sql = "update book";
		sql += " 	  set bName = ?";
		sql += " 	  ,writer = ?";
		sql += " 	  ,price = ?";
		sql += " 	  ,stock = ?";
		sql += "	  where bNo = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getbName());
			psmt.setString(2, book.getWriter());
			psmt.setInt(3, book.getPrice());
			psmt.setInt(4, book.getStock());
			psmt.setInt(5, book.getbNo());
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
