package gui;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.CustomerDao;
import dao.MedicineDao;
import entity.Customer;
import entity.Medicine;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.LineBorder;

public class TTCustomer extends JPanel {
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblIdCus;
	private JTextField IdCus1;
	private JLabel lblBirthDay;
	private JTextField NumPhone;
	private JLabel lblNumPhone;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblGender;
	private JLabel lblCCCD;
	private JLabel lblIdAddress;
	private JTextField IdAddress;
	private JTextField LastName;
	private JTextField FirstName;
	private JRadioButton rdbtnMade;
	private JRadioButton rdbtnFemade;
	//code tu tay them zo
	private Customer customer;
	private List<Customer> arrayCustomer;
	
	//
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JDateChooser Birthday1;
	private JButton btnUpdate;
	private JTextField Search;
	private JLabel lblSearch;
	private JButton btnSearch;
	private JTextField CCCD;
	private JTextField NumHome;
	private JTextField StreetName;
	private JTextField Ward;
	private JTextField County;
	private JTextField City;
	private JTextField Country;
	private JLabel lblNumHome;
	private JLabel lblStreetName;
	private JLabel lblWard;
	private JLabel lblCounty;
	private JLabel lblCity;
	private JLabel lblCountry;
	private JButton btnUpLoad;
	private JButton btnStopCus;
	private JButton btnActive;
	private JButton btnLast;
	private JButton btn;
	private JLabel lblDDD;
	private JSpinner spinner;
	private JSpinner spinnerColum;
	////
	private int stt=0;
	private int nowPlace=1;
	private int minimum=1;
	private int maximum;
	private int nowColum=20;
	private int total;
	private boolean status=true;
	private JButton btnAdd;
	private JButton btnReset;




	

	/**
	 * Cre
	 * ate the panel.
	 */
	
