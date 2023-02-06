package gui;

import java.awt.EventQueue;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.MedicineDao;
import entity.Medicine;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class Notification extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private int stt=0;
	private int nowPlace=1;
	private int minimum=1;
	private int maximum;
	private int nowColum=20;
	private int total;
	private boolean status=true;
	private List<Medicine> arrayMed;
	private JPanel btnOut;
	private JPanel btnEnd;
	private JLabel lblOut;
	private JLabel lblNum;
	private JLabel lblNewLabel_1;
	private JLabel lblNumEnd;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notification frame = new Notification();
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
	public Notification() {
		setTitle("Notification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 765, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(202, 207, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnOut = new JPanel();
		btnOut.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMouseClicked(e);
			}
		});
		
		btnEnd = new JPanel();
		btnEnd.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMouseClicked(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnOut, GroupLayout.PREFERRED_SIZE, 135, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnEnd, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addGap(444))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOut, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEnd, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		lblNewLabel_1 = new JLabel("Almost expired");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblNumEnd = new JLabel("0");
		lblNumEnd.setForeground(new Color(255, 0, 0));
		lblNumEnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumEnd.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_btnEnd = new GroupLayout(btnEnd);
		gl_btnEnd.setHorizontalGroup(
			gl_btnEnd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnEnd.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_btnEnd.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(lblNumEnd, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
					.addGap(9))
		);
		gl_btnEnd.setVerticalGroup(
			gl_btnEnd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnEnd.createSequentialGroup()
					.addGap(4)
					.addComponent(lblNewLabel_1)
					.addGap(4)
					.addComponent(lblNumEnd, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
		);
		btnEnd.setLayout(gl_btnEnd);
		
		lblOut = new JLabel("Nearly sold out");
		lblOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblNum = new JLabel("0");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum.setForeground(new Color(255, 0, 0));
		lblNum.setFont(new Font("Tahoma", Font.BOLD, 13));
		GroupLayout gl_btnOut = new GroupLayout(btnOut);
		gl_btnOut.setHorizontalGroup(
			gl_btnOut.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnOut.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_btnOut.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOut, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(lblNum, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
					.addGap(9))
		);
		gl_btnOut.setVerticalGroup(
			gl_btnOut.createParallelGroup(Alignment.LEADING)
				.addComponent(lblOut, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_btnOut.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNum))
		);
		btnOut.setLayout(gl_btnOut);
		contentPane.setLayout(gl_contentPane);
		arrayMed =MedicineDao.getListOut();
		SelMed_1(arrayMed);
		
	}
	private void SelMed(List<Medicine> arrayMedd) {
		stt=1;
		DefaultTableModel model = new DefaultTableModel() {
					public Class<?> getColumnClass(int column){
						switch(column) {
						case 1: return LocalDate.class;
						case 2: return LocalDate.class;
						
						case 9 : return Integer.class;
						}
						return String.class;
					}
					 public boolean isCellEditable(int row, int column){
					        
					        return false;
					    }
				   
				};
				model.addColumn("IdMedicine");
				model.addColumn("DateManufacture");
				model.addColumn("DateOut");
				model.addColumn("Unit");
				model.addColumn("PriceEnter");
				model.addColumn("UnitPrice");
				model.addColumn("NumImport");
				model.addColumn("DateImport");
				model.addColumn("PriceOut");
				model.addColumn("PriceRetailOut");
				model.addColumn("AmountNow");
				model.addColumn("DeleteStatus");
				model.addColumn("RegisNumber");
				model.addColumn("NameMedicine");
				model.addColumn("StatusImport");
				//arrayMed=MedicineDao.getList();
				arrayMedd.
				stream()
				.forEach(
					peo -> {
						stt++;
						model.addRow(new Object[] {
								peo.getIdMedicine(),peo.getDateManufacture(), peo.getDateOut(), peo.getUnit(),peo.getPriceEnter(),
								peo.getUnitPrice(),peo.getNumImport(),peo.getDateImport(),peo.getPriceOut(),peo.getPriceRetailOut(),
								peo.getAmountNow(),peo.isDeleteStatus(),peo.getRegisNumber(), peo.getNameMedicine(),peo.isStatusImport()
					});
					
					}	
				);
				
				table.setModel(model);
				table.setRowHeight(60);
				
	}
	
	private void SelMed_1(List<Medicine> arrayMedd) {
		stt=1;
		DefaultTableModel model = new DefaultTableModel() {
					public Class<?> getColumnClass(int column){
						switch(column) {
						case 1: return LocalDate.class;
						case 2: return LocalDate.class;
						
						case 9 : return Integer.class;
						}
						return String.class;
					}
					 public boolean isCellEditable(int row, int column){
					        
					        return false;
					    }
				   
				};
				model.addColumn("RegisNumber");
				model.addColumn("NameMedicine");
				model.addColumn("Class");
				model.addColumn("GroupMedicine");
				model.addColumn("Active");
				model.addColumn("Content");
				model.addColumn("CoverForm");
				model.addColumn("Packing");
				model.addColumn("Standard");
				model.addColumn("AmountNow");
				model.addColumn("Name");
				model.addColumn("StatusImport");
				//arrayMed=MedicineDao.getList();
				arrayMedd.
				stream()
				.forEach(
					peo -> {
						stt++;
						model.addRow(new Object[] {
								peo.getRegisNumber(),peo.getNameMedicine(),peo.getClass1(),peo.getGroupMedicine(),peo.getActive(),peo.getContent(),
								peo.getCoverForm(),peo.getPacking(),peo.getStandard(),
								peo.getAmountNow(),peo.getName(),peo.isStatusImport()
					});
					
					}	
				);
				
				table.setModel(model);
				table.setRowHeight(60);
				onClick(btnOut);
				onLeaveClick(btnEnd);
				lblNum.setText(""+MedicineDao.getListOutNum());
				lblNumEnd.setText(""+MedicineDao.getListOutDate());
	}
	public void onClick(JPanel panel) {
		panel.setBackground(new Color(255,128,255));
	}
	public void onLeaveClick(JPanel panel) {
		panel.setBackground(new Color(240,240,240));
	}
	protected void panelMouseClicked(MouseEvent e) {
		if(e.getSource().equals(btnOut)) {
			
		arrayMed = MedicineDao.getListOut();
		SelMed_1(arrayMed);
		onClick(btnOut);
		onLeaveClick(btnEnd);
		}else if(e.getSource().equals(btnEnd)) {
			arrayMed = MedicineDao.getListEndDate();
			SelMed(arrayMed);
			onClick(btnEnd);
			onLeaveClick(btnOut);
		}
	}

}
