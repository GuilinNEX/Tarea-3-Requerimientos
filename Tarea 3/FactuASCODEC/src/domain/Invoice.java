package domain;

import java.util.ArrayList;
import java.util.Random;

public class Invoice 
{
	private ArrayList<Product> productList = new ArrayList<Product>(); //List of all the products
	private ArrayList<SignIn> signInList = new ArrayList<SignIn>(); //List of all the Administrators
	
	public ArrayList<Product> fillProducts()
	{
		Product product1 = new Product("Papas", 500);
		Product product2 = new Product("Refresco", 750);
		Product product3 = new Product("Chocolate", 600);
		Product product4 = new Product("Chicles", 350);
		Product product5 = new Product("Barquillos", 900);
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		productList.add(product5);
		return productList;
	}
	
	public ArrayList<SignIn> fillSignIn()
	{
		SignIn signIn1 = new SignIn("Esteban", "12345");
		SignIn signIn2 = new SignIn("Danny", "54321");
		SignIn signIn3 = new SignIn("ABC", "0000");
		signInList.add(signIn1);
		signInList.add(signIn2);
		signInList.add(signIn3);
		return signInList;
	}

	public boolean callBank(String pCard, int pTotal)
	{
		Random rand = new Random();
		int value = rand.nextInt(1);
		if(value == 1)
		{
			Bank bank = new Bank(pCard, pTotal);
			return true;
		}
		else
			return false;
	}
	
	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
}
