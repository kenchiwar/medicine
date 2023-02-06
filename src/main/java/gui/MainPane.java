package gui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.Customer;
import entity.DetaiBill;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class MainPane extends JPanel {
	private JPanel panel_1;
	private JPanel mainPaine2;
	private JPanel panelBill;
	private JScrollPane scrollPane;
	private JPanel panelCustomer;
	private JPanel panelDetail;
	private JTable tableBill;
	//code tự tạo tay
		private String nameMedicine ;
		private	Customer customer;
		private JframeDetailBill JframeAddDetailBill;
		
		
		private ArrayList<DetaiBill> detailBill= new ArrayList<DetaiBill>();
		
	//thằng text
	 private BillJframe billJframe;
	 
	public BillJframe getBillJframe() {
		return billJframe;
	}

	public void setBillJframe(BillJframe billJframe) {
		this.billJframe = billJframe;
	}
	//
	private JButton btnAddMedicine;
	private JTextField textMedicine;
	private JLabel lblSearch;
	private JRadioButton rdbtnYesBill;
	private JRadioButton rdbtnNoBill;
	private JRadioButton rdbtnRetail;
	private final ButtonGroup checkStatus = new ButtonGroup();
	private JTextField textField;
	private JLabel lblidCustomer;
	private JButton btnNewButton;
	private JPanel chan;
	private JPanel hayqua;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JTextField textField_2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JLabel lblNewLabel_2;
	private JTextField textField_3;
	
	
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

	/**
	 * Create the panel.
	 */
	public MainPane() {
		setAutoscrolls(true);
		setInheritsPopupMenu(true);
		setIgnoreRepaint(true);
		setMinimumSize(new Dimension(100, 100));
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		add(panel, "name_470958390233900");
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 255), 3));
		
		panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		panel_5 = new JPanel();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(0)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
							.addGap(13))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(11)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(4)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
							.addGap(6))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE)
					.addGap(7)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(14))
		);
		
		lblNewLabel_2 = new JLabel("New label");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(4)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(272, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(79, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(18))
						.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14))))
		);
		panel_4.setLayout(gl_panel_4);
		
		lblNewLabel = new JLabel("New label");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("New label");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		rdbtnNewRadioButton = new JRadioButton("New radio button");
		
		rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		
		rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(3)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7))
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(113, Short.MAX_VALUE)
					.addComponent(rdbtnNewRadioButton_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnNewRadioButton)
							.addComponent(rdbtnNewRadioButton_2))
						.addComponent(rdbtnNewRadioButton_1, Alignment.TRAILING))
					.addGap(8)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(14))
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(9))
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(13))
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		panel_3.setLayout(gl_panel_3);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 411, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 60, Short.MAX_VALUE)
		);
		panel_5.setLayout(gl_panel_5);
		panel_2.setLayout(gl_panel_2);
		
		
	}
	public void totalFunction() {
		createTableDetailBill(getDetailBill());
		}
	//in danh sách detail ra yeah
		public void createTableDetailBill(ArrayList<DetaiBill> arrayDetailBill) {
		if(!(arrayDetailBill.size()<=0)) {
			DefaultTableModel model = new DefaultTableModel() {
				public Class getColumnClass(int column){
						switch(column) {
						case 0: return String.class;
						case 1: return Integer.class;
						case 2: return String.class;
						case 3: return String.class;
						case 4: return Float.class;
						
						default: return String.class;

						}	
				}
				 public boolean isCellEditable(int row, int column){
				        
				        return false;
				    }
			   
				
			};
			model.addColumn("Name Medicine");
			model.addColumn("Amount");
			model.addColumn("RegisNumber");
			model.addColumn("Unit");
			model.addColumn("Price Out");
			
			arrayDetailBill.forEach(i->{
				model.addRow(new Object[] {
						i.getNameMedicine(),
						i.getAmount(),
						i.getRegisNumber(),
						i.getUnit(),
						i.getPriceOut(),
						
				});
				
			}
					);
			///
			///
			///
			///
			//tableBill.setModel(model);
		}
		}
	// nút bấm truyền dữ liệu cho radio button	
		protected void do_btnAddMedicine_actionPerformed(ActionEvent e) {
		var  hay = (String) textMedicine.getText().trim();
		//nguyên cái đống này để kiểm tra coi 
			if(hay.equals("")) {
				JOptionPane.showMessageDialog
				(null,"Error text","Vui lòng nhập name medicine", JOptionPane.ERROR_MESSAGE);		
				}else {
					var hay23 = getJframeAddDetailBill();
					if(hay23==null) {
					JframeAddDetailBill = new JframeDetailBill();	
					JframeAddDetailBill.setVisible(true);
					JframeAddDetailBill.setNameMedicine(hay);
					JframeAddDetailBill.totalFunction();
				//	JframeAddDetailBill.setMainPaine(this);
						
					}
					else {
						if(!hay23.isVisible()) {
							JframeAddDetailBill = new JframeDetailBill();	
							JframeAddDetailBill.setVisible(true);
							JframeAddDetailBill.setNameMedicine(hay);
							JframeAddDetailBill.totalFunction();
						//	JframeAddDetailBill.setMainPaine(this);
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
					if(b.getName().equals("1")) {
						customer = new Customer();
						customer.setIdCustomer(1);
					}else if(b.getName().equals("2")) {
						customer = new Customer();
						customer.setIdCustomer(2);
					}
					JOptionPane.showMessageDialog
					(null,customer.getIdCustomer(),"Vui lòng nhập name medicine", JOptionPane.ERROR_MESSAGE);		
				}
			}
		}
		protected void do_btnNewButton_actionPerformed(ActionEvent e) {
			insertCustomer();
		}
}
