package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

//import database.ConnectDB;
//import database.ConnectDB;
import database.ConnectDb;
import database.ConnectProperties;
import entity.Customer;
import gui.TTCustomer;


public class CustomerDao {
	
	
			public void InsertCustomer(Customer mem) {
			
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareCall("{call InsertCustomer(?,?,?,?,?,?,?,?,?,?,?,?)}");
			) 
			{
			cs.setString(1,mem.getFirstName());
			cs.setString(2,mem.getLastName());
			cs.setDate(3,Date.valueOf(mem.getBirthday()));
			cs.setBoolean(4,mem.isGender());
			cs.setString(5,mem.getCCCD());
			cs.setString(6,mem.getNumphone());
			cs.setString(7,mem.getNumhome());
			cs.setString(8,mem.getName());
			cs.setString(9,mem.getWard());
			cs.setString(10,mem.getCounty());
			cs.setString(11,mem.getCity());
			cs.setString(12,mem.getCountry());
			cs.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
			
			public static List<Customer> getList(){
				List<Customer> list = new ArrayList<Customer>();
				
				try(
					var con = ConnectDb.getConnection();
						var cs = con.prepareStatement("SELECT Customer.*, Address.NumHome, "
								+ "Address.Name, Address.Ward, Address.County, Address.City ,Address.Country"
								+ " FROM Address INNER JOIN "
								+ " Customer ON Address.IdAddress = Customer.IdAddress");
						var rs = cs.executeQuery();
						var stmt=con.createStatement();
				) 
				{
					while(rs.next()) {
						var mem =  new Customer();
						mem.setIdCus(rs.getInt("IdCustomer"));
						mem.setFirstName(rs.getString("FirstName"));
						mem.setLastName(rs.getString("Lastname"));
						mem.setBirthday(rs.getDate("Birthday").toLocalDate());
						mem.setGender(rs.getBoolean("Gender"));
						mem.setCCCD(rs.getString("CCCD"));
						mem.setNumphone(rs.getString("Numphone"));
						mem.setIdAddress(rs.getInt("IdAddress"));
						mem.setNumhome(rs.getString("NumHome"));
						mem.setName(rs.getString("Name"));
						mem.setWard(rs.getString("Ward"));
						mem.setCounty(rs.getString("County"));
						
						mem.setCity(rs.getString("City"));
						mem.setCountry(rs.getString("Country"));
						mem.setDeleteStaus(rs.getBoolean("DeleteStaus"));
						var rs2=stmt.executeQuery("select sum (total) as met from Bill where IdCustomer = "+mem.getIdCus()+"");
						while(rs2.next()) {
							mem.setTotalCus(rs2.getFloat("met"));
						}
						
						list.add(mem);
					}
					return list;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return list;
			}
			
			
			public List<Customer> getList1(){
				List<Customer> list = new ArrayList<Customer>();
				
				try(
					var con = ConnectDb.getConnection();
					var cs = con.prepareStatement("SELECT Customer.*, Address.NumHome, Address.Name, Address.Ward, Address.County, Address.City,Address.Country"
							+ "FROM Address INNER JOIN"
							+ "Customer ON Address.IdAddress = Customer.IdAddress");
					var rs = cs.executeQuery();
				) 
				{
					while(rs.next()) {
						var mem =  new Customer();
						mem.setIdCus(rs.getInt("IdCustomer"));
						mem.setFirstName(rs.getString("FirstName"));
						mem.setLastName(rs.getString("Lastname"));
						mem.setBirthday(rs.getDate("Birthday").toLocalDate());
						mem.setGender(rs.getBoolean("Gender"));
						mem.setCCCD(rs.getString("CCCD"));
						mem.setNumphone(rs.getString("Numphone"));
						mem.setIdAddress(rs.getInt("IdAddress"));
						mem.setNumhome(rs.getString("NumHome"));
						mem.setName(rs.getString("Name"));
						mem.setWard(rs.getString("Ward"));
						mem.setCounty(rs.getString("County"));
						mem.setCity(rs.getString("City"));
						mem.setCountry(rs.getString("Country"));
						list.add(mem);
					}
					return list;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return list;
			}
			
			public static Customer SearchIfCustomer(int id) {
				
				var mem =  new Customer();
				try(
						var con = ConnectDb.getConnection();
						var cs = con.prepareStatement("SELECT Customer.*, Address.NumHome, "
								+ "Address.Name, Address.Ward, Address.County, Address.City ,Address.Country"
								+ " FROM Address INNER JOIN "
								+ " Customer ON Address.IdAddress = Customer.IdAddress  where IdCustomer="+id);
						var rs = cs.executeQuery();
					) 
					{
				while(rs.next()) {
					mem.setIdCus(rs.getInt("IdCustomer"));
					mem.setFirstName(rs.getString("FirstName"));
					mem.setLastName(rs.getString("Lastname"));
					mem.setBirthday(rs.getDate("BirthDay").toLocalDate());
					mem.setGender(rs.getBoolean("Gender"));
					mem.setCCCD(rs.getString("CCCD"));
					mem.setNumphone(rs.getString("NumPhone"));
					mem.setIdAddress(rs.getInt("IdAddress"));
					mem.setNumhome(rs.getString("NumHome"));
					mem.setName(rs.getString("Name"));
					mem.setWard(rs.getString("Ward"));
					mem.setCounty(rs.getString("County"));
					mem.setCity(rs.getString("City"));
					mem.setCountry(rs.getString("Country"));
				}
				return mem;
					
					} catch (Exception e) {
						e.printStackTrace();
						return mem;
					}
			}
			
	public static Customer Search(String phone) {
				
				var mem =  new Customer();
				
				try(
						var con = ConnectDb.getConnection();
						var cs = con.prepareStatement("SELECT Customer.*, Address.NumHome, Address.Name, Address.Ward, Address.County, Address.City\n"
								+ "FROM     Address INNER JOIN\n"
								+ "                  Customer ON Address.IdAddress = Customer.IdAddress where NumPhone="+phone);
						var rs = cs.executeQuery();
					) 
					{
					while(rs.next()) {
					mem.setIdCus(rs.getInt("IdCustomer"));
					mem.setFirstName(rs.getString("FirstName"));
					mem.setLastName(rs.getString("Lastname"));
					mem.setBirthday(rs.getDate("BirthDay").toLocalDate());
					mem.setGender(rs.getBoolean("Gender"));
					mem.setCCCD(rs.getString("CCCD"));
					mem.setNumphone(rs.getString("NumPhone"));
					mem.setIdAddress(rs.getInt("IdAddress"));
					mem.setNumhome(rs.getString("NumHome"));
					mem.setName(rs.getString("Name"));
					mem.setWard(rs.getString("Ward"));
					mem.setCounty(rs.getString("County"));
					mem.setCity(rs.getString("City"));
					mem.setCountry(rs.getString("Country"));
					}
					return mem;
	
					
					} catch (Exception e) {
						e.printStackTrace();
					}
				return mem;
			}
	
	public void UpdateCustomer(Customer mem) {
		
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareCall("{call updateCusomer(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			) 
			{
			cs.setString(1,mem.getFirstName());
			cs.setString(2,mem.getLastName());
			cs.setDate(3,Date.valueOf(mem.getBirthday()));
			cs.setBoolean(4,mem.isGender());
			cs.setString(5,mem.getCCCD());
			cs.setString(6,mem.getNumphone());
			cs.setString(7,mem.getNumhome());
			cs.setString(8,mem.getName());
			cs.setString(9,mem.getWard());
			cs.setString(10,mem.getCounty());
			cs.setString(11,mem.getCity());
			cs.setString(12,mem.getCountry());
			cs.setInt(13,mem.getIdAddress());
			cs.setInt(14,mem.getIdCus());
			cs.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public boolean erroPhoneCus(String NumPhone) {
		var boo=false;
		var mem =  new Customer();
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("Select * from Customer where NumPhone=N'"+NumPhone+"'  ");
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
	public boolean errPhoneUpdate(String NumPhone,int id) {
		var boo=false;
		var mem =  new Customer();
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("Select * from Customer where NumPhone=N'"+NumPhone+"' and IdCustomer != "+id);
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
	
	public static void StopCus(int regisNumber) {
		try(
				var con = ConnectDb.getConnection();
					var cs = con.prepareStatement("UPDate Customer"
							+ "	SET DeleteStaus =0 WHERE IdCustomer="+regisNumber+"");
					
			) 
			{
				
			cs.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		
	}
	
	public static void ImportCus(int regisNumber) {
	
	try(
			var con = ConnectDb.getConnection();
				var cs = con.prepareStatement("UPDate Customer"
						+ "	SET DeleteStaus =1 WHERE IdCustomer="+regisNumber+"");
			
		) 
		{
		cs.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void  InsertCustomer1(Customer mem) {
		
		try(
				var con = ConnectDb.getConnection();
				var cs = con.prepareCall("{call InsertCustomer(?,?,?,?,?,?,?,?,?,?,?,?)}");
			) 
			{
			cs.setString(1,mem.getFirstName());
			cs.setString(2,mem.getLastName());
			if(mem.getDob()!=null) {
			cs.setDate(3,Date.valueOf(mem.getDob()));
			}else {
			cs.setDate(3,null);
			}
			cs.setBoolean(4,mem.isGender());
			cs.setString(5,mem.getCCCD());
			cs.setString(6,mem.getNumberphone());
			cs.setString(7,mem.getNumhome());
			cs.setString(8,mem.getName());
			cs.setString(9,mem.getWard());
			cs.setString(10,mem.getCounty());
			cs.setString(11,mem.getCity());
			cs.setString(12,mem.getCountry());
			cs.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			public static Customer selectNumberPhone(String numPhone) {
				var customer = new Customer();
				try (
						var con = ConnectProperties.getConnection();
						
						var stmt=con.createStatement();	
						){
					var rs=stmt.executeQuery("SELECT Customer.FirstName, Customer.LastName, Customer.BirthDay, Customer.CCCD, Customer.Gender, Customer.NumPhone, Customer.DeleteStaus, Address.*, Customer.IdCustomer\r\n"
							+ "FROM     Address INNER JOIN "
							+ "                  Customer ON Address.IdAddress = Customer.IdAddress\r\n"
							+ "WHERE NumPhone=N'"+numPhone+"'");
					while(rs.next()) {
						customer.setIdCustomer(rs.getInt("IdCustomer"));
						
						customer.setFirstName(rs.getString("FirstName"));
						
						customer.setLastName(rs.getString("LastName"));
						
						customer.setName(rs.getString("Name"));
						
						customer.setNumhome(rs.getString("NumHome"));
					
						customer.setWard(rs.getString("Ward"));
						
						customer.setCounty(rs.getString("County"));
						
						customer.setCity(rs.getString("City"));
						
						customer.setCountry(rs.getString("Country"));
						
					
//					if(rs.getDate("BirthDay").getYear()==0)) {
//						customer.setDob((rs.getDate("BirthDay")).toLocalDate());
//					}
						if(rs.getString("BirthDay")!=null ) {
							customer.setDob((rs.getDate("BirthDay")).toLocalDate());
						} 
						customer.setGender(rs.getBoolean("Gender"));
						customer.setCCCD(rs.getString("CCCD"));
						customer.setNumberphone(rs.getString("NumPhone"));
						customer.setIdAddress(rs.getInt("IdAddress"));
				
						
					}
					return customer;
				}catch (Exception e) {
					e.printStackTrace();
					return customer;
				}
			}
			public static void updateCustomer(Customer mem) {
				try(
						var con = ConnectDb.getConnection();
						var cs = con.prepareCall("{call updateCusomer(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					) 
					{
					cs.setString(1,mem.getFirstName());
					cs.setString(2,mem.getLastName());
					if(mem.getDob()!=null) {
					cs.setDate(3,Date.valueOf(mem.getDob()));
					}else {
					cs.setDate(3,null);
					}
					cs.setBoolean(4,mem.isGender());
					cs.setString(5,mem.getCCCD());
					cs.setString(6,mem.getNumberphone());
					cs.setString(7,mem.getNumhome());
					cs.setString(8,mem.getName());
					cs.setString(9,mem.getWard());
					cs.setString(10,mem.getCounty());
					cs.setString(11,mem.getCity());
					cs.setString(12,mem.getCountry());
					cs.setInt(13,mem.getIdAddress());
					cs.setInt(14,mem.getIdCustomer());
					cs.executeUpdate();
					
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
			
			public static boolean erroPhoneCus12(String NumPhone) {
				var boo=false;
				var mem =  new Customer();
				try(
						var con = ConnectDb.getConnection();
						var cs = con.prepareStatement("Select * from Customer where NumPhone=N'"+NumPhone+"'  ");
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
			public static boolean errPhoneUpdate12(String NumPhone,int id) {
				var boo=false;
				var mem =  new Customer();
				try(
						var con = ConnectDb.getConnection();
						var cs = con.prepareStatement("Select * from Customer where NumPhone=N'"+NumPhone+"' and IdCustomer != "+id);
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
	
}


