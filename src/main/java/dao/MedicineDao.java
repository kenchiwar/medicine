package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDb;
import database.ConnectProperties;
import entity.Customer;
import entity.Medicine;
import entity.Supplier;

public class MedicineDao {
	
	public void InsertCustomer(Medicine mem) {
		
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareCall("{call insertMedicine(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			) 
			{
			cs.setString(1,mem.getRegisNumber());
			cs.setString(2,mem.getNameMedicine());
			cs.setString(3,mem.getClass1());
			cs.setString(4,mem.getGroupMedicine());
			cs.setString(5,mem.getActive());
			cs.setString(6,mem.getContent());
			cs.setString(7,mem.getCoverForm());
			cs.setString(8,mem.getPacking());
			cs.setString(9,mem.getStandard());
			cs.setInt(10,mem.getIdSupplier());
			cs.setDate(11,Date.valueOf(mem.getDateManufacture()));
			cs.setDate(12,Date.valueOf(mem.getDateOut()));
			cs.setString(13,mem.getUnit());
			cs.setDouble(14,mem.getPriceEnter());
			cs.setDouble(15,mem.getUnitPrice());
			cs.setInt(16,mem.getNumImport());
			cs.setDate(17,Date.valueOf(mem.getDateImport()));
			cs.setDouble(18,mem.getPriceOut());
			cs.setDouble(19,mem.getPriceRetailOut());
			cs.setInt(20,mem.getAmountNow());
			cs.setDouble(21,mem.getAmountRetailDefault());
			cs.setString(22,mem.getUnitRetai());
			cs.setInt(23,mem.getProNumOut());
			
			
			
			cs.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	public static List<String> addCombobox(){
	
		List<String> a = new ArrayList<String>();
		try(
			var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("select * FROM Supplier");
				var rs = cs.executeQuery();
		) 
		{
			while(rs.next()) {
				String b;		
				b=rs.getString("Name");
				a.add(b);

			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
		

	}
	
	public static List<Supplier> addComboboxid(){
		
		List<Supplier> a = new ArrayList<Supplier>();
		try(
			var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("select * FROM Supplier");
				var rs = cs.executeQuery();
		) 
		{
			while(rs.next()) {
				Supplier b= new Supplier();	
				b.setIdSupplier(rs.getInt("IdSupplier"));
				b.setName(rs.getString("Name"));
				a.add(b);

			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
		

	}
	public boolean erroPhoneMed(String RegisNumber) {
		var boo=false;
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("Select * from Medicine where RegisNumber=N'"+RegisNumber+"' AND DateDiff(day,getDate(),DateOut)>0");
				var rs = cs.executeQuery();
			) 
			{
		while(rs.next()) {
			boo=true;
		}
		return boo;
			
			} catch (Exception e) {
				e.printStackTrace();
				return boo;

			}


	}
	public static void StopImport(String regisNumber) {
		try(
				var con = ConnectDb.getConnection();
					var cs = con.prepareStatement("UPDate Medicine"
							+ "	SET StatusImport =0 WHERE RegisNumber=N'"+regisNumber+"'");
					
			) 
			{
				
			cs.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		
	}
	
public static void Import(String regisNumber) {
	
	try(
			var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("UPDate Medicine"
						+ "	SET StatusImport =1 WHERE RegisNumber=N'"+regisNumber+"'");
			
		) 
		{
		cs.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Medicine> getList(){
		List<Medicine> list = new ArrayList<Medicine>();
		
		try(
			var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("SELECT RegisNumber,NameMedicine ,Class, GroupMedicine, StatusImport, Active, [Content], CoverForm,"
						+ " Packing, [Standard], Supplier.Name ,Sum(AmountNow) as AmountNow"
						+ " FROM Medicine INNER JOIN Supplier ON Medicine.IdSupplier = Supplier.IdSupplier"
						+ " GROUP BY RegisNumber,NameMedicine,"
						+ " Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard],Supplier.Name, StatusImport");
				var rs = cs.executeQuery();
		) 
		{
			while(rs.next()) {
				var mem =new Medicine();
				mem.setRegisNumber(rs.getString("RegisNumber"));
				mem.setNameMedicine(rs.getString("NameMedicine"));
				mem.setClass1(rs.getString("Class"));
				mem.setGroupMedicine(rs.getString("GroupMedicine"));
				mem.setActive(rs.getString("Active"));
				mem.setContent(rs.getString("Content"));
				mem.setCoverForm(rs.getString("CoverForm"));
				mem.setPacking(rs.getString("Packing"));
				mem.setStandard(rs.getString("Standard"));
				mem.setAmountNow(rs.getInt("AmountNow"));
				mem.setName(rs.getString("Name"));
				mem.setStatusImport(rs.getBoolean("StatusImport"));
				list.add(mem);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<Medicine> SearchMed(String RegisNumber) {
		
		List<Medicine> hay =  new ArrayList<Medicine>();
		
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("SELECT IdMedicine, DateManufacture, DateOut, Unit, PriceEnter,"
						+ " UnitPrice, NumImport, DateImport, PriceOut, AmountNow, PriceRetailOut, DeleteStatus FROM Medicine where Regisnumber=N'"+RegisNumber+"' ");
				var rs = cs.executeQuery();
			) 
			{
			while(rs.next()) {
				var mem = new Medicine();
			mem.setIdMedicine(rs.getInt("IdMedicine"));
			mem.setDateManufacture(rs.getDate("DateManufacture").toLocalDate());
			mem.setDateOut(rs.getDate("DateOut").toLocalDate());
			mem.setUnit(rs.getString("Unit"));
			mem.setPriceEnter(rs.getDouble("PriceEnter"));
			mem.setUnitPrice(rs.getDouble("UnitPrice"));
			mem.setNumImport(rs.getInt("NumImport"));
			mem.setPriceOut(rs.getDouble("PriceOut"));
			mem.setPriceRetailOut(rs.getDouble("PriceRetailOut"));
			mem.setDateImport(rs.getDate("DateImport").toLocalDate());
			
			mem.setAmountNow(rs.getInt("AmountNow"));
			
			mem.setDeleteStatus(rs.getBoolean("DeleteStatus"));
			hay.add(mem);
			
			}
	

			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return hay;
	}
	
	////
	
	
	////
	public static Medicine get(String regis){
		Medicine mem = new Medicine();
		
		try(
			var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("SELECT RegisNumber,NameMedicine ,Class, GroupMedicine, StatusImport, Active, [Content], CoverForm,"
						+ " Packing, [Standard], Supplier.Name ,Sum(AmountNow) as AmountNow,Supplier.IdSupplier, Unit, UnitRetail, AmountRetailDefault, ProNumOut "
						+ " FROM Medicine INNER JOIN Supplier ON Medicine.IdSupplier = Supplier.IdSupplier "
						+ "WHERE RegisNumber=N'"+regis+"' AND DateDiff(day,getDate(),DateOut)>0"
						+ " GROUP BY RegisNumber,NameMedicine,"
						+ " Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard],Supplier.Name, StatusImport,Supplier.IdSupplier, Unit, UnitRetail, AmountRetailDefault, ProNumOut");
				var rs = cs.executeQuery();
		) 
		{
			while(rs.next()) {
				
				mem.setRegisNumber(rs.getString("RegisNumber"));
				mem.setNameMedicine(rs.getString("NameMedicine"));
				mem.setClass1(rs.getString("Class"));
				mem.setGroupMedicine(rs.getString("GroupMedicine"));
				mem.setActive(rs.getString("Active"));
				mem.setContent(rs.getString("Content"));
				mem.setCoverForm(rs.getString("CoverForm"));
				mem.setPacking(rs.getString("Packing"));
				mem.setStandard(rs.getString("Standard"));
				mem.setAmountNow(rs.getInt("AmountNow"));
				mem.setName(rs.getString("Name"));
				mem.setStatusImport(rs.getBoolean("StatusImport"));
				mem.setUnit(rs.getString("Unit"));
				mem.setUnitRetai(rs.getString("UnitRetail"));
				mem.setAmountRetailDefault(rs.getDouble("AmountRetailDefault"));
				mem.setProNumOut(rs.getInt("ProNumOut"));
				mem.setIdSupplier(rs.getInt("IdSupplier"));
				
			}
			return mem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mem;
	}
	
	public static Medicine EnterMed(String hay){
		var mem = new Medicine();
		
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("SELECT * FROM Medicine where Regisnumber=N'"+hay+"'  ORDER BY IdMedicine  DESC  OFFSET 0 ROWS  FETCH NEXT 1 ROWS ONLY");
				var rs = cs.executeQuery();
			) 
			{
			while(rs.next()) {
				
			
				mem.setIdSupplier(rs.getInt("IdSupplier"));
				mem.setRegisNumber(rs.getString("RegisNumber"));
				mem.setClass1(rs.getString("Class"));
				mem.setNameMedicine(rs.getString("NameMedicine"));
				mem.setGroupMedicine(rs.getString("GroupMedicine"));
				mem.setActive(rs.getString("Active"));
				mem.setContent(rs.getString("Content"));
				mem.setCoverForm(rs.getString("CoverForm"));
				mem.setPacking(rs.getString("Packing"));
				mem.setStandard(rs.getString("Standard"));
				mem.setAmountNow(rs.getInt("AmountNow"));
				mem.setAmountRetailDefault(rs.getDouble("AmountRetailDefault"));
				mem.setUnitRetai(rs.getString("UnitRetail"));
				mem.setUnit(rs.getString("Unit"));
			
			}
	

			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return mem;
		
	}
	public void UpdateMedicine(Medicine mem,String hay) {
		
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareCall("{call updatelMedicine(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			) 
			{
			cs.setString(1,mem.getRegisNumber());
			cs.setString(2,mem.getNameMedicine());
			cs.setString(3,mem.getClass1());
			cs.setString(4,mem.getGroupMedicine());
			cs.setString(5,mem.getActive());
			cs.setString(6,mem.getContent());
			cs.setString(7,mem.getCoverForm());
			cs.setString(8,mem.getPacking());
			cs.setString(9,mem.getStandard());
			cs.setInt(10,mem.getIdSupplier());
			cs.setString(11,mem.getUnit());
			cs.setDouble(12,mem.getAmountRetailDefault());
			cs.setString(13,mem.getUnitRetai());
			cs.setInt(14,mem.getProNumOut());
			cs.setString(15,hay);
			cs.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public boolean erroUpdateRegisNumber(String RegisNumberOld,String RegisNumberNew) {
		var boo=false;
		if(RegisNumberOld.equals(RegisNumberNew)) return boo;
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("Select RegisNumber from Medicine  where RegisNumber=N'"+RegisNumberNew+"' AND DateDiff(day,getDate(),DateOut)>0");
				var rs = cs.executeQuery();
			) 
			{
		while(rs.next()) {
			boo=true;
		}
		return boo;
			
			} catch (Exception e) {
				e.printStackTrace();
				return boo;

			}


	}
public static void UpdateMedicineDetail(Medicine mem) {
		
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareCall("{call updateDetailMedi(?,?,?,?,?,?,?,?)}");
			) 
			{
			cs.setDate(1,Date.valueOf(mem.getDateManufacture()));
			cs.setDate(2,Date.valueOf(mem.getDateOut()));
			cs.setDouble(3,mem.getPriceEnter());
			cs.setInt(4,mem.getNumImport());
			cs.setDouble(5,mem.getPriceOut());
			cs.setDouble(6,mem.getPriceRetailOut());
			cs.setDate(7,Date.valueOf(mem.getDateImport()));
			cs.setInt(8,mem.getIdMedicine());
			
			cs.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

public static List<Medicine> Searchh(String code) {
	
	List<Medicine> hay =  new ArrayList<Medicine>();
	
	try(
			var con = ConnectDb.getConnection();
			var cs = con.prepareStatement("SELECT RegisNumber,NameMedicine ,Class, GroupMedicine, StatusImport, Active, [Content], CoverForm,"
					+ " Packing, [Standard], Supplier.Name ,Sum(AmountNow) as AmountNow"
					+ " FROM Medicine INNER JOIN Supplier ON Medicine.IdSupplier = Supplier.IdSupplier "
					+ " where RegisNumber like N'"+code+"%' or NameMedicine like N'"+code+"%' AND DateDiff(day,getDate(),DateOut)>0"
					+ "	GROUP BY RegisNumber,NameMedicine,"
					+ " Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard],Supplier.Name, StatusImport");
			var rs = cs.executeQuery();
		) 
		{
		while(rs.next()) {
			var mem = new Medicine();
			mem.setRegisNumber(rs.getString("RegisNumber"));
			mem.setNameMedicine(rs.getString("NameMedicine"));
			mem.setClass1(rs.getString("Class"));
			mem.setGroupMedicine(rs.getString("GroupMedicine"));
			mem.setActive(rs.getString("Active"));
			mem.setContent(rs.getString("Content"));
			mem.setCoverForm(rs.getString("CoverForm"));
			mem.setPacking(rs.getString("Packing"));
			mem.setStandard(rs.getString("Standard"));
			mem.setAmountNow(rs.getInt("AmountNow"));
			mem.setName(rs.getString("Name"));
			mem.setStatusImport(rs.getBoolean("StatusImport"));
			hay.add(mem);
		}

		
		} catch (Exception e) {
			e.printStackTrace();
		}
	return hay;
}

public static List<Medicine> getListOut(){
	List<Medicine> list = new ArrayList<Medicine>();
	
	try(
		var con = ConnectDb.getConnection();
			var cs = con.prepareStatement("SELECT RegisNumber,NameMedicine ,Class, GroupMedicine, StatusImport, Active, [Content], CoverForm,"
					+ " Packing, [Standard], Supplier.Name ,Sum(AmountNow) as AmountNow"
					+ " FROM Medicine INNER JOIN Supplier ON Medicine.IdSupplier = Supplier.IdSupplier"
					+ " WHERE DateDiff(day,getDate(),DateOut)>0 and StatusImport=1  and Medicine.DeleteStatus=0"
					+ " GROUP BY RegisNumber,NameMedicine,"
					+ " Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard],Supplier.Name, StatusImport"
					+ " HAVING SUM(AmountNow)<=10 "
					+ "");
			var rs = cs.executeQuery();
			
//			SELECT COUNT(RegisNumber) as Met"
//			+ " FROM Medicine"
//			+ " WHERE DateDiff(day,getDate(),DateOut)>0 and StatusImport=1"
//			+ " GROUP BY RegisNumber"
//			+ " HAVING SUM(AmountNow)<=10
	) 
	{
		while(rs.next()) {
			var mem =new Medicine();
			mem.setRegisNumber(rs.getString("RegisNumber"));
			mem.setNameMedicine(rs.getString("NameMedicine"));
			mem.setClass1(rs.getString("Class"));
			mem.setGroupMedicine(rs.getString("GroupMedicine"));
			mem.setActive(rs.getString("Active"));
			mem.setContent(rs.getString("Content"));
			mem.setCoverForm(rs.getString("CoverForm"));
			mem.setPacking(rs.getString("Packing"));
			mem.setStandard(rs.getString("Standard"));
			mem.setAmountNow(rs.getInt("AmountNow"));
			mem.setName(rs.getString("Name"));
			mem.setStatusImport(rs.getBoolean("StatusImport"));
			if(mem.getAmountNow()<=10) {
			list.add(mem);
			}
		}
		return list;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
}
	
public static Integer getListOutNum(){
	var a = 0;
	
	try(
		var con = ConnectDb.getConnection();
			var cs = con.prepareStatement("SELECT RegisNumber as Met "
					+ " FROM Medicine "
					+ " WHERE DateDiff(day,getDate(),DateOut)>0 and StatusImport=1 and Medicine.DeleteStatus=0"
					+ " GROUP BY RegisNumber"
			
					+ " HAVING SUM(AmountNow)<=10 "
					+ "");
			var rs = cs.executeQuery();
	) 
	{
		while(rs.next()) {
		
		a++;
		}
		return a;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return a;
}
public static List<Medicine> getListEndDate(){
	List<Medicine> list = new ArrayList<Medicine>();
	
	try(
		var con = ConnectDb.getConnection();
			var cs = con.prepareStatement("Select * from Medicine"
					+ " WHERE DateDiff(day,getDate(),DateOut)<30 AND DeleteStatus=0");
			var rs = cs.executeQuery();
	) 
	{
		while(rs.next()) {
			var mem =new Medicine();
			mem.setIdMedicine(rs.getInt("IdMedicine"));
			mem.setDateManufacture(rs.getDate("DateManufacture").toLocalDate());
			mem.setDateOut(rs.getDate("DateOut").toLocalDate());
			mem.setUnit(rs.getString("Unit"));
			mem.setPriceEnter(rs.getDouble("PriceEnter"));
			mem.setUnitPrice(rs.getDouble("UnitPrice"));
			mem.setNumImport(rs.getInt("NumImport"));
			mem.setPriceOut(rs.getDouble("PriceOut"));
			mem.setPriceRetailOut(rs.getDouble("PriceRetailOut"));
			mem.setDateImport(rs.getDate("DateImport").toLocalDate());
			mem.setPriceOut(rs.getDouble("PriceOut"));
			mem.setAmountNow(rs.getInt("AmountNow"));
			mem.setDeleteStatus(rs.getBoolean("DeleteStatus"));
			mem.setRegisNumber(rs.getString("RegisNumber"));
			mem.setNameMedicine(rs.getString("NameMedicine"));
			mem.setStatusImport(rs.getBoolean("StatusImport"));
			
			list.add(mem);
			
		}
		return list;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
}
public static Integer getListOutDate(){
	var a = 0;
	
	try(
		var con = ConnectDb.getConnection();
			var cs = con.prepareStatement("SELECT COUNT(IdMedicine) as Met"
					+ " FROM Medicine"
					+ " WHERE DateDiff(day,getDate(),DateOut)<30 and DeleteStatus=0"
					+ " "
					+ "  ");
			var rs = cs.executeQuery();
	) 
	{
		while(rs.next()) {
		a=rs.getInt("Met");
		}
		return a;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return a;
}
public static void updateOutDate(Integer id) {
	try(
			var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("Update Medicine set DeleteStatus = 1 WHERE IdMedicine="+id);
			
		) 
		{
		 cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

}

public static ArrayList<Medicine> selectName(String name) {
	var arrayMedicine = new ArrayList<Medicine>();
	
	try (
			var con = ConnectProperties.getConnection();
			
			var stmt=con.createStatement();	
			var stmt2=con.createStatement();	
			)
	{
		var rs=stmt.executeQuery("Select * from Medicine where (NameMedicine like N'%"+name+"%' or RegisNumber like N'%"+name+"%' )and DeleteStatus=0 ");
		
		while(rs.next()) {
			var medicine = new Medicine();
			medicine.setIdMedicine(rs.getInt("IdMedicine"));
			medicine.setRegisNumber(rs.getString("RegisNumber"));
			medicine.setNameMedicine(rs.getString("NameMedicine"));
		
			medicine.setUnit(rs.getString("Unit"));
			medicine.setPriceEnter(rs.getFloat("Unit"));
			medicine.setPriceOut(rs.getFloat("PriceOut"));
			medicine.setPriceRetailOut(rs.getFloat("PriceRetailOut"));
			
			var rs2 = stmt2.executeQuery("Select sum(amountNow) as amount  from Medicine "
					+ "where DeleteStatus = 0 and RegisNumber=N'"+medicine.getRegisNumber()+"'"
							+ " and DateDiff(day,getDate(),DateOut)>0"
					+ " GROUP BY RegisNumber");
			while(rs2.next()) {
				medicine.setAmountNow(rs2.getInt("amount"));
			}
			if(rs.getDate("DateOut")!=null) {
			medicine.setDateOut((rs.getDate("DateOut").toLocalDate()));
			}
			arrayMedicine.add(medicine);
		}
	
		return arrayMedicine;
		
	}catch (Exception e) {
		e.printStackTrace();
		return arrayMedicine;
	}
}
public static String monthMedicineTotal() {
	String message = "";
	try (
			var con = ConnectProperties.getConnection();
			
			var stmt=con.createStatement();	
			var stmt2=con.createStatement();	
			)
	{
		
		var rs=stmt.executeQuery("SELECT Sum(Medicine.UnitPrice) as Medicine FROM Medicine WHERE DATEDIFF(month, Medicine.DateManufacture,GETDATE())<=1");

		while(rs.next()) {
			message=rs.getString("Medicine");
			
		}
		return message;		
	}catch (Exception e) {
		e.printStackTrace();
		return message;	
		
	}

}

public static String searchMedicineTotal(String search) {
	String message = "";
	try (
			var con = ConnectProperties.getConnection();
			
			var stmt=con.createStatement();	
			var stmt2=con.createStatement();	
			)
	{
		
		var rs=stmt.executeQuery("SELECT Sum(Medicine.UnitPrice) as Medicine FROM Medicine "
				+ "WHERE CONVERT(NVARCHAR,Medicine.DateManufacture,103) LIKE N'%"+search+"%' ");

		while(rs.next()) {
			message=rs.getString("Medicine");
			
		}
		return message;		
	}catch (Exception e) {
		e.printStackTrace();
		return message;	
		
	}
	
}


public static List<Medicine> getListEvent(){
	List<Medicine> list = new ArrayList<Medicine>();
	
	try(
		var con = ConnectProperties.getConnection();
			var cs = con.prepareStatement("SELECT RegisNumber,NameMedicine ,Class, GroupMedicine, StatusImport, Active, [Content], CoverForm,"
					+ " Packing, [Standard], Supplier.Name ,Sum(AmountNow) as AmountNow"
					+ " FROM Medicine INNER JOIN Supplier ON Medicine.IdSupplier = Supplier.IdSupplier GROUP BY RegisNumber,NameMedicine,"
					+ " Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard],Supplier.Name, StatusImport");
			var rs = cs.executeQuery();
	) 
	{
		while(rs.next()) {
			var mem =new Medicine();
			mem.setRegisNumber(rs.getString("RegisNumber"));
			mem.setNameMedicine(rs.getString("NameMedicine"));
			mem.setClass1(rs.getString("Class"));
			mem.setGroupMedicine(rs.getString("GroupMedicine"));
			mem.setActive(rs.getString("Active"));
			mem.setContent(rs.getString("Content"));
			mem.setCoverForm(rs.getString("CoverForm"));
			mem.setPacking(rs.getString("Packing"));
			mem.setStandard(rs.getString("Standard"));
			mem.setAmountNow(rs.getInt("AmountNow"));
			mem.setName(rs.getString("Name"));
			
			mem.setDeleteStatus(false);
			list.add(mem);
		}
		return list;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
}


	
}

