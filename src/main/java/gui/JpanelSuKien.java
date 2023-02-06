package gui;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.BillDao;
import dao.CustomerDao;
import dao.MedicineDao;
import dao.SuKienDao;
import entity.Medicine;
import entity.SuKien;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JSplitPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;

public class JpanelSuKien extends JPanel {
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textName;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textGift;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JComboBox comboBox;
	private JDateChooser dateStart;
	private JDateChooser dateEnd;
	private JScrollPane scrollPane;
	private JTable table;
	//code tự tạo
	private int stt=0;
	private int stt2=0;
	private int nowPlace=1;
	private int minimum=1;
	private int maximum;
	private int nowColum=20;
	private int total;
	private boolean status=true;
	List<Medicine> listMedicine;
	private String chuoi;
	private SuKien eventK;
	private boolean checka=false; //xét trường hợp cho search
	private String chuoiSearch="";
	
	public SuKien getEventK() {
		return eventK;
	}

	public void setEventK(SuKien eventK) {
		this.eventK = eventK;
	}
	//
	private JPanel panel_1;
	private JLabel lblMoney;
	private JLabel lblQuanity;
	private JSpinner spinnerMoney;
	private JSpinner spinnerQuanity;
	private JTextField textSearch;
	private JButton btnSearch;
	private JButton btnPrevious;
	private JSpinner spinnerXXX;
	private JLabel lblDDD;
	private JButton btnNext;
	private JSpinner spinnerColum;
	private JButton btnLoad;
	private JButton btnCreate;
	private JButton btnRestart;
	private JSpinner textSale;
	private JButton btnUpdate;
	private JRadioButton rdbtnChoose;
	private JLabel lblSale;
	private JSpinner spinnerSale;

	/**
	 * Create the panel.
	 */
	
