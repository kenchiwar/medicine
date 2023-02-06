package entity;

import java.time.LocalDate;

public class Bill {
	private  String idBill;
	private LocalDate dateFounder;
	private Integer idStaff;
	private Integer idCustomer;
	private float sale;
	private float total;
	private float pay;
	private float unitPrice;
	private String firstName;
	private String lastName;
	private String firstNameCusl;
	private String lastNameCusl;
	private int idMedicine;
	private float amount;
	private int idEvent;
	private float sale_1;
	private String nameMedicine;
	private String unit;
	private double priceOut;
	
	
	public Bill(String idBill, LocalDate dateFounder, Integer idStaff, Integer idCustomer, float sale, float total) {
		
		this.idBill = idBill;
		this.dateFounder = dateFounder;
		this.idStaff = idStaff;
		this.idCustomer = idCustomer;
		this.sale = sale;
		this.total = total;
	}
	
	
	
	public float getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}



	public Bill() {
		
	}
	
	public String getIdBill() {
		return idBill;
	}
	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}
	public LocalDate getDateFounder() {
		return dateFounder;
	}
	public void setDateFounder(LocalDate dateFounder) {
		this.dateFounder = dateFounder;
	}
	public Integer getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(Integer idStaff) {
		this.idStaff = idStaff;
	}
	public Integer getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	public float getSale() {
		return sale;
	}
	public void setSale(float sale) {
		this.sale = sale;
	}
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getPay() {
		return (unitPrice-sale<0)?0:total-sale;
	}
	
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public String getFirstNameCusl() {
		return firstNameCusl;
	}



	public void setFirstNameCusl(String firstNameCusl) {
		this.firstNameCusl = firstNameCusl;
	}



	public String getLastNameCusl() {
		return lastNameCusl;
	}



	public void setLastNameCusl(String lastNameCusl) {
		this.lastNameCusl = lastNameCusl;
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



	public float getSale_1() {
		return sale_1;
	}



	public void setSale_1(float sale_1) {
		this.sale_1 = sale_1;
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
		return "Bill [idBill=" + idBill + ", dateFounder=" + dateFounder + ", idStaff=" + idStaff + ", idCustomer="
				+ idCustomer + ", sale=" + sale + ", total=" + total + ",pay="+getPay()+ ", unitPrice=" + unitPrice
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	
	
	
	
}	