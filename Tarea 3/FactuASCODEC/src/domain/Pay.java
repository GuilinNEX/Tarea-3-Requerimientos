package domain;

import java.sql.Date;
import java.util.ArrayList;

public class Pay 
{
	private ArrayList<Purchase> pruchaseList = new ArrayList<Purchase>();
	private Date date;
	
	public Pay(ArrayList<Purchase> pList, Date pDate)
	{
		this.pruchaseList = pList;
		this.date = pDate;
	}
	
	//GETTERS & SETTERS
	public ArrayList<Purchase> getPruchaseList() {
		return pruchaseList;
	}
	public void setPruchaseList(ArrayList<Purchase> pruchaseList) {
		this.pruchaseList = pruchaseList;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
