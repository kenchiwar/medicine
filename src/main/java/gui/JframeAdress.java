package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Customer;

import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JframeAdress extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNumberHome;
	private JTextField textNumHome;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textWard;
	private JTextField textName;
	private JLabel lblNewLabel_4;
	private JTextField textCity;
	private JLabel lblNewLabel_5;
	//code tự tay thêm zô
		private Customer customer;
		private BillJframe billJframe;
	//
	private JTextField textCounty;
	private JLabel lblNewLabel_6;
	private JTextField textCountry;
	private JButton btnNewButton;
	
	
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	public BillJframe getBillJframe() {
		return billJframe;
	}

	public void setBillJframe(BillJframe billJframe) {
		this.billJframe = billJframe;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JframeAdress frame = new JframeAdress();
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
	public JframeAdress() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, "name_565410582335600");
		panel.setLayout(new CardLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, "name_565418181732200");
		
		lblNewLabel = new JLabel("Adress");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		
		lblNumberHome = new JLabel("Number Home");
		
		textNumHome = new JTextField();
		textNumHome.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Ward");
		
		lblNewLabel_3 = new JLabel("Name Street");
		
		textWard = new JTextField();
		textWard.setColumns(10);
		
		textName = new JTextField();
		textName.setColumns(10);
		
		lblNewLabel_4 = new JLabel("City");
		
		textCity = new JTextField();
		textCity.setColumns(10);
		
		lblNewLabel_5 = new JLabel("County");
		
		textCounty = new JTextField();
		textCounty.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Country");
		
		textCountry = new JTextField();
		textCountry.setColumns(10);
		
		btnNewButton = new JButton("Change");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(103)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
					.addGap(115))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNumberHome, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNumHome, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textName, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textWard, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textCounty, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textCity, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(10)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
									.addGap(35))
								.addComponent(textCountry, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))))
					.addGap(168))
		);
		
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberHome, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(textNumHome, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(textWard, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(textCounty, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(textCity, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(textCountry, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addComponent(btnNewButton))
		);
		panel_1.setLayout(gl_panel_1);
	}
	//
	public void totalFunction() {
		insertCusomer(billJframe.getCustomer());
	}
	public void insertCusomer(Customer mem) {
		textNumHome.setText(mem.getNumhome());
		textName.setText(mem.getName());
		textWard.setText(mem.getWard());
		textCounty.setText(mem.getCounty());
		textCity.setText(mem.getCity());
		textCountry.setText(mem.getCountry());
		
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		var cus=billJframe.getCustomer();
		cus.setNumhome(textNumHome.getText());
		cus.setName(textName.getText());
		cus.setWard(textWard.getText());
		cus.setCounty(textCounty.getText());
		cus.setCountry(textCountry.getText());
		cus.setCity(textCity.getText());
		System.out.println(cus.getName());
		billJframe.setCustomer(cus);
	//	billJframe.setTextCustomer();
        this.dispose();
	}
}
