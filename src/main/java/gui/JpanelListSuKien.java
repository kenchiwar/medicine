package gui;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import dao.SuKienDao;
import entity.SuKien;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class JpanelListSuKien extends JPanel {
	private JPanel panel;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnSearch;
	private JTextField textSearch;
	//code tự tạo
	private List<SuKien> arraySuKien;
	private JpanelSuKien jpanelSuKien;
	CardLayout cl= new CardLayout() ;
	//
	private final ButtonGroup choose = new ButtonGroup();
	private JDateChooser dateChooser;
	private JRadioButton rdbtnMonth;
	private JRadioButton rdbtnYear;
	private JPanel panelEvent;
	private JButton btnBack;
	private JPanel panel_3;
	private JButton btnLoad;
	private JButton btnUpdate;
	private JButton btnSearch_2;

	/**
	 * Create the panel.
	 */
	public JpanelListSuKien() {
		setLayout(cl);
		
		panel = new JPanel();
		add(panel, "name_509860571744600");
		
		panel_2 = new JPanel();
		
		scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 804, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textSearch = new JTextField();
		textSearch.setColumns(10);
		textSearch.setText("");
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("MM/yyyy");
		
		rdbtnMonth = new JRadioButton("Month");
		rdbtnMonth.setSelected(true);
		rdbtnMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnMonth_actionPerformed(e);
			}
		});
		choose.add(rdbtnMonth);
		
		rdbtnYear = new JRadioButton("Year");
		rdbtnYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnMonth_actionPerformed(e);
			}
		});
		choose.add(rdbtnYear);
		
		btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLoad_actionPerformed(e);
			}
		});
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdate_actionPerformed(e);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnSearch_2 = new JButton("Create");
		btnSearch_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_2_actionPerformed(e);
			}
		});
		btnSearch_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(textSearch, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnMonth, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnYear, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearch_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(textSearch, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnYear)
							.addComponent(rdbtnMonth)
							.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(10))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(btnSearch_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		panelEvent = new JPanel();
		add(panelEvent, "name_523104239060200");
		panelEvent.setLayout(new BorderLayout(0, 0));
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBack_actionPerformed(e);
			}
		});
		panelEvent.add(btnBack, BorderLayout.NORTH);
		jpanelSuKien = new JpanelSuKien();
		
		panelEvent.add(jpanelSuKien, BorderLayout.CENTER);
		
		arraySuKien = SuKienDao.getListSuKien();
		listSuKien(arraySuKien);
	}
	public void listSuKien(List<SuKien> arraySuKien2) {
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 100 : return Boolean.class;
				case 0 : return Integer.class;
				case 2 : return Integer.class;
				case 3 : return LocalDate.class;
				case 4: return LocalDate.class;
				case 7 : return Float.class;
				case 8 : return Float.class;
				case 9: return Float.class;
				case 11 : return Integer.class;
				case 12 : return Float.class;
				
				}
				return String.class;
			}
			 public boolean isCellEditable(int row, int column){
				 switch(column) {
					case 100 : return true;
					}
					
			        return false;
			    }
		   
		};
		model.addColumn("Id");
		model.addColumn("Name");
		model.addColumn("Category");
		model.addColumn("Time Start");
		model.addColumn("Time End");
		model.addColumn("Status");
		model.addColumn("Medicine");
		model.addColumn("Unit Price");
		model.addColumn("Sum Sale");
		model.addColumn("Sale");
		
		model.addColumn("Gift");
		
		model.addColumn("Quanity");
		model.addColumn("Price");
		
		arraySuKien2.
		stream()
