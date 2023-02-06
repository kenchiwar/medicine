package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.BillDao;
import dao.CustomerDao;
import dao.DetailBillDao;
import entity.Bill;
import entity.Customer;
import entity.DetaiBill;
import entity.Staff;
import helper.REGEX;
import helper.Validation;

public class BillJframe extends JFrame {

	private JPanel contentPane;
	private JPanel mainPane;
	private JPanel panel_1;
	private JPanel mainPaine2;
	private JPanel panelBill;
	private JScrollPane scrollPane;
	private JPanel panelCustomer;
	private JPanel panelDetail;
	private JTable tableBill;
	//code tự tạo tay
		CardLayout cl = new CardLayout(); 
		private String nameMedicine ;
		private	Customer customer=new Customer();
		private JframeDetailBill JframeAddDetailBill;
		private ArrayList<DetaiBill> detailBill= new ArrayList<DetaiBill>();
		private JframeAdress jframeAdress;
		private Staff staff= new Staff();;
		private Bill bill;
		private StatisticalBill statisticalBill;
		private JpanelSuKien jpanelSuKien;
		private JpanelListSuKien listSuKien;
		private JReportBill report;
		private Notification not;
		private HomePage homePage = new HomePage();
		//code giá trị
		private float number ;
		private float number2 ;
			//true là kích hoạt nút jbutton  bill
		   private boolean checkBill=true;
		   //TRUE là kích hoạt nút export bill
		   private boolean checkExportBill=false;
		   // true là kích hoạt nút jbutton  addCussomer
		   private boolean checkAddCustomer=false;
		   //true là kích hoạt nút jbutton update customer
		   private boolean checkUpdateCustomer=false;
		  
	//
	private JButton btnAddMedicine;
	private JTextField textMedicine;
	private JLabel lblSearch;
	private JRadioButton rdbtnYesBill;
	private JRadioButton rdbtnNoBill;
	private JRadioButton rdbtnRetail;
	private final ButtonGroup checkStatus = new ButtonGroup();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textTotalBill;
	private JTextField textSale;
	private JSpinner spinnerSale;
	private JLabel lblNewLabel_3;
	private JLabel lblMoney;
	private JTextField textPayment;
	private JLabel lblMoney_1;
	private JButton btnResetBill;
	private JButton btnBill;
	private JLabel lblidBill;
	private JTextField textidBill;
	private JLabel lblNumPhone;
	private JTextField textNumPhone;
	private JLabel lblDateTime;
	private JTextField textTime;
	private JLabel lblFirstName;
	private JTextField textFirstName;
	private JLabel lblidCustomer_5;
	private JTextField textAdress;
	private JLabel lblStaff;
	private JTextField textStaff;
	private JLabel lblGender;
	private JLabel lblDob;
	private JLabel lblidCustomer_6;
	private JTextField textLastName;
	private JLabel lblidCCCD;
	private JTextField textCCCD;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JButton btnChangAdress;
	private JButton btnUpdate;
	private JButton btnAddCus;
	private JLabel lblNewLabel_4;
	private final ButtonGroup gender = new ButtonGroup();
	private JDateChooser dateChooser;
	private JButton btnExportBill;
	private JButton btnSearchBill;
	private JSpinner spinnerMoneyGet;
	private JSpinner spinnerChange;
	private JPanel formJpanel;
	private JScrollPane scrollFrom;
	private JPanel panel_2;
	private JButton btnMet;
	private JPanel panel_3;
	private JButton btnPrintBill;
	private JButton btnLogout;
	
	
	
	public HomePage getHomePage() {
		return homePage;
	}

	public void setHomePage(HomePage homePage) {
		this.homePage = homePage;
	}

	public ArrayList<DetaiBill> getDetailBill() {
		return detailBill;
	}

	public void setDetailBill(ArrayList<DetaiBill> detailBill) {
		this.detailBill = detailBill;
	}	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public JframeDetailBill getJframeAddDetailBill() {
		return JframeAddDetailBill;
	}

	public void setJframeAddDetailBill(JframeDetailBill jframeAddDetailBill) {
		JframeAddDetailBill = jframeAddDetailBill;
	}

	public String getNameMedicine() {
		return nameMedicine;
	}

	public void setNameMedicine(String nameMedicine) {
		this.nameMedicine = nameMedicine;
	}
	
	
	public JframeAdress getJframeAdress() {
		return jframeAdress;
	}

