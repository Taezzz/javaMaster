package co.yedam;

import java.util.List;
import java.util.Scanner;

public class MemManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		memDAO dao = new memDAO();
		
		while(run) {
			System.out.println("1.회원목록 2.회원등록 3.정보수정 4.정보삭제 5.종료");
			System.out.print("선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
				case 1 :
				List<Member> meml = dao.memList();
				System.out.println("회원번호  이름    전화번호    생일   성별");
				System.out.println("--------------------------------");
				for(Member mem : meml) {
					System.out.println(mem.toString());
				}
				break;
				case 2 : 
					System.out.print("회원명 > ");
					String name = sc.nextLine();
					System.out.print("전화번호 > ");
					String phone = sc.nextLine();
					System.out.print("생일 > ");
					String birth = sc.nextLine();
					System.out.print("성별 > ");
					String sex = sc.nextLine();
					
					Member mem = new Member();
					mem.setMemName(name);
					mem.setMemPhone(phone);
					mem.setMemBirth(birth);
					mem.setMemSex(sex);
					
					if(dao.insertMem(mem)) {
						System.out.println("정상등록.");
					}else {
						System.out.println("예외발생.");
					}
					break;
				case 3 : 
					System.out.print("수정할 회원번호 > ");
					int memNo = Integer.parseInt(sc.nextLine());
					System.out.println("연락처 > ");
					String phoneNum = sc.nextLine();
					
					mem = new Member();
					mem.setMemNo(memNo);
					mem.setMemPhone(phoneNum);
					
					if(dao.updateMem(mem)) {
						System.out.println("수정완료.");
					}else {
						System.out.println("수정실패.");
					}
					
				case 4 : 
					System.out.println("삭제할 회원번호 > ");
					memNo = Integer.parseInt(sc.nextLine());

					mem = new Member();
					mem.setMemNo(memNo);
					
					if(dao.deleteMem(mem)) {
						System.out.println("삭제완료.");
					}else {
						System.out.println("삭제실패.");
					}
					break;
				case 5 : 
					run = false;
					break;
			}
		}
		

	}

}
