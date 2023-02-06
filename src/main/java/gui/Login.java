package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

import org.exolab.castor.xml.handlers.ValueOfFieldHandler;

import database.ConnectProperties;
import entity.Staff;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;


public class Login extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblUser;
	private JLabel lblPass;
	private JButton btnClear;
	private JLabel lblNewLabel;
	private BillJframe bill;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnLogin;
	private JLabel lblNewLabel_4;
	
	private Point mouseDown;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param sta 
	 */
	public Login() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				thisMouseDragged(e);
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				thisMousePressed(e);
			}
		});
		setTitle("login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(500, 200, 849, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		
		panel_1 = new JPanel();
		panel_1.setBounds(317, 0, 532, 587);
		panel_1.setEnabled(false);
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel_1.setBackground(new Color(0, 255, 64));
		panel_1.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(141, 204, 244, 34);
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsername.setBackground(new Color(0, 255, 64));
		txtUsername.setColumns(10);
		panel_1.add(txtUsername);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(141, 263, 244, 36);
		pwdPassword.setToolTipText("");
		pwdPassword.setBorder(null);
		pwdPassword.setBackground(new Color(0, 255, 64));
		panel_1.add(pwdPassword);
		
		separator = new JSeparator();
		separator.setBounds(141, 238, 244, 8);
		separator.setBackground(Color.DARK_GRAY);
		separator.setForeground(Color.DARK_GRAY);
		panel_1.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(141, 310, 244, 8);
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBackground(Color.DARK_GRAY);
		panel_1.add(separator_1);
		
		lblUser = new JLabel("");
		lblUser.setBounds(88, 194, 48, 44);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\user.png"));
		panel_1.add(lblUser);
		
		lblPass = new JLabel("");
		lblPass.setBounds(88, 265, 43, 34);
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPass.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\lock.png"));
		panel_1.add(lblPass);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(161, 329, 89, 34);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed(e);
			}
		});
		btnClear.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(btnClear);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(107, 535, 0, 0);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(65, 71, 200, 59);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\logo.png"));
		
		lblNewLabel_2 = new JLabel("WELCOME");
		lblNewLabel_2.setBounds(98, 141, 128, 31);
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(32, 206, 256, 256);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\pharmacy.png"));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_3);
		contentPane.add(panel_1);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed(e);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(277, 329, 89, 34);
		panel_1.add(btnLogin);
		
		lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Java\\ProjectJavaSwing\\icon\\login.png"));
		lblNewLabel_4.setBounds(103, 11, 308, 134);
		panel_1.add(lblNewLabel_4);
		
		btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(219, 395, 89, 34);
		panel_1.add(btnNewButton);
	}
	
	protected void ActionPerformed(ActionEvent e) {
		Staff staff = new Staff();
		
		String username = txtUsername.getText();
		String password = String.valueOf(pwdPassword.getPassword());
		if(e.getSource().equals(btnLogin)) {
			try(var connect = ConnectProperties.getConnection();
					var stmt = connect.createStatement();
					var cs = stmt.executeQuery("SELECT IdStaff, Username, [Password], FirstName, LastName,[Rank],[Shift], Address.IdAddress, Address.NumHome, Address.[Name], Address.Ward, Address. County, Address.City, Address.Country , BirthDay, Gender,NumPhone,CCCD, Gmail, DeleteStatus From Staff INNER JOIN Address ON Staff.IdAddress = Address.IdAddress\r\n"
							+ " "
							+ "where Username='"+username+"' and [Password]='"+password+"'")) {
						if(cs.next()) {
							staff.setIdStaff(cs.getInt("IdStaff"));
							staff.setIdAddress(cs.getInt("IdAddress"));
							staff.setUsername(cs.getString("Username"));
							staff.setPassword(cs.getString("Password"));
							staff.setFirstName(cs.getString("FirstName"));
							staff.setLastName(cs.getString("LastName"));
							staff.setRank_1(cs.getInt("Rank"));
							staff.setShift(cs.getString("Shift"));
							staff.setNumHome(cs.getString("NumHome"));
							staff.setNameHome(cs.getString("Name"));
							staff.setWard(cs.getString("Ward"));
							staff.setCounty(cs.getString("County"));
							staff.setCity(cs.getString("City"));
							staff.setCountry(cs.getString("Country"));
							staff.setCounty(cs.getString("County"));
							staff.setBirthDay(cs.getDate("BirthDay").toLocalDate());
							staff.setGender(cs.getBoolean("Gender"));
							staff.setNumPhone(cs.getString("NumPhone"));
							staff.setCccd(cs.getString("CCCD"));
							staff.setGmail(cs.getString("Gmail"));
							staff.setDeleteStatus(cs.getBoolean("DeleteStatus"));
							
							if(staff.isDeleteStatus()==true) {
								JOptionPane.showMessageDialog(null,"Username stoped working!!!");
								txtUsername.setText("");
								pwdPassword.setText("");
							}else {
								if(staff.getRank_1()==1) {
							JOptionPane.showMessageDialog(null,"Login Successful");
							dispose();
							bill = new BillJframe();
							bill.setVisible(true);
							bill.setStaff(staff);
							bill.totalFunction();
							
							}else if(staff.getRank_1()==0) {
								JOptionPane.showMessageDialog(null,"Login Successful");
								dispose();
								HomePage home = new HomePage();
								home.setVisible(true);
								home.setSta(staff);
								
							}
							}
							
							}
							
						else {
							JOptionPane.showMessageDialog(null,"Username or password is wrong!");
							txtUsername.setText("");
							pwdPassword.setText("");
						}
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource().equals(btnClear)) {
			txtUsername.setText(null);
			pwdPassword.setText(null);
		}else {
			System.exit(0);
		}
		
		
	}
	protected void thisMousePressed(MouseEvent e) {
		mouseDown = e.getPoint();
	}
	protected void thisMouseDragged(MouseEvent e) {
		Point curCoord = e.getLocationOnScreen();
		this.setLocation(curCoord.x-mouseDown.x, curCoord.y-mouseDown.y);
	}
	
}
