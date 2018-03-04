package domain;

public class Product 
{
	private String name;
	private int price;
	
	public Product(String pName, int pPrice)
	{
		this.name = pName;
		this.price = pPrice;
	}
	
	//GETTERS & SETTERS
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
	
}
