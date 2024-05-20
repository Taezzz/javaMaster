package bookProject;

import java.util.Date;

public class Member {
	private int mNo;
	private String mName;
	private String phone;
	private String sex;
	private String birthday;
	private String loan;
	
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getLoan() {
		return loan;
	}
	public void setLoan(String loan) {
		this.loan = loan;
	}
	
	@Override
	public String toString() {
		return String.format("%4d %6s %15s %4s %13s %6s", mNo, mName, phone, sex, birthday, loan);
	}
}
