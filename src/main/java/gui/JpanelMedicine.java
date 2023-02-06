package gui;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.CustomerDao;
import dao.MedicineDao;
import entity.Customer;
import entity.Medicine;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;

import java.awt.Component;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class JpanelMedicine extends JPanel {
	private JPanel Medicine;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblMedicineCode;
	private JTextField MedicineCode;
	private JTextField PriceEnter;
	private JTextField NumImport;
	private JLabel lblDateManufacture;
	private JLabel lblDateOut;
	private JLabel lblPriceEnter;
	private JLabel lblNumImport;
	private JLabel lblDateImport;
	private JDateChooser DateManufacture;
	private JDateChooser DateOut;
	private JDateChooser DateImport;
	private JButton btnAddMedicine;
	private List<Medicine> arrayMed;
	private JButton btnLoad;
	private Medicine medicine;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JLabel lblPriceout;
	private JTextField PriceOut;
	private JTextField PriceRetailOut;
	private JLabel lblPriceRetailOut;
	private JButton btnStopImport;
	private JButton btnImport;
	private UpdateMedicine upMedicine;
	
	//
	private String num;
	//
	private int stt=0;
	private int nowPlace=1;
	private int minimum=1;
	private int maximum;
	private int nowColum=20;
	private int total;
	private boolean status=true;
	private JSpinner spinner;
	private JSpinner spinnerColum;
	private JButton btnLast;
	private JButton btnNext;
	private JLabel lblDDD;
	private JButton btnUpdate;
	private JPanel panel;
	private JButton btnback;
	private JButton btnUpdate_1;
	CardLayout cl = new CardLayout();
	private JPanel panel_1;
	private JButton btnMoreMedicie;
	//
	private JpanelinsMedicine InlMed;
	private JPanel hay;
	private JButton btnReturn;
	private JTextField Search;
	private JButton btnSearch;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblOut;
	private JLabel lblExpired;
	private JPanel OutMed;
	private JButton btnBack;
	private JPanel PannelOut;
	/**
	 * 
	 * Create the panel.
	 */
	public JpanelMedicine() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new CardLayout(0, 0));
		panel_1=new JPanel();
		panel_1.setBackground(new Color(202, 207, 254));
		add(panel_1,"hay");
		panel_1.setLayout(cl);
		Medicine = new JPanel();
		Medicine.setBackground(new Color(202, 207, 254));
		panel_1.add(Medicine, "name_214223015674958");
		hay=new JPanel();
		panel_1.add(hay,"bbbb");	
		hay.setLayout(new BorderLayout(0, 0));
		
		btnReturn = new JButton("Back");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReturnActionPerformed(e);
			}
		});
		hay.add(btnReturn, BorderLayout.NORTH);
		
		InlMed = new JpanelinsMedicine();
		hay.add(InlMed, BorderLayout.CENTER);
			
		scrollPane = new JScrollPane();
		
		lblMedicineCode = new JLabel("Medicine Code");
		
		MedicineCode = new JTextField();
		MedicineCode.setEditable(false);
		MedicineCode.setColumns(10);
		
		PriceEnter = new JTextField();
		PriceEnter.setColumns(10);
		
		NumImport = new JTextField();
		NumImport.setColumns(10);
		
		lblDateManufacture = new JLabel("Date Manufacture");
		
		lblDateOut = new JLabel("Date Out ");
		
		lblPriceEnter = new JLabel("Price Enter");
		
		lblNumImport = new JLabel("Num Import");
		
		lblDateImport = new JLabel("Date Import");
		
		DateManufacture = new JDateChooser();
		DateManufacture.setDateFormatString("yyyy/MM/dd");
		
		DateOut = new JDateChooser();
		DateOut.setDateFormatString("yyyy/MM/dd");
		
		DateImport = new JDateChooser();
		DateImport.setDateFormatString("yyyy/MM/dd");
		
		btnAddMedicine = new JButton("Add");
		btnAddMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddMedicineActionPerformed(e);
			}
		});
		
		btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadActionPerformed(e);
			}
		});
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		lblPriceout = new JLabel("Price Out");
		
		PriceOut = new JTextField();
		PriceOut.setColumns(10);
		
		PriceRetailOut = new JTextField();
		PriceRetailOut.setColumns(10);
		
		lblPriceRetailOut = new JLabel("Price Retail Out");
		
		btnStopImport = new JButton("Stop import");
		btnStopImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStopImportActionPerformed(e);
			}
		});
		
		btnImport = new JButton("\nimport goods");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnImportActionPerformed(e);
			}
		});
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinnerStateChanged(e);
			}
		});
		
		spinnerColum = new JSpinner();
		spinnerColum.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinnerColumStateChanged(e);
			}
		});
		
		btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		
		lblDDD = new JLabel("1");
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		
		btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate_1ActionPerformed(e);
			}
		});
		
		btnMoreMedicie = new JButton("More Medicine");
		btnMoreMedicie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMoreMedicieActionPerformed(e);
			}
		});
		
		Search = new JTextField();
		Search.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		
		lblNewLabel = new JLabel("Medicine");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2MouseClicked(e);
			}
		});
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.YELLOW);
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_3MouseClicked(e);
			}
		});
		
		GroupLayout gl_Medicine = new GroupLayout(Medicine);
		gl_Medicine.setHorizontalGroup(
			gl_Medicine.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Medicine.createSequentialGroup()
					.addGap(12)
					.addComponent(btnMoreMedicie, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(btnUpdate_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(btnLast)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(spinnerColum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(lblDDD, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Search, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnSearch)
					.addGap(20))
				.addGroup(gl_Medicine.createSequentialGroup()
					.addGroup(gl_Medicine.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
						.addGroup(gl_Medicine.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_Medicine.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMedicineCode, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPriceEnter, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDateManufacture)
								.addComponent(lblDateOut, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumImport, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPriceout, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPriceRetailOut, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDateImport, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(gl_Medicine.createParallelGroup(Alignment.LEADING)
								.addComponent(PriceRetailOut, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
								.addComponent(PriceOut, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
								.addComponent(DateManufacture, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
								.addComponent(MedicineCode, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Medicine.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(NumImport, Alignment.LEADING)
									.addComponent(PriceEnter, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Medicine.createParallelGroup(Alignment.TRAILING)
									.addComponent(DateImport, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
									.addComponent(DateOut, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_Medicine.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Medicine.createSequentialGroup()
									.addGap(18)
									.addComponent(btnAddMedicine, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnStopImport, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_Medicine.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)))))
					.addGap(4))
				.addGroup(gl_Medicine.createSequentialGroup()
					.addGap(127)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(270, Short.MAX_VALUE))
		);
		gl_Medicine.setVerticalGroup(
			gl_Medicine.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Medicine.createSequentialGroup()
					.addGroup(gl_Medicine.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_Medicine.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 73, Short.MAX_VALUE)
							.addGap(12))
						.addGroup(gl_Medicine.createSequentialGroup()
							.addGap(52)
							.addGroup(gl_Medicine.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_Medicine.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_Medicine.createSequentialGroup()
							.addComponent(scrollPane_1, 0, 0, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Medicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAddMedicine)
								.addComponent(btnStopImport)
								.addComponent(btnImport)
								.addComponent(btnLoad)
								.addComponent(btnUpdate)))
						.addGroup(gl_Medicine.createSequentialGroup()
							.addGroup(gl_Medicine.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Medicine.createSequentialGroup()
									.addGap(4)
									.addComponent(lblMedicineCode))
								.addComponent(MedicineCode, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_Medicine.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDateManufacture)
								.addComponent(DateManufacture, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(17)
							.addGroup(gl_Medicine.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDateOut)
								.addComponent(DateOut, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_Medicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPriceEnter)
								.addComponent(PriceEnter, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Medicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(NumImport, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumImport))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Medicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(PriceOut, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPriceout))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Medicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(PriceRetailOut, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPriceRetailOut))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Medicine.createParallelGroup(Alignment.TRAILING)
								.addComponent(DateImport, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDateImport))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Medicine.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMoreMedicie)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerColum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLast)
						.addComponent(lblDDD)
						.addComponent(btnNext)
						.addComponent(btnUpdate_1)
						.addComponent(Search, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch))
					.addGap(17))
		);
		
		lblExpired = new JLabel("Expired");
		lblExpired.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(lblExpired);
		
		lblOut = new JLabel("Out");
		lblOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(lblOut);
		
		table_1 = new JTable();
		table_1.setAutoCreateRowSorter(true);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_1.setViewportView(table_1);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		arrayMed=MedicineDao.getList();
		pagingJtable();
		SelMed(arrayMed);
		scrollPane.setViewportView(table);
		Medicine.setLayout(gl_Medicine);
		
		panel = new JPanel();
		panel_1.add(panel, "aaaa");
		panel.setLayout(new BorderLayout(0, 0));
		
		btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReturnActionPerformed(e);
			}
		});
		panel.add(btnback, BorderLayout.NORTH);
		upMedicine=new UpdateMedicine();
		panel.add(upMedicine,BorderLayout.CENTER);
		
		lblOut.setText("Nearly sold out(0)");
		lblExpired.setText("Almost expired(0)");
		OutMed = new JPanel();
		panel_1.add(OutMed, "showOut");
		OutMed.setLayout(new BorderLayout(0, 0));
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackActionPerformed(e);
			}
		});
		OutMed.add(btnBack, BorderLayout.NORTH);
		
		PannelOut = new JpanelEndMedicine();
		OutMed.add(PannelOut, BorderLayout.SOUTH);
		
		showNum();
	}
