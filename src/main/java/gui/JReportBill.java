package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.BillDao;
import dao.StaffDao;
import database.ConnectProperties;
import entity.Bill;
import entity.DetaiBill;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;


public class JReportBill extends JFrame {
	private Bill bill;
	private Bill bill_1;
	private DetaiBill detailBill;
	private JPanel contentPane;
	
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	
	

	public DetaiBill getDetailBill() {
		return detailBill;
	}

	public void setDetailBill(DetaiBill detailBill) {
		this.detailBill = detailBill;
	}
	
	public Bill getBill_1() {
		return bill_1;
	}

	public void setBill_1(Bill bill_1) {
		this.bill_1 = bill_1;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JReportBill frame = new JReportBill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JReportBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
	
	public void showBill() {
		try {
			List<Map<String,?>> list = new ArrayList<Map<String,?>>();
			Map<String, Object> map = new HashMap<String, Object>();

			JasperReport rp = JasperCompileManager.compileReport("Report/reportBill.jrxml");

			map.put("IdBill", bill.getIdBill());
			map.put("DateFounded", bill.getDateFounder());
			map.put("NameStaff", bill.getFirstName()+" "+bill.getLastName());
			map.put("total", bill.getTotal());
			List<Bill> nnn ;
			nnn=BillDao.printBill_1(bill.getIdBill());
			nnn.forEach(i->{
				map.put("nameMedicine", i.getNameMedicine());
				map.put("amountMedicine", i.getAmount());
				map.put("sale", i.getSale());
				map.put("price", i.getUnitPrice());
				list.add(map);
			});
			
			
			JRDataSource dataSource = new JRBeanCollectionDataSource(list);
			String file = "Report/reportBill.jrxml";
			JasperPrint print = JasperFillManager.fillReport(rp,null,dataSource);
			this.getContentPane().add(new JRViewer(print), BorderLayout.CENTER);
			this.pack();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
