package bookProject;

public class Loan {
	private int mNo;
	private String mName;
	private int bNo;
	private String bName;
	
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
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	
	@Override
	public String toString() {
		return String.format("%4d %8s %7d %10s", mNo, mName, bNo, bName);
	}
}