//		.filter(i->{
//			if(stt> (nowPlace-1)*nowColum &&  stt<=nowPlace*nowColum) {
//				return true;
//			}
//		stt++;
//			return false;
//		})
		.forEach(
			peo -> {
				//stt++;
				var start =Period.between(peo.getStartDate(), java.time.LocalDate.now())
						.isNegative();
				var end =Period.between(peo.getEndDate(), java.time.LocalDate.now())
						.isNegative();
				var chuoi="";
				if(start==true ) chuoi = "Not Active";
				if( end==false) chuoi="Expired";
				if(start==false && end==true) chuoi="Active";
				
				
				model.addRow(new Object[] {
						peo.getIdEvent(),peo.getNameEvent(),
						peo.getCategory(),peo.getStartDate(),peo.getEndDate(),
						chuoi,peo.getMedicine(),peo.getSumBill(),peo.getSumSale()
						,peo.getSale(),peo.getGift(),
						peo.getPrice(),peo.getQuanity()
					
			});
			
			}	
		);
		
		table.setModel(model);
		
		table.getTableHeader().setReorderingAllowed(true);
//		table.getColumnModel().getColumn(1).setMinWidth(100);
		
		table.getColumnModel().getColumn(6).setMinWidth(200);
	}
	protected void do_rdbtnMonth_actionPerformed(ActionEvent e) {
		dateChooser.setDate(null);
		Enumeration<AbstractButton>  met =  choose.getElements();
		while(met.hasMoreElements()) {
			AbstractButton b =met.nextElement();	
			if(b.isSelected()) {	
					switch(b.getText()) {
					case "Month" : {
						
						dateChooser.setDateFormatString("MM/yyyy");
						break;
					}
					case "Year" : {
						
						dateChooser.setDateFormatString("yyyy");
						break;
						
					}
				}	
			}
		}
	}
	
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		if(JOptionPane.showConfirmDialog(null,
				"Choose", "Are you sure want to update Event", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
		{
			var boolen = false;
			var text = "SELECT * FROM SuKien ";
			if(dateChooser.getDate()!=null) {
				if(boolen==false) {
					text +=" WHERE ";
					boolen=true;
				}
				Enumeration<AbstractButton>  met =  choose.getElements();
				while(met.hasMoreElements()) {
					AbstractButton b =met.nextElement();	
					if(b.isSelected()) {	
							switch(b.getText()) {
							
							case "Year" : {
								var chan=new SimpleDateFormat("yyyy").format(dateChooser.getDate());
								text+=" (CONVERT(NVARCHAR,StartDate,103) LIKE N'% "+chan+"%' or "
										+ "CONVERT(NVARCHAR,EndDate,103) LIKE N'% "+chan+ "%' or "
												+ " '"+chan+ "' BETWEEN StartDate and EndDate  )";
								break;
							}
							case "Month" : {
								
								var chan =new SimpleDateFormat("yyyy/MM").format(dateChooser.getDate());
								text+="('"+chan+"/01' BETWEEN StartDate and EndDate)";
								break;
								
							}
						}	
					}
				}
				System.out.println("yyyy");
			}
			if(!textSearch.getText().trim().equals("")) {
				if(boolen==false) {
					text+= " WHERE ";
					boolen=true;
				}else{
					text+= " AND ";
				}
				text+=" (NameEvent like N'%"+textSearch.getText().trim()+"%') ";
				System.out.println("name");
			}
			System.out.println(text);
			arraySuKien=SuKienDao.searchListSuKien(text);
			listSuKien(arraySuKien);
		}
	}
	protected void do_btnLoad_actionPerformed(ActionEvent e) {
		arraySuKien = SuKienDao.getListSuKien();
		listSuKien(arraySuKien);
	}
	
	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		if(JOptionPane.showConfirmDialog(null,
				"Choose", "Are you sure want to Update Event", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
			
			int[] rows = table.getSelectedRows();
		if(rows.length>0) {
			jpanelSuKien.totalUpdate(Integer.valueOf(table.getValueAt(rows[0],0).toString()));
			cl.show(this,"name_523104239060200");
		}
			}
	}
	
	protected void do_btnBack_actionPerformed(ActionEvent e) {
		cl.show(this,"name_509860571744600");
	}
	protected void do_btnSearch_2_actionPerformed(ActionEvent e) {
		jpanelSuKien.totalAdd();
		cl.show(this,"name_523104239060200");
	}
}
