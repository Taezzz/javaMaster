package co.yedam;

public class Member {
	private int memNo;
	private String memName;
	private String memPhone;
	private String memBirth;
	private String memSex;
	private String memEmail;
	
	
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemBirth() {
		return memBirth;
	}
	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
	}
	public String getMemSex() {
		return memSex;
	}
	public void setMemSex(String memSex) {
		this.memSex = memSex;
	}
	@Override
	public String toString() {
		return String.format("%d %4s %12s %5s %3s", memNo,memName,memPhone,memBirth,memSex);
	}
	

}
