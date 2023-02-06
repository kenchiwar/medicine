package gui;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.BillDao;
import dao.DetailBillDao;
import dao.MedicineDao;
import entity.Bill;
import entity.Customer;
import entity.DetaiBill;
import entity.Medicine;
import entity.Staff;
import entity.ThongKeBill;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Adjustable;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;

//import quick.dbtable.DBTable;



public class StatisticalBill extends JPanel {
	private JPanel statisticalBillJpanel;
	private JLabel lblAAA;
	private JPanel bbb;
	private JPanel aaa;
	private JPanel ccc;
	private JScrollPane scrollfff;
	private JTable tableDetailBill;
	private JLabel lblCusomer;
	private JTextField textTurnover;
	private JLabel lblNewLabel_5;
	private JTextField textField_4;
	private JLabel lblNumPhone;
	private JTextField textImport;
	private JPanel eee;
	//Code tự tay tạo
	
	private Bill bill;
	private List<ThongKeBill> arrayBill;
	private Staff staff1;
	private Customer customer;
	
	private List<DetaiBill> arrayDetailBill;
	
			//đống code để check trạng jtable paging
		private int stt=0;
		private int nowPlace=1;
		private int minimum=1;
		private int maximum;
		private int nowColum=20;
		private int total;
		private boolean status=true;
	private JPanel fff;
	private JScrollPane scrollggg;
	private JTable tableBill;
	private JPanel panelEEE;
	private JSpinner spinner;
	private JLabel lblDDD;
	private JButton btnPrevious;
	private JButton btnNext;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JRadioButton rdbtnIdBill;
	private final ButtonGroup typeSearch = new ButtonGroup();
	private JRadioButton rdbtnIdNameCustomer;
	private JRadioButton rdbtnNameStaff;
	private JRadioButton rdbtnNgayLap;
	private JComboBox comboBox;
	private JButton btnNewButton_2;
	private JSpinner spinnerColum;
	private JPanel panel_1;
	private JSeparator separator;
	private JLabel lblidBill;
	private JTextField textDay;
	private JPanel panel_2;
	private JLabel lblDateSell;
	private JTextField textMonth;
	private JLabel lblStaff;
	private JTextField textMothImport;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JButton btnNewButton;
	private JSeparator separator_1;
	private final ButtonGroup timeSearch = new ButtonGroup();
	private JLabel lblNewLabel_1;
	private JDateChooser dateChooser;
	private JButton btnNewButton_1;

