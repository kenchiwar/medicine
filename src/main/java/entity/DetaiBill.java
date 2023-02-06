package entity;

import java.time.LocalDate;

public class DetaiBill extends Medicine {
	private String idBill;
	private int idMedicine;
	private float amount;
	private int idEvent;
	private float sale;
	private double unitPrice;
	private String nameMedicine;
	private String unit;
	private double priceOut;
//	private double priceOut_1;
//	private double unitPrice_1;

//	public DetaiBill(int idMedicine, String regisNumber, String nameMedicine, LocalDate dateOut, String unit,
//			float priceEnter, float priceOut, float priceRetailOut, String idBill, float amount, int idEvent) {
//		super(idMedicine, regisNumber, nameMedicine, dateOut, unit, priceEnter, priceOut, priceRetailOut);
//		this.idBill = idBill;
//		this.amount = amount;
//		this.idEvent = idEvent;
//	}
	public DetaiBill() {
		
	}
	
	
	


	public String getIdBill() {
		return idBill;
	}





	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}





	public int getIdMedicine() {
		return idMedicine;
	}





	public void setIdMedicine(int idMedicine) {
		this.idMedicine = idMedicine;
	}





	public float getAmount() {
		return amount;
	}





	public void setAmount(float amount) {
		this.amount = amount;
	}





	public int getIdEvent() {
		return idEvent;
	}





	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}





	public float getSale() {
		return sale;
	}





	public void setSale(float sale) {
		this.sale = sale;
	}





	public double getUnitPrice() {
		return unitPrice;
	}





	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}





	public String getNameMedicine() {
		return nameMedicine;
	}





	public void setNameMedicine(String nameMedicine) {
		this.nameMedicine = nameMedicine;
	}





	public String getUnit() {
		return unit;
	}





	public void setUnit(String unit) {
		this.unit = unit;
	}





	public double getPriceOut() {
		return priceOut;
	}





	public void setPriceOut(double priceOut) {
		this.priceOut = priceOut;
	}





	@Override
	public String toString() {
		return "DetaiBill [idBill=" + idBill + ", amount=" + amount + ", idEvent=" + idEvent + ", sale=" + sale
				+ ", getAmountNow()=" + getAmountNow() + ", getUnitPrice()=" + getUnitPrice() + ", getIdMedicine()="
				+ getIdMedicine() + ", getRegisNumber()=" + getRegisNumber() + ", getNameMedicine()="
				+ getNameMedicine() + ", getDateOut()=" + getDateOut() + ", getUnit()=" + getUnit()
				+ ", getPriceEnter()=" + getPriceEnter() + ", getPriceOut()=" + getPriceOut() + ", getPriceRetailOut()="
				 + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	
	
	
	
	
	
}