	public TTCustomer() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(202, 207, 254));
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(202, 207, 254));
		add(panel, "name_111703783663042");
		
		scrollPane = new JScrollPane();
		
		lblIdCus = new JLabel("IdCus");
		
		IdCus1 = new JTextField();
		IdCus1.setEditable(false);
		IdCus1.setColumns(10);
		
		lblBirthDay = new JLabel("Birthday");
		
		NumPhone = new JTextField();
		NumPhone.setColumns(10);
		
		lblNumPhone = new JLabel("Number Phone");
		
		lblFirstName = new JLabel("First Name");
		
		lblLastName = new JLabel("Last Name");
		
		lblGender = new JLabel("Gender");
		
		lblCCCD = new JLabel("CCCD");
		
		lblIdAddress = new JLabel("Id Address");
		
		IdAddress = new JTextField();
		IdAddress.setEditable(false);
		IdAddress.setColumns(10);
		
		LastName = new JTextField();
		LastName.setColumns(10);
		
		FirstName = new JTextField();
		FirstName.setColumns(10);
		
		rdbtnMade = new JRadioButton("Male");
		rdbtnMade.setSelected(true);
		buttonGroup.add(rdbtnMade);
		
		rdbtnFemade = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemade);
		
		Birthday1 = new JDateChooser();
		Birthday1.setDateFormatString("yyyy/MM/dd");
		
		btnUpdate = new JButton("Updata");
		btnUpdate.setBackground(new Color(255, 255, 0));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		
		Search = new JTextField();
		Search.setColumns(10);
		
		lblSearch = new JLabel("Number Phone");
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		
		CCCD = new JTextField();
		CCCD.setColumns(10);
		
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
		
		lblNumHome = new JLabel("NumHome");
		
		lblStreetName = new JLabel("StreetName");
		
		lblWard = new JLabel("Ward");
		
		lblCounty = new JLabel("County");
		
		lblCity = new JLabel("City");
		
		lblCountry = new JLabel("Country");
		
		btnUpLoad = new JButton("Load");
		btnUpLoad.setBackground(Color.RED);
		btnUpLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpLoadActionPerformed(e);
			}
		});
		
		btnStopCus = new JButton("Stop Customer");
		btnStopCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStopCusActionPerformed(e);
			}
		});
		btnStopCus.setBackground(Color.YELLOW);
		
		btnActive = new JButton("Active");
		btnActive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActiveActionPerformed(e);
			}
		});
		btnActive.setBackground(Color.YELLOW);
		
		btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastActionPerformed(e);
			}
		});
		
		btn = new JButton("Next");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed(e);
			}
		});
		
		lblDDD = new JLabel("1");
		
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
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setBackground(Color.YELLOW);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetActionPerformed(e);
			}
		});
		btnReset.setBackground(Color.YELLOW);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdCus, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumPhone, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBirthDay)
						.addComponent(lblCCCD, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumHome, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStreetName, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWard, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(Ward, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(StreetName, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(NumPhone, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(CCCD, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(NumHome, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(Birthday1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(IdCus1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnMade, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnFemade, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(LastName, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(FirstName, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblCounty, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblIdAddress, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCountry, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(County, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
										.addComponent(City, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
										.addComponent(Country, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
										.addComponent(IdAddress, 256, 256, 256))))
							.addGap(26)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(51)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnUpLoad, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnStopCus, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
								.addComponent(btnAdd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnActive, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblSearch, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(Search, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(114)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(295)
					.addComponent(btnLast)
					.addGap(57)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(spinnerColum, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
					.addComponent(lblDDD, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(btn)
					.addGap(184))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdCus, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(IdCus1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFirstName)
						.addComponent(FirstName, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblBirthDay)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblLastName)
									.addComponent(LastName, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addComponent(Birthday1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(NumPhone, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumPhone)
								.addComponent(lblGender)
								.addComponent(rdbtnMade, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnFemade, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(CCCD, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIdAddress)
								.addComponent(IdAddress, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCCCD))
							.addGap(25)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(County, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(NumHome, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCounty)
								.addComponent(lblNumHome))
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(StreetName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(City, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCity)
								.addComponent(lblStreetName))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(Ward, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(Country, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCountry)
								.addComponent(lblWard)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnUpLoad, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnStopCus, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnActive, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(Search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSearch))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSearch)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(16)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLast)
						.addComponent(btn)
						.addComponent(lblDDD)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerColum, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18))
		);
		
		table = new JTable();
		
		table.setAutoCreateRowSorter(true);
		ListSelectionModel listSelectionModel= table.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		arrayCustomer=CustomerDao.getList();
		pagingJtable();
		SelCus(arrayCustomer);
		panel.setLayout(gl_panel);

		
	}
	
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Customer> getArrayCustomer() {
		return arrayCustomer;
	}


	public void setArrayCustomer(List<Customer> arrayCustomer) {
		this.arrayCustomer = arrayCustomer;
	}


	private void SelCus(List<Customer> arrayCustomerr) {
		stt=1;
	DefaultTableModel model = new DefaultTableModel() {
				public Class<?> getColumnClass(int column){
					switch(column) {
					case 0 : return Integer.class;
					}
					return String.class;
				}
				 public boolean isCellEditable(int row, int column){
				        
				        return false;
				    }
			   
			};
			
			model.addColumn("IdCus");
			model.addColumn("FirstName");
			model.addColumn("LastName");
			model.addColumn("Birthday");
			model.addColumn("Gender");
			model.addColumn("CCCD");
			model.addColumn("NumPhone");
			model.addColumn("TotalPurchasePrice");
			model.addColumn("IdAddress");
			model.addColumn("DeleteStaus");
			
	
		
			
			
			arrayCustomerr.
			stream().filter(i->{
				if(stt> (nowPlace-1)*nowColum &&  stt<=nowPlace*nowColum) {
					return true;
				}
			stt++;
				return false;
			}).forEach(
				peo ->{
					stt++;
					model.addRow(new Object[] {
						peo.getIdCus(), peo.getFirstName(), peo.getLastName(),peo.getBirthday().toString(),
						peo.isGender()?"Male":"Female",peo.getCCCD(),peo.getNumphone(),peo.getTotalCus(),peo.getIdAddress(),peo.getDeleteStaus()?"Active":"Stop Active"
				});
				}
			);
			
			table.setModel(model);
			table.setRowHeight(60);
//			table.getTableHeader().setReorderingAllowed(true);
//			table.getColumnModel().getColumn(1).setMinWidth(100);
//			table.setAutoCreateRowSorter(true);
		}
	
	
	protected void tableMouseClicked(MouseEvent e) {
		
		
		Customer mem = new Customer();
		int[] rows = table.getSelectedRows();
		
		int id=Integer.valueOf(table.getValueAt(rows[0],0).toString());
		
//		CustomerDao IdCus = new CustomerDao();
		//mem = CustomerDao.SearchIfCustomer(1);
		arrayCustomer.stream().filter(i->i.getIdCus()==id).forEach(i->customer=i);;
		
		FirstName.setText(customer.getFirstName());

		LastName.setText(customer.getLastName());
		try {
			Birthday1.setDate(
					//LocalDate.ofInstant(Birthday1.getDate().toInstant(),ZoneId.systemDefault()) 
					Date.from(customer.getBirthday().atStartOfDay(ZoneId.systemDefault()).toInstant())
			);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		NumPhone.setText(customer.getNumphone());
		CCCD.setText(customer.getCCCD());
		IdCus1.setText(String.valueOf(customer.getIdCus()));
		IdAddress.setText(String.valueOf(customer.getIdAddress()));
		NumHome.setText(customer.getNumhome());
		Ward.setText(customer.getWard());
		StreetName.setText(customer.getName());
		County.setText(customer.getCounty());
		City.setText(customer.getCity());
		Country.setText(customer.getCountry());
		if(customer.isGender()==true) {
			rdbtnMade.setSelected(true);
		}else {
			rdbtnFemade.setSelected(true);
		}
		
		lblFirstName.setForeground(Color.black);
		lblLastName.setForeground(Color.black);
		lblBirthDay.setForeground(Color.black);
		lblCCCD.setForeground(Color.black);
		lblNumPhone.setForeground(Color.black);
		lblNumHome.setForeground(Color.black);
		lblStreetName.setForeground(Color.black);
		lblWard.setForeground(Color.black);
		lblCounty.setForeground(Color.black);
		lblCity.setForeground(Color.black);
		lblCountry.setForeground(Color.black);

		
		
		
	}
	protected void btnSearchActionPerformed(ActionEvent e) {

		Customer mem = new Customer();
		String phone =Search.getText();
//		CustomerDao IdCus = new CustomerDao();
		//mem = CustomerDao.SearchIfCustomer(1);
		arrayCustomer.stream().filter(i->i.getNumphone().equals(phone)).forEach(i->customer=i);;
		
		FirstName.setText(customer.getFirstName());

		LastName.setText(customer.getLastName());
		try {
			Birthday1.setDate(
					//LocalDate.ofInstant(Birthday1.getDate().toInstant(),ZoneId.systemDefault()) 
					Date.from(customer.getBirthday().atStartOfDay(ZoneId.systemDefault()).toInstant())
			);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		NumPhone.setText(customer.getNumphone());
		CCCD.setText(customer.getCCCD());
		IdCus1.setText(String.valueOf(customer.getIdCus()));
		IdAddress.setText(String.valueOf(customer.getIdAddress()));
		NumHome.setText(customer.getNumhome());
		Ward.setText(customer.getWard());
		StreetName.setText(customer.getName());
		County.setText(customer.getCounty());
		City.setText(customer.getCity());
		Country.setText(customer.getCountry());
		if(customer.isGender()==true) {
			rdbtnMade.setSelected(true);
		}else {
			rdbtnFemade.setSelected(true);
		}
		if(customer.getNumphone().equals(phone)) {
			JOptionPane.showMessageDialog(null,"successful");
		}else {
			JOptionPane.showMessageDialog(null,"Can't find phone number");
			FirstName.setText(null);
			LastName.setText(null);
			Birthday1.setDate(null);
			rdbtnMade.setSelectedIcon(null);
			rdbtnFemade.setSelectedIcon(null);
			CCCD.setText(null);
			StreetName.setText(null);
			NumPhone.setText(null);
			NumHome.setText(null);
			Ward.setText(null);
			County.setText(null);
			City.setText(null);
			Country.setText(null);
			IdCus1.setText(null);
			IdAddress.setText(null);
			
			
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}
		
	}
	protected void btnUpdateActionPerformed(ActionEvent e) {
		boolean g = true;
		if(rdbtnMade.isSelected()) {
	        g=true;
		}else{ 
	       g=false;
		}
		
		Customer mem = new Customer();
		
		if(FirstName.getText().length()==0) {
			lblFirstName.setForeground(Color.red);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
			
		}else if(LastName.getText().length()==0){
			lblLastName.setForeground(Color.red);
			lblFirstName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(Birthday1.getDate() ==null) {
				
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.red);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(CCCD.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.red);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(NumPhone.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.red);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(NumHome.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.red);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if (StreetName.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.red);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if (Ward.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.red);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(County.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.red);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(City.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.red);
			lblCountry.setForeground(Color.black);
		}else if(Country.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.red);
			
		}else {
		mem.setIdCus(Integer.parseInt(IdCus1.getText()));
		mem.setIdAddress(Integer.parseInt(IdAddress.getText()));

		mem.setFirstName(FirstName.getText());
		
		mem.setLastName(LastName.getText());
		mem.setBirthday(
				LocalDate.ofInstant(Birthday1.getDate().toInstant(),ZoneId.systemDefault()) 
		);
		mem.setGender(g);
		mem.setCCCD(CCCD.getText());	
		mem.setNumphone(NumPhone.getText());
		mem.setNumhome(NumHome.getText());
		mem.setName(StreetName.getText());
		mem.setWard(Ward.getText());
		mem.setCounty(County.getText());
		mem.setCity(City.getText());
		mem.setCountry(Country.getText());
		
		
		
		
		// add sql
		int sell = JOptionPane.showConfirmDialog(null,"You realy want updata","notification",JOptionPane.YES_NO_CANCEL_OPTION);
		if(sell == JOptionPane.YES_OPTION) {
		CustomerDao CusDao = new CustomerDao();
		CusDao.UpdateCustomer(mem);
		JOptionPane.showMessageDialog(null,"successful");
		//reset
		lblFirstName.setForeground(Color.black);
		lblLastName.setForeground(Color.black);
		lblBirthDay.setForeground(Color.black);
		lblCCCD.setForeground(Color.black);
		lblNumPhone.setForeground(Color.black);
		lblNumHome.setForeground(Color.black);
		lblStreetName.setForeground(Color.black);
		lblWard.setForeground(Color.black);
		lblCounty.setForeground(Color.black);
		lblCity.setForeground(Color.black);
		lblCountry.setForeground(Color.black);
		arrayCustomer = CustomerDao.getList();
		pagingJtable();
		SelCus(arrayCustomer);
		}
		}

	}
	protected void btnUpLoadActionPerformed(ActionEvent e) {
		arrayCustomer = CustomerDao.getList();
		pagingJtable();
		SelCus(arrayCustomer);
	}
	protected void btnStopCusActionPerformed(ActionEvent e) {
		int sell = JOptionPane.showConfirmDialog(null,"You realy want Stop Customer","notification",JOptionPane.YES_NO_CANCEL_OPTION);
		if(sell == JOptionPane.YES_OPTION) {
		int[] rows = table.getSelectedRows();
		int id=Integer.valueOf(table.getValueAt(rows[0],0).toString());
		CustomerDao.StopCus(id);
		JOptionPane.showMessageDialog(null, "Successful");
		}
	}
	
	protected void btnActiveActionPerformed(ActionEvent e) {
		int sell = JOptionPane.showConfirmDialog(null,"You realy want Active Customer","notification",JOptionPane.YES_NO_CANCEL_OPTION);
		if(sell == JOptionPane.YES_OPTION) {
		int[] rows = table.getSelectedRows();
		int id=Integer.valueOf(table.getValueAt(rows[0],0).toString());
		CustomerDao.ImportCus(id);
		JOptionPane.showMessageDialog(null, "Successful");
		}
	}
	public void pagingJtable() {
		total=arrayCustomer.size();
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
			SelCus(arrayCustomer);
		}
	}
	protected void btnActionPerformed(ActionEvent e) {
		if(nowPlace==maximum) {
			return;
		}else {
			status=false;
			++nowPlace;
			spinnerColum.setValue(nowPlace);
			SelCus(arrayCustomer);
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
			SelCus(arrayCustomer);
	}
	protected void spinnerColumStateChanged(ChangeEvent e) {
		nowPlace=Integer.valueOf(spinnerColum.getValue().toString());		
		SelCus(arrayCustomer);
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		boolean g = true;
		if(rdbtnMade.isSelected()) {
	        g=true;
		}else{ 
	       g=false;
		}
		
		Customer mem = new Customer();
		
		if(FirstName.getText().length()==0) {
			lblFirstName.setForeground(Color.red);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
			
		}else if(LastName.getText().length()==0){
			lblLastName.setForeground(Color.red);
			lblFirstName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(Birthday1.getDate() ==null) {
				
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.red);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(CCCD.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.red);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(NumPhone.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.red);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(NumHome.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.red);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if (StreetName.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.red);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if (Ward.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.red);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(County.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.red);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(City.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.red);
			lblCountry.setForeground(Color.black);
		}else if(Country.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthDay.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumHome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.red);
		}else {

		mem.setFirstName(FirstName.getText());
		
		mem.setLastName(LastName.getText());
		mem.setBirthday(
				LocalDate.ofInstant(Birthday1.getDate().toInstant(),ZoneId.systemDefault()) 
		);
		mem.setGender(g);
		mem.setCCCD(CCCD.getText());
		mem.setNumphone(NumPhone.getText());
		mem.setNumhome(NumHome.getText());
		mem.setName(StreetName.getText());
		mem.setWard(Ward.getText());
		mem.setCounty(County.getText());
		mem.setCity(City.getText());
		mem.setCountry(Country.getText());
		
		// add sql
		CustomerDao CusDao = new CustomerDao();
		//CusDao.InsertCustomer(mem);
		if(CusDao.erroPhoneCus(mem.getNumphone())==true) {
		JOptionPane.showMessageDialog(null,"Phone number already in use ");
		lblNumPhone.setForeground(Color.red);
		}else {
			JOptionPane.showMessageDialog(null,"successful");
			CusDao.InsertCustomer(mem);
		
		//reset
		FirstName.setText(null);
		LastName.setText(null);
		Birthday1.setDate(null);
		rdbtnMade.setSelectedIcon(null);
		rdbtnFemade.setSelectedIcon(null);
		CCCD.setText(null);
		StreetName.setText(null);
		NumPhone.setText(null);
		NumHome.setText(null);
		Ward.setText(null);
		County.setText(null);
		City.setText(null);
		Country.setText(null);
		
		lblFirstName.setForeground(Color.black);
		lblLastName.setForeground(Color.black);
		lblBirthDay.setForeground(Color.black);
		lblCCCD.setForeground(Color.black);
		lblNumPhone.setForeground(Color.black);
		lblNumHome.setForeground(Color.black);
		lblStreetName.setForeground(Color.black);
		lblWard.setForeground(Color.black);
		lblCounty.setForeground(Color.black);
		lblCity.setForeground(Color.black);
		lblCountry.setForeground(Color.black);
		arrayCustomer = CustomerDao.getList();
		pagingJtable();
		SelCus(arrayCustomer);
		}
		}
		
	}
	protected void btnResetActionPerformed(ActionEvent e) {
		FirstName.setText(null);
		LastName.setText(null);
		Birthday1.setDate(null);
		rdbtnMade.setSelectedIcon(null);
		rdbtnFemade.setSelectedIcon(null);
		CCCD.setText(null);
		StreetName.setText(null);
		NumPhone.setText(null);
		NumHome.setText(null);
		Ward.setText(null);
		County.setText(null);
		City.setText(null);
		Country.setText(null);
		IdCus1.setText(null);
		IdAddress.setText(null);
		
	}
}