	public void setJframeAdress(JframeAdress jframeAdress) {
		this.jframeAdress = jframeAdress;
	}
	

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillJframe frame = new BillJframe();
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
	public BillJframe() {
		setTitle("Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1011, 904);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cl);
		formJpanel = new JPanel();
		formJpanel.setBackground(new Color(0, 255, 255));
		contentPane.add(formJpanel, "name_8459342237000");
		formJpanel.setLayout(new BorderLayout(0, 0));
		
		scrollFrom = new JScrollPane();
		formJpanel.add(scrollFrom, BorderLayout.CENTER);
		
		 statisticalBill=new StatisticalBill();
		scrollFrom.setViewportView(statisticalBill);
		
		
		
		
		
		btnMet = new JButton("Return BIll");
		btnMet.setBackground(new Color(0, 255, 255));
		btnMet.setForeground(new Color(255, 0, 0));
		btnMet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnMet_actionPerformed(e);
			}
		});
		formJpanel.add(btnMet, BorderLayout.NORTH);
		mainPane = new JPanel();
		contentPane.add(mainPane, "name_354575640624600");
		mainPane.setLayout(new BorderLayout(0, 0));
		mainPaine2 = new JPanel();
		mainPaine2.setForeground(new Color(255, 0, 0));
		mainPaine2.setBackground(new Color(0, 255, 255));
		mainPane.add(mainPaine2, BorderLayout.CENTER);
		
		panelBill = new JPanel();
		panelBill.setBackground(new Color(0, 255, 255));
		panelBill.setBorder(new TitledBorder(new LineBorder(new Color(0, 64, 0), 2), "Information Bill", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		
		panelCustomer = new JPanel();
		panelCustomer.setBackground(new Color(0, 255, 255));
		panelCustomer.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		
		panelDetail = new JPanel();
		panelDetail.setBackground(new Color(0, 255, 255));
		panelDetail.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Information Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		
		btnResetBill = new JButton("ResetBill");
		btnResetBill.setForeground(new Color(255, 0, 0));
		btnResetBill.setBackground(new Color(0, 255, 255));
		btnResetBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			do_btnNewButton_1_actionPerformed(e);
			}
		});
		
		btnBill = new JButton("Bill");
		btnBill.setForeground(new Color(255, 0, 0));
		btnBill.setBackground(new Color(0, 255, 255));
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		
		lblNewLabel_4 = new JLabel("Bill ");
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnSearchBill = new JButton("SearchBill");
		btnSearchBill.setForeground(new Color(255, 0, 0));
		btnSearchBill.setBackground(new Color(0, 255, 255));
		btnSearchBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearchBill_actionPerformed(e);
			}
		});
		GroupLayout gl_mainPaine2 = new GroupLayout(mainPaine2);
		gl_mainPaine2.setHorizontalGroup(
			gl_mainPaine2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPaine2.createSequentialGroup()
					.addComponent(panelDetail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_mainPaine2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPaine2.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnResetBill, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBill, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
						.addComponent(btnSearchBill, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_mainPaine2.createSequentialGroup()
					.addGap(372)
					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
					.addGap(353))
				.addGroup(gl_mainPaine2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCustomer, GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_mainPaine2.createSequentialGroup()
					.addGap(1)
					.addComponent(panelBill, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_mainPaine2.setVerticalGroup(
			gl_mainPaine2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_mainPaine2.createSequentialGroup()
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCustomer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelBill, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_mainPaine2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_mainPaine2.createSequentialGroup()
							.addComponent(btnBill, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSearchBill, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnResetBill, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelDetail, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		lblNewLabel = new JLabel("Price Sale");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblNewLabel_1 = new JLabel("Sale(%)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblNewLabel_2 = new JLabel("Total(VND)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textTotalBill = new JTextField();
		textTotalBill.setEditable(false);
		textTotalBill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTotalBill.setHorizontalAlignment(SwingConstants.CENTER);
		textTotalBill.setColumns(10);
		
		textSale = new JTextField();
		textSale.setEditable(false);
		textSale.setColumns(10);
		
		spinnerSale = new JSpinner();
		spinnerSale.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_spinnerSale_keyReleased(e);
			}
		});
		spinnerSale.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_spinnerSale_stateChanged(e);
			}
		});
		spinnerSale.setModel(new SpinnerNumberModel(0, 0, 60, 5));
		
		lblNewLabel_3 = new JLabel("PayMents");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblMoney = new JLabel("Money Get(VND)");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textPayment = new JTextField();
		textPayment.setEditable(false);
		textPayment.setColumns(10);
		
		lblMoney_1 = new JLabel("Change(VND)");
		lblMoney_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnExportBill = new JButton("ExportBill");
		btnExportBill.setBackground(new Color(0, 255, 255));
		btnExportBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnExportBill_actionPerformed(e);
			}
		});
		
		spinnerMoneyGet = new JSpinner();
		spinnerMoneyGet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_spinnerSale_keyReleased(e);
				
				
			}
		});
		spinnerMoneyGet.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_spinnerSale_stateChanged(e);
			}
		});
		spinnerMoneyGet.setModel(new SpinnerNumberModel(Float.valueOf(0), null, null, Float.valueOf(1000)));
		
		spinnerChange = new JSpinner();
		spinnerChange.setForeground(new Color(255, 0, 0));
		spinnerChange.setEnabled(false);
		
		btnPrintBill = new JButton("Print Bill");
		btnPrintBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPrintBillActionPerformed(e);
			}
		});
		btnPrintBill.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panelDetail = new GroupLayout(panelDetail);
		gl_panelDetail.setHorizontalGroup(
			gl_panelDetail.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelDetail.createSequentialGroup()
					.addGroup(gl_panelDetail.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDetail.createSequentialGroup()
							.addGroup(gl_panelDetail.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelDetail.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textTotalBill, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
								.addGroup(gl_panelDetail.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_panelDetail.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelDetail.createSequentialGroup()
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textSale, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
										.addGroup(gl_panelDetail.createSequentialGroup()
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
											.addGap(121)
											.addComponent(spinnerSale, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
							.addGap(4)
							.addGroup(gl_panelDetail.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMoney_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
							.addGap(20))
						.addGroup(gl_panelDetail.createSequentialGroup()
							.addGap(243)
							.addComponent(btnExportBill, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
							.addGap(60)))
					.addGroup(gl_panelDetail.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnPrintBill)
						.addComponent(textPayment, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addComponent(spinnerChange, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addComponent(spinnerMoneyGet))
					.addGap(119))
		);
		gl_panelDetail.setVerticalGroup(
			gl_panelDetail.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDetail.createSequentialGroup()
					.addGroup(gl_panelDetail.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDetail.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(textTotalBill, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDetail.createSequentialGroup()
							.addGap(3)
							.addComponent(textPayment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelDetail.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDetail.createSequentialGroup()
							.addGroup(gl_panelDetail.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(textSale, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelDetail.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinnerSale, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelDetail.createSequentialGroup()
							.addGroup(gl_panelDetail.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinnerMoneyGet, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelDetail.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoney_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinnerChange, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelDetail.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExportBill, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrintBill))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panelDetail.setLayout(gl_panelDetail);
		
		btnAddMedicine = new JButton("Add");
		btnAddMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAddMedicine_actionPerformed(e);
			}
		});
		
		textMedicine = new JTextField();
		textMedicine.setColumns(10);
		
		lblSearch = new JLabel("Name Medicine :");
		lblSearch.setName("2");
		
		panel = new JPanel();
		
		lblidBill = new JLabel("Id Bill");
		
		textidBill = new JTextField();
		textidBill.setEditable(false);
		textidBill.setForeground(Color.BLACK);
		textidBill.setColumns(10);
		textidBill.setBackground(Color.WHITE);
		
		lblNumPhone = new JLabel("NumPhone");
		
		textNumPhone = new JTextField();
		textNumPhone.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				do_textNumPhone_keyReleased(e);
			}
		});
		textNumPhone.setForeground(Color.BLACK);
		textNumPhone.setColumns(10);
		textNumPhone.setBackground(new Color(255, 255, 255));
		
		lblDateTime = new JLabel("Time");
		
		textTime = new JTextField();
		textTime.setEditable(false);
		textTime.setForeground(Color.BLACK);
		textTime.setColumns(10);
		textTime.setBackground(Color.WHITE);
		
		lblFirstName = new JLabel("FirstName");
		
		textFirstName = new JTextField();
		textFirstName.setForeground(Color.BLACK);
		textFirstName.setColumns(10);
		textFirstName.setBackground(Color.WHITE);
		
		lblidCustomer_5 = new JLabel("Adress");
		
		textAdress = new JTextField();
		textAdress.setEditable(false);
		textAdress.setForeground(Color.BLACK);
		textAdress.setColumns(10);
		textAdress.setBackground(Color.WHITE);
		
		lblStaff = new JLabel("Staff");
		
		textStaff = new JTextField();
		textStaff.setEditable(false);
		textStaff.setForeground(Color.BLACK);
		textStaff.setColumns(10);
		textStaff.setBackground(Color.WHITE);
		
		lblGender = new JLabel("Gender");
		
		lblDob = new JLabel("Birthday");
		
		lblidCustomer_6 = new JLabel("Last Name Cus");
		
		textLastName = new JTextField();
		textLastName.setForeground(Color.BLACK);
		textLastName.setColumns(10);
		textLastName.setBackground(Color.WHITE);
		
		lblidCCCD = new JLabel("CCCD");
		
		textCCCD = new JTextField();
		textCCCD.setForeground(Color.BLACK);
		textCCCD.setColumns(10);
		textCCCD.setBackground(Color.WHITE);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		gender.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("female");
		gender.add(rdbtnFemale);
		
		btnChangAdress = new JButton("Change");
		btnChangAdress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		
		btnUpdate = new JButton("Update Cus");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdate_actionPerformed(e);
			}
		});
		
		btnAddCus = new JButton("Add Cus");
		btnAddCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAddCus_actionPerformed(e);
			}
		});
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogoutActionPerformed(e);
			}
		});
		GroupLayout gl_panelCustomer = new GroupLayout(panelCustomer);
		gl_panelCustomer.setHorizontalGroup(
			gl_panelCustomer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCustomer.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnUpdate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAddCus)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogout)
					.addGap(312)
					.addComponent(lblSearch, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textMedicine, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnAddMedicine)
					.addGap(29))
				.addGroup(gl_panelCustomer.createSequentialGroup()
					.addGroup(gl_panelCustomer.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCustomer.createSequentialGroup()
							.addGap(5)
							.addComponent(lblidBill, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textidBill, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblDateTime, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(textTime, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
							.addGap(29)
							.addComponent(lblStaff, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCustomer.createSequentialGroup()
							.addGroup(gl_panelCustomer.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCustomer.createSequentialGroup()
									.addGap(1)
									.addComponent(lblNumPhone, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textNumPhone, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
									.addGap(38)
									.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(textFirstName, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
									.addGap(29))
								.addGroup(gl_panelCustomer.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblidCustomer_5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textAdress, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
									.addComponent(btnChangAdress, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addGap(6)))
							.addGroup(gl_panelCustomer.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panelCustomer.createSequentialGroup()
									.addGap(10)
									.addComponent(lblidCCCD, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panelCustomer.createSequentialGroup()
									.addComponent(lblidCustomer_6, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addGap(6)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCustomer.createParallelGroup(Alignment.TRAILING)
						.addComponent(textLastName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
						.addComponent(textStaff, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
						.addComponent(textCCCD, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panelCustomer.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelCustomer.createSequentialGroup()
							.addGap(28)
							.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnMale, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panelCustomer.createSequentialGroup()
							.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addGap(39))))
		);
		gl_panelCustomer.setVerticalGroup(
			gl_panelCustomer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCustomer.createSequentialGroup()
					.addGroup(gl_panelCustomer.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCustomer.createSequentialGroup()
							.addGroup(gl_panelCustomer.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCustomer.createSequentialGroup()
									.addGap(17)
									.addComponent(lblidBill, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelCustomer.createSequentialGroup()
									.addGap(18)
									.addComponent(textidBill, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addGroup(gl_panelCustomer.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumPhone, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelCustomer.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textNumPhone, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panelCustomer.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_panelCustomer.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStaff, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textStaff, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(2)
							.addGroup(gl_panelCustomer.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCustomer.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_panelCustomer.createParallelGroup(Alignment.BASELINE)
										.addComponent(rdbtnFemale)
										.addComponent(rdbtnMale)
										.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelCustomer.createSequentialGroup()
									.addGap(7)
									.addGroup(gl_panelCustomer.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblidCustomer_6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(textLastName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panelCustomer.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panelCustomer.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDateTime, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textTime, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_panelCustomer.createParallelGroup(Alignment.LEADING)
								.addComponent(textFirstName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_panelCustomer.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCustomer.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panelCustomer.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCustomer.createParallelGroup(Alignment.BASELINE)
									.addComponent(textCCCD, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCustomer.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(lblSearch)
								.addGroup(gl_panelCustomer.createSequentialGroup()
									.addGap(2)
									.addComponent(textMedicine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnAddMedicine)))
						.addGroup(gl_panelCustomer.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_panelCustomer.createParallelGroup(Alignment.BASELINE)
								.addComponent(textAdress, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnChangAdress)
								.addComponent(lblidCustomer_5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCustomer.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAddCus, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLogout)))
						.addGroup(gl_panelCustomer.createSequentialGroup()
							.addGap(8)
							.addComponent(lblidCCCD, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addGap(13))
		);
		
		rdbtnRetail = new JRadioButton("Retail");
		rdbtnRetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnRetail_actionPerformed(e);
			}
		});
		panel.add(rdbtnRetail);
		rdbtnRetail.setName("1");
		checkStatus.add(rdbtnRetail);
		rdbtnRetail.setForeground(new Color(0, 0, 255));
		rdbtnRetail.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		rdbtnNoBill = new JRadioButton("No Bill");
		rdbtnNoBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnRetail_actionPerformed(e);
			}
		});
		panel.add(rdbtnNoBill);
		rdbtnNoBill.setName("2");
		checkStatus.add(rdbtnNoBill);
		rdbtnNoBill.setForeground(new Color(0, 0, 255));
		rdbtnNoBill.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		rdbtnYesBill = new JRadioButton("Yes Bill");
		
		rdbtnYesBill.setSelected(true);
		rdbtnYesBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnRetail_actionPerformed(e);
			}
		});
		panel.add(rdbtnYesBill);
		checkStatus.add(rdbtnYesBill);
		rdbtnYesBill.setForeground(new Color(0, 0, 255));
		rdbtnYesBill.setFont(new Font("Tahoma", Font.PLAIN, 8));
		panelCustomer.setLayout(gl_panelCustomer);
		panelBill.setLayout(new CardLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panelBill.add(scrollPane, "name_356581197724100");
		
		tableBill = new JTable();
		ListSelectionModel listSelectionModel= tableBill.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableBill.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Name Medicine","Amount", "Unit Price", "RegisNumber","Unit","Price out","Sale"
				}
			));
		scrollPane.setViewportView(tableBill);
		mainPaine2.setLayout(gl_mainPaine2);
		
		
		
		
		
		panel_1 = new JPanel();
		if(staff.getFirstName()==null) {
		
		staff.setIdStaff(1);
		staff.setFirstName("hay");
		staff.setLastName("ko vui");
		}
		customer.setIdCustomer(2);
		
		cl.show(contentPane,"name_354575640624600");
		
//		panel_3 = new JPanel();
//		contentPane.add(panel_3, "name_342527665034000");
//		panel_3.setLayout(new CardLayout(0, 0));
//		jpanelSuKien = new JpanelSuKien();
//		listSuKien = new JpanelListSuKien();
//		panel_3.add(listSuKien );
//		cl.show(contentPane,"name_342527665034000");
//		//setDate();
//		insertCustomer();
//		totalFunction() ;
	
		
	}
public void totalFunction() {
	if(staff.getFirstName()!=null) {
	textStaff.setText(staff.getFirstName()+" "+staff.getLastName());
	}
	createTableDetailBill(getDetailBill());
	totalBill();
	
	}
public void totalFunctionJframeAdress() {
	setTextCustomer();
}
//in danh sách detail ra yeah
	public void createTableDetailBill(ArrayList<DetaiBill> arrayDetailBill) {
	if(!(arrayDetailBill.size()<=0)) {
		DefaultTableModel model = new DefaultTableModel() {
			public Class getColumnClass(int column){
					switch(column) {
//					case 0: return String.class;
//					case 1: return Integer.class;
//					case 2: return String.class;
//					case 3: return String.class;
//					case 4: return String.class;
					case 10: return Float.class;
					
					default: return String.class;

					}	
			}
			 public boolean isCellEditable(int row, int column){
			        
			        return false;
			    }
		   
			
		};
		model.addColumn("Name Medicine");
		model.addColumn("Amount");
		model.addColumn("Unit Price");
		model.addColumn("RegisNumber");
		model.addColumn("Unit");
		model.addColumn("Price Out");
		model.addColumn("Sale");
		
		arrayDetailBill.forEach(i->{
			model.addRow(new Object[] {
					i.getNameMedicine(),
					i.getAmount(),
					String.valueOf(i.getAmount()*i.getPriceOut())+" VND",
					i.getRegisNumber(),
					i.getUnit(),
					i.getPriceOut(),
					i.getSale()
					
			});
			
		}
				);
		
		tableBill.setModel(model);
	}
	}
	//lele
// nút bấm truyền dữ liệu cho radio button	
	protected void do_btnAddMedicine_actionPerformed(ActionEvent e) {
		if(checkExportBill && checkBill) return;
	var  hay = (String) textMedicine.getText().trim();
	//nguyên cái đống này để kiểm tra coi 
		if(hay.equals("")) {
			JOptionPane.showMessageDialog
			(null,"Error text","Please eneter name medicine", JOptionPane.ERROR_MESSAGE);		
			}else {
				var hay23 = getJframeAddDetailBill();
				if(hay23==null) {
				JframeAddDetailBill = new JframeDetailBill();	
				JframeAddDetailBill.setVisible(true);
				JframeAddDetailBill.setNameMedicine(hay);
				JframeAddDetailBill.totalFunction();
				JframeAddDetailBill.setBillJframe(this);
				JframeAddDetailBill.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
				}
				else {
					if(!hay23.isVisible()) {
						JframeAddDetailBill = new JframeDetailBill();	
						JframeAddDetailBill.setVisible(true);
						JframeAddDetailBill.setNameMedicine(hay);
						JframeAddDetailBill.totalFunction();
						JframeAddDetailBill.setBillJframe(this);
						JframeAddDetailBill.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				}
			}
	}
	// insert giá trị cho customer
	public void insertCustomer() {
		Enumeration<AbstractButton> group = checkStatus.getElements();
		while(group.hasMoreElements()) {
			AbstractButton b = group.nextElement();
			if(b.isSelected()) {
				if(b.getName()==null) {
					customer = new Customer();
					customer.setIdCustomer(2);
					
				}
				else if(b.getName().equals("1")) {
					customer = new Customer();
					customer.setIdCustomer(1);
					
				}else if(b.getName().equals("2")) {
					customer = new Customer();
					customer.setIdCustomer(2);
				}
						
			}
		}
	}
	public void totalBill() {
		//number lấy giá trị tổng tiền
		number=0;
		//number2 lấy giá trị sale
		number2=0;
		detailBill.forEach(i->{
			number+=i.getAmount()*i.getPriceOut();
			number2+=i.getSale();
		});
//		spinnerChange
//		spinnerMoneyGet
		textTotalBill.setText(number+" ");
		textSale.setText(number2+" ");
		//(Integer.valueOf(spinnerSale.getValue().toString())==);
		textPayment.setText(((number-number2)/100*(100-Integer.valueOf(spinnerSale.getValue().toString())))+"");
		spinnerChange.setValue(Float.valueOf(spinnerMoneyGet.getValue().toString())-Float.valueOf(textPayment.getText()));
		
	}
	//
	public void setDate() {
		textTime.setText(java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
	// khi thay đổi radio thì chuyện gì xảy ra
	protected void do_rdbtnRetail_actionPerformed(ActionEvent e) {
		Enumeration<AbstractButton> group = checkStatus.getElements();
		while(group.hasMoreElements()) {
			AbstractButton b = group.nextElement();
			if(b.isSelected()) {
				if(b.getName()==null) {
					setIsEditableCustomer(true);
					customer = new Customer();
					customer.setIdCustomer(2);
				}
				else if(b.getName().equals("1")) {
					setTextNullCustomer();
					setIsEditableCustomer(false);
						customer = new Customer();
						customer.setIdCustomer(1);
					
				}else if(b.getName().equals("2")) {
					setTextNullCustomer();
					setIsEditableCustomer(false);
						customer = new Customer();
						customer.setIdCustomer(2);
				}
						
			}
		}
		
	}
	//kiểm tra số điện thoại và hiện dữ liệu
	protected void do_textNumPhone_keyReleased(KeyEvent e) {
		if(textNumPhone.getText().trim().length()>=10) {
			if(Validation.checkBoolean(REGEX.TELEPHONE,textNumPhone.getText().trim())) {
				
				customer =CustomerDao.selectNumberPhone(textNumPhone.getText().trim());
				
				if(customer.getIdCustomer()==0) {
					JOptionPane.showMessageDialog
					(null,"Don't have the Customer in the system");
					 checkAddCustomer=true;
					 checkUpdateCustomer=false;
				}else {
					
					textFirstName.setText(customer.getFirstName());
					textLastName.setText(customer.getLastName());
					textCCCD.setText(customer.getCCCD());
					if(customer.getDob()!=null) {
					dateChooser.setDate(Date.valueOf(customer.getDob()));
					}
					if(customer.isGender()==true) {
						rdbtnFemale.setSelected(true);
					}
					textAdress.setText(customer.getNumhome()+" "+customer.getName()+","+customer.getWard()+","+customer.getCounty()
					+","+customer.getCity()+","+customer.getCountry());
				
					checkUpdateCustomer=true;
					 checkAddCustomer=false;
				}
			}else {
				JOptionPane.showMessageDialog
				(null,"Error NumPhone","Phone is Incorrect", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	//in update dữ liệu customer hiện đang trên hệ thống
	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		if(!checkUpdateCustomer) {
			return ;
		}
		customer.setNumberphone(textNumPhone.getText().trim());
		customer.setFirstName(textFirstName.getText());
		customer.setLastName(textLastName.getText());
		customer.setCCCD(textCCCD.getText());
		customer.setGender(rdbtnFemale.isSelected());
		if(dateChooser.getDate()!=null) {
		customer.setDob(LocalDate.ofInstant(dateChooser.getDate().toInstant(),ZoneId.systemDefault()));
		}
		if(CustomerDao.errPhoneUpdate12(customer.getNumberphone(),customer.getIdCustomer())) {
			JOptionPane.showMessageDialog(null, "Error phone", "phone isn't in the system", JOptionPane.ERROR_MESSAGE);
			return;
		};
		CustomerDao.updateCustomer(customer);
		JOptionPane.showMessageDialog
		(null,"Update CUSTOMER Success");
		
	}
	//add customer dữ liệu trên hệ thống
	protected void do_btnAddCus_actionPerformed(ActionEvent e) {
		if(!checkAddCustomer) {
			return ;
		}
		customer.setFirstName(textFirstName.getText());
		customer.setLastName(textLastName.getText());
		customer.setCCCD(textCCCD.getText());
		customer.setNumberphone(textNumPhone.getText());
		if(dateChooser.getDate()!=null) {
			customer.setDob(LocalDate.ofInstant(dateChooser.getDate().toInstant(),ZoneId.systemDefault()));
			}
		customer.setGender(rdbtnFemale.isSelected());
		if(CustomerDao.erroPhoneCus12(customer.getNumberphone())) {
			JOptionPane.showMessageDialog(null, "Error phone", "phone is in the system", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		CustomerDao.InsertCustomer1(customer);
		JOptionPane.showMessageDialog
		(null,"ADD CUSTOMER Success");
		checkUpdateCustomer=true;
		checkAddCustomer=false;
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		if(!checkUpdateCustomer && !checkAddCustomer) {
			return ;
		}
		var hay23 = getJframeAdress();
		if(hay23==null) {
		jframeAdress = new JframeAdress();	
		jframeAdress.setVisible(true);
		
		
		jframeAdress.setBillJframe(this);
		jframeAdress.totalFunction();
			
		}
		else {
			if(!hay23.isVisible()) {
				jframeAdress = new JframeAdress();	
				jframeAdress.setVisible(true);
				
				
				jframeAdress.setBillJframe(this);
				jframeAdress.totalFunction();
			}
		}
	}
	// set lại toàn bộ dữ liệu dựa trên cus tomer
	public void setTextCustomer() {
		textFirstName.setText(customer.getFirstName());
		textLastName.setText(customer.getLastName());
		textCCCD.setText(customer.getCCCD());
		if(customer.getDob()!=null) {
		dateChooser.setDate(Date.valueOf(customer.getDob()));
		}
		if(customer.isGender()==true) {
			rdbtnFemale.setSelected(true);
		}
		textAdress.setText(customer.getNumhome()+" "+customer.getName()+","+customer.getWard()+","+customer.getCounty()
		+","+customer.getCity()+","+customer.getCountry());
	
		
		
	}
	//các phần text của customer bị null hết
	public void setTextNullCustomer() {
		textFirstName.setText(null);
		textLastName.setText(null);
		textCCCD.setText(null);
		dateChooser.setDate(null);
		textAdress.setText(null);
		textNumPhone.setText(null);
		spinnerSale.setValue(0);
		spinnerMoneyGet.setValue(0);
		spinnerChange.setValue(0);
		
	}
	// in du lieu bill
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		if(!checkBill && (btnBill.getText()!=null )) return;
		bill=BillDao.insertSelectNewBill(staff.getIdStaff(),customer.getIdCustomer());
		textidBill.setText(bill.getIdBill());
		
		checkBill=false;
		checkExportBill=true;
	}
	
	
	
	protected void do_btnExportBill_actionPerformed(ActionEvent e) {
		if(!checkExportBill) return;
		if(!(JOptionPane.showConfirmDialog(null,
				"Choose", "Are you sure want to Export Bill", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)) return ;
		
		if(Float.valueOf(spinnerChange.getValue().toString())<0) return;
		detailBill.forEach(i->{
			i.setIdBill(bill.getIdBill());
	
			DetailBillDao.createDetailBill(bill,i);
			DetailBillDao.exportDetailBill(i);
			
		});
		bill.setUnitPrice(Float.valueOf(textTotalBill.getText().trim()));
		bill.setSale(Float.valueOf(textTotalBill.getText().trim())-Float.valueOf(textPayment.getText().trim()));
		bill.setIdCustomer(customer.getIdCustomer());
		bill.setTotal(Float.valueOf(textPayment.getText()));
		BillDao.exportBill(bill);
		checkExportBill=false;
		JOptionPane.showMessageDialog
		(null,"Export Bill success");
	}
	//đưa trạng thái bảng lại ban đầu
	protected void resertStatusBill() {
		customer=new Customer();
		
		setDetailBill(new ArrayList<DetaiBill>());
		 bill=new Bill();
		 setTextNullCustomer();
			setIsEditableCustomer(textNumPhone.isEditable());
			  checkBill=true;	  
			    checkExportBill=false;	
			  checkAddCustomer=false;
			    checkUpdateCustomer=false;
			    textidBill.setText(null);
			    tableBill.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Name Medicine","Amount", "Unit Price", "RegisNumber","Unit","Price out","Sale"
						}
					));
			    textMedicine.setText("");
				insertCustomer();
				totalFunction();
		
	}
	
	// set trạng thái edit cho toàn bộ thuộc tính
	protected void setIsEditableCustomer(boolean bit) {
		textFirstName.setEditable(bit);
		textLastName.setEditable(bit);
		textCCCD.setEditable(bit);
		dateChooser.setEnabled(bit);
		textAdress.setEditable(bit);
		textNumPhone.setEditable(bit);
		//setBackground(new Color(192, 192, 192)
		if(bit) {
			textFirstName.setBackground(new Color(250,250,250));
			textLastName.setBackground(new Color(250,250,250));
			textCCCD.setBackground(new Color(250,250,250));
			dateChooser.setBackground(new Color(250,250,250));
			textAdress.setBackground(new Color(250,250,250));
			textNumPhone.setBackground(new Color(250,250,250));
		}else{
			textFirstName.setBackground(new Color(192, 192, 192));
			textLastName.setBackground(new Color(192, 192, 192));
			textCCCD.setBackground(new Color(192, 192, 192));
			dateChooser.setBackground(new Color(192, 192, 192));
			textAdress.setBackground(new Color(192, 192, 192));
			textNumPhone.setBackground(new Color(192, 192, 192));
		}
		
		
	}
	
	
	protected void do_btnSearchBill_actionPerformed(ActionEvent e) {
		resertStatusBill();
		cl.show(contentPane,"name_8459342237000");
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		resertStatusBill();
	}
	protected void do_spinnerSale_stateChanged(ChangeEvent e) {
		totalBill();
		
	}
	
	protected void do_spinnerSale_keyReleased(KeyEvent e) {
		totalBill();
	}
	
	protected void do_btnMet_actionPerformed(ActionEvent e) {
		cl.show(contentPane,"name_354575640624600");
				
	}
	protected void btnPrintBillActionPerformed(ActionEvent e) {
		var id = BillDao.printBill(bill.getIdBill());
		var id_1 = BillDao.printBill_1(bill.getIdBill());
		report = new JReportBill();
		report.setVisible(true);
		report.setBill(id);
		
		report.showBill();
		
	}
	protected void btnLogoutActionPerformed(ActionEvent e) {
		Login login = new Login();
//		HomePage home = new HomePage();
		homePage.getNot().dispose();
		homePage.dispose();
		dispose();
		
//		home.dispose();
		login.setVisible(true);
	}
}
