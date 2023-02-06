package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDb;
import entity.Customer;
import entity.Medicine;
import entity.Supplier;

public class SupplierDao {

	public void InsertSupplier(Supplier mem) {
	
try(
		var con = ConnectDb.getConnection();
		var cs = con.prepareCall("{call InsertSupplier(?,?,?,?,?,?,?,?,?)}");
	) 
	{
	cs.setString(1,mem.getName1());
	cs.setString(2,mem.getNumPhone());
	cs.setString(3,mem.getGmail());
	cs.setString(4,mem.getNumhome());
	cs.setString(5,mem.getName());
	cs.setString(6,mem.getWard());
	cs.setString(7,mem.getCounty());
	cs.setString(8,mem.getCity());
	cs.setString(9,mem.getCountry());
	cs.executeUpdate();
	
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	public static List<Supplier> getList(){
		List<Supplier> list = new ArrayList<Supplier>();
		
		try(
			var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("SELECT Supplier.*, Address.NumHome, "
						+ "Address.Name as Name1, Address.Ward, Address.County, Address.City ,Address.Country"
						+ " FROM Address INNER JOIN "
						+ " Supplier ON Address.IdAddress = Supplier.IdAddress");
				var rs = cs.executeQuery();
		) 
		{
			while(rs.next()) {
				var mem =  new Supplier();
				mem.setIdSupplier(rs.getInt("IdSupplier"));
				mem.setName1(rs.getString("Name"));
				mem.setNumPhone(rs.getString("NumPhone"));
				mem.setGmail(rs.getString("Gmail"));
				mem.setIdAddress(rs.getInt("IdAddress"));
				mem.setNumhome(rs.getString("NumHome"));
				mem.setName(rs.getString("Name1"));
				mem.setWard(rs.getString("Ward"));
				mem.setCounty(rs.getString("County"));
				mem.setCity(rs.getString("City"));
				mem.setCountry(rs.getString("Country"));
				mem.setDeleteStatus(rs.getBoolean("DeleteStatus"));
				
				list.add(mem);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public boolean erroNameSup(String RegisNumber) {
		var boo=false;
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("Select * from Supplier where Name=N'"+RegisNumber+"'");
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
	public boolean erroNameSupp(String RegisNumber) {
		var boo=false;
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("Select * from Supplier where NumPhone=N'"+RegisNumber+"'");
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
	
public static List<Supplier> SearchSup(String name) {
		
		List<Supplier> hay =  new ArrayList<Supplier>();
		
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("SELECT Supplier.*, Address.NumHome,"
						+ "	Address.Name as Name2, Address.Ward, Address.County, Address.City ,Address.Country"
						+ "	FROM Address INNER JOIN "
						+ "	Supplier ON Address.IdAddress = Supplier.IdAddress  where Supplier.Name=N'"+name+"'");
				var rs = cs.executeQuery();
			) 
			{
			while(rs.next()) {
				var mem = new Supplier();
				mem.setName1(rs.getString("Name"));
				mem.setNumPhone(rs.getString("NumPhone"));
				mem.setGmail(rs.getString("Gmail"));
				mem.setNumhome(rs.getString("NumHome"));
				mem.setName(rs.getString("Name2"));
				mem.setWard(rs.getString("Ward"));
				mem.setCounty(rs.getString("County"));
				mem.setCity(rs.getString("City"));
				mem.setCountry(rs.getString("Country"));
			hay.add(mem);
			
			}			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return hay;
	}
public void UpdateSupplier(Supplier mem) {
	
	try(
			var con = ConnectDb.getConnection();
			var cs = con.prepareCall("{call UpdateSupplier(?,?,?,?,?,?,?,?,?,?,?)}");
		) 
		{
		cs.setString(1,mem.getName1());
		cs.setString(2,mem.getNumPhone());
		cs.setString(3,mem.getGmail());
		cs.setString(4,mem.getNumhome());
		cs.setString(5,mem.getName());
		cs.setString(6,mem.getWard());
		cs.setString(7,mem.getCounty());
		cs.setString(8,mem.getCity());
		cs.setString(9,mem.getCountry());
		cs.setInt(10,mem.getIdAddress());
		cs.setInt(11,mem.getIdSupplier());
		cs.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
}

public boolean erroUpdateName(int RegisNumber,String RegisNumberr) {
	var boo=false;
	try(
			var con = ConnectDb.getConnection();
			var cs = con.prepareStatement("Select * from Supplier WHERE IdSupplier != "+RegisNumber+" and Name = N'"+RegisNumberr+"'");
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
public boolean erroUpdatePhone(int RegisNumber,String RegisNumberr) {
	var boo=false;
	try(
			var con = ConnectDb.getConnection();
			var cs = con.prepareStatement("Select * from Supplier WHERE IdSupplier != "+RegisNumber+" and NumPhone = N'"+RegisNumberr+"'");
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
public static List<Medicine> getListt(int id){
	List<Medicine> list = new ArrayList<Medicine>();
	
	try(
		var con = ConnectDb.getConnection();
			var cs = con.prepareStatement("SELECT RegisNumber,NameMedicine ,Class, GroupMedicine, StatusImport, Active, [Content], CoverForm,"
					+ " Packing, [Standard], Supplier.Name ,Sum(AmountNow) as AmountNow"
					+ " FROM Medicine INNER JOIN Supplier ON Medicine.IdSupplier = Supplier.IdSupplier"
					+ " where Supplier.IdSupplier = "+id+" "
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
					+ " UnitPrice, NumImport, DateImport, PriceOut, AmountNow, PriceRetailOut, DeleteStatus FROM Medicine where Regisnumber=N'"+RegisNumber+"'");
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
		mem.setPriceOut(rs.getDouble("PriceOut"));
		mem.setAmountNow(rs.getInt("AmountNow"));
		
		mem.setDeleteStatus(rs.getBoolean("DeleteStatus"));
		hay.add(mem);
		
		}


		
		} catch (Exception e) {
			e.printStackTrace();
		}
	return hay;
}
}
