package dao;

import java.util.ArrayList;

import database.ConnectProperties;
import entity.Bill;
import entity.DetaiBill;
import entity.Medicine;

public class DetailBillDao {
	//tạo detail bill dựa vào idbill với medicine
	public static void createDetailBill(Bill bill,DetaiBill medicine) {
		try (
				var con = ConnectProperties.getConnection();
				var cs = con.prepareCall("{call "
						+ "CreateDetailBill(?,?,?,?,?,?,?,?)}");
				
				)
		{
			//@idBill NVARCHAR(50),@regisNumber NVARCHAR(50) 
			//,@idCustomer int ,@amount float,@unit NVARCHAR(50),@priceOut FLOAT
			//,@priceRetailOut FLOAT,@idMedicine INT 
			
			
			cs.setString(1,bill.getIdBill());
			cs.setString(2,medicine.getRegisNumber());
			cs.setInt(3,bill.getIdCustomer());
			cs.setFloat(4,medicine.getAmount());
			cs.setString(5,medicine.getUnit());
			cs.setDouble(6,medicine.getPriceOut());
			cs.setDouble(7,medicine.getPriceRetailOut());
			cs.setInt(8,medicine.getIdMedicine());
			cs.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void exportDetailBill(DetaiBill medicine ) {
		
		try (
				var con = ConnectProperties.getConnection();
				var cs = con.prepareCall("{call "
						+ "exportDetailBill(?,?)}");
				
				){
			cs.setString(1,medicine.getRegisNumber());
			cs.setFloat(2,medicine.getAmount());
			cs.executeUpdate();
			
		}catch (Exception e) {
					e.printStackTrace();
				}
		
	}
	// trả về mảng detail dựa theo idBill
	public static ArrayList<DetaiBill> selectDetailBill(String idBill) {
		var arrayBill = new ArrayList<DetaiBill>();
		try (
				var con = ConnectProperties.getConnection();
				
				
				var stmt=con.createStatement();	
				){
			 var rs=stmt.executeQuery("SELECT DetailBill.*, Medicine.NameMedicine FROM DetailBill INNER JOIN Medicine ON DetailBill.IdMedicine = Medicine.IdMedicine where IdBill=N'"+idBill+"'");
			 while(rs.next()) {
				 var detailBill = new DetaiBill();
				 detailBill.setIdBill(rs.getString("IdBill"));
				 detailBill.setNameMedicine(rs.getString("NameMedicine"));
				 detailBill.setIdMedicine(rs.getInt("IdMedicine"));
				 detailBill.setUnitPrice(rs.getFloat("UnitPrice"));
				 detailBill.setUnit(rs.getString("Unit"));
				 detailBill.setSale(rs.getFloat("Sale"));
				 detailBill.setAmount(rs.getFloat("Amount"));
				 detailBill.setPriceOut(rs.getFloat("PriceOut"));
				 detailBill.setIdEvent(rs.getInt("IdEvent"));
				 arrayBill.add(detailBill);
			 }
			return arrayBill;
		}catch(Exception e) {
			e.printStackTrace();
			return arrayBill;
		}
		
	}
}
