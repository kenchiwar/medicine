package entity;

import java.time.LocalDate;

public class ThongKeBill extends Bill {
	private String nameStaff ;
	private String nameCustomer;
	public ThongKeBill(String idBill, LocalDate dateFounder, Integer idStaff, Integer idCustomer, float sale,
			float total, String nameStaff, String nameCustomer) {
		super(idBill, dateFounder, idStaff, idCustomer, sale, total);
		this.nameStaff = nameStaff;
		this.nameCustomer = nameCustomer;
	}
	public ThongKeBill() {
		super();
	}
	public String getNameStaff() {
		return nameStaff;
	}
	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	@Override
	
	public String toString() {
		return "ThongKeBill [nameStaff=" + nameStaff + ", nameCustomer=" + nameCustomer + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
