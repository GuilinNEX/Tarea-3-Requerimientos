package domain;

public class Bank 
{
	private String cardNummber;
	private int total;
	
	public Bank(String pCardNumber, int pAmount)
	{
		this.cardNummber = pCardNumber;
		this.total = pAmount;
	}
}
