package domain;

import java.util.ArrayList;

public class Control 
{
	private ArrayList<Purchase> purchaseList = new ArrayList<Purchase>();

	
	public ArrayList<Purchase> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(ArrayList<Purchase> purchaseList) {
		this.purchaseList = purchaseList;
	}
	
}
