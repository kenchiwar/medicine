package gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.w3c.dom.events.Event;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.StaffDao;
import database.ConnectProperties;
import entity.Staff;
import helper.RegexConst;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

public class EmployeePane extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textUsername;
	private JTextField textLastname;
	private JTextField textCccd;
	private JDateChooser dateBirth;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;
	private JTextField textPhone;
	private JButton btnAddEp;
	private JButton btnUpdateEp;
	private JButton btnDeleteEp;
	private JButton btnFindEp;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnFirstBut;
	private JButton btnPriBut;
	private JButton btnNextBut;
	private JButton btnLastBut;
	private JTextField textPage;
	private JLabel lblStatusPage;
	private JLabel lblTotalRows;
	
	private Staff staff;
	private List<Staff> list;
	
	Integer pageNumber = 1;
	Integer rowOfPage = 15;
	Integer totalRows = 0;
	Double totalPage = 0.0;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_7;
	private JTextField textPassword;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JLabel lblNewLabel_9;
	private JTextField textShift;
	private JTextField textMail;
	String status;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JTextField textNumHome;
	private JTextField textNameHome;
	private JTextField textWard;
	private JTextField textCounty;
	private JTextField textCity;
	private JTextField textCountry;
	private JTextField textIdAddress;
	private JTextField textidStaff;
	private JLabel lblIdaddress;
	private JLabel lblIdstaff;
	private JTextField txtSearch;
	private JButton btnRefesh;
	private JButton btnClear;
	private JLabel lblNewLabel_1;
	private JTextField textFirstname;
	private JButton btnShowDel;
	/**
	 * Create the panel.
	 */
	public EmployeePane() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		setBackground(new Color(202, 207, 254));
		
		lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNewLabel_2 = new JLabel("Last name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNewLabel_3 = new JLabel("Birth:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNewLabel_4 = new JLabel("Gender:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNewLabel_5 = new JLabel("Phone:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		
		textLastname = new JTextField();
		textLastname.setColumns(10);
		
		textCccd = new JTextField();
		textCccd.setColumns(10);
		
		dateBirth = new JDateChooser();
		dateBirth.setDateFormatString("YYYY/MM/dd");
		
		lblNewLabel_6 = new JLabel("CCCD:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNewLabel_8 = new JLabel("Mail:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		
		btnAddEp = new JButton("Add");
		btnAddEp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddEp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed_1(e);
			}
		});
		
		btnUpdateEp = new JButton("Update");
		btnUpdateEp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateEp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed_1(e);
			}
		});
		
		btnDeleteEp = new JButton("Delete");
		btnDeleteEp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteEp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed_1(e);
			}
		});
		
		btnFindEp = new JButton("Search");
		btnFindEp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFindEp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFindEpActionPerformed(e);
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		btnFirstBut = new JButton("<<");
		btnFirstBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed(e);
			}
		});
		btnFirstBut.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnPriBut = new JButton("<");
		btnPriBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed(e);
			}
		});
		btnPriBut.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnNextBut = new JButton(">");
		btnNextBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed(e);
			}
		});
		btnNextBut.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnLastBut = new JButton(">>");
		btnLastBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed(e);
			}
		});
		btnLastBut.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textPage = new JTextField();
		textPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed(e);
			}
		});
		textPage.setColumns(10);
		
		lblStatusPage = new JLabel("Page 1");
		lblStatusPage.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblTotalRows = new JLabel("Rows count 0");
		lblTotalRows.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(202, 207, 254));
