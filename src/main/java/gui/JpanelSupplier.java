package gui;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import dao.CustomerDao;
import dao.MedicineDao;
import dao.SupplierDao;
import entity.Customer;
import entity.Medicine;
import entity.Supplier;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;

public class JpanelSupplier extends JPanel {
	private JPanel Supplier;
	private JLabel lblSuppliername;
	private JTextField Suppliername;
	private JTextField NumPhone;
	private JTextField Email;
	private JTextField NumHome;
	private JTextField StreetName;
	private JTextField Ward;
	private JTextField County;
	private JTextField City;
	private JTextField Country;
	private JLabel lblNumphone;
	private JLabel lblEmail;
	private JLabel lblNumhome;
	private JLabel lblStreetName;
	private JLabel lblWard;
	private JLabel lblCounty;
	private JLabel lblCity;
	private JLabel lblCountry;
	private JButton btnAddSupp;
	private JScrollPane scrollPane;
	private JTable table;
	private List<Supplier> arraySup;
	private Supplier supplier;
	private JButton btnLast;
	private JButton btnNext;
	private JSpinner spinner;
	private JSpinner spinnerColum;
	private JLabel lblDDD;
	private Suppmed upMedicine;
	CardLayout cl = new CardLayout();
	
	private int stt=0;
	private int nowPlace=1;
	private int minimum=1;
	private int maximum;
	private int nowColum=20;
	private int total;
	private boolean status=true;
	private JButton btnAdd;
	private JButton btnReset;
	private JLabel lblIdSupplier;
	private JTextField IdSupplier;
	private JButton btnUpdata;
	private JButton Reset;
	private JLabel lblIdAddress;
	private JTextField IdAddress;
	private JButton btnShow;
	private JPanel panel;
	private JPanel SearchMed;
	private JButton btnNewButton;
	private List<Medicine> medicine;
	private JPanel panel_1;

