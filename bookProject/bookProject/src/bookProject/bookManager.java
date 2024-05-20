package bookProject;

import java.sql.DriverManager;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bookManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run1 = true;
		bookDAO dao = new bookDAO();
		memberDAO dao2 = new memberDAO();
		loanDAO dao3 = new loanDAO();
		
		int menu1;
		int menu2;
		int menu3;


		
		while(run1) {
			
			boolean run2 = true;
			boolean run3 = true;
			
			System.out.println("<도서관리프로그램>");
			System.out.println("1. 도서관리");
			System.out.println("2. 회원관리");
			System.out.println("3. 대출/반납관리");
			System.out.println("4. 종료");
			System.out.println("--------------");
			System.out.print("선택 > ");
			
			menu1 = Integer.parseInt(sc.nextLine());
			
			while(run2) {	
				switch(menu1) {
					case 1 : 
						while(run3) {
							System.out.println("  <도서관리>");
							System.out.println("1. 도서조회");
							System.out.println("2. 도서추가");
							System.out.println("3. 도서삭제");
							System.out.println("4. 도서정보수정");
							System.out.println("5. 이전메뉴");
							System.out.println("-------------");
							System.out.print("선택 > ");
							
							menu2 = Integer.parseInt(sc.nextLine());
							System.out.println();
							
							switch(menu2) {
							case 1 : 
								List<Book> bookL = dao.bookList();
								
								System.out.println("---------------------------도서조회--------------------------------");
								System.out.println("도서번호\t도서명\t\t저자\t\t가격\t\t재고수량");
								System.out.println("----------------------------------------------------------------");
								for(Book book : bookL) {
									System.out.println(book.toString());
								}
								System.out.println();
								break;
							case 2 : 
								Book book1 = new Book();
								
								System.out.print("도서명 > ");
								String bName = sc.nextLine();
								
								if(!dao.isBook(bName)) { // 조건문 : bName(입력받은 도서명)이 book 테이블에 없으면										
									System.out.print("저자 > ");
									String writer = sc.nextLine();
									System.out.print("가격 > ");
									int price = Integer.parseInt(sc.nextLine());
									System.out.print("재고수량 > ");
									int stock = Integer.parseInt(sc.nextLine());
									
									book1.setbName(bName);
									book1.setWriter(writer);
									book1.setPrice(price);
									book1.setStock(stock);
									
									if(dao.insertBook2(book1)) {
										System.out.println("정상등록.");
									}else {
										System.out.println("예외발생.");
									}
									
								}else {
									
									System.out.println("이미 있는 책입니다.");
									System.out.println("추가할 책의 개수는? > ");
									int stock = Integer.parseInt(sc.nextLine());
									
									book1.setbName(bName);
									book1.setStock(stock);
									
									if(dao.updateBook2(book1)) {
										System.out.println("정상등록.");
									}else {
										System.out.println("예외발생.");
									}
								}
								break;		
								
							case 3 : 
								System.out.print("삭제할 도서명 > ");
								bName = sc.nextLine();
								
								Book book2 = new Book();
								book2.setbName(bName);
								
								if(dao.deleteBook(book2)) {
									System.out.println("삭제완료");
								}else {
									System.out.println("예외발생");
								}
								break;
							case 4 : 
								System.out.print("수정할 도서의 코드 > ");
								int bNo = Integer.parseInt(sc.nextLine());
								System.out.print("도서명 > ");
								bName = sc.nextLine();
								System.out.print("저자 > ");
								String writer = sc.nextLine();
								System.out.print("가격 > ");
								int price = Integer.parseInt(sc.nextLine());
								System.out.print("재고수량 > ");
								int stock = Integer.parseInt(sc.nextLine());
								
								Book book3 = new Book();
								book3.setbNo(bNo);
								book3.setbName(bName);
								book3.setWriter(writer);
								book3.setPrice(price);
								book3.setStock(stock);
								
								if(dao.updateBook(book3)) {
									System.out.println("수정완료");
								}else {
									System.out.println("예외발생");
								}
								break;
								
							case 5 :
								run3 = false;
							}
							
						}
							
						break;
						
					case 2 : 
						while(run3) {
							System.out.println("  <회원관리>");
							System.out.println("1. 회원정보조회");
							System.out.println("2. 회원추가");
							System.out.println("3. 회원삭제");
							System.out.println("4. 회원정보수정");
							System.out.println("5. 이전메뉴");
							System.out.println("-------------");
							System.out.print("선택 > ");
							menu2 = Integer.parseInt(sc.nextLine());
							switch(menu2) {
							case 1 : 
								List<Member> memberL = dao2.memberList();
								
								System.out.println("-------------------------------------------------------");
								System.out.println("회원번호   회원명        연락처       성별       생년월일     대출여부");
								System.out.println("-------------------------------------------------------");
								for(Member member : memberL) {
									System.out.println(member.toString());
								}
								break;
							case 2 : 
								System.out.print("회원명 > ");
								String mName = sc.nextLine();
								System.out.print("연락처 > ");
								String phone = sc.nextLine();
								System.out.print("성별 > ");
								String sex = sc.nextLine();
								System.out.print("생년월일 > ");
								String birthday = sc.nextLine();
								
								
								Member member1 = new Member();
								member1.setmName(mName);
								member1.setPhone(phone);
								member1.setSex(sex);
								member1.setBirthday(birthday);
								
								if(dao2.insertMember(member1)) {
									System.out.println("추가완료.");
								}else {
									System.out.println("추가실패.");
								}
								break;
							case 3 : 
								System.out.print("삭제할 회원의 코드 > ");
								int mNo = Integer.parseInt(sc.nextLine());
								
								Member member2 = new Member();
								member2.setmNo(mNo);
								
								if(dao2.deleteMember(member2)) {
									System.out.println("삭제완료");
								}else {
									System.out.println("예외발생");
									System.out.println("사유 : 없는 회원이거나 대출중인 회원");
								}
								break;
							case 4 : 
								System.out.print("수정할 회원의 코드 > ");
								mNo = Integer.parseInt(sc.nextLine());
								System.out.print("회원명 > ");
								mName = sc.nextLine();
								System.out.print("연락처 > ");
								phone = sc.nextLine();
								System.out.print("성별 > ");
								sex = sc.nextLine();
								System.out.print("생년월일 > ");
								birthday = sc.nextLine();									
								System.out.print("대출여부 > ");
								String loan = sc.nextLine();
								
								
								Member member3 = new Member();
								member3.setmNo(mNo);
								member3.setmName(mName);
								member3.setPhone(phone);
								member3.setSex(sex);
								member3.setBirthday(birthday);
								member3.setLoan(loan);
								
								if(dao2.updateMember(member3)) {
									System.out.println("수정완료");
								}else {
									System.out.println("수정실패");
								}
								break;
							case 5 :
								run3 = false;
							}
						}
							break;
							
					case 3 : 
						while(run3) {
							System.out.println("  <대출관리>");
							System.out.println("1.대출현황조회");
							System.out.println("2.대출하기");
							System.out.println("3.반납하기");
							System.out.println("4.이전메뉴");
							System.out.println("-----------");
							System.out.print("선택 > ");
							menu3 = Integer.parseInt(sc.nextLine());
							
							
							switch(menu3) {
							case 1 : 
								List<Loan> loanL = dao3.loanList();
								
								System.out.println("-----------------------------------");
								System.out.println("회원코드     회원명     도서코드     도서명 ");
								System.out.println("-----------------------------------");
								for(Loan loan : loanL) {
									System.out.println(loan.toString());
								}
								break;
								
							case 2 :
								System.out.print("회원번호 > ");
								int mNo = Integer.parseInt(sc.nextLine());
								System.out.print("회원명 > ");
								String mName = sc.nextLine();								
								System.out.print("도서번호 > ");
								int bNo = Integer.parseInt(sc.nextLine());
								System.out.print("도서명 > ");
								String bName = sc.nextLine();
								
								Loan loan = new Loan();
								loan.setmNo(mNo);
								loan.setmName(mName);
								loan.setbNo(bNo);
								loan.setbName(bName);
								
								if(dao3.insertLoan(loan) && dao3.stockMinus(loan)) {
									System.out.println("대출성공.");
									dao3.loanCheck(loan);
								}else {
									System.out.println("대출실패.");
								}
								break;
								
							case 3 :
								System.out.print("회원코드 > ");
								mNo = Integer.parseInt(sc.nextLine());
								System.out.print("회원명 > ");
								mName = sc.nextLine();								
								System.out.print("도서명 > ");
								bName = sc.nextLine();
								
								
								Loan loan1 = new Loan();
								loan1.setmName(mName);
								loan1.setmNo(mNo);
								loan1.setbName(bName);
								
								if(dao3.deleteLoan(loan1) && dao3.stockPlus(loan1)) {
									System.out.println(mName + " 반납완료.");
									dao3.loanCheckout(loan1);
								}else {
									System.out.println("반납실패.");
								}
								break;
								
							case 4 :
								run3 = false;
							}
						}
							break;
						
						
				case 4 :
						run1 = false;
					}
				break;
				}
			
	}
		System.out.println("종료합니다.");
}

}