	public JpanelSuKien() {
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		add(panel, "name_342671867436000");
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textName = new JTextField();
		textName.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textName.setForeground(new Color(0, 0, 0));
		textName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textName.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Sale");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_2 = new JLabel("Gift");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textGift = new JTextField();
		textGift.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textGift.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textGift.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Category");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_4 = new JLabel("Start");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_5 = new JLabel("End");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_6 = new JLabel("Event");
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
	
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1.Sale % ", "2.Giam tien"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		dateStart = new JDateChooser();
		dateStart.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		dateStart.setDateFormatString("dd/MM/yyyy");
		
		dateEnd = new JDateChooser();
		dateEnd.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		dateEnd.setDateFormatString("dd/MM/yyyy");
		
		scrollPane = new JScrollPane();
		
		panel_1 = new JPanel();
		
		lblMoney = new JLabel("Money");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblQuanity = new JLabel("Quanity");
		lblQuanity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		spinnerMoney = new JSpinner();
		spinnerMoney.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		spinnerMoney.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(10000)));
		spinnerMoney.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		spinnerQuanity = new JSpinner();
		spinnerQuanity.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		spinnerQuanity.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(10000)));
		spinnerQuanity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textSearch = new JTextField();
		textSearch.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSearch_actionPerformed(e);
			}
		});
		
		btnCreate = new JButton("CREATE ");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCreate_actionPerformed(e);
			}
		});
		
		btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		
		textSale = new JSpinner();
		textSale.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdate_actionPerformed(e);
			}
		});
		
		rdbtnChoose = new JRadioButton("Choose All ");
		
		lblSale = new JLabel("Sale %");
		lblSale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		spinnerSale = new JSpinner();
		spinnerSale.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		spinnerSale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerSale.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textSearch, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(rdbtnChoose, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRestart)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearch)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textGift, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, 0, 267, Short.MAX_VALUE)
									.addGap(2))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dateStart, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dateEnd, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
							.addGap(453))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textName, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
									.addGap(26)
									.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(spinnerMoney, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textSale, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblSale, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(spinnerSale, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblQuanity, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(spinnerQuanity, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
											.addGap(1)))))
							.addGap(74))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addGap(7))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(textName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(textSale, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(textGift, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateStart, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(dateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinnerMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMoney, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblQuanity, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinnerQuanity, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(spinnerSale, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSale, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch)
						.addComponent(btnRestart)
						.addComponent(rdbtnChoose))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		btnPrevious = new JButton("Last");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPrevious_actionPerformed(e);
			}
		});
		
		spinnerXXX = new JSpinner();
		spinnerXXX.setModel(new SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnerXXX.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_spinner_2_stateChanged(e);
			}
		});
		
		lblDDD = new JLabel("/1");
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNext_actionPerformed(e);
			}
		});
		
		spinnerColum = new JSpinner();
		spinnerColum.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_spinnerColum_stateChanged(e);
			}
		});
		
		btnLoad = new JButton("Load Data");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPrevious)
					.addGap(22)
					.addComponent(spinnerXXX, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinnerColum, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblDDD, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNext)
					.addGap(94))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnPrevious)
							.addComponent(spinnerColum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(spinnerXXX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDDD)
								.addComponent(btnNext))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_table_mouseClicked(e);
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
		table.setAutoCreateRowSorter(true);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		panel.setLayout(gl_panel);
		
		
		
		//textName.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
		//textName.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		listMedicine=MedicineDao.getListEvent();
		pagingJtable();
		SelMed( listMedicine);
		
		
	}
	// dùng khi kêu jpanel update
	public void totalUpdate(int id) {
		eventK=SuKienDao.idSuKien(id);
		if((Period.between(eventK.getEndDate(), java.time.LocalDate.now())
					.isNegative())) {
			listMedicine=MedicineDao.getListEvent();
			pagingJtable();
			btnCreate.setVisible(false);
			btnUpdate.setVisible(true);
			enabledSuKien(true);
			checka=false;
			SelUpdate(listMedicine,eventK);
			setInfoSuKien();
		}else {
			listMedicine=MedicineDao.getListEvent();
			pagingJtable();
			btnCreate.setVisible(false);
			btnUpdate.setVisible(false);
			enabledSuKien(false);
			checka=false;
			SelUpdate(listMedicine,eventK);
			setInfoSuKien();
		}
		
		
	}
	
	public void totalAdd() {
		listMedicine=MedicineDao.getListEvent();
		pagingJtable();
		btnCreate.setVisible(true);
		btnUpdate.setVisible(false);
		enabledSuKien(true);
		SelMed( listMedicine);
		
		setNullSuKien();
		
	}
	
	private void SelMed(List<Medicine> arrayMedd) {
		stt=1;
		DefaultTableModel model = new DefaultTableModel() {
					public Class<?> getColumnClass(int column){
						switch(column) {
						case 2 : return Boolean.class;
						case 10 : return Integer.class;
						}
						return String.class;
					}
					 public boolean isCellEditable(int row, int column){
						 switch(column) {
							case 2 : return true;
							}
							
					        return false;
					    }
				   
				};
				
				model.addColumn("RegisNumber");
				model.addColumn("NameMedicine");
				model.addColumn("Choose");
				model.addColumn("Class");
				model.addColumn("GroupMedicine");
				model.addColumn("Active");
				model.addColumn("Content");
				model.addColumn("CoverForm");
				model.addColumn("Packing");
				model.addColumn("Standard");
				model.addColumn("Amount Now");
				model.addColumn("Supplier");
			
				
				
				
				//arrayMed=MedicineDao.getList();
				arrayMedd.
				stream()
				.filter(i->{
					if(stt> (nowPlace-1)*nowColum &&  stt<=nowPlace*nowColum) {
						return true;
					}
				stt++;
					return false;
				})
				.forEach(
					peo -> {
						stt++;
						model.addRow(new Object[] {
							peo.getRegisNumber(), peo.getNameMedicine(),
							peo.isDeleteStatus(), peo.getClass1(),peo.getGroupMedicine(),
							peo.getActive(),peo.getContent(),peo.getCoverForm(),peo.getPacking()
							,peo.getStandard(),peo.getAmountNow(),peo.getName()
					});
					
					}	
				);
				
				table.setModel(model);
				table.setRowHeight(60);
//				table.getTableHeader().setReorderingAllowed(true);
//				table.getColumnModel().getColumn(1).setMinWidth(100);
				table.getColumnModel().getColumn(0).setMinWidth(200);
				table.getColumnModel().getColumn(1).setMinWidth(150);
				table.getColumnModel().getColumn(2).setMinWidth(100);
				table.getColumnModel().getColumn(10).setMinWidth(100);
//				table.setAutoCreateRowSorter(true);
			}
	private void SelSearch(List<Medicine> arrayMedd,String search) {
		stt=1;
		stt2=0;
		DefaultTableModel model = new DefaultTableModel() {
					public Class<?> getColumnClass(int column){
						switch(column) {
						case 2 : return Boolean.class;
						case 10 : return Integer.class;
						}
						return String.class;
					}
					 public boolean isCellEditable(int row, int column){
						 switch(column) {
							case 2 : return true;
							}
							
					        return false;
					    }
				   
				};
				
				model.addColumn("RegisNumber");
				model.addColumn("NameMedicine");
				model.addColumn("Choose");
				model.addColumn("Class");
				model.addColumn("GroupMedicine");
				model.addColumn("Active");
				model.addColumn("Content");
				model.addColumn("CoverForm");
				model.addColumn("Packing");
				model.addColumn("Standard");
				model.addColumn("Amount Now");
				model.addColumn("Supplier");
			
				
				
				
				//arrayMed=MedicineDao.getList();
				arrayMedd.
				stream()
				.filter(i->{
					if(stt> (nowPlace-1)*nowColum &&  stt<=nowPlace*nowColum) {
						return true;
					}
				stt++;
				stt2++;
					return false;
				})
				.filter(i->
					i.getRegisNumber().toLowerCase().indexOf(search.toLowerCase())>=0 || 
						i.getNameMedicine().toLowerCase().indexOf(search.toLowerCase())>=0
				)
				.forEach(
					peo -> {
						stt++;
						stt2++;
						model.addRow(new Object[] {
							peo.getRegisNumber(), peo.getNameMedicine(),
							peo.isDeleteStatus(), peo.getClass1(),peo.getGroupMedicine(),
							peo.getActive(),peo.getContent(),peo.getCoverForm(),peo.getPacking()
							,peo.getStandard(),peo.getAmountNow(),peo.getName()
					});
					
					}	
				);
			
				table.setModel(model);
			
				table.getTableHeader().setReorderingAllowed(true);
//				table.getColumnModel().getColumn(1).setMinWidth(100);
				table.getColumnModel().getColumn(0).setMinWidth(200);
				table.getColumnModel().getColumn(1).setMinWidth(150);
				table.getColumnModel().getColumn(2).setMinWidth(100);
				table.getColumnModel().getColumn(10).setMinWidth(100);
				
//				table.setAutoCreateRowSorter(true);
			}
	public void pagingJtable() {
		total=listMedicine.size();
		nowColum=20;
		maximum=( Math.round(total/nowColum))+1;
		spinnerXXX.setValue(5);
		minimum=1;
		nowPlace=1;
		spinnerColum.setModel(new SpinnerNumberModel(1, 1, maximum, 1));
		lblDDD.setText("/"+maximum);
		
	}
	public void pagingJtable2() {
		checka=true;
		total=stt2;
		nowColum=5;
		maximum=( Math.round(total/nowColum))+1;
		spinnerXXX.setValue(5);
		minimum=1;
		nowPlace=1;
		spinnerColum.setModel(new SpinnerNumberModel(1, 1, maximum, 1));
		lblDDD.setText("/"+maximum);
		
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		int[] rows = table.getSelectedRows();
		if(rows.length>0) {
		listMedicine.stream().filter(i->i.getRegisNumber().equals(table.getValueAt(rows[0], 0).toString()))
		.forEach(i->
		{i.setDeleteStatus(Boolean.valueOf(table.getValueAt(rows[0], 2).toString()));
		});
	
		}
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		listMedicine=MedicineDao.getListEvent();
		
		setNullSuKien();
		pagingJtable() ;
		SelMed( listMedicine);	
		
	}
	protected void do_btnPrevious_actionPerformed(ActionEvent e) {
		
			if(nowPlace==1) {
				return;
			}else {
				status=false;
				--nowPlace;
				spinnerColum.setValue(nowPlace);
				if(checka) {
					SelSearch(listMedicine,chuoiSearch);
				}else
				{
				SelMed( listMedicine);	
				}
			}
		
	}
	protected void do_spinner_2_stateChanged(ChangeEvent e) {
		nowColum=Integer.valueOf(spinnerXXX.getValue().toString());	
	maximum=( Math.round(total/nowColum))+1;

	minimum=1;
	status=false;	
	spinnerColum.setModel(new SpinnerNumberModel(1, 1, maximum, 1));
	nowPlace=1;
		lblDDD.setText("/"+maximum);	
		if(checka) {
			SelSearch(listMedicine,chuoiSearch);
		}else
		{
		SelMed( listMedicine);	
		}
		
	}
	protected void do_spinnerColum_stateChanged(ChangeEvent e) {
		nowPlace=Integer.valueOf(spinnerColum.getValue().toString());		
		if(checka) {
			SelSearch(listMedicine,chuoiSearch);
		}else
		{
		SelMed( listMedicine);	
		}
	
	}
	protected void do_btnNext_actionPerformed(ActionEvent e) {
		if(nowPlace==maximum) {
			return;
		}else {
			status=false;
			++nowPlace;
			spinnerColum.setValue(nowPlace);
			if(checka) {
				SelSearch(listMedicine,chuoiSearch);
			}else
			{
			SelMed( listMedicine);	
			}
		}
	}
	
	protected void do_btnSearch_actionPerformed(ActionEvent e) {
		chuoiSearch=textSearch.getText().trim();
		SelSearch(listMedicine,chuoiSearch);
		pagingJtable2() ;
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		checka=false;
		pagingJtable() ;
		SelMed( listMedicine);	
	}
	
	protected void do_btnCreate_actionPerformed(ActionEvent e) {
		if(JOptionPane.showConfirmDialog(null,
"Choose", "Are you sure want to Create Event", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
			textName.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			textSale.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			textGift.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			spinnerSale.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

			comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			dateStart.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			dateEnd.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			spinnerMoney.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			spinnerQuanity.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			var checkTrue="";
			var check= "";
			check+=(textName.getText().length()==0)?"Name is Null \n":"" ;
			check+=(textName.getText().length()<10)?"Name is too short \n":"";
			
			
			checkTrue+=check;
			if(!check.equals("")) textName.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
			//1 thằng
			check="";
			check+=(dateStart.getDate()==null)?"Time start Event is Null \n":"";
			if(check.equals("")) {
			check+=(!Period.between(LocalDate.ofInstant
					(dateStart.getDate().toInstant(),ZoneId.systemDefault()), java.time.LocalDate.now())
					.isNegative())?"Tims Start is Lower than Now !\n":"";
		
			
			}
			
			checkTrue+=check;
			if(!check.equals("")) dateStart.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
			//2 thằng
			check="";
		
			check+=(dateEnd.getDate()==null)?"Time end Event is Null \n":"";
			if(check.equals("")) {
				check+=(!Period.between(LocalDate.ofInstant
						(dateEnd.getDate().toInstant(),ZoneId.systemDefault()), 
						LocalDate.ofInstant
						(dateStart.getDate().toInstant(),ZoneId.systemDefault()))
						.isNegative())?"Tims End event is Lower than Time Start !\n":"";
			}
			
			checkTrue+=check;
			if(!check.equals("")) dateEnd.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
			
			
			// 3 thằng
			check="";
			
			check+=(textGift.getText().length()==0 && textGift.isEnabled())?"Time end Event is Null \n":"";
			
			checkTrue+=check;
			if(!check.equals("")) textGift.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
			//4 thằng
			
//			if(textSale.getValue().toString().length()==0 && textSale.isEnabled()) {textSale.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
//			
//			}
//			
//			
//			//5 thằng
//			if(spinnerQuanity.getValue().toString().length()==0 && spinnerQuanity.isEnabled()) {spinnerQuanity.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
//			
//			}
//			
//			//6 thằng
//			if(spinnerMoney.getValue().toString().length()==0 && spinnerMoney.isEnabled()) {spinnerMoney.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
//			
//			}
			
			
			
			
			if(!checkTrue.equals("")) {
				JOptionPane.showMessageDialog(null, checkTrue, "Something wrong", JOptionPane.ERROR_MESSAGE);
				return;
			}
			var suKien = new SuKien();

			suKien.setNameEvent(textName.getText());
			suKien.setCategory(Integer.valueOf(comboBox.getSelectedItem().toString().substring(0,comboBox.getSelectedItem().toString().indexOf("."))));
			suKien.setStartDate(LocalDate.ofInstant(dateStart.getDate().toInstant(),ZoneId.systemDefault()));
			suKien.setEndDate(LocalDate.ofInstant(dateEnd.getDate().toInstant(),ZoneId.systemDefault()));
			suKien.setGift(textGift.getText());
			suKien.setPrice(Float.valueOf(spinnerMoney.getValue().toString()))	;
			suKien.setSale(Float.valueOf(textSale.getValue().toString()));
			suKien.setQuanity(Integer.valueOf(spinnerQuanity.getValue().toString()));
			chuoi = "";
//			System.out.println(Period.between(suKien.getStartDate(), java.time.LocalDate.now()).isNegative());
			if(rdbtnChoose.isSelected()) {
				eventK.setMedicine("ALL");
			}else {
			listMedicine.stream().filter(i->i.isDeleteStatus()).forEach(i->
			chuoi=chuoi+i.getRegisNumber()+","
					);
			eventK.setMedicine(chuoi);
			}
			
			SuKienDao.insertSuKien(suKien);
			JOptionPane.showMessageDialog(null, "Success", "Insert Success", JOptionPane.DEFAULT_OPTION);
		
		}
		
	}
	//set enable cho cac thuoc tinh
	protected void enabledSuKien(boolean chan) {
		textName.setEnabled(chan);
		textName.setEnabled(chan);
		textSale.setEnabled(chan);
		textGift.setEnabled(chan);
		spinnerSale.setEnabled(chan);
		comboBox.setEnabled(chan);
		dateStart.setEnabled(chan);
		dateEnd.setEnabled(chan);
		spinnerMoney.setEnabled(chan);
		spinnerQuanity.setEnabled(chan);
		table.setEnabled(chan);
		rdbtnChoose.setEnabled(chan);
		btnSearch.setEnabled(chan);
		btnRestart.setEnabled(chan);
		btnLoad.setEnabled(chan);
		
	}
	// chuyển dữ liệu về trạng thái khuôn mẫu
	protected void setNullSuKien() {
		textName.setText("");
		textSale.setValue(0);
		textGift.setText("");
		spinnerSale.setValue(0);
		dateStart.setDate(null);
		dateEnd.setDate(null);
		spinnerMoney.setValue(0);
		spinnerQuanity.setValue(0);
		comboBox.setSelectedIndex(0);
		rdbtnChoose.setSelected(false);
		checka=false;
	}
	//in dữ liệu dựa vào biến k
	protected void setInfoSuKien() {
		textName.setText(eventK.getNameEvent());
		textSale.setValue(eventK.getSale());
		textGift.setText(eventK.getGift());
		dateStart.setDate(java.sql.Date.valueOf(eventK.getStartDate()));
		dateEnd.setDate(java.sql.Date.valueOf(eventK.getEndDate()));
		spinnerMoney.setValue(eventK.getPrice());
		spinnerQuanity.setValue(eventK.getQuanity());
		comboBox.setSelectedIndex(eventK.getCategory()-1);
		rdbtnChoose.setSelected(eventK.getMedicine().indexOf("ALL")>=0?true:false);
		
	}
	// dùng trong phần update 
	private void SelUpdate(List<Medicine> arrayMedd,SuKien suKien) {
		stt=1;
		DefaultTableModel model = new DefaultTableModel() {
					public Class<?> getColumnClass(int column){
						switch(column) {
						case 2 : return Boolean.class;
						case 10 : return Integer.class;
						}
						return String.class;
					}
					 public boolean isCellEditable(int row, int column){
						 switch(column) {
							case 2 : return true;
							}
							
					        return false;
					    }
				   
				};
				
				model.addColumn("RegisNumber");
				model.addColumn("NameMedicine");
				model.addColumn("Choose");
				model.addColumn("Class");
				model.addColumn("GroupMedicine");
				model.addColumn("Active");
				model.addColumn("Content");
				model.addColumn("CoverForm");
				model.addColumn("Packing");
				model.addColumn("Standard");
				model.addColumn("Amount Now");
				model.addColumn("Supplier");
			
				
				
				
				//arrayMed=MedicineDao.getList();
				arrayMedd.
				stream()
				.filter(i->{
					if(stt> (nowPlace-1)*nowColum &&  stt<=nowPlace*nowColum) {
						return true;
					}
				stt++;
					return false;
				})
				.forEach(
					peo -> {
						stt++;
						if(suKien.getMedicine().indexOf(peo.getRegisNumber()+",")>=0) 
							peo.setDeleteStatus(true);
						
						model.addRow(new Object[] {
							peo.getRegisNumber(), peo.getNameMedicine(),
							peo.isDeleteStatus(), peo.getClass1(),peo.getGroupMedicine(),
							peo.getActive(),peo.getContent(),peo.getCoverForm(),peo.getPacking()
							,peo.getStandard(),peo.getAmountNow(),peo.getName()
					});
					
					}	
				);
				
				table.setModel(model);
				
//				table.getTableHeader().setReorderingAllowed(true);
//				table.getColumnModel().getColumn(1).setMinWidth(100);
				table.getColumnModel().getColumn(0).setMinWidth(200);
				table.getColumnModel().getColumn(1).setMinWidth(150);
				table.getColumnModel().getColumn(2).setMinWidth(100);
				table.getColumnModel().getColumn(10).setMinWidth(100);
//				table.setAutoCreateRowSorter(true);
			}
	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		if(JOptionPane.showConfirmDialog(null,
				"Choose", "Are you sure want to update Event", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
							textName.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
							textSale.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
							textGift.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
							comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
							dateStart.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
							dateEnd.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
							spinnerMoney.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
							spinnerQuanity.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
							var checkTrue="";
							var check= "";
							check+=(textName.getText().length()==0)?"Name is Null \n":"" ;
							check+=(textName.getText().length()<10)?"Name is too short \n":"";
							
							
							checkTrue+=check;
							if(!check.equals("")) textName.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
							//1 thằng
							check="";
							check+=(dateStart.getDate()==null)?"Time start Event is Null \n":"";
//							if(check.equals("")) {
//							check+=(!Period.between(LocalDate.ofInstant
//									(dateStart.getDate().toInstant(),ZoneId.systemDefault()), java.time.LocalDate.now())
//									.isNegative())?"Tims Start is Lower than Now !\n":"";
//						
//							
//							}
							
							checkTrue+=check;
							if(!check.equals("")) dateStart.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
							//2 thằng
							check="";
						
							check+=(dateEnd.getDate()==null)?"Time end Event is Null \n":"";
							if(check.equals("")) {
								check+=(!Period.between(LocalDate.ofInstant
										(dateEnd.getDate().toInstant(),ZoneId.systemDefault()), 
										LocalDate.ofInstant
										(dateStart.getDate().toInstant(),ZoneId.systemDefault()))
										.isNegative())?"Tims End event is Lower than Time Start !\n":"";
							}
							
							checkTrue+=check;
							if(!check.equals("")) dateEnd.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
							
							
							// 3 thằng
							check="";
							
							check+=(textGift.getText().length()==0 && textGift.isEnabled())?"Time end Event is Null \n":"";
							
							checkTrue+=check;
							if(!check.equals("")) textGift.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
							//4 thằng
							
//							if(textSale.getValue().toString().length()==0 && textSale.isEnabled()) {textSale.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
//							
//							}
//							
//							
//							//5 thằng
//							if(spinnerQuanity.getValue().toString().length()==0 && spinnerQuanity.isEnabled()) {spinnerQuanity.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
//							
//							}
//							
//							//6 thằng
//							if(spinnerMoney.getValue().toString().length()==0 && spinnerMoney.isEnabled()) {spinnerMoney.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
//							
//							}
							
							
							
							
							if(!checkTrue.equals("")) {
								JOptionPane.showMessageDialog(null, checkTrue, "Something wrong", JOptionPane.ERROR_MESSAGE);
								return;
							}
							

							eventK.setNameEvent(textName.getText());
							eventK.setCategory(Integer.valueOf(comboBox.getSelectedItem().toString().substring(0,comboBox.getSelectedItem().toString().indexOf("."))));
							eventK.setStartDate(LocalDate.ofInstant(dateStart.getDate().toInstant(),ZoneId.systemDefault()));
							eventK.setEndDate(LocalDate.ofInstant(dateEnd.getDate().toInstant(),ZoneId.systemDefault()));
							eventK.setGift(textGift.getText());
							eventK.setPrice(Float.valueOf(spinnerMoney.getValue().toString()))	;
							eventK.setSale(Float.valueOf(textSale.getValue().toString()));
							eventK.setQuanity(Integer.valueOf(spinnerQuanity.getValue().toString()));
							chuoi = "";
//							System.out.println(Period.between(suKien.getStartDate(), java.time.LocalDate.now()).isNegative());
							if(rdbtnChoose.isSelected()) {
								eventK.setMedicine("ALL");
							}else {
							listMedicine.stream().filter(i->i.isDeleteStatus()).forEach(i->
							chuoi=chuoi+i.getRegisNumber()+","
									);
							eventK.setMedicine(chuoi);
							}
							SuKienDao.updateSuKien(eventK);
							JOptionPane.showMessageDialog(null, "Success", "Insert Success", JOptionPane.DEFAULT_OPTION);
						
						}
	}
}
