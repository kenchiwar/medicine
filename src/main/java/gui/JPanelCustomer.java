package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.toedter.calendar.JDateChooser;

import dao.CustomerDao;
import entity.Customer;
import javax.swing.border.LineBorder;

public class JPanelCustomer extends JPanel {

	private JPanel Customer;
	private JLabel lblFirstName;
	private JTextField FirstName;
	private JLabel lblLastName;
	private JLabel lblBirthday;
	private JLabel lblGender;
	private JLabel lblCCCD;
	private JLabel lblNumPhone;
	private JLabel lblNumhome;
	private JLabel lblStreetName;
	private JLabel lblWard;
	private JLabel lblCounty;
	private JLabel lblCity;
	private JLabel lblCountry;
	private JTextField LastName;
	private JTextField CCCD;
	private JTextField NumPhone;
	private JTextField NumHome;
	private JTextField StreetName;
	private JTextField Ward;
	private JTextField County;
	private JTextField City;
	private JTextField Country;
	private JButton btnAddCus;
	private JDateChooser Birthday1;
	private JRadioButton rdbtnMade;
	private JRadioButton rdbtnFemade;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnReset;

	/**
	 * Create the panel.
	 */
	public JPanelCustomer() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(202, 207, 254));
		setLayout(new CardLayout(0, 0));
		
		Customer = new JPanel();
		Customer.setBackground(new Color(202, 207, 254));
		add(Customer, "name_84501382640958");
		
		lblFirstName = new JLabel("First Name");
		
		FirstName = new JTextField();
		FirstName.setColumns(10);
		
		lblLastName = new JLabel("Last Name");
		
		lblBirthday = new JLabel("Birthday");
		
		lblGender = new JLabel("Gender");
		
		lblCCCD = new JLabel("Card Id");
		
		lblNumPhone = new JLabel("Number Phone");
		
		lblNumhome = new JLabel("Number Home");
		
		lblStreetName = new JLabel("Street Name");
		
		lblWard = new JLabel("Ward");
		
		lblCounty = new JLabel("County");
		
		lblCity = new JLabel("City");
		
		lblCountry = new JLabel("Country");
		
		LastName = new JTextField();
		LastName.setColumns(10);
		
		CCCD = new JTextField();
		CCCD.setColumns(10);
		
		NumPhone = new JTextField();
		NumPhone.setColumns(10);
		
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
		
		btnAddCus = new JButton("Add");
		btnAddCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddCusActionPerformed(e);
			}
		});
		
		Birthday1 = new JDateChooser();
		Birthday1.setDateFormatString("yyyy/MM/dd");
		
		rdbtnMade = new JRadioButton("Made");
		rdbtnMade.setSelected(true);
		buttonGroup.add(rdbtnMade);
		
		rdbtnFemade = new JRadioButton("Femade");
		buttonGroup.add(rdbtnFemade);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetActionPerformed(e);
			}
		});
		GroupLayout gl_Customer = new GroupLayout(Customer);
		gl_Customer.setHorizontalGroup(
			gl_Customer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Customer.createSequentialGroup()
					.addGap(85)
					.addGroup(gl_Customer.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_Customer.createSequentialGroup()
							.addGroup(gl_Customer.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_Customer.createSequentialGroup()
									.addComponent(lblCountry, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Country, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Customer.createSequentialGroup()
									.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(City, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Customer.createSequentialGroup()
									.addComponent(lblCounty, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(County, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Customer.createSequentialGroup()
									.addComponent(lblWard, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Ward, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Customer.createSequentialGroup()
									.addComponent(lblStreetName, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(StreetName, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Customer.createSequentialGroup()
									.addComponent(lblNumhome, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(NumHome, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Customer.createSequentialGroup()
									.addComponent(lblNumPhone, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(NumPhone, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Customer.createSequentialGroup()
									.addComponent(lblCCCD, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(CCCD, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Customer.createSequentialGroup()
									.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnMade)
									.addGap(153)
									.addComponent(rdbtnFemade))
								.addGroup(gl_Customer.createSequentialGroup()
									.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(FirstName, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Customer.createSequentialGroup()
									.addComponent(lblBirthday, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Birthday1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_Customer.createSequentialGroup()
									.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(LastName, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_Customer.createSequentialGroup()
							.addGap(45)
							.addComponent(btnAddCus, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
							.addGap(29)
							.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
					.addGap(255))
		);
		gl_Customer.setVerticalGroup(
			gl_Customer.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Customer.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_Customer.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(FirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_Customer.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(LastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_Customer.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBirthday)
						.addComponent(Birthday1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Customer.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_Customer.createSequentialGroup()
							.addComponent(lblGender)
							.addGap(18))
						.addGroup(gl_Customer.createSequentialGroup()
							.addGroup(gl_Customer.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnMade)
								.addComponent(rdbtnFemade))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_Customer.createParallelGroup(Alignment.BASELINE)
						.addComponent(CCCD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCCCD))
					.addGap(18)
					.addGroup(gl_Customer.createParallelGroup(Alignment.BASELINE)
						.addComponent(NumPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumPhone))
					.addGap(18)
					.addGroup(gl_Customer.createParallelGroup(Alignment.BASELINE)
						.addComponent(NumHome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumhome))
					.addGap(18)
					.addGroup(gl_Customer.createParallelGroup(Alignment.BASELINE)
						.addComponent(StreetName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStreetName))
					.addGap(18)
					.addGroup(gl_Customer.createParallelGroup(Alignment.BASELINE)
						.addComponent(Ward, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWard))
					.addGap(18)
					.addGroup(gl_Customer.createParallelGroup(Alignment.BASELINE)
						.addComponent(County, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCounty))
					.addGap(18)
					.addGroup(gl_Customer.createParallelGroup(Alignment.BASELINE)
						.addComponent(City, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCity))
					.addGap(18)
					.addGroup(gl_Customer.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCountry)
						.addComponent(Country, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
					.addGroup(gl_Customer.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAddCus, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		Customer.setLayout(gl_Customer);

	}
	protected void btnAddCusActionPerformed(ActionEvent e) {
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
			lblBirthday.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
			
		}else if(LastName.getText().length()==0){
			lblLastName.setForeground(Color.red);
			lblFirstName.setForeground(Color.black);
			lblBirthday.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(Birthday1.getDate() ==null) {
				
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthday.setForeground(Color.red);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(CCCD.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthday.setForeground(Color.black);
			lblCCCD.setForeground(Color.red);
			lblNumPhone.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(NumPhone.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthday.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.red);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(NumHome.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthday.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumhome.setForeground(Color.red);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if (StreetName.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthday.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.red);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if (Ward.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthday.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.red);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(County.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthday.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.red);
			lblCity.setForeground(Color.black);
			lblCountry.setForeground(Color.black);
		}else if(City.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthday.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
			lblStreetName.setForeground(Color.black);
			lblWard.setForeground(Color.black);
			lblCounty.setForeground(Color.black);
			lblCity.setForeground(Color.red);
			lblCountry.setForeground(Color.black);
		}else if(Country.getText().length()==0) {
			lblFirstName.setForeground(Color.black);
			lblLastName.setForeground(Color.black);
			lblBirthday.setForeground(Color.black);
			lblCCCD.setForeground(Color.black);
			lblNumPhone.setForeground(Color.black);
			lblNumhome.setForeground(Color.black);
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
		lblBirthday.setForeground(Color.black);
		lblCCCD.setForeground(Color.black);
		lblNumPhone.setForeground(Color.black);
		lblNumhome.setForeground(Color.black);
		lblStreetName.setForeground(Color.black);
		lblWard.setForeground(Color.black);
		lblCounty.setForeground(Color.black);
		lblCity.setForeground(Color.black);
		lblCountry.setForeground(Color.black);
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
		
		lblFirstName.setForeground(Color.black);
		lblLastName.setForeground(Color.black);
		lblBirthday.setForeground(Color.black);
		lblCCCD.setForeground(Color.black);
		lblNumPhone.setForeground(Color.black);
		lblNumhome.setForeground(Color.black);
		lblStreetName.setForeground(Color.black);
		lblWard.setForeground(Color.black);
		lblCounty.setForeground(Color.black);
		lblCity.setForeground(Color.black);
		lblCountry.setForeground(Color.black);
		
	}
}
