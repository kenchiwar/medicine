package entity;

import java.time.LocalDate;

public class Staff {
	
	private int idStaff;
	private int idAddress;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String shift;
	private LocalDate birthDay;
	private boolean gender;
	private String numPhone;
	private String cccd;
	private String gmail;
	private boolean deleteStatus;
	private String numHome;
	private String nameHome;
	private String ward;
	private String county;
	private String city;
	private String country;
	private boolean rank;
	private int rank_1;
	
	
	
	public Staff() {}



	public Staff(int idStaff, int idAddress, String username, String password, String firstName, String lastName,
			String shift, LocalDate birthDay, boolean gender, String numPhone, String cccd, String gmail,
			boolean deleteStatus, String numHome, String nameHome, String ward, String county, String city,
			String country, boolean rank, int rank_1) {
		super();
		this.idStaff = idStaff;
		this.idAddress = idAddress;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.shift = shift;
		this.birthDay = birthDay;
		this.gender = gender;
		this.numPhone = numPhone;
		this.cccd = cccd;
		this.gmail = gmail;
		this.deleteStatus = deleteStatus;
		this.numHome = numHome;
		this.nameHome = nameHome;
		this.ward = ward;
		this.county = county;
		this.city = city;
		this.country = country;
		this.rank = rank;
		this.rank_1 = rank_1;
	}



	public int getIdStaff() {
		return idStaff;
	}



	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}



	public int getIdAddress() {
		return idAddress;
	}



	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
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



	public String getShift() {
		return shift;
	}



	public void setShift(String shift) {
		this.shift = shift;
	}



	public LocalDate getBirthDay() {
		return birthDay;
	}



	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}



	public boolean isGender() {
		return gender;
	}



	public void setGender(boolean gender) {
		this.gender = gender;
	}



	public String getNumPhone() {
		return numPhone;
	}



	public void setNumPhone(String numPhone) {
		this.numPhone = numPhone;
	}



	public String getCccd() {
		return cccd;
	}



	public void setCccd(String cccd) {
		this.cccd = cccd;
	}



	public String getGmail() {
		return gmail;
	}



	public void setGmail(String gmail) {
		this.gmail = gmail;
	}



	public boolean isDeleteStatus() {
		return deleteStatus;
	}



	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}



	public String getNumHome() {
		return numHome;
	}



	public void setNumHome(String numHome) {
		this.numHome = numHome;
	}



	public String getNameHome() {
		return nameHome;
	}



	public void setNameHome(String nameHome) {
		this.nameHome = nameHome;
	}



	public String getWard() {
		return ward;
	}



	public void setWard(String ward) {
		this.ward = ward;
	}



	public String getCounty() {
		return county;
	}



	public void setCounty(String county) {
		this.county = county;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public boolean isRank() {
		return rank;
	}



	public void setRank(boolean rank) {
		this.rank = rank;
	}



	public int getRank_1() {
		return rank_1;
	}



	public void setRank_1(int rank_1) {
		this.rank_1 = rank_1;
	}



	@Override
	public String toString() {
		return "Staff [idStaff=" + idStaff + ", idAddress=" + idAddress + ", username=" + username + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + ", shift=" + shift + ", birthDay="
				+ birthDay + ", gender=" + gender + ", numPhone=" + numPhone + ", cccd=" + cccd + ", gmail=" + gmail
				+ ", deleteStatus=" + deleteStatus + ", numHome=" + numHome + ", nameHome=" + nameHome + ", ward="
				+ ward + ", county=" + county + ", city=" + city + ", country=" + country + ", rank=" + rank
				+ ", rank_1=" + rank_1 + "]";
	}


	
}
