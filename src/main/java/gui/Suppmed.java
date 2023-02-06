package gui;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import dao.MedicineDao;
import dao.SupplierDao;
import entity.Medicine;

import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Suppmed extends JPanel {
	private List<Medicine> arrayMed;
	private int stt=0;
	private int nowPlace=1;
	private int minimum=1;
	private int maximum;
	private int nowColum=20;
	private int total;
	private boolean status=true;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnLast;
	private JButton btnNext;
	private JSpinner spinner;
	private JSpinner spinnerColum;
	private List<Medicine> medicine;	
	private JLabel lblDDD;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private Medicine medicinee;

	public List<Medicine> getMedicine() {
		return medicine;
	}
	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}
	/**
	 * Create the panel.
	 */
	public Suppmed() {
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		add(panel, "name_334018080559000");
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPaneMouseClicked(e);
			}
		});
		
		btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastActionPerformed(e);
			}
		});
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinnerStateChanged(e);
			}
		});
		
		spinnerColum = new JSpinner();
		spinnerColum.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinnerColumStateChanged(e);
			}
		});
		
		lblDDD = new JLabel("1");
		
		scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnLast)
					.addGap(45)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(spinnerColum, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(lblDDD, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNext)
					.addGap(206))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 966, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 962, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(9, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLast)
						.addComponent(spinnerColum, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDDD, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNext)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(19))
		);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);

	}
	public void SelMed(List<Medicine> arrayMedd) {
		stt=1;
		DefaultTableModel model = new DefaultTableModel() {
					public Class<?> getColumnClass(int column){
						switch(column) {
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
				model.addColumn("NameSupplier");
				model.addColumn("StatusImport");
				
				
				
				//arrayMed=MedicineDao.getList();
				arrayMedd.
				stream().filter(i->{
					if(stt> (nowPlace-1)*nowColum &&  stt<=nowPlace*nowColum) {
						return true;
					}
				stt++;
					return false;
				}).forEach(
					peo -> {
						stt++;
						model.addRow(new Object[] {
							peo.getRegisNumber(), peo.getNameMedicine(), peo.getClass1(),peo.getGroupMedicine(),
							peo.getActive(),peo.getContent(),peo.getCoverForm(),peo.getPacking(),peo.getStandard(),peo.getAmountNow(),peo.getName(),peo.isStatusImport()?"Still Import":"Stop Import"
					});
					
					}	
				);
				
				table.setModel(model);
				table.setRowHeight(60);
//				table.getTableHeader().setReorderingAllowed(true);
//				table.getColumnModel().getColumn(1).setMinWidth(100);
//				table.setAutoCreateRowSorter(true);
			}
	public void pagingJtable() {
		total=arrayMed.size();
		nowColum=3;
		maximum=( Math.round(total/nowColum))+1;
		spinner.setValue(5);
		minimum=1;
		nowPlace=1;
		spinnerColum.setModel(new SpinnerNumberModel(1, 1, maximum, 1));
		
	}
	public void totalSupplier(int id) {
		arrayMed=SupplierDao.getListt(id);
		pagingJtable();
		SelMed(arrayMed);
	}
	protected void btnLastActionPerformed(ActionEvent e) {
		if(nowPlace==1) {
			return;
		}else {
			status=false;
			--nowPlace;
			spinnerColum.setValue(nowPlace);
			SelMed(arrayMed);
		}
	}
	protected void btnNextActionPerformed(ActionEvent e) {
		if(nowPlace==maximum) {
			return;
		}else {
			status=false;
			++nowPlace;
			spinnerColum.setValue(nowPlace);
			SelMed(arrayMed);
		}
	}
	protected void spinnerStateChanged(ChangeEvent e) {
		nowColum=Integer.valueOf(spinner.getValue().toString());	
		maximum=( Math.round(total/nowColum))+1;

		minimum=1;
		status=false;	
		spinnerColum.setModel(new SpinnerNumberModel(1, 1, maximum, 1));
		nowPlace=1;
			lblDDD.setText("/"+maximum);	
	SelMed(arrayMed);
	}
	protected void spinnerColumStateChanged(ChangeEvent e) {
		nowPlace=Integer.valueOf(spinnerColum.getValue().toString());		
		SelMed(arrayMed);
	}
	protected void scrollPaneMouseClicked(MouseEvent e) {
		arrayMed = MedicineDao.getList();
		pagingJtable();
		SelMed(arrayMed);
	}
	protected void tableMouseClicked(MouseEvent e) {
		Medicine mem = new Medicine();
		int[] rows = table.getSelectedRows();
		
		String id= (table.getValueAt(rows[0],0).toString());
		String name= (table.getValueAt(rows[0],1).toString());
		
		SupplierDao.SearchMed(id);
		
//		CustomerDao IdCus = new CustomerDao();
		//mem = CustomerDao.SearchIfCustomer(1);
		arrayMed.stream().filter(i->i.getRegisNumber()==id).forEach(i->medicinee=i);;
				DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0 : return Integer.class;
				case 4 : return Integer.class;
				case 5 : return Integer.class;
				case 6 : return Integer.class;
				case 8 : return Integer.class;
				case 9 : return Integer.class;
				case 10 : return Integer.class;
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
		
		
		
		arrayMed=MedicineDao.SearchMed(id);
		arrayMed.stream().forEach(
			peo -> {model.addRow(new Object[] {
					peo.getIdMedicine(),peo.getDateManufacture().toString(), peo.getDateOut().toString(), peo.getUnit(),peo.getPriceEnter(),
					peo.getUnitPrice(),peo.getNumImport(),peo.getDateImport().toString(),peo.getPriceOut(),peo.getPriceRetailOut(),peo.getAmountNow(),peo.isDeleteStatus()?"Still Import":"Stop Import"
			});
			peo.getDateManufacture();
			}	
		);
		
		table_1.setModel(model);
		String name2= (table_1.getValueAt(0,4).toString());
		String name3= (table_1.getValueAt(0,8).toString());
		String name4= (table_1.getValueAt(0,9).toString());
	

		table_1.setRowHeight(60);
		table_1.getColumnModel().getColumn(0).setMinWidth(100);
		table_1.getColumnModel().getColumn(1).setMinWidth(100);
		table_1.getColumnModel().getColumn(2).setMinWidth(50);
		table_1.getColumnModel().getColumn(3).setMinWidth(50);
		table_1.getColumnModel().getColumn(4).setMinWidth(50);
		table_1.getColumnModel().getColumn(5).setMinWidth(50);
		table_1.getColumnModel().getColumn(7).setMinWidth(50);
		table_1.getColumnModel().getColumn(8).setMinWidth(50);
		table_1.getColumnModel().getColumn(9).setMinWidth(50);
		table_1.getColumnModel().getColumn(6).setMinWidth(100);
	
	}
}
