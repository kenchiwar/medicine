package entity;

import java.time.LocalDate;

public class Medicine extends Supplier {
	
	private int IdMedicine;
	private String RegisNumber;
	private String NameMedicine;
	private String Class1;
	private String GroupMedicine;
	private String Active;
	private String Content;
	private String CoverForm;
	private String Packing;
	private String Standard;
	private LocalDate DateManufacture;
	private LocalDate DateOut;
	private String Unit;
	private double PriceEnter;
	private double UnitPrice;
	private int NumImport;
	private LocalDate DateImport;
	private double PriceOut;
	private double PriceRetailOut;
	private int AmountNow;
	private double AmountRetailDefault;
	private boolean DeleteStatus;
	private String UnitRetai;
	private int ProNumOut;
	private boolean StatusImport;
	private String name;
	
	
	
	
	public double getPriceRetailOut() {
		return PriceRetailOut;
	}

	public void setPriceRetailOut(double priceRetailOut) {
		PriceRetailOut = priceRetailOut;
	}

	public void setPriceOut(double priceOut) {
		PriceOut = priceOut;
	}

	public Medicine() {}
	
	public int getIdMedicine() {
		return IdMedicine;
	}
	public void setIdMedicine(int idMedicine) {
		IdMedicine = idMedicine;
	}
	

	public Medicine(int idMedicine, String regisNumber, String nameMedicine, String class1, String groupMedicine,
			String active, String content, String coverForm, String packing, String standard, LocalDate dateManufacture,
			LocalDate dateOut, String unit, double priceEnter, double unitPrice, int numImport, LocalDate dateImport,
			float priceOut, float priceRetailOut, int amountNow, double amountRetailDefault, boolean deleteStatus,
			String unitRetai, int proNumOut, boolean statusImport, String name, double priceOut_1,
			double priceRetailOut_1) {
		super();
		IdMedicine = idMedicine;
		RegisNumber = regisNumber;
		NameMedicine = nameMedicine;
		Class1 = class1;
		GroupMedicine = groupMedicine;
		Active = active;
		Content = content;
		CoverForm = coverForm;
		Packing = packing;
		Standard = standard;
		DateManufacture = dateManufacture;
		DateOut = dateOut;
		Unit = unit;
		PriceEnter = priceEnter;
		UnitPrice = unitPrice;
		NumImport = numImport;
		DateImport = dateImport;
		PriceOut = priceOut;
		PriceRetailOut = priceRetailOut;
		AmountNow = amountNow;
		AmountRetailDefault = amountRetailDefault;
		DeleteStatus = deleteStatus;
		UnitRetai = unitRetai;
		ProNumOut = proNumOut;
		StatusImport = statusImport;
		this.name = name;
		
	}

	public String getRegisNumber() {
		return RegisNumber;
	}
	public void setRegisNumber(String regisNumber) {
		RegisNumber = regisNumber;
	}
	public String getNameMedicine() {
		return NameMedicine;
	}
	public void setNameMedicine(String nameMedicine) {
		NameMedicine = nameMedicine;
	}
	public String getClass1() {
		return Class1;
	}
	public void setClass1(String class1) {
		Class1 = class1;
	}
	public String getGroupMedicine() {
		return GroupMedicine;
	}
	public void setGroupMedicine(String groupMedicine) {
		GroupMedicine = groupMedicine;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
		Active = active;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getCoverForm() {
		return CoverForm;
	}
	public void setCoverForm(String coverForm) {
		CoverForm = coverForm;
	}
	public String getPacking() {
		return Packing;
	}
	public void setPacking(String packing) {
		Packing = packing;
	}
	public String getStandard() {
		return Standard;
	}
	public void setStandard(String standard) {
		Standard = standard;
	}
	public LocalDate getDateManufacture() {
		return DateManufacture;
	}
	public void setDateManufacture(LocalDate dateManufacture) {
		DateManufacture = dateManufacture;
	}
	public LocalDate getDateOut() {
		return DateOut;
	}
	public void setDateOut(LocalDate dateOut) {
		DateOut = dateOut;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public double getPriceEnter() {
		return PriceEnter;
	}
	public void setPriceEnter(double priceEnter) {
		PriceEnter = priceEnter;
	}
	public double getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}
	public int getNumImport() {
		return NumImport;
	}
	public void setNumImport(int numImport) {
		NumImport = numImport;
	}
	public LocalDate getDateImport() {
		return DateImport;
	}
	public void setDateImport(LocalDate dateImport) {
		DateImport = dateImport;
	}
	public double getPriceOut() {
		return PriceOut;
	}
	
	public int getAmountNow() {
		return AmountNow;
	}
	public void setAmountNow(int amountNow) {
		AmountNow = amountNow;
	}
	public double getAmountRetailDefault() {
		return AmountRetailDefault;
	}
	public void setAmountRetailDefault(double amountRetailDefault) {
		AmountRetailDefault = amountRetailDefault;
	}
	public boolean isDeleteStatus() {
		return DeleteStatus;
	}
	public void setDeleteStatus(boolean deleteStatus) {
		DeleteStatus = deleteStatus;
	}
	public String getUnitRetai() {
		return UnitRetai;
	}
	public void setUnitRetai(String unitRetai) {
		UnitRetai = unitRetai;
	}
	public int getProNumOut() {
		return ProNumOut;
	}
	public void setProNumOut(int proNumOut) {
		ProNumOut = proNumOut;
	}
	public boolean isStatusImport() {
		return StatusImport;
	}
	public void setStatusImport(boolean statusImport) {
		StatusImport = statusImport;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPriceOut(float priceOut) {
		PriceOut = priceOut;
	}

	public void setPriceRetailOut(float priceRetailOut) {
		PriceRetailOut = priceRetailOut;
	}
	
	
	

	@Override
	public String toString() {
		return "Medicine [IdMedicine=" + IdMedicine + ", RegisNumber=" + RegisNumber + ", NameMedicine=" + NameMedicine
				+ ", Class1=" + Class1 + ", GroupMedicine=" + GroupMedicine + ", Active=" + Active + ", Content="
				+ Content + ", CoverForm=" + CoverForm + ", Packing=" + Packing + ", Standard=" + Standard
				+ ", DateManufacture=" + DateManufacture + ", DateOut=" + DateOut + ", Unit=" + Unit + ", PriceEnter="
				+ PriceEnter + ", UnitPrice=" + UnitPrice + ", NumImport=" + NumImport + ", DateImport=" + DateImport
				+ ", PriceOut=" + PriceOut + ", PriceRetailOut=" + PriceRetailOut + ", AmountNow=" + AmountNow
				+ ", AmountRetailDefault=" + AmountRetailDefault + ", DeleteStatus=" + DeleteStatus + ", UnitRetai="
				+ UnitRetai + ", ProNumOut=" + ProNumOut + ", StatusImport=" + StatusImport + "]";
	}
	
	
	
	
	
	
}