	/**
	 * Create the panel.
	 */
	public StatisticalBill() {
		setBackground(new Color(0, 255, 255));
		setLayout(new CardLayout(0, 0));
		
		statisticalBillJpanel = new JPanel();
		statisticalBillJpanel.setBackground(new Color(0, 255, 255));
		add(statisticalBillJpanel, "name_6688207525700");
		
		lblAAA = new JLabel("BILL");
		lblAAA.setOpaque(true);
		lblAAA.setBackground(new Color(0, 255, 255));
		lblAAA.setForeground(new Color(255, 0, 0));
		lblAAA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAAA.setHorizontalAlignment(SwingConstants.CENTER);
		
		bbb = new JPanel();
		bbb.setBackground(new Color(0, 255, 255));
		bbb.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Bill Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		
		aaa = new JPanel();
		aaa.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		ccc = new JPanel();
		ccc.setBackground(new Color(0, 255, 255));
		ccc.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Statiscal Bill", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		
		eee = new JPanel();
		eee.setBackground(new Color(0, 255, 255));
		eee.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_statisticalBillJpanel = new GroupLayout(statisticalBillJpanel);
		gl_statisticalBillJpanel.setHorizontalGroup(
			gl_statisticalBillJpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statisticalBillJpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_statisticalBillJpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_statisticalBillJpanel.createSequentialGroup()
							.addComponent(aaa, GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
							.addGap(7))
						.addGroup(gl_statisticalBillJpanel.createSequentialGroup()
							.addComponent(ccc, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(bbb, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)))
					.addGap(1))
				.addGroup(gl_statisticalBillJpanel.createSequentialGroup()
					.addGap(18)
					.addComponent(eee, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_statisticalBillJpanel.createSequentialGroup()
					.addGap(29)
					.addComponent(lblAAA, GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
					.addGap(38))
		);
		gl_statisticalBillJpanel.setVerticalGroup(
			gl_statisticalBillJpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statisticalBillJpanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAAA, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_statisticalBillJpanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(bbb, 0, 0, Short.MAX_VALUE)
						.addComponent(ccc, GroupLayout.PREFERRED_SIZE, 296, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(eee, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(aaa, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		aaa.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBackground(new Color(0, 255, 255));
		aaa.add(panel, BorderLayout.CENTER);
		
		lblNewLabel = new JLabel("Enter Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setText("");
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Status");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		rdbtnIdBill = new JRadioButton("Id Bill");
		typeSearch.add(rdbtnIdBill);
		rdbtnIdBill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		rdbtnIdNameCustomer = new JRadioButton("Name Customer");
		typeSearch.add(rdbtnIdNameCustomer);
		rdbtnIdNameCustomer.setSelected(true);
		rdbtnIdNameCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		rdbtnNameStaff = new JRadioButton("Name Staff");
		typeSearch.add(rdbtnNameStaff);
		rdbtnNameStaff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		rdbtnNgayLap = new JRadioButton("Date(dd/MM/yyyy)");
		typeSearch.add(rdbtnNgayLap);
		rdbtnNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Yes Bill", "No Bill", "Retail"}));
		comboBox.setSelectedIndex(0);
		
		btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addGap(70)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(96)
							.addComponent(rdbtnIdBill, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(rdbtnIdNameCustomer, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(rdbtnNameStaff, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rdbtnNgayLap)
							.addGap(19)))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnIdNameCustomer, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnIdBill)
								.addComponent(rdbtnNameStaff, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnNgayLap, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		eee.setLayout(new BorderLayout(0, 0));
		
		fff = new JPanel();
		fff.setBackground(new Color(0, 255, 255));
		eee.add(fff, BorderLayout.CENTER);
		
		scrollggg = new JScrollPane();
		scrollggg.setBackground(new Color(0, 255, 255));
		scrollggg.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "List Bill", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		scrollggg.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollggg.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollggg.setAutoscrolls(true);
		
		tableBill = new JTable();
		tableBill.setSurrendersFocusOnKeystroke(true);
		tableBill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ListSelectionModel listSelectionModel= tableBill.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				int[] rows = tableBill.getSelectedRows();
				if(stt<=0) {
						if(rows.length>0) {
							
						if(stt<=0) {
							if(tableBill.getValueAt(rows[0], 1).toString()!=null) {
							selectDetailBill(tableBill.getValueAt(rows[0], 1).toString());
							}
						stt++;
						}else {
						stt=0;
						}
					}
						stt++;
				}else {
					stt=0;
				}
			}
		});
		tableBill.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"stt","Id Bill", "Date Sale", "Name Customer","Sale","Unit Price","Name Staff"
				}
			));
	
		scrollggg.setViewportView(tableBill);
		statisticalBillJpanel.setLayout(gl_statisticalBillJpanel);
		
		
		panelEEE = new JPanel();
		panelEEE.setBackground(new Color(0, 255, 255));
		GroupLayout gl_fff = new GroupLayout(fff);
		gl_fff.setHorizontalGroup(
			gl_fff.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_fff.createSequentialGroup()
					.addGroup(gl_fff.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_fff.createSequentialGroup()
							.addGap(260)
							.addComponent(panelEEE, GroupLayout.PREFERRED_SIZE, 248, Short.MAX_VALUE)
							.addGap(136))
						.addComponent(scrollggg, GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_fff.setVerticalGroup(
			gl_fff.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_fff.createSequentialGroup()
					.addComponent(scrollggg, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelEEE, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
		);
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_spinner_stateChanged(e);
			}
		});
		spinner.setModel(new SpinnerNumberModel(5, 5, 60, 5));
		spinner.setBounds(195, 3, 45, 20);
		
		lblDDD = new JLabel("met");
		lblDDD.setBounds(290, 6, 30, 13);
		
		btnPrevious = new JButton("Last");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPrevious_actionPerformed(e);
			}
		});
		btnPrevious.setBounds(100, 2, 85, 21);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNext_actionPerformed(e);
			}
		});
		btnNext.setBounds(331, 2, 85, 21);
		panelEEE.setLayout(null);
		panelEEE.add(btnPrevious);
		panelEEE.add(spinner);
		panelEEE.add(lblDDD);
		panelEEE.add(btnNext);
		
		spinnerColum = new JSpinner();
		spinnerColum.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_spinnerColum_stateChanged(e);
			}
		});
		spinnerColum.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerColum.setBounds(250, 3, 30, 20);
		panelEEE.add(spinnerColum);
		
		btnNewButton_1 = new JButton("Load Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(10, 2, 85, 21);
		panelEEE.add(btnNewButton_1);
		fff.setLayout(gl_fff);
		
		lblCusomer = new JLabel("Turnover");
		lblCusomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textTurnover = new JTextField();
		textTurnover.setEnabled(false);
		textTurnover.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTurnover.setColumns(10);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		lblNumPhone = new JLabel("Import");
		lblNumPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textImport = new JTextField();
		textImport.setEnabled(false);
		textImport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textImport.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Day", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "This Month ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		rdbtnNewRadioButton = new JRadioButton("Day");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnNewRadioButton_2_actionPerformed(e);
			}
		});
		timeSearch.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Month");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnNewRadioButton_2_actionPerformed(e);
			}
		});
		timeSearch.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Year");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnNewRadioButton_2_actionPerformed(e);
			}
		});
		timeSearch.add(rdbtnNewRadioButton_2);
		
		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		
		separator_1 = new JSeparator();
		separator_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		GroupLayout gl_ccc = new GroupLayout(ccc);
		gl_ccc.setHorizontalGroup(
			gl_ccc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ccc.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ccc.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_ccc.createSequentialGroup()
							.addGroup(gl_ccc.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_ccc.createSequentialGroup()
									.addGap(5)
									.addComponent(lblCusomer, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textTurnover, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
								.addGroup(gl_ccc.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_ccc.createSequentialGroup()
									.addComponent(lblNumPhone, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textImport, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
									.addGap(5)))
							.addGap(17))
						.addGroup(Alignment.TRAILING, gl_ccc.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_ccc.createSequentialGroup()
							.addGroup(gl_ccc.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 421, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_ccc.createSequentialGroup()
							.addGroup(gl_ccc.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_ccc.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_ccc.createSequentialGroup()
									.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnNewRadioButton_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton))
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
							.addGap(17))))
		);
		gl_ccc.setVerticalGroup(
			gl_ccc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ccc.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addGroup(gl_ccc.createParallelGroup(Alignment.LEADING)
						.addComponent(textTurnover, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCusomer, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ccc.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumPhone, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textImport, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ccc.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_ccc.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnNewRadioButton_1)
						.addComponent(rdbtnNewRadioButton_2)
						.addComponent(btnNewButton))
					.addGap(293)
					.addGroup(gl_ccc.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ccc.createSequentialGroup()
							.addGap(99)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_ccc.createSequentialGroup()
							.addGap(101)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		lblDateSell = new JLabel("Turnover");
		lblDateSell.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textMonth = new JTextField();
		textMonth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textMonth.setEnabled(false);
		textMonth.setColumns(10);
		
		lblStaff = new JLabel("Import");
		lblStaff.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textMothImport = new JTextField();
		textMothImport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textMothImport.setEnabled(false);
		textMothImport.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblDateSell, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textMonth, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblStaff, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textMothImport, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textMonth, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateSell, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStaff, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(2)
							.addComponent(textMothImport, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		separator = new JSeparator();
		separator.setForeground(new Color(64, 0, 64));
		separator.setBackground(new Color(64, 0, 0));
		panel_1.add(separator);
		
		lblidBill = new JLabel("Turnover");
		lblidBill.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblidBill);
		
		textDay = new JTextField();
		textDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textDay.setEnabled(false);
		textDay.setColumns(10);
		panel_1.add(textDay);
		ccc.setLayout(gl_ccc);
		bbb.setLayout(new CardLayout(0, 0));
		
		scrollfff = new JScrollPane();
		scrollfff.setBackground(new Color(0, 255, 255));
		bbb.add(scrollfff, "name_14548031606500");
		
		tableDetailBill = new JTable();
		tableDetailBill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ListSelectionModel listSelectionModel1= tableDetailBill.getSelectionModel();
		listSelectionModel1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		tableDetailBill.setBackground(new Color(255, 0, 0));
		scrollfff.setViewportView(tableDetailBill);
		statisticalBillJpanel.setLayout(gl_statisticalBillJpanel);
		tableDetailBill.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"stt","Name medicine", "Price", "Unit price","Amount","Sale","Unit Price"
				}
			));
		textDay.setText(BillDao.dayBillTotal());
		textMonth.setText(BillDao.monthBillTotal());
		textMothImport.setText(MedicineDao.monthMedicineTotal());
		arrayBill=BillDao.selectBill();
		pagingJtable();
		selectBill(arrayBill);

	}
	public void totalFunction() {
		//selectBill();
	}
	public void pagingJtable() {
		total=arrayBill.size();
		nowColum=5;
		maximum=( Math.round(total/nowColum))+1;
		spinner.setValue(5);
		minimum=1;
		nowPlace=1;
		spinnerColum.setModel(new SpinnerNumberModel(1, 1, maximum, 1));
		lblDDD.setText("/"+maximum);
		
	}

	//in giá trị mặc đinh để show table bill
	public void selectBill(List<ThongKeBill> array) {
		stt=1;
		
		
		DefaultTableModel model = new DefaultTableModel() {
			public Class getColumnClass(int column){
					switch(column) {
					case 0: return Integer.class;
					case 2:return LocalDate.class;
					case 4:return Float.class;
				
					default: return String.class;

					}	
			}
			 public boolean isCellEditable(int row, int column){
			        
			        return false;
			    }
		   
			
		};
		model.addColumn("stt");
		model.addColumn("ID Bill");
		model.addColumn("DateSale");
		model.addColumn("Name Customer");
		model.addColumn("Unit Price");
		model.addColumn("Name Staff");
		array.stream().filter(i->{
			if(stt> (nowPlace-1)*nowColum &&  stt<=nowPlace*nowColum) {
				return true;
			}
		stt++;
			return false;
		}).forEach(i->{
		model.addRow(new Object [] {
				stt++,
				i.getIdBill(),
				i.getDateFounder(),
				i.getNameCustomer(),
				i.getUnitPrice(),
				i.getNameStaff(),
		});
		
		}
		);
		tableBill.setModel(model);
		tableBill.getTableHeader().setReorderingAllowed(true);
		tableBill.getColumnModel().getColumn(1).setMinWidth(100);
		tableBill.setAutoCreateRowSorter(true);
		//tableBill.createControlPanel();
		stt=0;
		
	}
	//in gía trị cho bảng detail bill khi selected table bill
	public void selectDetailBill(String idBill) {
		stt=0;
		arrayDetailBill=DetailBillDao.selectDetailBill(idBill);
		DefaultTableModel model = new DefaultTableModel() {
			public Class getColumnClass(int column){
					switch(column) {
					
					case 10:	return Float.class;
					default: return String.class;

					}	
			}
			 public boolean isCellEditable(int row, int column){
			        
			        return false;
			    }
		   
			
		};
		model.addColumn("stt");
		model.addColumn("Name Medicine");
		model.addColumn("Unit");
		model.addColumn("Sale");
		model.addColumn("Amount");
		model.addColumn("Price");
		model.addColumn("Unit Price");
		arrayDetailBill.forEach(i->{
			model.addRow(new Object [] {
				++stt,
				i.getNameMedicine(),
				i.getUnit(),
				i.getSale(),
				i.getAmount(),
				i.getPriceOut(),
				i.getUnitPrice(),
				
			});
		});
		tableDetailBill.setModel(model);
		stt=0;
	
	}
	protected void do_btnNext_actionPerformed(ActionEvent e) {
		if(nowPlace==maximum) {
			return;
		}else {
			status=false;
			++nowPlace;
			spinnerColum.setValue(nowPlace);
			selectBill(arrayBill);
		}
		
	}
	protected void do_btnPrevious_actionPerformed(ActionEvent e) {
		if(nowPlace==1) {
			return;
		}else {
			status=false;
			--nowPlace;
			spinnerColum.setValue(nowPlace);
			selectBill(arrayBill);
		}
	}
	protected void do_spinner_stateChanged(ChangeEvent e) {
		nowColum=Integer.valueOf(spinner.getValue().toString());	
	maximum=( Math.round(total/nowColum))+1;

	minimum=1;
	status=false;	
	spinnerColum.setModel(new SpinnerNumberModel(1, 1, maximum, 1));
	nowPlace=1;
		lblDDD.setText("/"+maximum);	
		selectBill(arrayBill);
		
	}
	protected void do_spinnerColum_stateChanged(ChangeEvent e) {
		
		nowPlace=Integer.valueOf(spinnerColum.getValue().toString());		
			selectBill(arrayBill);
		
		
	}
	
	
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		String chan = "";
		 
		Enumeration<AbstractButton> group = typeSearch.getElements();
		while(group.hasMoreElements()) {
			AbstractButton b = group.nextElement();
			if(b.isSelected()) {
				switch(b.getText()) {
					case "Id Bill" : {
					chan+="IdBill like N'%"+textField.getText()+"%'"		;
					break ;}
					case "Name Customer" : {
						chan+="(Customer.FirstName + ' ' + Customer.LastName) like N'%"+textField.getText()+"%'"		;
					break ;
					}
					case "Name Staff" : {
						chan+="Staff.FirstName + ' ' + Staff.LastName like N'%"+textField.getText()+"%'"		;
						;
					break ;}
					case "Date(yyyy/MM/dd)" : {
						chan+="CONVERT(NVARCHAR,DateFounded,103)  like N'%"+textField.getText()+"%'";
					break ;}
					
				}
						
			}
		}
		
		
				switch(comboBox.getSelectedItem().toString()) {
				case "Yes Bill" : {
					
					break ;
				}
				case "No Bill" : {
					chan+="and IdCustomer=2";
					break ;
				}
				case "Retail" : {
					chan+="and IdCustomer=2";
					break ;
				}
			
			}
				arrayBill=BillDao.searchBill(chan);
				pagingJtable();
				selectBill(arrayBill);
			
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		if(dateChooser.getDate()==null) return;
		var text= "";
		Enumeration<AbstractButton>  met =  timeSearch.getElements();
		while(met.hasMoreElements()) {
			AbstractButton b =met.nextElement();	
			if(b.isSelected()) {	
					switch(b.getText()) {
					case "Day" : {
						text=new SimpleDateFormat("dd/MM/yyyy").format(dateChooser.getDate());
						
						break;
					}
					case "Month" : {
						text=new SimpleDateFormat("MM/yyyy").format(dateChooser.getDate());
						
						break;
					}
					case "Year" : {
						
						text=new SimpleDateFormat("yyyy").format(dateChooser.getDate());
						break;
						
					}
				}	
			}
		}
		textTurnover.setText(BillDao.searchBillTotal(text));
		textImport.setText(MedicineDao.searchMedicineTotal(text));
		
	}
	
	
	protected void do_rdbtnNewRadioButton_2_actionPerformed(ActionEvent e) {
		dateChooser.setDate(null);
		Enumeration<AbstractButton>  met =  timeSearch.getElements();
		while(met.hasMoreElements()) {
			AbstractButton b =met.nextElement();	
			if(b.isSelected()) {	
					switch(b.getText()) {
					case "Day" : {
						
						dateChooser.setDateFormatString("dd/MM/yyyy");
						break;
					}
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
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		textDay.setText(BillDao.dayBillTotal());
		textMonth.setText(BillDao.monthBillTotal());
		textMothImport.setText(MedicineDao.monthMedicineTotal());
		arrayBill=BillDao.selectBill();
		pagingJtable();
		selectBill(arrayBill);

		
	}
}
