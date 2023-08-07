package testPack;

public class Book {

	private String name;
	private int price;
	private boolean saleYN;
	
	public String name2;
	
	public Book(String name, int price, boolean saleYN) {
		this.name = name;
		this.price = price;
		this.saleYN = saleYN;
	}
	
	public Book() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isSaleYN() {
		return saleYN;
	}

	public void setSaleYN(boolean saleYN) {
		this.saleYN = saleYN;
	}

	@Override
	public String toString() {
		
		return "Book2 [name=" + name + ", price=" + price + ", saleYN=" + saleYN + ", name2 = " + name2 + "]";
	}

	
	
}
