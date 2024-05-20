package bookProject;

public class Book {
	private int bNo;
	private String bName;
	private String writer;
	private int price;
	private int stock;
	
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return String.format("%d\t %s\t\t %s\t\t %d\t\t %d", bNo, bName, writer, price, stock);	
		}
	
	
	
}
