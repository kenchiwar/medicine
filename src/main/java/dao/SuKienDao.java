package dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import database.ConnectProperties;
import entity.SuKien;

public class SuKienDao {
	public  static  void insertSuKien(SuKien suKien) {
		try (
				var con = ConnectProperties.getConnection();
				var cs = con.prepareCall("{call insertSuKien(?,?,?,?,?,?,?,?,?)}");
				var stmt=con.createStatement();	
				)
			
		{
			cs.setString(1,suKien.getNameEvent());
			cs.setInt(2,suKien.getCategory());
			cs.setFloat(3,suKien.getSale());
			cs.setString(4,suKien.getMedicine());
			cs.setString(5,suKien.getGift());
			cs.setDate(6,java.sql.Date.valueOf(suKien.getStartDate()));
			cs.setDate(7,java.sql.Date.valueOf(suKien.getEndDate()));
			cs.setInt(8,suKien.getQuanity());
			cs.setFloat(9,suKien.getPrice());
			cs.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public static void updateSuKien(SuKien suKien) {
		try (
				var con = ConnectProperties.getConnection();
				var cs = con.prepareCall("{call updateSuKien(?,?,?,?,?,?,?,?,?,?)}");
				var stmt=con.createStatement();	
				)
			
		{
			cs.setString(1,suKien.getNameEvent());
			cs.setInt(2,suKien.getCategory());
			cs.setFloat(3,suKien.getSale());
			cs.setString(4,suKien.getMedicine());
			cs.setString(5,suKien.getGift());
			cs.setDate(6,java.sql.Date.valueOf(suKien.getStartDate()));
			cs.setDate(7,java.sql.Date.valueOf(suKien.getEndDate()));
			cs.setInt(8,suKien.getQuanity());
			cs.setFloat(9,suKien.getPrice());
			cs.setInt(10,suKien.getIdEvent());
			cs.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static List<SuKien> getListSuKien() {
		var  suKien = new ArrayList<SuKien>();
		try (
				var con = ConnectProperties.getConnection();
				
				var stmt=con.createStatement();	
				var stmt2=con.createStatement();
				)
			
		{
		var rs = stmt.executeQuery("Select * from SuKien WHERE IdEvent != 0");
			while(rs.next()) {
				var met = new SuKien();
				met.setIdEvent(rs.getInt("IdEvent"));
				met.setPrice(rs.getInt("Price"));
				met.setCategory(rs.getInt("Category"));
				met.setSale(rs.getInt("Sale"));
				met.setStartDate(rs.getDate("StartDate").toLocalDate());
				met.setEndDate(rs.getDate("EndDate").toLocalDate());
				met.setNameEvent(rs.getString("NameEvent"));
				met.setMedicine(rs.getString("Medicine"));
				met.setQuanity(rs.getInt("Quanity"));
				met.setGift(rs.getString("Gift"));
				var rs2=stmt2.executeQuery("SELECT Sum(DetailBill.Unitprice) as SumBill , Sum(DetailBill.Sale) as SumSale "
						+ " FROM DetailBill "
						+ " WHERE IdEvent="+met.getIdEvent());
				while(rs2.next()) {
					met.setSumBill(rs2.getFloat("SumBill"));
					met.setSumSale(rs2.getFloat("SumSale"));
				}
				suKien.add(met);
			}
			
			return suKien;
		} catch (Exception e) {
			e.printStackTrace();
			return suKien;
		}
	
	}
	public static List<SuKien> searchListSuKien(String code) {
		var  suKien = new ArrayList<SuKien>();
		try (
				var con = ConnectProperties.getConnection();
				
				var stmt=con.createStatement();	
				var stmt2=con.createStatement();
				)
			
		{
		var rs = stmt.executeQuery(code);
			while(rs.next()) {
				var met = new SuKien();
				met.setIdEvent(rs.getInt("IdEvent"));
				met.setPrice(rs.getInt("Price"));
				met.setCategory(rs.getInt("Category"));
				met.setSale(rs.getInt("Sale"));
				met.setStartDate(rs.getDate("StartDate").toLocalDate());
				met.setEndDate(rs.getDate("EndDate").toLocalDate());
				met.setNameEvent(rs.getString("NameEvent"));
				met.setMedicine(rs.getString("Medicine"));
				met.setQuanity(rs.getInt("Quanity"));
				met.setGift(rs.getString("Gift"));
				var rs2=stmt2.executeQuery("SELECT Sum(DetailBill.Unitprice) as SumBill , Sum(DetailBill.Sale) as SumSale "
						+ " FROM DetailBill "
						+ " WHERE IdEvent="+met.getIdEvent());
				while(rs2.next()) {
					met.setSumBill(rs2.getFloat("SumBill"));
					met.setSumSale(rs2.getFloat("SumSale"));
				}
				suKien.add(met);
			}
			
			return suKien;
		} catch (Exception e) {
			e.printStackTrace();
			return suKien;
		}
	
	}
	public static SuKien idSuKien(int id) {
		 var met = new SuKien();
		try (
				var con = ConnectProperties.getConnection();
				
				var stmt=con.createStatement();	
				)
			
		{
		var rs = stmt.executeQuery("Select * from SuKien WHERE IdEvent ="+id);
			while(rs.next()) {
				
				met.setIdEvent(rs.getInt("IdEvent"));
				met.setPrice(rs.getInt("Price"));
				met.setCategory(rs.getInt("Category"));
				met.setSale(rs.getInt("Sale"));
				
				met.setStartDate(rs.getDate("StartDate").toLocalDate());
				
				met.setEndDate(rs.getDate("EndDate").toLocalDate());
				met.setNameEvent(rs.getString("NameEvent"));
				met.setMedicine(rs.getString("Medicine"));
				met.setQuanity(rs.getInt("Quanity"));
				met.setGift(rs.getString("Gift"));
				
			}
			
			return met;
		} catch (Exception e) {
			e.printStackTrace();
			return met;
		}
	}
}