//		rdbtnMale.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				rdbtnMaleActionPerformed(e);
//			}
//		});
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setSelected(true);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(202, 207, 254));
//		rdbtnFemale.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				rdbtnFemaleActionPerformed(e);
//			}
//		});
		buttonGroup.add(rdbtnFemale);
		
		lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Shift:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textShift = new JTextField();
		textShift.setColumns(10);
		
		textMail = new JTextField();
		textMail.setColumns(10);
		
		lblNewLabel_10 = new JLabel("Num Home:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNewLabel_11 = new JLabel("Street:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNewLabel_12 = new JLabel("Ward:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNewLabel_13 = new JLabel("County:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNewLabel_14 = new JLabel("City:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNewLabel_15 = new JLabel("Country:");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textNumHome = new JTextField();
		textNumHome.setColumns(10);
		
		textNameHome = new JTextField();
		textNameHome.setColumns(10);
		
		textWard = new JTextField();
		textWard.setColumns(10);
		
		textCounty = new JTextField();
		textCounty.setColumns(10);
		
		textCity = new JTextField();
		textCity.setColumns(10);
		
		textCountry = new JTextField();
		textCountry.setColumns(10);
		
		textIdAddress = new JTextField();
		textIdAddress.setEditable(false);
		textIdAddress.setColumns(10);
		
		textidStaff = new JTextField();
		textidStaff.setEditable(false);
		textidStaff.setColumns(10);
		
		lblIdaddress = new JLabel("IdAddress:");
		lblIdaddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblIdstaff = new JLabel("IdStaff:");
		lblIdstaff.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtSearch.setColumns(10);
		
		btnRefesh = new JButton("Refesh");
		btnRefesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefeshActionPerformed(e);
			}
		});
		btnRefesh.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClearActionPerformed(e);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		setLayout(null);
		
		lblNewLabel_1 = new JLabel("First name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textFirstname = new JTextField();
		textFirstname.setColumns(10);
		
		btnShowDel = new JButton("Show delete");
		btnShowDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActionPerformed_1(e);
			}
		});
		btnShowDel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(112)
					.addComponent(btnRefesh, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(67)
					.addComponent(btnAddEp, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(77)
					.addComponent(btnUpdateEp, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(67)
					.addComponent(btnDeleteEp, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(273))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(112)
					.addComponent(btnClear, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(67)
					.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
					.addGap(16)
					.addComponent(btnFindEp, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(281))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(lblIdstaff, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(textidStaff, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(42)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(dateBirth, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(lblNewLabel_10)
					.addGap(26)
					.addComponent(textNumHome, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addGap(204))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdaddress, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textIdAddress, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(textUsername, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(textPassword, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(textFirstname, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(rdbtnMale, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textCccd, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
							.addGap(23))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textPhone, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
							.addGap(23))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textMail, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
							.addGap(23)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_13)
						.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textNameHome, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(textWard, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(textCounty, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(textCity, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
					.addGap(204))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(textLastname, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(48)
					.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(textShift, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(textCountry, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addGap(204))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(lblStatusPage)
							.addGap(123)
							.addComponent(btnFirstBut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnPriBut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(42)
							.addComponent(textPage, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
							.addGap(39)
							.addComponent(btnNextBut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(btnLastBut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(31)
							.addComponent(lblTotalRows, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
							.addGap(69)
							.addComponent(btnShowDel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)))
					.addGap(22))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(8)
									.addComponent(lblStatusPage))
								.addComponent(btnFirstBut)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(btnPriBut))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(textPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(btnNextBut))
								.addComponent(btnLastBut)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(8)
									.addComponent(lblTotalRows)))
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRefesh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddEp, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpdateEp, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDeleteEp, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(19)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(btnFindEp, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIdstaff, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(textidStaff, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateBirth, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(textNumHome, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(30)
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblIdaddress, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
									.addGap(20)
									.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textIdAddress, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addComponent(textUsername, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(19)
									.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addGap(21)
									.addComponent(textFirstname, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnMale)
										.addComponent(rdbtnFemale))
									.addGap(13)
									.addComponent(textCccd, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(22)
									.addComponent(textPhone, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(textMail, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addGap(15)
									.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(16)
									.addComponent(textNameHome, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textWard, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textCounty, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textCity, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(textLastname, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_9))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(textShift, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(textCountry, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnShowDel)))
					.addGap(61))
		);
		setLayout(groupLayout);
		
		selectStaffTable();
		
		
	}
	
	private void selectStaffTable() {
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClassStaff(int column){
				switch(column) {
				case 0: return Integer.class;
				case 1: return String.class;
				case 2: return String.class;
				case 3: return String.class;
				case 4:return Integer.class;
				case 5: return String.class;
				case 6: return String.class;
				case 7:return String.class;
				case 8: return Boolean.class;
				case 9: return String.class;
				case 10: return String.class;
				case 11: return String.class;
				default: return Boolean.class;
				}
			}
		};
		model.addColumn("IdStaff");
		model.addColumn("Username");
//		model.addColumn("Password");
		model.addColumn("FirstName");
		model.addColumn("LastName");
		model.addColumn("Rank");
		model.addColumn("Shift");
		model.addColumn("Address");
		model.addColumn("BirthDay");
		model.addColumn("Gender");
		model.addColumn("NumPhone");
		model.addColumn("CCCD");
		model.addColumn("Gmail");
		model.addColumn("DeleteStatus");
		
		StaffDao DaoSt = new StaffDao();
		
		totalRows = DaoSt.countStaff();
		totalPage= Math.ceil(totalRows.doubleValue() / rowOfPage.doubleValue());
		lblStatusPage.setText("Page "+pageNumber);
		lblTotalRows.setText("Rown count: " + totalRows);
		
		DaoSt.selStaff(pageNumber,rowOfPage).stream().filter(i->i.isDeleteStatus()==false).forEach(
				staff->model.addRow(new Object[] {
						staff.getIdStaff(), staff.getUsername(), staff.getFirstName(), staff.getLastName(),staff.getRank_1()==1?"Employee":"Boss",
						staff.getShift(),staff.getNumHome()+", "+staff.getNameHome()+", "+staff.getWard()+ ", "+ staff.getCounty()+", "+staff.getCity()+", "+staff.getCountry()
						,staff.getBirthDay(),staff.isGender()?"Male":"Female",staff.getNumPhone(),staff.getCccd(),staff.getGmail(),
						staff.isDeleteStatus()?"OFF":"WORKING"
				})
				);
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(true);
		table.setAutoCreateRowSorter(true);

		table.setRowHeight(20);
		
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(6).setMinWidth(150);
		table.getColumnModel().getColumn(7).setMinWidth(100);
		table.getColumnModel().getColumn(8).setMinWidth(100);

		table.getColumnModel().getColumn(9).setMinWidth(100);
		table.getColumnModel().getColumn(10).setMinWidth(100);
		table.getColumnModel().getColumn(11).setMinWidth(100);
		table.getColumnModel().getColumn(12).setMinWidth(100);
	}
	
	
	protected void btnActionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnFirstBut)) {
			pageNumber = 1;
			textPage.setText(pageNumber.toString());
			selectStaffTable();
			}else if(e.getSource().equals(btnPriBut)) {
			if(pageNumber > 1) {
			pageNumber--;
			textPage.setText(pageNumber.toString());
			selectStaffTable();
			}
		}else if(e.getSource().equals(btnNextBut)) {
			if(pageNumber < totalPage.intValue()) {
			pageNumber++;
			textPage.setText(pageNumber.toString());
			selectStaffTable();
			}
		}else if(e.getSource().equals(btnLastBut)) {
			pageNumber = totalPage.intValue();
			textPage.setText(pageNumber.toString());
			selectStaffTable();
			
		}else {
			String errPage = textPage.getText();
			var valid= Pattern.compile(RegexConst.NUM).matcher(errPage);
			if(!valid.matches()) {
				JOptionPane.showMessageDialog(null, "Just input to string!");
				textPage.setText(null);
			}else {
				int page = Integer.parseInt(textPage.getText());
				if(page >=1 && page <= totalPage.intValue()) {
					pageNumber = page;
					selectStaffTable();
				}else {
					JOptionPane.showMessageDialog(null, "Page must be 1 to " + totalPage.intValue());
					textPage.setText(pageNumber.toString());
				}
			}
			
		}
	}
	
	protected void tableMouseClicked(MouseEvent e) {
		Staff sta = new Staff();
		int[] rows = table.getSelectedRows();
		if(rows.length > 0) {
			int id=Integer.valueOf(table.getModel().getValueAt(rows[0],0).toString());
//			StaffDao IdCus = new StaffDao();
			staff = StaffDao.getStaffById(id);
		}
		
		
		//list.stream().filter(i->i.getIdStaff()==id).forEach(i->staff=i);
		
		try {
			textIdAddress.setText(String.valueOf(staff.getIdAddress()));
			textidStaff.setText(String.valueOf(staff.getIdStaff()));
			textUsername.setText(staff.getUsername());
			textFirstname.setText(staff.getFirstName());
			textLastname.setText(staff.getLastName());
			try {
				dateBirth.setDate(
						//LocalDate.ofInstant(Birthday1.getDate().toInstant(),ZoneId.systemDefault()) 
						Date.from(staff.getBirthDay().atStartOfDay(ZoneId.systemDefault()).toInstant())
				);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			textPhone.setText(staff.getNumPhone());
			textCccd.setText(staff.getCccd());
			textMail.setText(staff.getGmail());
			textShift.setText(staff.getShift());
//			textPassword.setText(staff.getPassword());
			if(staff.isGender()==true) {
				rdbtnMale.setSelected(true);
			}else {
				rdbtnFemale.setSelected(true);
			}
			
			textNumHome.setText(staff.getNumHome());
			textNameHome.setText(staff.getNameHome());
			textWard.setText(staff.getWard());
			textCounty.setText(staff.getCounty());
			textCity.setText(staff.getCity());
			textCountry.setText(staff.getCountry());
		} catch (Exception e2) {
			e2.getMessage();
		}
	}
	
	
	
	protected void btnActionPerformed_1(ActionEvent e) {
		String userName = textUsername.getText();
		String password = textPassword.getText();
		String firstName = textFirstname.getText();
		String lastName = textLastname.getText();
//		LocalDate birth = LocalDate.ofInstant(dateBirth.getDate().toInstant(),ZoneId.systemDefault());
		String cccd = textCccd.getText();
		String phone = textPhone.getText();
		String mail = textMail.getText();
		String shift = textShift.getText();
		String numHome = textNumHome.getText();
		String street = textNameHome.getText();
		String ward = textWard.getText();
		String country = textCountry.getText();
		String city = textCity.getText();
		String county = textCounty.getText();
		
		var validUser= Pattern.compile(RegexConst.PASS).matcher(userName);
		var validPass= Pattern.compile(RegexConst.PASS).matcher(password);
		var validFirstname= Pattern.compile(RegexConst.CHARS).matcher(firstName);
		var validLastname= Pattern.compile(RegexConst.CHARS).matcher(lastName);
		var validCccd= Pattern.compile(RegexConst.NUM).matcher(cccd);
		var validPhone= Pattern.compile(RegexConst.PHONE).matcher(phone);
		var validMail= Pattern.compile(RegexConst.MAIL).matcher(mail);
		var validShift= Pattern.compile(RegexConst.CHARS_NUM).matcher(shift);
		var validNumhome= Pattern.compile(RegexConst.NUM).matcher(numHome);
		var validStreet= Pattern.compile(RegexConst.CHARS).matcher(street);
		var validWard= Pattern.compile(RegexConst.CHARS_NUM).matcher(ward);
		var validCountry= Pattern.compile(RegexConst.CHARS).matcher(country);
		var validCity= Pattern.compile(RegexConst.CHARS).matcher(city);
		var validCounty= Pattern.compile(RegexConst.CHARS).matcher(country);
		
		if(e.getSource().equals(btnAddEp)) {
			if(!validUser.matches()) {
				JOptionPane.showMessageDialog(null, "Username validation!");
				textUsername.setText(null);
			}
			
			else if(!validPass.matches()) {
				JOptionPane.showMessageDialog(null, "Password validation!");
				textPassword.setText(null);
			}
			
			else if(!validLastname.matches()) {
				JOptionPane.showMessageDialog(null, "Last name validation!");
				textLastname.setText(null);
			}
			else if(!validFirstname.matches()) {
				JOptionPane.showMessageDialog(null, "First name validation!");
				textFirstname.setText(null);
			}
			else if(dateBirth.getDate() == null) {
				JOptionPane.showMessageDialog(null, "Date of birth validation!");
			}
			else if(cccd.length()!=12|| !validCccd.matches()) {
				JOptionPane.showMessageDialog(null, "CCCD validation!");
				textCccd.setText(null);
			}
			else if(!validPhone.matches()) {
				JOptionPane.showMessageDialog(null, "Phone validation!");
				textPhone.setText(null);
			}
			else if(!validMail.matches()) {
				JOptionPane.showMessageDialog(null, "Mail validation!");
				textMail.setText(null);
			}
			else if(!validShift.matches()) {
				JOptionPane.showMessageDialog(null, "Shift validation!");
				textShift.setText(null);
			}
			else if(!validNumhome.matches()|| numHome.length()>=5) {
				JOptionPane.showMessageDialog(null, "Num home validation!");
				textNumHome.setText(null);
			}
			else if(!validStreet.matches()){
				JOptionPane.showMessageDialog(null, "Street name validation!");
				textNameHome.setText(null);
			}
			
			else if(!validWard.matches()) {
				JOptionPane.showMessageDialog(null, "Ward validation!");
				textWard.setText(null);
			}
			else if(!validCounty.matches()) {
				JOptionPane.showMessageDialog(null, "County validation!");
				textCounty.setText(null);
			}
			else if(!validCity.matches()) {
				JOptionPane.showMessageDialog(null, "City validation!");
				textCity.setText(null);
			}
			
			else if(!validCountry.matches()) {
				JOptionPane.showMessageDialog(null, "Country validation!");
				textCountry.setText(null);
			}
			else {
				boolean gender = true;
				if(rdbtnMale.isSelected()) {
					gender = true;
				}else gender = false;
				
				int p = JOptionPane.showConfirmDialog(null, "Are you sure add this record?","Add record",JOptionPane.YES_NO_OPTION);
				if(p==0) {
					
					Staff staff = new Staff();
					
					staff.setUsername(textUsername.getText());
					staff.setPassword(textPassword.getText());
					staff.setFirstName(textFirstname.getText());
					staff.setLastName(textLastname.getText());			
					staff.setBirthDay(LocalDate.ofInstant(dateBirth.getDate().toInstant(),ZoneId.systemDefault()));	 
					staff.setShift(textShift.getText());
					staff.setGender(gender);
					staff.setNumPhone(textPhone.getText());
					staff.setCccd(textCccd.getText());
					staff.setGmail(textMail.getText());
					staff.setNumHome(textNumHome.getText());
					staff.setNameHome(textNameHome.getText());
					staff.setWard(textWard.getText());
					staff.setCounty(textCounty.getText());
					staff.setCity(textCity.getText());
					staff.setCountry(textCountry.getText());
					
					StaffDao staffDao = new StaffDao();
					if(staffDao.erroUserStaff(staff.getUsername())==true){
						JOptionPane.showMessageDialog(null,"Username number already in use ");
						textUsername.setText(null);}
					
					else if(staffDao.erroPhoneStaff(staff.getNumPhone())==true) {
						JOptionPane.showMessageDialog(null,"Phone number already in use ");
						textPhone.setText(null);
					}	
					else if(staffDao.erroCCCDStaff(staff.getCccd())==true) {
						JOptionPane.showMessageDialog(null,"CCCD number already in use ");
						textCccd.setText(null);
					}	
					else if(staffDao.erroMailStaff(staff.getGmail())==true) {
						JOptionPane.showMessageDialog(null,"Mail number already in use ");
						textMail.setText(null);
					}
					
					else {
						StaffDao.InsertStaff(staff);
						textUsername.setText(null);
						textPassword.setText(null);
						textFirstname.setText(null);
						textLastname.setText(null);
						dateBirth.setDate(null);
						rdbtnMale.setSelected(true);
						rdbtnFemale.setSelected(false);
						textCccd.setText(null);
						textPhone.setText(null);
						textMail.setText(null);
						textNumHome.setText(null);
						textNameHome.setText(null);
						textCounty.setText(null);
						textCity.setText(null);
						textWard.setText(null);
						textCountry.setText(null);
						textShift.setText(null);
						}
					
					
					
					selectStaffTable();
				}
			}
		}
		else if(e.getSource().equals(btnUpdateEp)) {
			if(!validUser.matches()) {
				JOptionPane.showMessageDialog(null, "Username validation!");
				textUsername.setText(null);
			}
			
			else if(!validPass.matches()) {
				JOptionPane.showMessageDialog(null, "Password validation!");
				textPassword.setText(null);
			}
			
			else if(!validLastname.matches()) {
				JOptionPane.showMessageDialog(null, "Last name validation!");
				textLastname.setText(null);
			}
			else if(!validFirstname.matches()) {
				JOptionPane.showMessageDialog(null, "First name validation!");
				textFirstname.setText(null);
			}
			else if(dateBirth.getDate() == null) {
				JOptionPane.showMessageDialog(null, "Date of birth validation!");
			}
			else if(!validCccd.matches() || cccd.length()!=12)  {
				JOptionPane.showMessageDialog(null, "CCCD validation!");
				textCccd.setText(null);
			}
			else if(!validPhone.matches()) {
				JOptionPane.showMessageDialog(null, "Phone validation!");
				textPhone.setText(null);
			}
			else if(!validMail.matches()) {
				JOptionPane.showMessageDialog(null, "Mail validation!");
				textMail.setText(null);
			}
			else if(!validShift.matches()) {
				JOptionPane.showMessageDialog(null, "Shift validation!");
				textShift.setText(null);
			}
			else if(!validNumhome.matches() || numHome.length()>=5) {
				JOptionPane.showMessageDialog(null, "Num home validation!");
				textNumHome.setText(null);
			}
			else if(!validStreet.matches()){
				JOptionPane.showMessageDialog(null, "Street name validation!");
				textNameHome.setText(null);
			}
			
			else if(!validWard.matches()) {
				JOptionPane.showMessageDialog(null, "Ward validation!");
				textWard.setText(null);
			}
			else if(!validCounty.matches()) {
				JOptionPane.showMessageDialog(null, "County validation!");
				textCounty.setText(null);
			}
			else if(!validCity.matches()) {
				JOptionPane.showMessageDialog(null, "City validation!");
				textCity.setText(null);
			}
			
			else if(!validCountry.matches()) {
				JOptionPane.showMessageDialog(null, "Country validation!");
				textCountry.setText(null);
			}
			else {
				boolean gender = true;
				if(rdbtnMale.isSelected()) {
					gender = true;
				}else gender = false;
				
				int[] rows = table.getSelectedRows();
				int idStaff=Integer.valueOf(table.getValueAt(rows[0],0).toString());
				staff = StaffDao.errDel(idStaff);
				if(staff.getRank_1()==0) {
					JOptionPane.showMessageDialog(null, "Error update!!!");
					selectStaffTable();
				}else {
				int p = JOptionPane.showConfirmDialog(null, "Are you sure update this record?","Update record",JOptionPane.YES_NO_OPTION);
				if(p==0) {
					
					Staff sta = new Staff();
					
					sta.setUsername(textUsername.getText());
					sta.setPassword(textPassword.getText());
					sta.setFirstName(textFirstname.getText());
					sta.setLastName(textLastname.getText());
					sta.setBirthDay(LocalDate.ofInstant(dateBirth.getDate().toInstant(),ZoneId.systemDefault())); 
					sta.setShift(textShift.getText());
					sta.setGender(gender);
					sta.setNumPhone(textPhone.getText());
					sta.setCccd(textCccd.getText());
					sta.setGmail(textMail.getText());
					sta.setNumHome(textNumHome.getText());
					sta.setNameHome(textNameHome.getText());
					sta.setWard(textWard.getText());
					sta.setCounty(textCounty.getText());
					sta.setCity(textCity.getText());
					sta.setCountry(textCountry.getText());
					sta.setIdAddress(Integer.parseInt(textIdAddress.getText())); 
					sta.setIdStaff(Integer.parseInt(textidStaff.getText()));
					
					StaffDao.updateStaff(sta);	
					
					selectStaffTable();
				}
			}
		}
		}else if(e.getSource().equals(btnDeleteEp)) {
				
		int[] rows = table.getSelectedRows();
		int idStaff=Integer.valueOf(table.getValueAt(rows[0],0).toString());
		staff = StaffDao.errDel(idStaff);
		if(staff.getRank_1()==0) {
			JOptionPane.showMessageDialog(null, "Error delete!!!");
			selectStaffTable();
		}else {
		int p = JOptionPane.showConfirmDialog(null, "Are you sure delete?", "Delete success!", JOptionPane.YES_NO_OPTION);
		if(p == 0) {
			StaffDao.statusDelete(idStaff);
			selectStaffTable();}
		}
		
		}else if(e.getSource().equals(btnShowDel)) {
			DefaultTableModel model = new DefaultTableModel() {
				public Class<?> getColumnClassStaff(int column){
					switch(column) {
					case 0: return Integer.class;
					case 1: return String.class;
					case 2: return String.class;
					case 3: return String.class;
					case 4:return Integer.class;
					case 5: return String.class;
					case 6: return String.class;
					case 7:return String.class;
					case 8: return Boolean.class;
					case 9: return String.class;
					case 10: return String.class;
					case 11: return String.class;
					default: return Boolean.class;
					}
				}
			};
			model.addColumn("IdStaff");
			model.addColumn("Username");
//			model.addColumn("Password");
			model.addColumn("FirstName");
			model.addColumn("LastName");
			model.addColumn("Rank");
			model.addColumn("Shift");
			model.addColumn("Address");
			model.addColumn("BirthDay");
			model.addColumn("Gender");
			model.addColumn("NumPhone");
			model.addColumn("CCCD");
			model.addColumn("Gmail");
			model.addColumn("DeleteStatus");
			
			StaffDao DaoSt = new StaffDao();
			
			totalRows = DaoSt.countStaff();
			totalPage= Math.ceil(totalRows.doubleValue() / rowOfPage.doubleValue());
			lblStatusPage.setText("Page "+pageNumber);
			lblTotalRows.setText("Rown count: " + totalRows);
			
			DaoSt.selStaff(pageNumber,rowOfPage).stream().filter(i->i.isDeleteStatus()==true).forEach(
					staff->model.addRow(new Object[] {
							staff.getIdStaff(), staff.getUsername(), staff.getFirstName(), staff.getLastName(),staff.getRank_1()==1?"Employee":"Boss",
							staff.getShift(),staff.getNumHome()+", "+staff.getNameHome()+", "+staff.getWard()+ ", "+ staff.getCounty()+", "+staff.getCity()+", "+staff.getCountry()
							,staff.getBirthDay(),staff.isGender()?"Male":"Female",staff.getNumPhone(),staff.getCccd(),staff.getGmail(),
							staff.isDeleteStatus()?"OFF":"WORKING"
					})
					);
			table.setModel(model);
			table.getTableHeader().setReorderingAllowed(true);
			table.setAutoCreateRowSorter(true);

			table.setRowHeight(20);
			
			table.getColumnModel().getColumn(0).setMinWidth(100);
			table.getColumnModel().getColumn(1).setMinWidth(100);
			table.getColumnModel().getColumn(2).setMinWidth(100);
			table.getColumnModel().getColumn(3).setMinWidth(100);
			table.getColumnModel().getColumn(4).setMinWidth(100);
			table.getColumnModel().getColumn(5).setMinWidth(100);
			table.getColumnModel().getColumn(6).setMinWidth(150);
			table.getColumnModel().getColumn(7).setMinWidth(100);
			table.getColumnModel().getColumn(8).setMinWidth(100);

			table.getColumnModel().getColumn(9).setMinWidth(100);
			table.getColumnModel().getColumn(10).setMinWidth(100);
			table.getColumnModel().getColumn(11).setMinWidth(100);
			table.getColumnModel().getColumn(12).setMinWidth(100);
		}
}
	


	protected void btnFindEpActionPerformed(ActionEvent e) {

		String phone =txtSearch.getText();
		String firstName = txtSearch.getText();
		String lastName = txtSearch.getText();
	
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClassStaff(int column){
				switch(column) {
				case 0: return Integer.class;
				case 1: return String.class;
//				case 2: return String.class;
				case 2: return String.class;
				case 3: return String.class;
				case 4:return Integer.class;
				case 5: return String.class;
				case 6: return String.class;
				case 7:return String.class;
				case 8: return Boolean.class;
				case 9: return String.class;
				case 10: return String.class;
				case 11: return String.class;
				default: return Boolean.class;
				}
			}
		};
		model.addColumn("IdStaff");
		model.addColumn("Username");
//		model.addColumn("Password");
		model.addColumn("FirstName");
		model.addColumn("LastName");
		model.addColumn("Rank");
		model.addColumn("Shift");
		model.addColumn("Address");
		model.addColumn("BirthDay");
		model.addColumn("Gender");
		model.addColumn("NumPhone");
		model.addColumn("CCCD");
		model.addColumn("Gmail");
		model.addColumn("DeleteStatus");
		
		StaffDao Dao = new StaffDao();
		
		Dao.searchStaff(phone, firstName, lastName).stream()
		.forEach(
				staff->model.addRow(new Object[] {
				staff.getIdStaff(), staff.getUsername(), staff.getFirstName(), staff.getLastName(),
				staff.getRank_1()==1?"Employee":"Boss",
				staff.getShift(),staff.getNumHome()+", "+staff.getNameHome()+", "+staff.getWard()+ ", "+ 
				staff.getCounty()+", "+staff.getCity()+", "+staff.getCountry()
				,staff.getBirthDay(),staff.isGender()?"Nam":"Nu",staff.getNumPhone(),staff.getCccd(),staff.getGmail(),
				staff.isDeleteStatus()?"OFF":"WORKING"
		})
				);


		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(true);
		table.setAutoCreateRowSorter(true);

		table.setRowHeight(20);
		
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(6).setMinWidth(150);
		table.getColumnModel().getColumn(7).setMinWidth(100);
		table.getColumnModel().getColumn(8).setMinWidth(100);

		table.getColumnModel().getColumn(9).setMinWidth(100);
		table.getColumnModel().getColumn(10).setMinWidth(100);
		table.getColumnModel().getColumn(11).setMinWidth(100);
		table.getColumnModel().getColumn(12).setMinWidth(100);
//		table.getColumnModel().getColumn(13).setMinWidth(100);
		
		}
	protected void btnRefeshActionPerformed(ActionEvent e) {
		selectStaffTable();
	}
	
	protected void btnClearActionPerformed(ActionEvent e) {
		textIdAddress.setText(null);
		textidStaff.setText(null);
		textUsername.setText(null);
		textPassword.setText(null);
		textFirstname.setText(null);
		textLastname.setText(null);
		dateBirth.setDate(null);
		rdbtnMale.setSelected(true);
		rdbtnFemale.setSelected(false);
		textCccd.setText(null);
		textPhone.setText(null);
		textMail.setText(null);
		textNumHome.setText(null);
		textNameHome.setText(null);
		textCounty.setText(null);
		textCity.setText(null);
		textWard.setText(null);
		textCountry.setText(null);
		textShift.setText(null);
	}
}
