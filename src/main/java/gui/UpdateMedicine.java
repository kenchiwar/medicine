package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.MedicineDao;
import entity.Medicine;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class UpdateMedicine extends JPanel {
	private JPanel panel;
	private JLabel lblRegisNumber;
	private JTextField RegisNumber;
	private JLabel lblNamemedicine;
	private JLabel lblClass;
	private JLabel lblGroupMedicine;
	private JLabel lblActive;
	private JLabel lblContent;
	private JTextField NameMedicine;
	private JTextField Class;
	private JTextField GroupMedicine;
	private JTextField Active;
	private JTextField Content;
	private JLabel lblCoverform;
	private JTextField CoverForm;
	private JLabel lblPacking;
	private JLabel lblStandard;
	private JLabel lblNameSupplier;
	private JTextField Packing;
	private JTextField Standard;
	private JButton btnUpdate;
	private String regis;
	private int cac;
	//
	private List<String> Sup;
	public String getRegis() {
		return regis;
	}

	public void setRegis(String regis) {
		this.regis = regis;
	}

//
private Medicine medicine;	
private JComboBox Supplier;
private JLabel lblUnit;
private JTextField Unit;
private JLabel lblProNumOut;
private JLabel lblUnitretail;
private JTextField UnitRetail;
private JLabel lblAmountRetailDefault;
private JTextField AmountRetailDefault;
private JTextField ProNumOut;


	public Medicine getMedicine() {
	return medicine;
}

public void setMedicine(Medicine medicine) {
	this.medicine = medicine;
}

	/**
	 * Create the panel.
	 */
	public UpdateMedicine() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(202, 207, 254));
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(202, 207, 254));
		add(panel, "name_211412732626875");
		
		lblRegisNumber = new JLabel("Regis Number");
		
		RegisNumber = new JTextField();
		RegisNumber.setColumns(10);
		
		lblNamemedicine = new JLabel("Name Medicine");
		
		lblClass = new JLabel("Class");
		
		lblGroupMedicine = new JLabel("Group Medicine");
		
		lblActive = new JLabel("Active");
		
		lblContent = new JLabel("Content");
		
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
		
		lblCoverform = new JLabel("Cover Form");
		
		CoverForm = new JTextField();
		CoverForm.setColumns(10);
		
		lblPacking = new JLabel("Packing");
		
		lblStandard = new JLabel("Standard");
		
		lblNameSupplier = new JLabel("Name Supplier");
		
		Packing = new JTextField();
		Packing.setColumns(10);
		
		Standard = new JTextField();
		Standard.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		
		Supplier = new JComboBox();
		addcombobox();
		
		lblUnit = new JLabel("Unit");
		
		Unit = new JTextField();
		Unit.setColumns(10);
		
		lblProNumOut = new JLabel("ProNumOut");
		
		lblUnitretail = new JLabel("Unit Retail");
		
		UnitRetail = new JTextField();
		UnitRetail.setColumns(10);
		
		lblAmountRetailDefault = new JLabel("Amount Retail Default");
		
		AmountRetailDefault = new JTextField();
		AmountRetailDefault.setColumns(10);
		
		ProNumOut = new JTextField();
		ProNumOut.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblRegisNumber, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(RegisNumber, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNamemedicine, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(NameMedicine, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblClass, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Class, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblGroupMedicine, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(GroupMedicine, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblActive, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Active, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblUnit, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Unit, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblUnitretail, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(UnitRetail, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)))
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProNumOut, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContent, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNameSupplier, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCoverform, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPacking, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStandard, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmountRetailDefault, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(AmountRetailDefault, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
						.addComponent(Content, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
						.addComponent(CoverForm, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
						.addComponent(Packing, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
						.addComponent(Standard, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(ProNumOut, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
							.addComponent(Supplier, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)))
					.addGap(16))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(367)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(427, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(100)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(45)
									.addComponent(CoverForm, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(Packing, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(Standard, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(Supplier, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addComponent(Content, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ProNumOut, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(AmountRetailDefault, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(45)
									.addComponent(lblCoverform, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblPacking, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblStandard, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNameSupplier, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblRegisNumber, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
										.addComponent(RegisNumber, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblContent, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNamemedicine, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
										.addComponent(NameMedicine, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblClass, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
										.addComponent(Class, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblGroupMedicine, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
										.addComponent(GroupMedicine, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblActive, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
										.addComponent(Active, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnit, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(Unit, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProNumOut, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUnitretail, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(UnitRetail, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAmountRetailDefault, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addGap(33)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(114, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}
	public void SelMedicine() {
		RegisNumber.setText(medicine.getRegisNumber());
		NameMedicine.setText(medicine.getNameMedicine());
		Class.setText(medicine.getClass1());
		GroupMedicine.setText(medicine.getGroupMedicine());
		Active.setText(medicine.getActive());
		Content.setText(medicine.getContent());
		CoverForm.setText(medicine.getCoverForm());
		Packing.setText(medicine.getPacking());
		Standard.setText(medicine.getStandard());
		Supplier.setSelectedItem(medicine.getName());
		Unit.setText(medicine.getUnit());
		UnitRetail.setText(medicine.getUnitRetai());
		AmountRetailDefault.setText(String.valueOf(medicine.getAmountRetailDefault()));
		ProNumOut.setText(String.valueOf(medicine.getProNumOut()));
	
		
		
		
		
	}
	protected void btnUpdateActionPerformed(ActionEvent e) {
		if(RegisNumber.getText().length()==0) {
			lblRegisNumber.setForeground(Color.red);
			lblNamemedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverform.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			
			lblUnit.setForeground(Color.black);
		
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitretail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
			
		
			
		}else if(NameMedicine.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNamemedicine.setForeground(Color.red);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverform.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			
			lblUnit.setForeground(Color.black);
		
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitretail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
		}else if(Class.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNamemedicine.setForeground(Color.black);
			lblClass.setForeground(Color.red);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverform.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			
			lblUnit.setForeground(Color.black);
		
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitretail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
		}else if(GroupMedicine.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNamemedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.red);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverform.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			
			lblUnit.setForeground(Color.black);
		
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitretail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
		}else if(Active.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNamemedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.red);
			lblContent.setForeground(Color.black);
			lblCoverform.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			
			lblUnit.setForeground(Color.black);
		
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitretail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
		}else if(Content.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNamemedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.red);
			lblCoverform.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			
			lblUnit.setForeground(Color.black);
		
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitretail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
		}else if(CoverForm.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNamemedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverform.setForeground(Color.red);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			
			lblUnit.setForeground(Color.black);
		
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitretail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
		}else if(Packing.getText().length()==0) {
			
			lblRegisNumber.setForeground(Color.black);
			lblNamemedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverform.setForeground(Color.black);
			lblPacking.setForeground(Color.red);
			lblStandard.setForeground(Color.black);
			
			lblUnit.setForeground(Color.black);
		
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitretail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
		
		}else if(Standard.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNamemedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverform.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.red);
			
			lblUnit.setForeground(Color.black);
		
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitretail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
		
		}else if(Unit.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNamemedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverform.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			
			lblUnit.setForeground(Color.red);
		
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitretail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
		
		}else if(AmountRetailDefault.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNamemedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverform.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			
			lblUnit.setForeground(Color.black);
		
			lblAmountRetailDefault.setForeground(Color.red);
			lblUnitretail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.black);
		}else if(ProNumOut.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNamemedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverform.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			
			lblUnit.setForeground(Color.black);
		
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitretail.setForeground(Color.black);
			lblProNumOut.setForeground(Color.red);
		}else if(UnitRetail.getText().length()==0) {
			lblRegisNumber.setForeground(Color.black);
			lblNamemedicine.setForeground(Color.black);
			lblClass.setForeground(Color.black);
			lblGroupMedicine.setForeground(Color.black);
			lblActive.setForeground(Color.black);
			lblContent.setForeground(Color.black);
			lblCoverform.setForeground(Color.black);
			lblPacking.setForeground(Color.black);
			lblStandard.setForeground(Color.black);
			
			lblUnit.setForeground(Color.black);
		
			lblAmountRetailDefault.setForeground(Color.black);
			lblUnitretail.setForeground(Color.red);
			lblProNumOut.setForeground(Color.black);
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
		medi.setUnit(Unit.getText());
		medi.setAmountRetailDefault(Double.valueOf(AmountRetailDefault.getText()));
		medi.setUnitRetai(UnitRetail.getText());
		medi.setProNumOut(Integer.valueOf(ProNumOut.getText()));
		medi.setName1(RegisNumber.getText());
		cac=0;
		
		MedicineDao.addComboboxid().stream().filter(i->i.getName().equals(Supplier.getSelectedItem())).forEach(i->{
			cac=i.getIdSupplier();
			});
		medi.setIdSupplier(cac);
		MedicineDao MedDao = new MedicineDao();
		int sell = JOptionPane.showConfirmDialog(null,"You realy want updata","notification",JOptionPane.YES_NO_CANCEL_OPTION);
		if(sell == JOptionPane.YES_OPTION) {
		if(MedDao.erroUpdateRegisNumber(medicine.getRegisNumber(),medi.getRegisNumber())==true) {
			JOptionPane.showMessageDialog(null,"code already used");
			lblRegisNumber.setForeground(Color.red);
		}else {
		MedDao.UpdateMedicine(medi,medicine.getRegisNumber());
		JOptionPane.showMessageDialog(null,"successful");
		lblRegisNumber.setForeground(Color.black);
		lblNamemedicine.setForeground(Color.black);
		lblClass.setForeground(Color.black);
		lblGroupMedicine.setForeground(Color.black);
		lblActive.setForeground(Color.black);
		lblContent.setForeground(Color.black);
		lblCoverform.setForeground(Color.black);
		lblPacking.setForeground(Color.black);
		lblStandard.setForeground(Color.black);
		
		lblUnit.setForeground(Color.black);
	
		lblAmountRetailDefault.setForeground(Color.black);
		lblUnitretail.setForeground(Color.black);
		lblProNumOut.setForeground(Color.black);
			}
		}
				}
	}
	public void addcombobox() {
		Sup=MedicineDao.addCombobox();
		for(var item : Sup) {
			Supplier.addItem(item);
		}
	}
}
