package domain;

public class Purchase 
{
	private Product product;
	private int quantity;
	
	public Purchase(Product pProduct, int pQuantity)
	{
		this.product = pProduct;
		this.quantity = pQuantity;
	}
	
	//GETTERS & SETTERS
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
