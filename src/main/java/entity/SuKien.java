package entity;

import java.time.LocalDate;

public class SuKien {
	private int idEvent ;
	private int category;
	private float sale;
	private String medicine;
	private String gift;
	private LocalDate startDate;
	private LocalDate endDate;
	private int quanity;
	private String nameEvent;
	private float SumSale;
	private float SumBill;
	private int SaleTiLe;
	
	//
	
	//
	
	
	private float price;
	
	
	


	public float getSumSale() {
		return SumSale;
	}


	public void setSumSale(float sumSale) {
		SumSale = sumSale;
	}

	
	


	public int getSaleTiLe() {
		return SaleTiLe;
	}


	public void setSaleTiLe(int saleTiLe) {
		SaleTiLe = saleTiLe;
	}


	public float getSumBill() {
		return SumBill;
	}


	public void setSumBill(float sumBill) {
		SumBill = sumBill;
	}


	public SuKien() {
		super();
	}
	
	
	public String getNameEvent() {
		return nameEvent;
	}


	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}


	

	public int getQuanity() {
		return quanity;
	}


	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getGift() {
		return gift;
	}

	public void setGift(String gift) {
		this.gift = gift;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public float getSale() {
		return sale;
	}
	public void setSale(float sale) {
		this.sale = sale;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	
	
}
