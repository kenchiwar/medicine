package entity;

public class Address {
	private int IdAddress;
	private String Numhome;
	private String Name;
	private String Ward;
	private String County;
	private String City;
	private String Country;
	
	public Address() {}

	public Address(int idAddress, String numhome, String name, String ward, String county, String city,
			String country) {
		
		IdAddress = idAddress;
		Numhome = numhome;
		Name = name;
		Ward = ward;
		County = county;
		City = city;
		Country = country;
	}

	public int getIdAddress() {
		return IdAddress;
	}

	public void setIdAddress(int idAddress) {
		IdAddress = idAddress;
	}

	public String getNumhome() {
		return Numhome;
	}

	public void setNumhome(String numhome) {
		Numhome = numhome;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getWard() {
		return Ward;
	}

	public void setWard(String ward) {
		Ward = ward;
	}

	public String getCounty() {
		return County;
	}

	public void setCounty(String county) {
		County = county;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	@Override
	public String toString() {
		return "Address [IdAddress=" + IdAddress + ", Numhome=" + Numhome + ", Name=" + Name + ", Ward=" + Ward
				+ ", County=" + County + ", City=" + City + ", Country=" + Country + "]";
	}
	
	
	

}