	/**
	 * Create the panel.
	 */
	public JpanelSupplier() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(202, 207, 254));
		setLayout(new CardLayout(0, 0));
		arraySup=SupplierDao.getList();
		
		
		panel = new JPanel();
		panel.setBackground(new Color(202, 207, 254));
		add(panel, "name_336434818050416");
		panel.setLayout(cl);
		
		Supplier = new JPanel();
		Supplier.setBackground(new Color(202, 207, 254));
		panel.add(Supplier, "name_336463268421291");
		
		lblSuppliername = new JLabel("Supplier Name");
		
		Suppliername = new JTextField();
		Suppliername.setColumns(10);
		
		NumPhone = new JTextField();
		NumPhone.setColumns(10);
		
		Email = new JTextField();
		Email.setColumns(10);
		
		NumHome = new JTextField();
		NumHome.setColumns(10);
		
		StreetName = new JTextField();
		StreetName.setColumns(10);
		
		Ward = new JTextField();
		Ward.setColumns(10);
		
		County = new JTextField();
		County.setColumns(10);
		
		City = new JTextField();
		City.setColumns(10);
		
		Country = new JTextField();
		Country.setColumns(10);
		
		lblNumphone = new JLabel("Num phone");
		
		lblEmail = new JLabel("Email");
		
		lblNumhome = new JLabel("Num Home");
		
		lblStreetName = new JLabel("Street Name");
		
		lblWard = new JLabel("Ward");
		
		lblCounty = new JLabel("County");
		
		lblCity = new JLabel("City");
		
		lblCountry = new JLabel("Country");
		
		btnAddSupp = new JButton("Add");
		btnAddSupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddSuppActionPerformed(e);
			}
		});
		
		scrollPane = new JScrollPane();
		
		btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastActionPerformed(e);
			}
		});
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		
		spinner = new JSpinner();
		spinner.setValue(5);
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
		
		lblDDD = new JLabel("1");
		
		lblIdSupplier = new JLabel("Id Supplier");
		
		IdSupplier = new JTextField();
		IdSupplier.setEditable(false);
		IdSupplier.setColumns(10);
		
		btnUpdata = new JButton("Update");
		btnUpdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdataActionPerformed(e);
			}
		});
		
		Reset = new JButton("Reset");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetActionPerformed(e);
			}
		});
		
		lblIdAddress = new JLabel("Id Address");
		
		IdAddress = new JTextField();
		IdAddress.setEditable(false);
		IdAddress.setColumns(10);
		
		btnShow = new JButton("Show Medicine");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowActionPerformed(e);
			}
		});
		GroupLayout gl_Supplier = new GroupLayout(Supplier);
		gl_Supplier.setHorizontalGroup(
			gl_Supplier.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Supplier.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_Supplier.createSequentialGroup()
					.addGap(281)
					.addComponent(btnLast)
					.addGap(68)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(spinnerColum, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(lblDDD)
					.addGap(61)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_Supplier.createSequentialGroup()
					.addGap(97)
					.addGroup(gl_Supplier.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSuppliername, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumphone, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumhome, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStreetName, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_Supplier.createParallelGroup(Alignment.LEADING)
						.addComponent(Suppliername, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(NumHome, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(Email, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(NumPhone, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(StreetName, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
					.addGap(35)
					.addGroup(gl_Supplier.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWard, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCounty, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCountry, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdSupplier, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_Supplier.createParallelGroup(Alignment.LEADING)
						.addComponent(Ward, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(County, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(City, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(Country, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addGroup(gl_Supplier.createSequentialGroup()
							.addComponent(IdSupplier, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
							.addGap(30)
							.addComponent(lblIdAddress, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(IdAddress, 0, 29, Short.MAX_VALUE)))
					.addGap(95))
				.addGroup(gl_Supplier.createSequentialGroup()
					.addGap(228)
					.addComponent(btnAddSupp, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnUpdata, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(Reset, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnShow, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(145))
		);
		gl_Supplier.setVerticalGroup(
			gl_Supplier.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Supplier.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_Supplier.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSuppliername, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(Suppliername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Ward, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWard, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Supplier.createParallelGroup(Alignment.BASELINE)
						.addComponent(NumPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(County, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumphone, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCounty, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Supplier.createParallelGroup(Alignment.BASELINE)
						.addComponent(Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(City, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Supplier.createParallelGroup(Alignment.BASELINE)
						.addComponent(NumHome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Country, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumhome, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCountry, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Supplier.createParallelGroup(Alignment.BASELINE)
						.addComponent(StreetName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStreetName, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdSupplier, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(IdSupplier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(IdAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdAddress, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_Supplier.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddSupp, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdata, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(Reset, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_Supplier.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLast)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerColum, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNext)
						.addComponent(lblDDD, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(38))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		Supplier.setLayout(gl_Supplier);
		
		SearchMed = new JPanel();
		SearchMed.setBackground(new Color(202, 207, 254));
		panel.add(SearchMed, "show");
		SearchMed.setLayout(new BorderLayout(0, 0));
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		SearchMed.add(btnNewButton, BorderLayout.NORTH);
		upMedicine = new Suppmed();
		
		SearchMed.add(upMedicine, BorderLayout.CENTER);
		pagingJtable();
		SelSupp(arraySup);

	}
	protected void btnAddSuppActionPerformed(ActionEvent e) {
	Supplier	mem = new Supplier();
		
		if(Suppliername.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
			
		}else if(Email.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(NumPhone.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
		
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(NumHome.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.red);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if (StreetName.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.red);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if (Ward.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.red);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(County.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.red);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(City.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.red);
			lblCountry.setForeground(Color.black);
		}else if(Country.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.red);
		}else {

		mem.setName1(Suppliername.getText());	
		mem.setNumPhone(NumPhone.getText());
		mem.setGmail(Email.getText());
		mem.setNumhome(NumHome.getText());
		mem.setName(StreetName.getText());
		mem.setWard(Ward.getText());
		mem.setCounty(County.getText());
		mem.setCity(City.getText());
		mem.setCountry(Country.getText());
		SupplierDao CusDao = new SupplierDao();
		// add sql
		if(CusDao.erroNameSup(mem.getName1())==true) {
			JOptionPane.showMessageDialog(null,"Suppliert Name already in use ");
			lblSuppliername.setForeground(Color.red);
		}else if(CusDao.erroNameSupp(mem.getNumPhone())==true) {
			JOptionPane.showMessageDialog(null,"NumPhone already in use ");
			lblNumphone.setForeground(Color.red);
		}else{
		JOptionPane.showMessageDialog(null,"successful");
		CusDao.InsertSupplier(mem);
		Suppliername.setText(null);
		NumPhone.setText(null);
		Email.setText(null);
		StreetName.setText(null);
		NumHome.setText(null);
		Ward.setText(null);
		County.setText(null);
		City.setText(null);
		Country.setText(null);
		
		lblSuppliername.setForeground(Color.black);
		lblNumphone.setForeground(Color.black);
		lblEmail.setForeground(Color.black);
		lblNumhome.setForeground(Color.black);
		lblStreetName.setForeground(Color.black);
		lblWard.setForeground(Color.black);
		lblCounty.setForeground(Color.black);
		lblCity.setForeground(Color.black);
		lblCountry.setForeground(Color.black);
		arraySup=SupplierDao.getList();
		//pagingJtable();
		SelSupp(arraySup);
			}
		}
		}
	
	private void SelSupp(List<Supplier> arraySuppp) {
		stt=1;
		DefaultTableModel model = new DefaultTableModel() {
					public Class<?> getColumnClass(int column){
						switch(column) {
						
						}
						return String.class;
					}
					 public boolean isCellEditable(int row, int column){
					        
					        return false;
					    }
				   
				};
				
				
				model.addColumn("SupplierName");
				model.addColumn("NumPhone");
				model.addColumn("Email");
				model.addColumn("IdAddress");
				model.addColumn("DeleteStatus");
				
				
//				arraySup=SupplierDao.getList();
				
				
				arraySuppp.
				stream().filter(i->{
					if(stt> (nowPlace-1)*nowColum &&  stt<=nowPlace*nowColum) {
						return true;
					}
				stt++;
					return false;
				}).forEach(
					peo ->{stt++; 
					model.addRow(new Object[] {
							peo.getName1(), peo.getNumPhone(),peo.getGmail(),
							peo.getIdAddress(),peo.isDeleteStatus()?"Still":"Stop"
					});
					}
				);
				
				table.setModel(model);
				table.setRowHeight(60);
//				table.getTableHeader().setReorderingAllowed(true);
//				table.getColumnModel().getColumn(1).setMinWidth(100);
//				table.setAutoCreateRowSorter(true);
			}
		
	protected void tableMouseClicked(MouseEvent e) {
		Medicine mem = new Medicine();
		int[] rows = table.getSelectedRows();
		String name= (table.getValueAt(rows[0],0).toString());
		SupplierDao.SearchSup(name);
		
//		CustomerDao IdCus = new CustomerDao();
		//mem = CustomerDao.SearchIfCustomer(1);
		arraySup.stream().filter(i->i.getName1()==name).forEach(i->supplier=i);
		
		Suppliername.setText(supplier.getName1());
		NumPhone.setText(String.valueOf(supplier.getNumPhone()));
		Email.setText(String.valueOf(supplier.getGmail()));
		NumHome.setText(supplier.getNumhome());
		Ward.setText(supplier.getWard());
		StreetName.setText(supplier.getName());
		County.setText(supplier.getCounty());
		City.setText(supplier.getCity());
		Country.setText(supplier.getCountry());
		IdSupplier.setText(String.valueOf(supplier.getIdSupplier()));
		IdAddress.setText(String.valueOf(supplier.getIdAddress()));
		
		lblSuppliername.setForeground(Color.black);
		lblEmail.setForeground(Color.black);
		lblNumphone.setForeground(Color.black);
		lblNumhome.setForeground(Color.black);
		lblStreetName.setForeground(Color.black);
		lblWard.setForeground(Color.black);
		lblCounty.setForeground(Color.black);
		lblCity.setForeground(Color.black);
		lblCountry.setForeground(Color.black);
	}
	public void pagingJtable() {
		total=arraySup.size();
		nowColum=5;
		maximum=( Math.round(total/nowColum))+1;
		spinner.setValue(5);
		minimum=1;
		nowPlace=1;
		spinnerColum.setModel(new SpinnerNumberModel(1, 1, maximum, 1));
		
	}
	protected void btnLastActionPerformed(ActionEvent e) {
		if(nowPlace==1) {
			return;
		}else {
			status=false;
			--nowPlace;
			spinnerColum.setValue(nowPlace);
			SelSupp(arraySup);
		}
	}
	protected void btnNextActionPerformed(ActionEvent e) {
		if(nowPlace==maximum) {
			return;
		}else {
			status=false;
			++nowPlace;
			spinnerColum.setValue(nowPlace);
			SelSupp(arraySup);
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
			SelSupp(arraySup);
	}
	protected void spinnerColumStateChanged(ChangeEvent e) {
		nowPlace=Integer.valueOf(spinnerColum.getValue().toString());		
		SelSupp(arraySup);
	}
	protected void btnUpdataActionPerformed(ActionEvent e) {
		Supplier mem = new Supplier();
		if(Suppliername.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
			
		}else if(Email.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(NumPhone.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
		
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(NumHome.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.red);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if (StreetName.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.red);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if (Ward.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.red);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(County.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.red);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(City.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.red);
			lblCountry.setForeground(Color.black);
		}else if(Country.getText().length()==0) {
			lblSuppliername.setForeground(Color.black);
			lblNumphone.setForeground(Color.black);
			lblEmail.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.red);
		}else {
		mem.setIdSupplier(Integer.parseInt(IdSupplier.getText()));
		mem.setIdAddress(Integer.parseInt(IdAddress.getText()));
		mem.setName1(Suppliername.getText());	
		mem.setNumPhone(NumPhone.getText());
		mem.setGmail(Email.getText());
		mem.setNumhome(NumHome.getText());
		mem.setName(StreetName.getText());
		mem.setWard(Ward.getText());
		mem.setCounty(County.getText());
		mem.setCity(City.getText());
		mem.setCountry(Country.getText());
		SupplierDao CusDao = new SupplierDao();
		// add sql
		int sell = JOptionPane.showConfirmDialog(null,"You realy want updata","notification",JOptionPane.YES_NO_CANCEL_OPTION);
		if(sell == JOptionPane.YES_OPTION) {
		if(CusDao.erroUpdateName(mem.getIdSupplier(),mem.getName1())==true) {
			JOptionPane.showMessageDialog(null,"Suppliert Name already in use ");
			lblSuppliername.setForeground(Color.red);
		}else if(CusDao.erroUpdateName(mem.getIdSupplier(),mem.getNumPhone())==true) {
			JOptionPane.showMessageDialog(null,"NumPhone already in use ");
			lblNumphone.setForeground(Color.red);
		}else{
		JOptionPane.showMessageDialog(null,"successful");
		CusDao.UpdateSupplier(mem);
		Suppliername.setText(null);
		NumPhone.setText(null);
		Email.setText(null);
		StreetName.setText(null);
		NumHome.setText(null);
		Ward.setText(null);
		County.setText(null);
		City.setText(null);
		Country.setText(null);
		IdAddress.setText(null);
		IdSupplier.setText(null);
		
		lblSuppliername.setForeground(Color.black);
		lblNumphone.setForeground(Color.black);
		lblEmail.setForeground(Color.black);
		lblNumhome.setForeground(Color.black);
		lblStreetName.setForeground(Color.black);
		lblWard.setForeground(Color.black);
		lblCounty.setForeground(Color.black);
		lblCity.setForeground(Color.black);
		lblCountry.setForeground(Color.black);
		arraySup=SupplierDao.getList();
		pagingJtable();
		SelSupp(arraySup);
		}
		}}
	}
	protected void ResetActionPerformed(ActionEvent e) {
		Suppliername.setText(null);
		NumPhone.setText(null);
		Email.setText(null);
		StreetName.setText(null);
		NumHome.setText(null);
		Ward.setText(null);
		County.setText(null);
		City.setText(null);
		Country.setText(null);
		IdAddress.setText(null);
		IdSupplier.setText(null);
	}
	protected void btnShowActionPerformed(ActionEvent e) {
		if(IdSupplier.getText().length()== 0) {
			JOptionPane.showMessageDialog(null,"Please choose supplier!!!");
		}else {
		int id =Integer.valueOf(IdSupplier.getText());
		upMedicine.totalSupplier(id);
		cl.show(panel,"show");
		
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		cl.show(panel,"name_336463268421291");
	}
}
