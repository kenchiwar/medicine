package gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import entity.Staff;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.time.ZoneId;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class JPanelAccount extends JPanel {
	private JTextField textIdStaff;
	private JTextField textPhone;
	private JTextField textMail;
	private JTextField textShift;
	private JTextField textNumhome;
	private JTextField textStreet;
	private JTextField textWard;
	private JTextField textCounty;
	private JTextField textCity;
	private JTextField textCountry;
	private JTextField textCCCD;
	private JLabel lblNewLabel;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblUsername;
	private JLabel lblNewLabel_16;
	private JLabel lblFullname;
	private JLabel lblNewLabel_15;
	private JTextField textPassword;
	
	private Staff staff;
	private JDateChooser dateChooser;
	

	
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	/**
	 * Create the panel.
	 */
	public JPanelAccount() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(204, 207, 255));
		
		textIdStaff = new JTextField();
		textIdStaff.setEditable(false);
		textIdStaff.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setEditable(false);
		textPhone.setColumns(10);
		
		textMail = new JTextField();
		textMail.setEditable(false);
		textMail.setColumns(10);
		
		textShift = new JTextField();
		textShift.setEditable(false);
		textShift.setColumns(10);
		
		textNumhome = new JTextField();
		textNumhome.setEditable(false);
		textNumhome.setColumns(10);
		
		textStreet = new JTextField();
		textStreet.setEditable(false);
		textStreet.setColumns(10);
		
		textWard = new JTextField();
		textWard.setEditable(false);
		textWard.setColumns(10);
		
		textCounty = new JTextField();
		textCounty.setEditable(false);
		textCounty.setColumns(10);
		
		textCity = new JTextField();
		textCity.setEditable(false);
		textCity.setColumns(10);
		
		textCountry = new JTextField();
		textCountry.setEditable(false);
		textCountry.setColumns(10);
		
		textCCCD = new JTextField();
		textCCCD.setEditable(false);
		textCCCD.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\login.png"));
		
		rdbtnMale = new JRadioButton("Male");
		
		rdbtnFemale = new JRadioButton("Female");
		
		lblNewLabel_1 = new JLabel("IDStaff:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_3 = new JLabel("DOB:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_4 = new JLabel("Gender:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_5 = new JLabel("CCCD:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_6 = new JLabel("Phone:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_7 = new JLabel("Mail:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_8 = new JLabel("Shift:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_9 = new JLabel("Num home:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_10 = new JLabel("Street name:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_11 = new JLabel("Ward:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_12 = new JLabel("County:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_13 = new JLabel("City:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_14 = new JLabel("Country:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblUsername = new JLabel("");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		lblNewLabel_16 = new JLabel("FULLNAME:");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblFullname = new JLabel("");
		lblFullname.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_15 = new JLabel("Password:");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textPassword = new JTextField();
		textPassword.setEditable(false);
		textPassword.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		dateChooser.setDateFormatString("YYYY,MM,dd");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_15))
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(dateChooser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textPassword, Alignment.LEADING)
									.addComponent(textIdStaff, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(rdbtnMale, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
									.addComponent(textCCCD, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_9, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
											.addGap(36)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textPhone, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
										.addComponent(textMail, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
										.addComponent(textShift, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
										.addComponent(textNumhome, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
									.addGap(62)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_10)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textCounty, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
								.addComponent(textCity, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
								.addComponent(textCountry, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
								.addComponent(textWard, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
								.addComponent(textStreet, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblFullname, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(textStreet, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textWard, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textCounty, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textCity, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textCountry, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFullname, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textIdStaff, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(46)
											.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(7)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(rdbtnMale)
												.addComponent(rdbtnFemale))))
									.addGap(18))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textPhone, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(textMail, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textShift, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addGap(6)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(textCCCD, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addComponent(textNumhome, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
					.addGap(159))
		);
		setLayout(groupLayout);
//		showInfo_1();

	}
	public void showInfo_1() {
		lblFullname.setText(staff.getFirstName()+" "+staff.getLastName());
		lblUsername.setText(staff.getUsername());
//		textPassword.setText(staff.getPassword());
		textIdStaff.setText(String.valueOf(staff.getIdStaff()));
		dateChooser.setDate(Date.from(staff.getBirthDay().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		if(staff.isGender()==true) {
			rdbtnMale.setSelected(true);
		}else {
			rdbtnFemale.setSelected(true);
		}
		textCCCD.setText(staff.getCccd());
		textPhone.setText(staff.getNumPhone());
		textMail.setText(staff.getGmail());
		textShift.setText(staff.getShift());
		textNumhome.setText(staff.getNumHome());
		textStreet.setText(staff.getNameHome());
		textCounty.setText(staff.getCounty());
		textCity.setText(staff.getCity());
		textWard.setText(staff.getWard());
		textCountry.setText(staff.getCountry());
		
	}
}
