package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import database.ConnectDb;
import database.ConnectProperties;
import entity.Customer;
import entity.Staff;
import java.sql.Date;

public class StaffDao {
	
	public int countStaff() {
		int count=0;
		try (var con = ConnectProperties.getConnection();
			var cs = con.prepareCall("{call countStaff}");
				var rs = cs.executeQuery();){
				while (rs.next()) {
					count = rs.getInt(1);
				};
		}catch (Exception e) {
			e.printStackTrace();
		}return count;
	}
	
	public static CallableStatement createCs(Connection Connect, int pageNumber, int rowOfPage) throws SQLException{
		String sql = "{call selectStaff(?,?)}";
		var cs = Connect.prepareCall(sql);
		cs.setInt(1, pageNumber);
		cs.setInt(2, rowOfPage);
		return cs;
	}
	
	public List<Staff> selStaff(int pageNumber, int rowOfPage){
		List<Staff> list = new ArrayList<Staff>();
		try(var con = ConnectProperties.getConnection();
			var cs = createCs(con, pageNumber, rowOfPage);
			var rs = cs.executeQuery();) {
			
			while(rs.next()) {
				var staff = new Staff();
				staff.setIdStaff(rs.getInt("IdStaff"));
				staff.setUsername(rs.getString("Username"));
				staff.setPassword(rs.getString("Password"));
				staff.setFirstName(rs.getString("FirstName"));
				staff.setLastName(rs.getString("LastName"));
				staff.setRank_1(rs.getInt("Rank"));
				staff.setShift(rs.getString("Shift"));
				staff.setNumHome(rs.getString("NumHome"));
				staff.setNameHome(rs.getString("Name"));
				staff.setWard(rs.getString("Ward"));
				staff.setCounty(rs.getString("County"));
				staff.setCity(rs.getString("City"));
				staff.setCountry(rs.getString("Country"));
				staff.setBirthDay(rs.getDate("BirthDay").toLocalDate());
				staff.setGender(rs.getBoolean("Gender"));
				staff.setNumPhone(rs.getString("NumPhone"));
				staff.setCccd(rs.getString("CCCD"));
				staff.setGmail(rs.getString("Gmail"));
				staff.setDeleteStatus(rs.getBoolean("DeleteStatus"));
				list.add(staff);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}return list;
	}
	
	public List<Staff> selStaff(){
		List<Staff> list = new ArrayList<Staff>();
		try(var con = ConnectProperties.getConnection();
			var cs = con.prepareCall("{call SelectAllStaff}");
			var rs = cs.executeQuery();) {
			
			while(rs.next()) {
				var staff = new Staff();
				staff.setIdStaff(rs.getInt("IdStaff"));
				staff.setUsername(rs.getString("Username"));
				staff.setPassword(rs.getString("Password"));
				staff.setFirstName(rs.getString("FirstName"));
				staff.setLastName(rs.getString("LastName"));
				staff.setRank_1(rs.getInt("Rank"));
				staff.setShift(rs.getString("Shift"));
				staff.setNumHome(rs.getString("NumHome"));
				staff.setNameHome(rs.getString("Name"));
				staff.setWard(rs.getString("Ward"));
				staff.setCounty(rs.getString("County"));
				staff.setCity(rs.getString("City"));
				staff.setCountry(rs.getString("Country"));
				staff.setBirthDay(rs.getDate("BirthDay").toLocalDate());
				staff.setGender(rs.getBoolean("Gender"));
				staff.setNumPhone(rs.getString("NumPhone"));
				staff.setCccd(rs.getString("CCCD"));
				staff.setGmail(rs.getString("Gmail"));
				staff.setDeleteStatus(rs.getBoolean("DeleteStatus"));
				list.add(staff);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}return list;
	}
	
//	public static CallableStatement createCs_1(Connection Connect, int idStaff) throws SQLException{
//		String sql = "{call getStaffById(?)}";
//		var cs = Connect.prepareCall(sql);
//		cs.setInt(1, idStaff);
//		return cs;
//	}
	
	public static Staff getStaffById(int idStaff) {
		
		var staff =  new Staff();
		try(
				var con = ConnectProperties.getConnection();
				var cs = con.prepareStatement("	SELECT IdStaff,Address.IdAddress, Username, [Password], FirstName, LastName,[Rank],[Shift],"
						+ " Address.NumHome, Address.[Name], Address.Ward, Address.County, Address.City, Address.Country ,"
						+ " BirthDay, Gender,NumPhone,CCCD, Gmail, DeleteStatus From Staff INNER JOIN Address ON Staff.IdAddress = Address.IdAddress\r\n"
						+ ""
					
						+ "	where IdStaff = "+idStaff);
				var rs = cs.executeQuery();
			) 
			{
		while(rs.next()) {
			staff.setIdStaff(rs.getInt("IdStaff"));
			staff.setIdAddress(rs.getInt("IdAddress"));
			staff.setUsername(rs.getString("Username"));
			staff.setPassword(rs.getString("Password"));
			staff.setFirstName(rs.getString("FirstName"));
			staff.setLastName(rs.getString("LastName"));
			staff.setRank_1(rs.getInt("Rank"));
			staff.setShift(rs.getString("Shift"));
			staff.setNumHome(rs.getString("NumHome"));
			staff.setNameHome(rs.getString("Name"));
			staff.setWard(rs.getString("Ward"));
			staff.setCounty(rs.getString("County"));
			staff.setCity(rs.getString("City"));
			staff.setCountry(rs.getString("Country"));
			staff.setBirthDay(rs.getDate("BirthDay").toLocalDate());
			staff.setGender(rs.getBoolean("Gender"));
			staff.setNumPhone(rs.getString("NumPhone"));
			staff.setCccd(rs.getString("CCCD"));
			staff.setGmail(rs.getString("Gmail"));
			staff.setDeleteStatus(rs.getBoolean("DeleteStatus"));
		}
		return staff;
			
			} catch (Exception e) {
				e.printStackTrace();
				return staff;
			}
	}
	
	public static void InsertStaff(Staff staff) {
		
		try(
				var con = ConnectProperties.getConnection();
				var cs = con.prepareCall("{call InsertStaff(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			) 
			{
			cs.setString(1,staff.getUsername());
			cs.setString(2, staff.getPassword());
			cs.setString(3, staff.getFirstName());
			cs.setString(4, staff.getLastName());
			cs.setDate(5,Date.valueOf(staff.getBirthDay()));
			cs.setString(6, staff.getShift());
			cs.setBoolean(7, staff.isGender());
			cs.setString(8, staff.getNumPhone());
			cs.setString(9, staff.getCccd());
			cs.setString(10, staff.getGmail());
			cs.setString(11, staff.getNumHome());
			cs.setString(12, staff.getNameHome());
			cs.setString(13, staff.getWard());
			cs.setString(14, staff.getCounty());
			cs.setString(15, staff.getCity());
			cs.setString(16, staff.getCountry());

			cs.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
	public boolean erroPhoneStaff(String NumPhone) {
		var boo=false;
		var sta=  new Staff();
		try(
				var con = ConnectProperties.getConnection();
				var cs = con.prepareStatement("Select * from Staff where NumPhone=N'"+NumPhone+"'  ");
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
	public boolean erroCCCDStaff(String Cccd) {
		var boo=false;
		var sta=  new Staff();
		try(
				var con = ConnectProperties.getConnection();
				var cs = con.prepareStatement("Select * from Staff where CCCD=N'"+Cccd+"'  ");
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
	public boolean erroMailStaff(String Mail) {
		var boo=false;
		var sta=  new Staff();
		try(
				var con = ConnectProperties.getConnection();
				var cs = con.prepareStatement("Select * from Staff where Gmail=N'"+Mail+"'  ");
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
	public boolean erroUserStaff(String User) {
		var boo=false;
		var sta=  new Staff();
		try(
				var con = ConnectProperties.getConnection();
				var cs = con.prepareStatement("Select * from Staff where Username=N'"+User+"'  ");
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
	
	public static void updateStaff(Staff staff) {
		try(var con = ConnectProperties.getConnection();
				var cs = con.prepareCall("{call UpdateStaff(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");) {
			cs.setString(1,staff.getUsername());
			cs.setString(2, staff.getPassword());
			cs.setString(3, staff.getFirstName());
			cs.setString(4, staff.getLastName());
			cs.setDate(5,Date.valueOf(staff.getBirthDay()));
			cs.setString(6, staff.getShift());
			cs.setBoolean(7, staff.isGender());
			cs.setString(8, staff.getNumPhone());
			cs.setString(9, staff.getCccd());
			cs.setString(10, staff.getGmail());
			cs.setString(11, staff.getNumHome());
			cs.setString(12, staff.getNameHome());
			cs.setString(13, staff.getWard());
			cs.setString(14, staff.getCounty());
			cs.setString(15, staff.getCity());
			cs.setString(16, staff.getCountry());
			cs.setInt(17, staff.getIdAddress());
			cs.setInt(18,staff.getIdStaff());
			
			cs.executeUpdate();
			
		}catch (Exception e) {e.printStackTrace();}
	}
	public static void statusDelete(int idStaff) {
		try(
				var con = ConnectProperties.getConnection();
					var cs = con.prepareStatement(""
							+"UPDate Staff"
							+ "	SET DeleteStatus = 1 WHERE IdStaff="+idStaff+"");
			) 
			{
			cs.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static Staff errDel(int idStaff) {
		var sta = new Staff();
		try(var con = ConnectProperties.getConnection();
				var cs = con.prepareStatement("SELECT [Rank] FROM Staff WHERE IdStaff="+idStaff+"");
				var rs = cs.executeQuery();){
			
			while (rs.next()) {
				sta.setRank_1(rs.getInt("Rank"));
			}
			}catch (Exception e) 
		{e.printStackTrace();
		}return sta;
	}
	
	public static List<Staff> searchStaff(String numPhone, String Firstname, String Lastname) {
		List<Staff> list = new ArrayList<Staff>();
		try(
				var con = ConnectProperties.getConnection();
				var cs = con.prepareStatement("	SELECT IdStaff,Address.IdAddress, Username, [Password], FirstName, LastName,[Rank],[Shift],"
						+ " Address.NumHome, Address.[Name], Address.Ward, Address. County, Address.City, Address.Country ,"
						+ " BirthDay, Gender,NumPhone,CCCD, Gmail, DeleteStatus From Staff INNER JOIN Address ON Staff.IdAddress = Address.IdAddress\r\n"
						+ ""
					
						+ "	where NumPhone like N'%"+numPhone+"%' or FirstName like N'%" +Firstname + "%' or LastName like N'%"+ Lastname+"%'");
						
				var rs = cs.executeQuery();
			) 
			{
		while(rs.next()) {
			var staff = new Staff();
			staff.setIdStaff(rs.getInt("IdStaff"));
			staff.setIdAddress(rs.getInt("IdAddress"));
			staff.setUsername(rs.getString("Username"));
			staff.setPassword(rs.getString("Password"));
			staff.setFirstName(rs.getString("FirstName"));
			staff.setLastName(rs.getString("LastName"));
			staff.setRank_1(rs.getInt("Rank"));
			staff.setShift(rs.getString("Shift"));
			staff.setNumHome(rs.getString("NumHome"));
			staff.setNameHome(rs.getString("Name"));
			staff.setWard(rs.getString("Ward"));
			staff.setCounty(rs.getString("County"));
			staff.setCity(rs.getString("City"));
			staff.setCountry(rs.getString("Country"));
			staff.setBirthDay(rs.getDate("BirthDay").toLocalDate());
			staff.setGender(rs.getBoolean("Gender"));
			staff.setNumPhone(rs.getString("NumPhone"));
			staff.setCccd(rs.getString("CCCD"));
			staff.setGmail(rs.getString("Gmail"));
			staff.setDeleteStatus(rs.getBoolean("DeleteStatus"));
			list.add(staff);
		}
		
			
			} catch (Exception e) {
				e.printStackTrace();
			}return list;
	}
	
}
