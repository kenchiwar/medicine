package dao;
import java.util.ArrayList;
import java.util.List;

import database.ConnectProperties;
import entity.Bill;
import entity.ThongKeBill;

public class BillDao {
	//Bill bill = new Bill();
	public static Bill insertSelectNewBill(int idStaff,int idCustomer) {
		var bill = new Bill();
		try (
				var con = ConnectProperties.getConnection();
				var cs = con.prepareCall("{call CreateIdBillSelect(?,?)}");
				
				)
		{
			
			
			cs.setInt(1, idStaff);	
			cs.setInt(2, idCustomer);
			var rs = cs.executeQuery();
			while(rs.next()) {
			bill.setIdBill(rs.getString("IdBill"));
			if(rs.getString("DateFounded")==null){
				bill.setDateFounder((rs.getDate("DateFounded")).toLocalDate());
			}
			bill.setDateFounder((rs.getDate("DateFounded")).toLocalDate());
			bill.setIdStaff(rs.getInt("IdStaff"));
			bill.setIdCustomer(rs.getInt("IdCustomer"));
				
			}
		
		return bill;
		} catch (Exception e) {
			e.printStackTrace();
			return bill;
		}
	
		
	}
	
	public static List<ThongKeBill> selectBill() {
		var arrayBill = new ArrayList<ThongKeBill>();
		try (
				var con = ConnectProperties.getConnection();
				
				var stmt=con.createStatement();	
				)
		{
			
			var rs = stmt.executeQuery("SELECT Bill.IdBill, Bill.DateFounded, Bill.IdStaff, Bill.IdCustomer, "
					+ " Bill.Sale, Bill.Total, Staff.FirstName + ' ' + Staff.LastName AS NameStaff, "
					+ " Customer.FirstName + ' ' + Customer.LastName AS NameCustomer "
					+ "FROM     Customer INNER JOIN"
					+ "          Bill ON Customer.IdCustomer = Bill.IdCustomer INNER JOIN"
					+ "          Staff ON Bill.IdStaff = Staff.IdStaff "
					+ "WHERE Sale>0 or Total>0 "
					+ "ORDER BY DateFounded DESC "
					+ "OFFSET 0 ROWS "
					+ "FETCH NEXT 1000 ROWS ONLY "
					);
			while(rs.next()) {
				var bill = new ThongKeBill();
			bill.setIdBill(rs.getString("IdBill"));
			//
			if(rs.getDate("DateFounded")!=null) {
			bill.setDateFounder((rs.getDate("DateFounded")).toLocalDate());
			}
			
			bill.setIdStaff(rs.getInt("IdStaff"));
			bill.setIdCustomer(rs.getInt("IdCustomer"));
			bill.setSale(rs.getFloat("Sale"));
			bill.setTotal(rs.getFloat("Total"));
			bill.setNameStaff(rs.getString("NameStaff"));
			bill.setNameCustomer(rs.getString("NameCustomer"));
			
			arrayBill.add(bill);
			}
		
		return arrayBill;
		} catch (Exception e) {
			e.printStackTrace();
			return arrayBill;
		}
	}
	public static void deleteBill(String idBill) {
		try (
				var con = ConnectProperties.getConnection();
				
				var stmt=con.createStatement();	
				)
		{
			var rs = stmt.executeUpdate("Delete  from Bill where IdBill=N'"+idBill+"'");
		}catch (Exception e) {
		
			}
	}
	public static List<ThongKeBill> searchBill(String code) {
		List<ThongKeBill> arrayBill = new ArrayList<ThongKeBill>();
		try (
				var con = ConnectProperties.getConnection();
				
				var stmt=con.createStatement();	
				)
		{
			
			var rs = stmt.executeQuery("SELECT Bill.IdBill, Bill.DateFounded, Bill.IdStaff, Bill.IdCustomer, "
					+ " Bill.Sale, Bill.Total, Staff.FirstName + ' ' + Staff.LastName AS NameStaff, "
					+ " Customer.FirstName + ' ' + Customer.LastName AS NameCustomer "
					+ "FROM     Customer INNER JOIN"
					+ "          Bill ON Customer.IdCustomer = Bill.IdCustomer INNER JOIN"
					+ "          Staff ON Bill.IdStaff = Staff.IdStaff "
					+ "WHERE Sale>0 or Total>0 and  "+code+" "
					+ "ORDER BY DateFounded DESC "
					+ "OFFSET 0 ROWS "
					+ "FETCH NEXT 1000 ROWS ONLY "
					);
			while(rs.next()) {
				var bill = new ThongKeBill();
			bill.setIdBill(rs.getString("IdBill"));
			//
			if(rs.getDate("DateFounded")!=null) {
			bill.setDateFounder((rs.getDate("DateFounded")).toLocalDate());
			}
			
			bill.setIdStaff(rs.getInt("IdStaff"));
			bill.setIdCustomer(rs.getInt("IdCustomer"));
			bill.setSale(rs.getFloat("Sale"));
			bill.setTotal(rs.getFloat("Total"));
			bill.setNameStaff(rs.getString("NameStaff"));
			bill.setNameCustomer(rs.getString("NameCustomer"));
			
			arrayBill.add(bill);
			}
		
		return arrayBill;
		} catch (Exception e) {
			e.printStackTrace();
			return arrayBill;
		}
	}
	public static void exportBill(Bill bill) {
	
		try (
				var con = ConnectProperties.getConnection();
				var cs = con.prepareCall("{call exportBill(?,?,?,?,?)}");
				var stmt=con.createStatement();	
				)
			
		{
			cs.setString(1,bill.getIdBill());
						
			cs.setFloat(2,bill.getUnitPrice());
			cs.setFloat(3,bill.getSale());
			cs.setInt(4,bill.getIdCustomer());
			cs.setFloat(5,bill.getTotal());
			cs.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static void dropBill(String idBill) {
		try (
				var con = ConnectProperties.getConnection();
				var cs = con.prepareCall("{call exportBill(?)}");
				
				)
			
		{
		
			cs.setString(1,idBill);
			cs.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	public static String monthBillTotal() {
		String message = "";
		try (
				var con = ConnectProperties.getConnection();
				
				var stmt=con.createStatement();	
				var stmt2=con.createStatement();	
				)
		{
			
			var rs=stmt.executeQuery("SELECT SUM(Bill.Total-Bill.Sale) as Bill from Bill WHERE DATEDIFF(month, Bill.DateFounded,GETDATE())<=1");

			while(rs.next()) {
				message=rs.getString("Bill");
				
			}
			return message;		
		}catch (Exception e) {
			e.printStackTrace();
			return message;	
			
		}
	
	}
	public static String dayBillTotal() {
		String message = "";
		try (
				var con = ConnectProperties.getConnection();
				
				var stmt=con.createStatement();	
				var stmt2=con.createStatement();	
				)
		{
			
			var rs=stmt.executeQuery("SELECT SUM(Bill.Total-Bill.Sale) as Bill from Bill WHERE DATEDIFF(day, Bill.DateFounded,GETDATE())<=0");

			while(rs.next()) {
				message=rs.getString("Bill");
				
			}
			return message;		
		}catch (Exception e) {
			e.printStackTrace();
			return message;	
			
		}
	
	}
	public static String searchBillTotal(String search) {
		String message = "";
		try (
				var con = ConnectProperties.getConnection();
				
				var stmt=con.createStatement();	
				var stmt2=con.createStatement();	
				)
		{
			
			var rs=stmt.executeQuery("SELECT SUM(Bill.Total-Bill.Sale) AS Bill from Bill WHERE CONVERT(NVARCHAR,DateFounded,103) LIKE N'%"+search+"%'");

			while(rs.next()) {
				message=rs.getString("Bill");
				
			}
			return message;		
		}catch (Exception e) {
			e.printStackTrace();
			return message;	
			
		}
	
	}
	
	public static Bill printBill(String idBill) {
		var bill=new Bill();
		try(var con = ConnectProperties.getConnection();
				var ps = con.prepareStatement("SELECT Bill.*, Customer.FirstName AS FirstNameCus, Customer.LastName AS LastNameCus, Staff.LastName AS LastNameSta, Staff.FirstName AS FirstNameSta"
						+ " FROM Bill INNER JOIN Customer ON Bill.IdCustomer = Customer.IdCustomer INNER JOIN"
						+ " Staff ON Bill.IdStaff = Staff.IdStaff"
						+ " WHERE IdBill=N'"+idBill+"'");
				var rs = ps.executeQuery();
				){
			while(rs.next()) {
				bill.setIdBill(rs.getString("IdBill"));
				bill.setIdStaff(rs.getInt("IdStaff"));
				bill.setIdCustomer(rs.getInt("IdCustomer"));
				bill.setFirstNameCusl(rs.getString("FirstNameCus"));
				bill.setLastNameCusl(rs.getString("LastNameCus"));
				bill.setFirstName(rs.getString("FirstNameSta"));
				bill.setLastName(rs.getString("LastNameSta"));
				bill.setDateFounder(rs.getDate("DateFounded").toLocalDate());
				bill.setSale(rs.getFloat("Sale"));
				bill.setTotal(rs.getFloat("Total"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bill;
		
		
	}
	public static List<Bill> printBill_1(String idBill) {
		var detailBill1 = new ArrayList<Bill>();
//		var bill = new Bill();
		try(var con = ConnectProperties.getConnection();
			var ps = con.prepareStatement(" SELECT Medicine.NameMedicine, DetailBill.*"
					+ " FROM DetailBill INNER JOIN"
					+ " Medicine ON DetailBill.IdMedicine = Medicine.IdMedicine"
					+ "	WHERE IdBill=N'"+idBill+"'");
				var rs = ps.executeQuery();){
			while(rs.next()) {
				var detailBill=new Bill();
				detailBill.setIdBill(rs.getString("IdBill"));
				detailBill.setIdMedicine(rs.getInt("IdMedicine"));
				detailBill.setIdEvent(rs.getInt("IdEvent"));
				detailBill.setNameMedicine(rs.getString("NameMedicine"));
				detailBill.setAmount(rs.getFloat("Amount"));
				detailBill.setSale(rs.getFloat("Sale"));
				detailBill.setUnitPrice(rs.getFloat("UnitPrice"));
				detailBill.setUnit(rs.getString("Unit"));
				detailBill.setPriceOut(rs.getDouble("PriceOut"));
				detailBill1.add(detailBill);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return detailBill1;
	}
	
}
