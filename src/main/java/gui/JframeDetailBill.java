package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.MedicineDao;
import entity.DetaiBill;
import entity.Medicine;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class JframeDetailBill extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	//CODE TỰ TAY THÊM ZÔ
			private BillJframe billJframe;	
			private String nameMedicine;
	public String getNameMedicine() {
				return nameMedicine;
			}

			public void setNameMedicine(String nameMedicine) {
				this.nameMedicine = nameMedicine;
			}
			//
		
	//		
	private JPanel panelDetailBill;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable tableMet;
	private JPanel panel;
	private JLabel lblNameMedicine;
	private JScrollPane scrollPane_1;
	private JTable tableDetailBill;
	private JButton btnNewButton;
	public BillJframe getBillJframe() {
		if(billJframe==null) {
			billJframe = new BillJframe();
		}
		return billJframe;
	}

	public void setBillJframe(BillJframe billJframe) {
		this.billJframe = billJframe;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JframeDetailBill frame = new JframeDetailBill();
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
	public JframeDetailBill() {
		getContentPane().setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		getContentPane().add(panel, "name_381276655670000");
		
		lblNameMedicine = new JLabel("Name Medicine");
		lblNameMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameMedicine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNameMedicine.setForeground(new Color(255, 0, 0));
		
		scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNameMedicine, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNameMedicine, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		tableDetailBill = new JTable();
		scrollPane_1.setViewportView(tableDetailBill);
		panel.setLayout(gl_panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 739, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panelDetailBill = new JPanel();
		panelDetailBill.setBackground(new Color(255, 255, 255));
		contentPane.add(panelDetailBill, "name_375277443801500");
		
		lblNewLabel = new JLabel("Name is");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		scrollPane = new JScrollPane();
		
		tableMet = new JTable();
		tableMet.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		
		scrollPane.setViewportView(tableMet);
		
		btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBackground(new Color(255, 128, 0));
		GroupLayout gl_panelDetailBill = new GroupLayout(panelDetailBill);
		gl_panelDetailBill.setHorizontalGroup(
			gl_panelDetailBill.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDetailBill.createSequentialGroup()
					.addGroup(gl_panelDetailBill.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
						.addGroup(gl_panelDetailBill.createSequentialGroup()
							.addGap(185)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
							.addGap(263)))
					.addGap(0))
		);
		gl_panelDetailBill.setVerticalGroup(
			gl_panelDetailBill.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDetailBill.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelDetailBill.setLayout(gl_panelDetailBill);
		ListSelectionModel listSelectionModel= tableDetailBill.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		
	}
	public void totalFunction() {
		met();
	}
	ArrayList<Medicine> arrayMedicine;
	public void met () {
		arrayMedicine=MedicineDao.selectName(getNameMedicine());
		if(arrayMedicine.size()<=0) {
			JOptionPane.showMessageDialog(null,"No result","Don't have medicine"
					, JOptionPane.ERROR_MESSAGE);
			this.setVisible(false);
			return ;
		}
		
		lblNewLabel.setText(lblNewLabel.getText()+ getNameMedicine());
		DefaultTableModel model = new DefaultTableModel() {
			public Class getColumnClass(int column){
					switch(column) {
					case 0: return String.class;
					case 1: return Integer.class;
					case 2: return String.class;
					case 3: return String.class;
					case 4: return Float.class;
					case 5:	return Float.class;
					default: return String.class;

					}	
			}
			 public boolean isCellEditable(int row, int column){
			        
			        return false;
			    }
		   
			
		};
		model.addColumn("Name Medicine");
		model.addColumn("Amount Now");
		model.addColumn("RegisNumber");
		model.addColumn("Unit");
		model.addColumn("Price Out");
		model.addColumn("Price Retail Out");
		arrayMedicine.stream()
        .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Medicine::getRegisNumber)))).forEach(i->{
			model.addRow(new Object[] {
					i.getNameMedicine(),
					i.getAmountNow(),
					i.getRegisNumber(),
					i.getUnit(),
					i.getPriceOut(),
					i.getPriceRetailOut()
			});
			
		}
				);
		tableMet.setModel(model);
		tableMet.addRowSelectionInterval(0,0);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		int[] rows = tableMet.getSelectedRows();
	
		try {
			
			float a = Integer.valueOf( JOptionPane.showInputDialog("Enter Quanity",1));
			
			if(Integer.valueOf(String.valueOf(tableMet.getValueAt(rows[0],1)))<a) {
				JOptionPane.showMessageDialog(null,"Error Quality","Quanity Out Max"
						, JOptionPane.ERROR_MESSAGE);
			
				
			}else {
				var medicine = new DetaiBill();
				// sau này có thì làm chức năng sale event sau
				float sale=0;
				arrayMedicine.stream().filter(i->
				i.getRegisNumber().equals(String.valueOf(tableMet.getValueAt(rows[0],2))))
				.forEach(i->{
					medicine.setIdMedicine(i.getIdMedicine());
					medicine.setPriceOut(i.getPriceOut());
					medicine.setNameMedicine(i.getNameMedicine());
					medicine.setDateOut(i.getDateOut());
					medicine.setUnit(i.getUnit());
					medicine.setPriceEnter(i.getPriceEnter());
					medicine.setPriceOut(i.getPriceOut());
					medicine.setPriceRetailOut(i.getPriceRetailOut());
					medicine.setRegisNumber(i.getRegisNumber());
					medicine.setAmount(a);
					medicine.setSale(sale);
				});
				
				var arrayDetailBill = billJframe.getDetailBill();
				arrayDetailBill.removeIf(i->i.getRegisNumber().equals(medicine.getRegisNumber()));
				arrayDetailBill.add(medicine);
				billJframe.setDetailBill(arrayDetailBill);
				
				billJframe.totalFunction();
				this.dispose();
				//code text
				
				
				
			}
		}catch(Exception e1) {
			
		}
		
		
		
	}
}
