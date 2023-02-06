package gui;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.time.LocalDate;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import dao.MedicineDao;
import entity.Medicine;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JpanelEndMedicine extends JPanel {
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnProcessed;
	private JButton btnLoad;
	private int stt=0;
	private int nowPlace=1;
	private int minimum=1;
	private int maximum;
	private int nowColum=20;
	private int total;
	private boolean status=true;
	private List<Medicine> arrayMed;
	private JButton btnAllProcessed;

	/**
	 * Create the panel.
	 */
	public JpanelEndMedicine() {
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		add(panel, "name_41692488894000");
		
		scrollPane = new JScrollPane();
		
		btnProcessed = new JButton("Processed");
		btnProcessed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnProcessedActionPerformed(e);
			}
		});
		
		btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadActionPerformed(e);
			}
		});
		
		btnAllProcessed = new JButton("\nAll processed");
		btnAllProcessed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAllProcessedActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(211)
					.addComponent(btnProcessed, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addComponent(btnAllProcessed, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(207))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(121)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(btnProcessed, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAllProcessed, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		
		table = new JTable();
		arrayMed =MedicineDao.getListEndDate();
		SelMed(arrayMed);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);

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
								peo.getIdMedicine(),peo.getDateManufacture(), peo.getDateOut(), peo.getUnit(),peo.getPriceEnter(),
								peo.getUnitPrice(),peo.getNumImport(),peo.getDateImport(),peo.getPriceOut(),peo.getPriceRetailOut(),
								peo.getAmountNow(),peo.isDeleteStatus(),peo.getRegisNumber(), peo.getNameMedicine(),peo.isStatusImport()
					});
					
					}	
				);
				
				table.setModel(model);
				table.setRowHeight(60);
//				table.getTableHeader().setReorderingAllowed(true);
//				table.getColumnModel().getColumn(1).setMinWidth(100);
//				table.setAutoCreateRowSorter(true);
			}
	protected void btnProcessedActionPerformed(ActionEvent e) {
		int sell = JOptionPane.showConfirmDialog(null,"You realy want Processed","notification",JOptionPane.YES_NO_CANCEL_OPTION);
		if(sell == JOptionPane.YES_OPTION) {
		int[] rows = table.getSelectedRows();
		int RegisNum= Integer.valueOf(table.getValueAt(rows[0],0).toString());
		MedicineDao.updateOutDate(RegisNum);
		arrayMed =MedicineDao.getListEndDate();
		SelMed(arrayMed);
		JOptionPane.showMessageDialog(null, "Successful");
		}
	}
	protected void btnAllProcessedActionPerformed(ActionEvent e) {
		int sell = JOptionPane.showConfirmDialog(null,"You realy want All Processed","notification",JOptionPane.YES_NO_CANCEL_OPTION);
		if(sell == JOptionPane.YES_OPTION) {
		var a=table.getModel().getRowCount();
		
		for(var b=0;b<a;b++) {
			var RegisNum= Integer.valueOf(table.getValueAt(b,0).toString());
			MedicineDao.updateOutDate(RegisNum);
		}
		arrayMed =MedicineDao.getListEndDate();
		SelMed(arrayMed);
		JOptionPane.showMessageDialog(null, "Successful");
		}
	}
	protected void btnLoadActionPerformed(ActionEvent e) {
		arrayMed =MedicineDao.getListEndDate();
		SelMed(arrayMed);
	}
}
