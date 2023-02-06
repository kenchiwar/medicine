package entity;

import java.time.LocalDate;
import java.util.Date;

public class Customer extends Address {
	private int IdCus;
	private String FirstName;
	private String LastName;
	private LocalDate Birthday;
	private boolean Gender;
	private String Numphone;
	private String CCCD;
	private Boolean DeleteStaus;
	private float totalCus;
	private LocalDate dob;
	private String Numberphone;
	private int IdCustomer;
	private String firstName;
	private String lastName;
	private boolean gender;
	private String CardId;
	private int address;
	
	
	public Customer() {}

	
	public float getTotalCus() {
		return totalCus;
	}


	public void setTotalCus(float totalCus) {
		this.totalCus = totalCus;
	}


	public Customer(int idCus, String firstName, String lastName, LocalDate birthday, boolean gender, String numphone,
			String cCCD, Boolean deleteStaus) {
		
		IdCus = idCus;
		FirstName = firstName;
		LastName = lastName;
		Birthday = birthday;
		Gender = gender;
		Numphone = numphone;
		CCCD = cCCD;
		DeleteStaus = deleteStaus;
	}


	public int getIdCus() {
		return IdCus;
	}


	public void setIdCus(int idCus) {
		IdCus = idCus;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public LocalDate getBirthday() {
		return Birthday;
	}


	public void setBirthday(LocalDate birthday) {
		Birthday = birthday;
	}


	public boolean isGender() {
		return Gender;
	}


	public void setGender(boolean gender) {
		Gender = gender;
	}


	public String getNumphone() {
		return Numphone;
	}


	public void setNumphone(String numphone) {
		Numphone = numphone;
	}


	public String getCCCD() {
		return CCCD;
	}


	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}


	public Boolean getDeleteStaus() {
		return DeleteStaus;
	}


	public void setDeleteStaus(Boolean deleteStaus) {
		DeleteStaus = deleteStaus;
	}
	
	

	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	

	public String getNumberphone() {
		return Numberphone;
	}


	public void setNumberphone(String numberphone) {
		Numberphone = numberphone;
	}
	
	

	public int getIdCustomer() {
		return IdCustomer;
	}


	public void setIdCustomer(int idCustomer) {
		IdCustomer = idCustomer;
	}


	public String getCardId() {
		return CardId;
	}


	public void setCardId(String cardId) {
		CardId = cardId;
	}


	public int getAddress() {
		return address;
	}


	public void setAddress(int address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [IdCus=" + IdCus + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Birthday="
				+ Birthday + ", Gender=" + Gender + ", Numphone=" + Numphone + ", CCCD=" + CCCD + ", DeleteStaus="
				+ DeleteStaus + "]";
	}


	
	
}