private void SelMed(List<Medicine> arrayMedd) {
		stt=1;
		DefaultTableModel model = new DefaultTableModel() {
					public Class<?> getColumnClass(int column){
						switch(column) {
						case 9 : return Integer.class;
						}
						return String.class;
					}
					 public boolean isCellEditable(int row, int column){
					        
					        return false;
					    }
				   
				};
				
				model.addColumn("RegisNumber");
				model.addColumn("NameMedicine");
				model.addColumn("Class");
				model.addColumn("GroupMedicine");
				model.addColumn("Active");
				model.addColumn("Content");
				model.addColumn("CoverForm");
				model.addColumn("Packing");
				model.addColumn("Standard");
				model.addColumn("AmountNow");
				model.addColumn("NameSupplier");
				model.addColumn("StatusImport");
				
				
				
				//arrayMed=MedicineDao.getList();
				arrayMedd
				.stream().filter(i->{
					if(stt> (nowPlace-1)*nowColum &&  stt<=nowPlace*nowColum) {
						return true;
					}
				stt++;
					return false;
				})
				.forEach(
					peo -> {
						stt++;
						model.addRow(new Object[] {
							peo.getRegisNumber(), peo.getNameMedicine(), peo.getClass1(),peo.getGroupMedicine(),
							peo.getActive(),peo.getContent(),peo.getCoverForm(),peo.getPacking(),peo.getStandard(),peo.getAmountNow(),peo.getName(),peo.isStatusImport()?"Still Import":"Stop Import"
					});
					
					}	
				);
				
				table.setModel(model);
				table.setRowHeight(60);
//				table.getTableHeader().setReorderingAllowed(true);
//				table.getColumnModel().getColumn(1).setMinWidth(100);
//				table.setAutoCreateRowSorter(true);
			}
	protected void btnLoadActionPerformed(ActionEvent e) {
		arrayMed = MedicineDao.getList();
		pagingJtable();
		SelMed(arrayMed);
	}
	protected void tableMouseClicked(MouseEvent e) {
		Medicine mem = new Medicine();
		int[] rows = table.getSelectedRows();
		
		String id= (table.getValueAt(rows[0],0).toString());
		String name= (table.getValueAt(rows[0],1).toString());
		MedicineDao.SearchMed(id);
		
//		CustomerDao IdCus = new CustomerDao();
		//mem = CustomerDao.SearchIfCustomer(1);
		arrayMed.stream().filter(i->i.getRegisNumber()==id).forEach(i->medicine=i);;
		MedicineCode.setText(name);
				DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0 : return Integer.class;
				case 4 : return Integer.class;
				case 5 : return Integer.class;
				case 6 : return Integer.class;
				case 8 : return Integer.class;
				case 9 : return Integer.class;
				case 10 : return Integer.class;
				}
				return String.class;
			}
			 public boolean isCellEditable(int row, int column){
			        
			        return false;
			    }
		   
		};
		model.addColumn("IdMedicine");
		model.addColumn("DateManufacture");
		model.addColumn("DateOut");
		model.addColumn("Unit");
		model.addColumn("PriceEnter");
		model.addColumn("UnitPrice");
		model.addColumn("NumImport");
		model.addColumn("DateImport");
		model.addColumn("PriceOut");
		model.addColumn("PriceRetailOut");
		model.addColumn("AmountNow");
		model.addColumn("DeleteStatus");
		
		
		
		arrayMed=MedicineDao.SearchMed(id);
		arrayMed.stream().forEach(
			peo -> {model.addRow(new Object[] {
					peo.getIdMedicine(),peo.getDateManufacture().toString(), peo.getDateOut().toString(), peo.getUnit(),peo.getPriceEnter(),
					peo.getUnitPrice(),peo.getNumImport(),peo.getDateImport().toString(),peo.getPriceOut(),peo.getPriceRetailOut(),peo.getAmountNow(),(peo.isDeleteStatus()?"Still Import":"Stop Import")
			});
			peo.getDateManufacture();
			}	
		);
		
		table_1.setModel(model);
		String name2= (table_1.getValueAt(0,4).toString());
		String name3= (table_1.getValueAt(0,8).toString());
		String name4= (table_1.getValueAt(0,9).toString());
		
		PriceEnter.setText(name2);
		PriceOut.setText(name3);
		PriceRetailOut.setText(name4);

		table_1.setRowHeight(60);
		table_1.getColumnModel().getColumn(0).setMinWidth(100);
		table_1.getColumnModel().getColumn(1).setMinWidth(100);
		table_1.getColumnModel().getColumn(2).setMinWidth(50);
		table_1.getColumnModel().getColumn(3).setMinWidth(50);
		table_1.getColumnModel().getColumn(4).setMinWidth(50);
		table_1.getColumnModel().getColumn(5).setMinWidth(50);
		table_1.getColumnModel().getColumn(7).setMinWidth(50);
		table_1.getColumnModel().getColumn(8).setMinWidth(50);
		table_1.getColumnModel().getColumn(9).setMinWidth(50);
		table_1.getColumnModel().getColumn(6).setMinWidth(100);
		DateManufacture.setDate(null);
		DateOut.setDate(null);
		NumImport.setText(null);
		DateImport.setDate(null);
		
	}
	protected void btnAddMedicineActionPerformed(ActionEvent e) {
		Medicine mem = new Medicine();
		int[] rows = table.getSelectedRows();
		
		String id= (table.getValueAt(rows[0],0).toString());
		mem=MedicineDao.EnterMed(id);
		mem.setDateManufacture(
				LocalDate.ofInstant(DateManufacture.getDate().toInstant(),ZoneId.systemDefault()) 
				);
		mem.setDateOut(
				LocalDate.ofInstant(DateOut.getDate().toInstant(),ZoneId.systemDefault()) 
				);
		mem.setPriceEnter(Double.parseDouble(PriceEnter.getText()));
		mem.setNumImport(Integer.parseInt(NumImport.getText()));
		mem.setPriceOut(Double.parseDouble(PriceOut.getText()));
		mem.setPriceRetailOut(Double.parseDouble(PriceRetailOut.getText()));
		mem.setUnitPrice(Double.parseDouble(PriceEnter.getText())*Integer.parseInt(NumImport.getText()));
		mem.setDateImport(
				LocalDate.ofInstant(DateImport.getDate().toInstant(),ZoneId.systemDefault()) 
				);
		MedicineDao medDAO = new MedicineDao();
		medDAO.InsertCustomer(mem);
		JOptionPane.showMessageDialog(null,"successful");
		arrayMed = MedicineDao.getList();
		pagingJtable();
		SelMed(arrayMed);
	}
	
	protected void btnStopImportActionPerformed(ActionEvent e) {
		int sell = JOptionPane.showConfirmDialog(null,"You realy want StopImport","notification",JOptionPane.YES_NO_CANCEL_OPTION);
		if(sell == JOptionPane.YES_OPTION) {
		int[] rows = table.getSelectedRows();
		String RegisNum= (table.getValueAt(rows[0],0).toString());
		MedicineDao.StopImport(RegisNum);
		JOptionPane.showMessageDialog(null, "Successful");
		}
		arrayMed = MedicineDao.getList();
		pagingJtable();
		SelMed(arrayMed);
	}
	protected void btnImportActionPerformed(ActionEvent e) {
		int sell = JOptionPane.showConfirmDialog(null,"You realy want All Import","notification",JOptionPane.YES_NO_CANCEL_OPTION);
		if(sell == JOptionPane.YES_OPTION) {
		int[] rows = table.getSelectedRows();
		String RegisNum= (table.getValueAt(rows[0],0).toString());
		MedicineDao.Import(RegisNum);
		JOptionPane.showMessageDialog(null, "Successful");
		
		
		}
		arrayMed = MedicineDao.getList();
		pagingJtable();
		SelMed(arrayMed);
	}
	
	public void pagingJtable() {
		total=arrayMed.size();
		nowColum=5;
		maximum=( Math.round(total/nowColum))+1;
		spinner.setValue(5);
		minimum=1;
		nowPlace=1;
		spinnerColum.setModel(new SpinnerNumberModel(1, 1, maximum, 1));
		
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		if(nowPlace==1) {
			return;
		}else {
			status=false;
			--nowPlace;
			spinnerColum.setValue(nowPlace);
			SelMed(arrayMed);
		}
	}
	protected void btnNextActionPerformed(ActionEvent e) {
		if(nowPlace==maximum) {
			return;
		}else {
			status=false;
			++nowPlace;
			spinnerColum.setValue(nowPlace);
			SelMed(arrayMed);
		}
	}
	protected void spinnerStateChanged(ChangeEvent e) {
		nowColum=Integer.valueOf(spinner.getValue().toString());	
		maximum=( Math.round(total/nowColum))+1;

		minimum=1;
		status=false;	
		spinnerColum.setModel(new SpinnerNumberModel(1, 1, maximum, 1));
		nowPlace=1;
			lblDDD.setText("/"+maximum);	
			SelMed(arrayMed);
	}
	protected void spinnerColumStateChanged(ChangeEvent e) {
		nowPlace=Integer.valueOf(spinnerColum.getValue().toString());		
		SelMed(arrayMed);
	}
	protected void btnUpdate_1ActionPerformed(ActionEvent e) {
		//var card=(CardLayout)this.getLayout();
		int[] rows = table.getSelectedRows();
		if(rows.length!=0) {
		String id= (table.getValueAt(rows[0],0).toString());
		upMedicine.setMedicine(MedicineDao.get(id));
		upMedicine.SelMedicine();
		
		cl.show(panel_1,"aaaa");
		}
		
		
		
		
		
	}
	protected void btnReturnActionPerformed(ActionEvent e) {
		
		cl.show(panel_1,"name_214223015674958");
	}
	protected void btnMoreMedicieActionPerformed(ActionEvent e) {
		cl.show(panel_1,"bbbb");
		InlMed.restart();
		
	}
	protected void btnUpdateActionPerformed(ActionEvent e) {
		int sell = JOptionPane.showConfirmDialog(null,"You realy want updata","notification",JOptionPane.YES_NO_CANCEL_OPTION);
		if(sell == JOptionPane.YES_OPTION) {
		int[] rows = table_1.getSelectedRows();
		if(rows.length!=0) {
			var id= Integer.valueOf(table_1.getValueAt(rows[0],0).toString());
			medicine.setDateManufacture(
					LocalDate.ofInstant(DateManufacture.getDate().toInstant(),ZoneId.systemDefault()) 
			);
			medicine.setDateOut(
					LocalDate.ofInstant(DateOut.getDate().toInstant(),ZoneId.systemDefault()) 
			);
			medicine.setIdMedicine(id);
			medicine.setPriceEnter(Double.valueOf(PriceEnter.getText()));
			medicine.setNumImport(Integer.valueOf(NumImport.getText()));
			medicine.setPriceOut(Double.valueOf(PriceOut.getText()));
			medicine.setPriceRetailOut(Double.valueOf(PriceRetailOut.getText()));
			medicine.setDateImport(
					LocalDate.ofInstant(DateImport.getDate().toInstant(),ZoneId.systemDefault()) 
			);
			MedicineDao.UpdateMedicineDetail(medicine);
		}
		}
	}
	protected void btnSearchActionPerformed(ActionEvent e) {
		
		arrayMed = MedicineDao.Searchh(Search.getText());
		pagingJtable();
		SelMed(arrayMed);
	}
	protected void panel_3MouseClicked(MouseEvent e) {
		lblExpired.setText("Almost expired("+MedicineDao.getListOutDate()+")");

		cl.show(panel_1,"showOut");
	}
	protected void panel_2MouseClicked(MouseEvent e) {
		arrayMed = MedicineDao.getListOut();
		pagingJtable();
		lblOut.setText("Nearly sold out("+MedicineDao.getListOutNum()+")");
		SelMed(arrayMed);
		
	}
	
	protected void btnBackActionPerformed(ActionEvent e) {
		cl.show(panel_1,"name_214223015674958");
	}
	private void showNum() {
		lblOut.setText("Nearly sold out("+MedicineDao.getListOutNum()+")");
		lblExpired.setText("Almost expired("+MedicineDao.getListOutDate()+")");
	}
}
