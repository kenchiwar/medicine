package entity;

public class Supplier extends Address {
	private int IdSupplier;
	private String Name1;
	private String NumPhone;
	private String Gmail;
	private boolean DeleteStatus;
	public Supplier() {}
	public Supplier(int idSupplier, String name1, String numPhone, String gmail, boolean deleteStatus) {
		
		IdSupplier = idSupplier;
		Name1 = name1;
		NumPhone = numPhone;
		Gmail = gmail;
		DeleteStatus = deleteStatus;
	}
	public int getIdSupplier() {
		return IdSupplier;
	}
	public void setIdSupplier(int idSupplier) {
		IdSupplier = idSupplier;
	}
	public String getName1() {
		return Name1;
	}
	public void setName1(String name1) {
		Name1 = name1;
	}
	public String getNumPhone() {
		return NumPhone;
	}
	public void setNumPhone(String numPhone) {
		NumPhone = numPhone;
	}
	public String getGmail() {
		return Gmail;
	}
	public void setGmail(String gmail) {
		Gmail = gmail;
	}
	public boolean isDeleteStatus() {
		return DeleteStatus;
	}
	public void setDeleteStatus(boolean deleteStatus) {
		DeleteStatus = deleteStatus;
	}
	@Override
	public String toString() {
		return "Supplier [IdSupplier=" + IdSupplier + ", Name1=" + Name1 + ", NumPhone=" + NumPhone + ", Gmail=" + Gmail
				+ ", DeleteStatus=" + DeleteStatus + "]";
	}
	
	
}
