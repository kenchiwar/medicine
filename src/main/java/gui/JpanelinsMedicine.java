package gui;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.CustomerDao;
import dao.MedicineDao;
import entity.Medicine;

import entity.Supplier;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JpanelinsMedicine extends JPanel {
	private JPanel InsertMedicine;
	private JLabel lblRegisNumber;
	private JLabel lblNameMedicine;
	private JLabel lblClass;
	private JLabel lblGroupMedicine;
	private JLabel lblActive;
	private JLabel lblContent;
	private JLabel lblCoverForm;
	private JLabel lblPacking;
	private JLabel lblStandard;
	private JLabel lblSupplier;
	private JLabel lblDateManufacture;
	private JLabel lblDateOut;
	private JLabel lblUnit;
	private JLabel lblPriceEnter;
	private JLabel lblNumImport;
	private JLabel lblDateImport;
	private JLabel lblPriceOut;
	private JLabel lblPriceRetailOut;
	private JLabel lblAmountNow;
	private JLabel lblAmountRetailDefault;
	private JLabel lblUnitRetail;
	private JTextField RegisNumber;
	private JTextField NameMedicine;
	private JTextField Class;
	private JTextField GroupMedicine;
	private JTextField Active;
	private JTextField Content;
	private JTextField CoverForm;
	private JTextField Packing;
	private JTextField Standard;
	private JTextField Unit;
	private JTextField PriceEnter;
	private JTextField NumImport;
	private JTextField PriceOut;
	private JTextField PriceRetailOut;
	private JTextField AmountNow;
	private JTextField AmountRetailDefault;
	private JTextField UnitRetail;
	private JTextField ProNumOut;
	private JDateChooser DateImport;
	private JLabel lblProNumOut;
	private JDateChooser DateManufacture;
	private JDateChooser DateOut;
	private JComboBox Supplier;
	//code tu tao
	
	int cac =0;
	//
	private JButton btnAddMedicine;
	private List<Supplier> Supp;
	private List<String> Sup;
	private List<Medicine> arrayMed;
	private JpanelSupplier suppp;
	

	/**
	 * Create the panel.
	 */
	public JpanelinsMedicine() {
		setLayout(new CardLayout(0, 0));
		
		InsertMedicine = new JPanel();
		add(InsertMedicine, "name_86415541439000");
		
		lblRegisNumber = new JLabel("RegisNumber");
		
		lblNameMedicine = new JLabel("Medicine Name");
		
		lblClass = new JLabel("Class");
		
		lblGroupMedicine = new JLabel("Group Medicine");
		
		lblActive = new JLabel("Active");
		
		lblContent = new JLabel("Content");
		
		lblCoverForm = new JLabel("Cover Form");
		
		lblPacking = new JLabel("Packing");
		
		lblStandard = new JLabel("Standard");
		
		lblSupplier = new JLabel("Supplier");
		
		lblDateManufacture = new JLabel("Date Manufacture");
		
		lblDateOut = new JLabel("Date Out");
		
		lblUnit = new JLabel("Unit");
		
		lblPriceEnter = new JLabel("Price Enter");
		
		lblNumImport = new JLabel("Num Import");
		
		lblDateImport = new JLabel("Date Import");
		
		lblPriceOut = new JLabel("Price Out");
		
		lblPriceRetailOut = new JLabel("Price Retail Out");
		
		lblAmountNow = new JLabel("Amount Now");
		
		lblAmountRetailDefault = new JLabel("Amount Retail Default");
		
		lblUnitRetail = new JLabel("Unit Retail");
		
		RegisNumber = new JTextField();
		RegisNumber.setColumns(10);
		
		NameMedicine = new JTextField();
		NameMedicine.setColumns(10);
		
		Class = new JTextField();
		Class.setColumns(10);
		
		GroupMedicine = new JTextField();
		GroupMedicine.setColumns(10);
		
		Active = new JTextField();
		Active.setColumns(10);
		
		Content = new JTextField();
		Content.setColumns(10);
		
		CoverForm = new JTextField();
		CoverForm.setColumns(10);
		
		Packing = new JTextField();
		Packing.setColumns(10);
		
		Standard = new JTextField();
		Standard.setColumns(10);
		
		Unit = new JTextField();
		Unit.setColumns(10);
		
		PriceEnter = new JTextField();
		PriceEnter.setColumns(10);
		
		NumImport = new JTextField();
		NumImport.setColumns(10);
		
		PriceOut = new JTextField();
		PriceOut.setColumns(10);
		
		PriceRetailOut = new JTextField();
		PriceRetailOut.setColumns(10);
		
		AmountNow = new JTextField();
		AmountNow.setColumns(10);
		
		AmountRetailDefault = new JTextField();
		AmountRetailDefault.setColumns(10);
		
		UnitRetail = new JTextField();
		UnitRetail.setColumns(10);
		
		ProNumOut = new JTextField();
		ProNumOut.setColumns(10);
		
		DateImport = new JDateChooser();
		DateImport.setDateFormatString("yyyy/MM/dd");
		
		lblProNumOut = new JLabel("Pro Num Out");
		
		DateManufacture = new JDateChooser();
		DateManufacture.setDateFormatString("yyyy/MM/dd");
		
		DateOut = new JDateChooser();
		DateOut.setDateFormatString("yyyy/MM/dd");
		
		Supplier = new JComboBox();
		
		addcombobox();
		
		
		btnAddMedicine = new JButton("Add");
		btnAddMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddMedicineActionPerformed(e);
			}
		});
		GroupLayout gl_InsertMedicine = new GroupLayout(InsertMedicine);
		gl_InsertMedicine.setHorizontalGroup(
			gl_InsertMedicine.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InsertMedicine.createSequentialGroup()
					.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_InsertMedicine.createSequentialGroup()
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_InsertMedicine.createSequentialGroup()
									.addGap(29)
									.addComponent(lblDateManufacture, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_InsertMedicine.createSequentialGroup()
									.addGap(48)
									.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.LEADING)
											.addComponent(lblCoverForm, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblPacking, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblStandard, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblRegisNumber, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNameMedicine, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblClass, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblGroupMedicine, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblContent, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblActive, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_InsertMedicine.createSequentialGroup()
											.addComponent(lblSupplier, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)))))
							.addGap(25)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.LEADING)
								.addComponent(NameMedicine, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addComponent(Class, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addComponent(GroupMedicine, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addComponent(Active, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addComponent(Content, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addComponent(CoverForm, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addComponent(Packing, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addComponent(Standard, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addComponent(RegisNumber, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addComponent(Supplier, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
								.addComponent(DateManufacture, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
							.addGap(75)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_InsertMedicine.createSequentialGroup()
									.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblPriceEnter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblPriceOut, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblUnitRetail, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblAmountRetailDefault, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblProNumOut, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblAmountNow, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblPriceRetailOut, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblDateImport, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNumImport, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(lblUnit, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_InsertMedicine.createSequentialGroup()
									.addComponent(lblDateOut, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addGap(46))))
						.addGroup(gl_InsertMedicine.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAddMedicine, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
							.addGap(230)))
					.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.LEADING)
						.addComponent(NumImport, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addComponent(DateImport, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addComponent(PriceOut, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addComponent(PriceRetailOut, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addComponent(AmountNow, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addComponent(AmountRetailDefault, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addComponent(UnitRetail, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addComponent(PriceEnter, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addComponent(Unit, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addComponent(DateOut, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addComponent(ProNumOut, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
					.addGap(44, 44, Short.MAX_VALUE))
		);
		gl_InsertMedicine.setVerticalGroup(
			gl_InsertMedicine.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InsertMedicine.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_InsertMedicine.createSequentialGroup()
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(RegisNumber, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRegisNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(NameMedicine, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNameMedicine, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(9))
						.addGroup(gl_InsertMedicine.createSequentialGroup()
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.TRAILING)
								.addComponent(DateOut, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDateOut, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.TRAILING)
								.addComponent(Unit, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUnit, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_InsertMedicine.createSequentialGroup()
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.BASELINE)
									.addComponent(Class, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblClass, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblPriceEnter, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addComponent(PriceEnter, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
							.addGap(9)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_InsertMedicine.createSequentialGroup()
									.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.BASELINE)
										.addComponent(GroupMedicine, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblGroupMedicine, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addGap(9)
									.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.TRAILING)
										.addComponent(Active, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblActive, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_InsertMedicine.createSequentialGroup()
									.addGap(9)
									.addComponent(lblNumImport, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblDateImport, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(9)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.TRAILING)
								.addComponent(Content, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblContent, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(CoverForm, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCoverForm, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPriceRetailOut, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(Packing, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPacking, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAmountNow, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.TRAILING)
								.addComponent(Standard, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStandard, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSupplier, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(Supplier, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGap(17))
						.addGroup(gl_InsertMedicine.createSequentialGroup()
							.addComponent(NumImport, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(DateImport, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(PriceOut, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPriceOut, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addComponent(PriceRetailOut, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(AmountNow, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(AmountRetailDefault, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAmountRetailDefault, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnitRetail, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(UnitRetail, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)))
					.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.LEADING)
						.addComponent(DateManufacture, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_InsertMedicine.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblProNumOut, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDateManufacture, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(ProNumOut, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
					.addComponent(btnAddMedicine, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
		);
		InsertMedicine.setLayout(gl_InsertMedicine);

	}
	
	protected void btnAddMedicineActionPerformed(ActionEvent e) {
		
		if(RegisNumber.getText().length()==0) {
			lblRegisNumber.setForeground(Color.red);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
			
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		
			
		}else if(NameMedicine.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.red);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
		
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(Class.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.red);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
		
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(GroupMedicine.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.red);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
		
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(Active.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.red);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
			
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(Content.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.red);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
			
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(CoverForm.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.red);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
			
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(Packing.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.red);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
			
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(RegisNumber.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
		
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(RegisNumber.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
		
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(Standard.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.red);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
		
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(DateManufacture.getDate()==null) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.red);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
		
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(DateOut.getDate()==null) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.red);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
	
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(Unit.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.red);
			lblPriceEnter.setForeground(Color.black);

			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(PriceEnter.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.red);
	
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(NumImport.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
		
			lblNumImport.setForeground(Color.red);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(DateImport.getDate()==null) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
		
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.red);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(PriceOut.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
	
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.red);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(PriceRetailOut.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);

			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.red);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(AmountNow.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);

			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.red);
		}else if(AmountRetailDefault.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);

			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.red);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
		}else if(ProNumOut.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);

			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.red);
			lblAmountNow.setForeground(Color.black);
		}else if(UnitRetail.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNameMedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverForm.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			lblDateManufacture.setForeground(Color.black);
			lblDateOut.setForeground(Color.black);
			lblUnit.setForeground(Color.black);
			lblPriceEnter.setForeground(Color.black);
	
			lblNumImport.setForeground(Color.black);
			lblDateImport.setForeground(Color.black);
			lblPriceOut.setForeground(Color.black);
			lblPriceRetailOut.setForeground(Color.black);
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitRetail.setForeground(Color.red);
			lblProNumOut.setForeground(Color.black);
			lblAmountNow.setForeground(Color.black);
				}else {
		
		
	
		Medicine medi = new Medicine();
		medi.setRegisNumber(RegisNumber.getText());
		medi.setNameMedicine(NameMedicine.getText());
		medi.setClass1(Class.getText());
		medi.setGroupMedicine(GroupMedicine.getText());
		medi.setActive(Active.getText());
		medi.setContent(Content.getText());
		medi.setCoverForm(CoverForm.getText());
		medi.setPacking(Packing.getText());
		medi.setStandard(Standard.getText());
//		medi.setIdSupplier(Integer.parseInt(Supplier.getSelectedItem().toString()));
		medi.setDateManufacture(
				LocalDate.ofInstant(DateManufacture.getDate().toInstant(),ZoneId.systemDefault()) 
				);
		medi.setDateOut(
				LocalDate.ofInstant(DateOut.getDate().toInstant(),ZoneId.systemDefault()) 
				);
		medi.setUnit(Unit.getText());
		medi.setPriceEnter(Double.parseDouble(PriceEnter.getText()));
		medi.setNumImport(Integer.parseInt(NumImport.getText()));
		medi.setUnitPrice(Double.parseDouble(PriceEnter.getText())*Integer.parseInt(NumImport.getText()));
		medi.setDateImport(
				LocalDate.ofInstant(DateImport.getDate().toInstant(),ZoneId.systemDefault()) 
				);
		medi.setPriceOut(Double.parseDouble(PriceOut.getText()));
		medi.setPriceRetailOut(Double.parseDouble(PriceRetailOut.getText()));
		medi.setAmountNow(Integer.parseInt(AmountNow.getText()));
		medi.setAmountRetailDefault(Double.parseDouble(AmountRetailDefault.getText()));
		medi.setUnitRetai(UnitRetail.getText());
		medi.setProNumOut(Integer.parseInt(ProNumOut.getText()));
		cac=0;
	
		MedicineDao.addComboboxid().stream().filter(i->i.getName().equals(Supplier.getSelectedItem())).forEach(i->{
			cac=i.getIdSupplier();
			});
		medi.setIdSupplier(cac);
		MedicineDao MedDao = new MedicineDao();
		if(MedDao.erroPhoneMed(medi.getRegisNumber())==true) {
			JOptionPane.showMessageDialog(null,"code already used");
			lblRegisNumber.setForeground(Color.red);
		}else {
		MedDao.InsertCustomer(medi);
		JOptionPane.showMessageDialog(null,"successful");
		lblRegisNumber.setForeground(Color.black);
		lblNameMedicine.setForeground(Color.black);
		lblClass.setForeground(Color.black);
		lblGroupMedicine.setForeground(Color.black);
		lblActive.setForeground(Color.black);
		lblContent.setForeground(Color.black);
		lblCoverForm.setForeground(Color.black);
		lblPacking.setForeground(Color.black);
		lblStandard.setForeground(Color.black);
		lblDateManufacture.setForeground(Color.black);
		lblDateOut.setForeground(Color.black);
		lblUnit.setForeground(Color.black);
		lblPriceEnter.setForeground(Color.black);

		lblNumImport.setForeground(Color.black);
		lblDateImport.setForeground(Color.black);
		lblPriceOut.setForeground(Color.black);
		lblPriceRetailOut.setForeground(Color.black);
		lblAmountRetailDefault.setForeground(Color.black);
		lblUnitRetail.setForeground(Color.black);
		lblProNumOut.setForeground(Color.black);
		lblAmountNow.setForeground(Color.black);
		RegisNumber.setText(null);
		NameMedicine.setText(null);
		Class.setText(null);
		GroupMedicine.setText(null);
		Active.setText(null);
		Content.setText(null);
		CoverForm.setText(null);
		Packing.setText(null);
		Standard.setText(null);
		DateManufacture.setDate(null);
		DateOut.setDate(null);
		Unit.setText(null);
		PriceEnter.setText(null);
		
		NumImport.setText(null);
		DateImport.setDate(null);
		PriceOut.setText(null);
		PriceRetailOut.setText(null);
		AmountNow.setText(null);
		AmountRetailDefault.setText(null);
	
		UnitRetail.setText(null);
		ProNumOut.setText(null);
			}
		}
	}
	public void restart() {
		Supplier.setModel(new DefaultComboBoxModel(new String[] {}));
		Sup=MedicineDao.addCombobox();
		for(var item : Sup) {
			Supplier.addItem(item);
		}
		
		
	}
	
	public void addcombobox() {
		Sup=MedicineDao.addCombobox();
		for(var item : Sup) {
			Supplier.addItem(item);
		}
	}

	public List<Supplier> getSupp() {
		return Supp;
	}

	public void setSupp(List<Supplier> supp) {
		Supp = supp;
	}

}
