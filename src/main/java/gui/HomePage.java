package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.EmployeePane;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import dao.MedicineDao;
import entity.Staff;

import javax.swing.JScrollPane;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JPanel slidePane;
	private JPanel btnEmployee;
	private JLabel lblNewLabel;
	private JButton btnLogout;
	private JPanel paneMain;
	
	private EmployeePane ep;
	private TTCustomer jpcus;
	private JpanelMedicine jpMe;
	private JpanelSupplier jpSup;
	private StatisticalBill creBill;
	private Staff sta;
	private BillJframe bill;
	private JPanelAccount acc;
	private  Notification not;
	public Staff getSta() {
		return sta;
	}

	public void setSta(Staff sta) {
		this.sta = sta;
	}
	
	
	public BillJframe getBill() {
		return bill;
	}

	public void setBill(BillJframe bill) {
		this.bill = bill;
	}


	private JPanel btnBill;
	private JLabel lblBill;
	private JPanel btnMedicine;
	private JLabel lblMedi;
	private JPanel btnCus;
	private JLabel lblCustomer;
	private JPanel btnSupplier;
	private JLabel lblSupplier;
	private JPanel btnAcc;
	private JLabel lblAccount;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel btnCreBill;
	private JLabel lblSetBill;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNumEnd;
	private JLabel lblNumOut;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblHotline;
	private JLabel lblHotline_1;
	
	
	public Notification getNot() {
		return not;
	}

	public void setNot(Notification not) {
		this.not = not;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setTitle("HealthMart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1300, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		slidePane = new JPanel();
		slidePane.setBorder(new LineBorder(new Color(0, 0, 0)));
		slidePane.setBackground(new Color(255, 255, 255));
		
		btnEmployee = new JPanel();
		btnEmployee.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMouseClicked(e);
			}
		});
		btnEmployee.setLayout(null);
		lblNewLabel = new JLabel("Employee");
		
		lblNewLabel.setBounds(10, 29, 110, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEmployee.add(lblNewLabel);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogoutActionPerformed(e);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		paneMain = new JPanel();
		ep = new EmployeePane();
		jpcus = new TTCustomer();
		jpMe = new JpanelMedicine();
		jpSup = new JpanelSupplier();
		creBill = new StatisticalBill();
		acc = new JPanelAccount();
		
		btnBill = new JPanel();
		btnBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBillMouseClicked(e);
			}
		});
		btnBill.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnBill.setLayout(null);
		
		lblBill = new JLabel("Bill");
		lblBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblBill.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBill.setBounds(10, 30, 110, 19);
		btnBill.add(lblBill);
		
		btnMedicine = new JPanel();
		btnMedicine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMouseClicked(e);
			}
		});
		btnMedicine.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnMedicine.setLayout(null);
		
		lblMedi = new JLabel("Medicine");
		lblMedi.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMedi.setBounds(10, 29, 110, 20);
		btnMedicine.add(lblMedi);
		
		btnCus = new JPanel();
		btnCus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMouseClicked(e);
			}
		});
		btnCus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCus.setLayout(null);
		
		lblCustomer = new JLabel("Customer");
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomer.setBounds(10, 29, 110, 20);
		btnCus.add(lblCustomer);
		
		btnSupplier = new JPanel();
		btnSupplier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMouseClicked(e);
			}
		});
		btnSupplier.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSupplier.setLayout(null);
		
		lblSupplier = new JLabel("Supplier");
		lblSupplier.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSupplier.setBounds(10, 29, 110, 20);
		btnSupplier.add(lblSupplier);
		
		btnAcc = new JPanel();
		btnAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMouseClicked(e);
			}
		});
		btnAcc.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAcc.setLayout(null);
		
		lblAccount = new JLabel("Account");
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAccount.setBounds(10, 29, 110, 20);
		btnAcc.add(lblAccount);
		
		btnCreBill = new JPanel();
		btnCreBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMouseClicked(e);
			}
		});
		btnCreBill.setLayout(null);
		btnCreBill.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblSetBill = new JLabel("Statistical");
		lblSetBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetBill.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSetBill.setBounds(10, 29, 110, 20);
		btnCreBill.add(lblSetBill);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\billCre.png"));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(10, 0, 110, 38);
		btnCreBill.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\pngegg.png"));
		
		panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1MouseClicked(e);
			}
		});
		panel_1.setBackground(new Color(255, 255, 255));
		GroupLayout gl_slidePane = new GroupLayout(slidePane);
		gl_slidePane.setHorizontalGroup(
			gl_slidePane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_slidePane.createSequentialGroup()
					.addGap(22)
					.addComponent(btnLogout, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
					.addGap(21))
				.addGroup(gl_slidePane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_slidePane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_slidePane.createSequentialGroup()
							.addGap(1)
							.addComponent(btnCus, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
						.addGroup(gl_slidePane.createSequentialGroup()
							.addGap(1)
							.addComponent(btnSupplier, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
						.addGroup(gl_slidePane.createSequentialGroup()
							.addGap(1)
							.addComponent(btnAcc, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
						.addGroup(gl_slidePane.createSequentialGroup()
							.addGroup(gl_slidePane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnMedicine, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(btnEmployee, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(btnBill, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
							.addGap(1)))
					.addContainerGap())
				.addGroup(gl_slidePane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCreBill, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_slidePane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_8, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_slidePane.createSequentialGroup()
					.addGap(45)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_slidePane.setVerticalGroup(
			gl_slidePane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_slidePane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(btnEmployee, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBill, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnMedicine, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCus, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSupplier, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAcc, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCreBill, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(79)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		panel_1.setLayout(null);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(23, 5, 32, 32);
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\bell.png"));
		panel_1.add(lblNewLabel_9);
		
		lblNumEnd = new JLabel("0");
		lblNumEnd.setForeground(new Color(255, 0, 0));
		lblNumEnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumEnd.setBounds(52, 20, 32, 14);
		panel_1.add(lblNumEnd);
		
		lblNumOut = new JLabel("0");
		lblNumOut.setForeground(new Color(255, 0, 0));
		lblNumOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumOut.setBounds(52, 0, 26, 14);
		panel_1.add(lblNumOut);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\profile.png"));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 0, 110, 38);
		btnAcc.add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\supplier.png"));
		lblNewLabel_5.setBounds(10, 0, 110, 38);
		btnSupplier.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\rating.png"));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 0, 110, 38);
		btnCus.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\medicine.png"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 0, 110, 38);
		btnMedicine.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\bill.png"));
		lblNewLabel_2.setBounds(10, 0, 110, 34);
		btnBill.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\id-card.png"));
		lblNewLabel_1.setBounds(10, 0, 110, 32);
		btnEmployee.add(lblNewLabel_1);
		slidePane.setLayout(gl_slidePane);
		paneMain.setLayout(new CardLayout(0, 0));
		paneMain.add(ep, "name_1211686973472400");
		paneMain.add(jpcus);
		paneMain.add(jpMe);
		paneMain.add(jpSup);
		paneMain.add(creBill);
		paneMain.add(acc);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(202, 207, 254));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(slidePane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(paneMain, GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(slidePane, GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(paneMain, GroupLayout.PREFERRED_SIZE, 726, Short.MAX_VALUE))
		);
		
		lblHotline = new JLabel("Gmail: healmart@gmail.com");
		lblHotline.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblHotline_1 = new JLabel("Hotline: 19006567");
		lblHotline_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(166)
					.addComponent(lblHotline, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblHotline_1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(423, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHotline, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHotline_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
		showNotification();

		
	}
	private void showNotification() {
		
		var hay23 = not;
		if(hay23==null) {
			
			 not = new Notification(); 
			not.setVisible(true);
			not.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		else {
			if(!hay23.isVisible()) {
				 not = new Notification(); 
					not.setVisible(true);
					not.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}
		lblNumOut.setText(""+MedicineDao.getListOutNum());
		lblNumEnd.setText(""+MedicineDao.getListOutDate());
	}
	
	public void onClick(JPanel panel) {
		panel.setBackground(new Color(202,207,254));
	}
	public void onLeaveClick(JPanel panel) {
		panel.setBackground(new Color(240,240,240));
	}
	
	
	protected void btnMouseClicked(MouseEvent e) {
		if(e.getSource().equals(btnEmployee)) {
			onClick(btnEmployee);
			onLeaveClick(btnBill);
			onLeaveClick(btnCus);
			onLeaveClick(btnMedicine);
			onLeaveClick(btnSupplier);
			onLeaveClick(btnAcc);
			onLeaveClick(btnCreBill);
			
			paneMain.add(ep).setVisible(true);
			paneMain.add(jpcus).setVisible(false);
			paneMain.add(jpMe).setVisible(false);
			paneMain.add(jpSup).setVisible(false);
			paneMain.add(creBill).setVisible(false);
			paneMain.add(acc).setVisible(false);


//			paneSalary.setVisible(false);
			
			
			
		}else if(e.getSource().equals(btnCus)){
			onClick(btnCus);
			onLeaveClick(btnEmployee);
			onLeaveClick(btnBill);
			onLeaveClick(btnMedicine);
			onLeaveClick(btnSupplier);
			onLeaveClick(btnAcc);
			onLeaveClick(btnCreBill);
			
			paneMain.add(jpcus).setVisible(true);
			paneMain.add(ep).setVisible(false);
			paneMain.add(jpMe).setVisible(false);
			paneMain.add(jpSup).setVisible(false);
			paneMain.add(creBill).setVisible(false);
			paneMain.add(acc).setVisible(false);

		}else if(e.getSource().equals(btnMedicine)) {
			onClick(btnMedicine);
			onLeaveClick(btnBill);
			onLeaveClick(btnCus);
			onLeaveClick(btnEmployee);
			onLeaveClick(btnSupplier);
			onLeaveClick(btnAcc);
			onLeaveClick(btnCreBill);
			
			paneMain.add(jpMe).setVisible(true);
			
			paneMain.add(ep).setVisible(false);
			paneMain.add(jpcus).setVisible(false);
			paneMain.add(jpSup).setVisible(false);
			paneMain.add(creBill).setVisible(false);
			paneMain.add(acc).setVisible(false);

		}else if(e.getSource().equals(btnSupplier)) {
			onClick(btnSupplier);
			onLeaveClick(btnEmployee);
			onLeaveClick(btnBill);
			onLeaveClick(btnMedicine);
			onLeaveClick(btnCus);
			onLeaveClick(btnAcc);
			onLeaveClick(btnCreBill);
			
			paneMain.add(jpSup).setVisible(true);
			paneMain.add(ep).setVisible(false);
			paneMain.add(jpcus).setVisible(false);
			paneMain.add(jpMe).setVisible(false);
			paneMain.add(creBill).setVisible(false);
			paneMain.add(acc).setVisible(false);

			
		}else if(e.getSource().equals(btnCreBill)) {
		onClick(btnCreBill);
		onLeaveClick(btnEmployee);
		onLeaveClick(btnBill);
		onLeaveClick(btnCus);
		
		onLeaveClick(btnMedicine);
		onLeaveClick(btnAcc);
		onLeaveClick(btnSupplier);
		
		paneMain.add(creBill).setVisible(true);
		
		paneMain.add(jpSup).setVisible(false);
		paneMain.add(ep).setVisible(false);
		paneMain.add(jpcus).setVisible(false);
		paneMain.add(jpMe).setVisible(false);
		paneMain.add(acc).setVisible(false);

		}else if(e.getSource().equals(btnAcc)) {
			onClick(btnAcc);
			onLeaveClick(btnEmployee);
			onLeaveClick(btnBill);
			onLeaveClick(btnCus);
			
			onLeaveClick(btnMedicine);
			onLeaveClick(btnCreBill);
			onLeaveClick(btnSupplier);
			paneMain.add(acc).setVisible(true);
			acc.setStaff(sta);
			acc.showInfo_1();
//			System.out.println(sta.getIdStaff());
			
			paneMain.add(creBill).setVisible(false);
			paneMain.add(jpSup).setVisible(false);
			paneMain.add(ep).setVisible(false);
			paneMain.add(jpcus).setVisible(false);
			paneMain.add(jpMe).setVisible(false);
			
		}
		else {
			onLeaveClick(btnSupplier);
			onLeaveClick(btnBill);
			onLeaveClick(btnCus);
			onLeaveClick(btnEmployee);
			onLeaveClick(btnMedicine);
			onLeaveClick(btnAcc);
			onLeaveClick(btnCreBill);
			
			paneMain.add(creBill).setVisible(false);
			paneMain.add(jpSup).setVisible(false);
			paneMain.add(ep).setVisible(false);
			paneMain.add(jpcus).setVisible(false);
			paneMain.add(jpMe).setVisible(false);
			paneMain.add(acc).setVisible(false);
		}
		
		
	}
	protected void btnLogoutActionPerformed(ActionEvent e) {
		Login login = new Login();
		
		
		not.dispose();
		dispose();
		login.setVisible(true);
	}
	
	protected void btnBillMouseClicked(MouseEvent e) {
		var bill_1 = getBill();
		if(bill_1 == null) {
			
			onClick(btnBill);
			onLeaveClick(btnMedicine);
			onLeaveClick(btnCus);
			onLeaveClick(btnEmployee);
			onLeaveClick(btnSupplier);
			onLeaveClick(btnAcc);
			onLeaveClick(btnCreBill);
			
			bill = new BillJframe();
			bill.setVisible(true);
		
			bill.setStaff(sta);
			bill.setHomePage(this);
			bill.totalFunction();
			bill.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}else if(!bill.isVisible()){
			
			onClick(btnBill);
			onLeaveClick(btnMedicine);
			onLeaveClick(btnCus);
			onLeaveClick(btnEmployee);
			onLeaveClick(btnSupplier);
			onLeaveClick(btnAcc);
			onLeaveClick(btnCreBill);
			
			bill = new BillJframe();
			bill.setVisible(true);
			bill.setStaff(sta);
			bill.totalFunction();
			bill.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	protected void panel_1MouseClicked(MouseEvent e) {
		showNotification();
	}
}
