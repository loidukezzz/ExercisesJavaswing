package BAI3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Choice;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;


import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NHANVIENGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtmanv;
	private JTextField txttennv;
	private JTable table;
	JButton btnThem;
	JButton btnSua;
	JButton btnXoa;
	JButton btnThoat;
	JButton btnLuu;
	JDateChooser dcngaysinh;
	String []colsName = {"Mã nhân viên", "Tên nhân viên","Ngày sinh"};
	DefaultTableModel tableMode = new DefaultTableModel();
	NHANVIEN nv = new NHANVIEN();
	boolean them = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NHANVIENGUI frame = new NHANVIENGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void ClearData()
	{
		int n = tableMode.getRowCount()-1;
		for(int i=n; i>=0; i--)
			tableMode.removeRow(i);
	}
	public void ShowData() throws SQLException
	{
		ClearData();
		ResultSet rs = nv.Shownhanvien();
		while (rs.next()) {
			String rows[] = new String [3];
			rows[0] = rs.getString(1);
			rows[1] = rs.getString(2);
			rows[2] = rs.getString(3);
			tableMode.addRow(rows);		
			}
	}
	void Dieukhien(boolean b) {
		btnThem.setEnabled(!b);
		btnSua.setEnabled(b);
		btnXoa.setEnabled(b);
		table.setEnabled(!b);
		btnLuu.setEnabled(b);
		txtmanv.setEditable(b);
		txttennv.setEditable(b);	
		}

	void Xoatrang() {
		txtmanv.setText("");
		txttennv.setText("");
		dcngaysinh.setDate(null);
		}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NHANVIENGUI() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 563);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dieukhien(false);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunLNhn = new JLabel("DANH SÁCH NHÂN VIÊN");
		lblQunLNhn.setForeground(Color.RED);
		lblQunLNhn.setFont(new Font("Dialog", Font.BOLD, 28));
		lblQunLNhn.setBounds(228, 11, 332, 65);
		contentPane.add(lblQunLNhn);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them = true;
				Dieukhien(true);
				Xoatrang();
			}
		});
		btnThem.setBounds(60, 187, 100, 32);
		contentPane.add(btnThem);
		
		btnXoa = new JButton("Xoá");
		btnXoa.setEnabled(false);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma= txtmanv.getText();
				try {
					int n = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá không?","Thông báo",JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION)
					{
						nv.Xoa(ma);
						ShowData();
						JOptionPane.showMessageDialog(null, "Xoá thành công");
						Xoatrang();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();				
					}
				them=true;
				Dieukhien(false);
			}
		});
		btnXoa.setBounds(198, 187, 100, 32);
		contentPane.add(btnXoa);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma, ten;
				String date;
				NHANVIENOBJECT nvo;
				ma = txtmanv.getText();	
				ten = txttennv.getText();	
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				date = sdf.format(dcngaysinh.getDate());

				if(txtmanv.getText().length()==0||txttennv.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
					return;
				} 				
				nvo = new NHANVIENOBJECT(ma, ten, date);
				if(them==true)
				{
					try {						
						try {
							if(dcngaysinh.getDate().compareTo(sdf.parse("2000-11-03"))<0) {
							nv.Themdl(nvo);
							ShowData();
							JOptionPane.showMessageDialog(null, "Thêm thành công");
							}
							else {
								JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh nhỏ hơn ngày 03/11/2000");
							}
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error ");
					}
				}
				else {
						try {
							try {
								if(dcngaysinh.getDate().compareTo(sdf.parse("2000-11-03"))<0) {
								nv.Sua(nvo);
								ShowData();
								JOptionPane.showMessageDialog(null, "Sửa thành công");
								}
								else {
									JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh nhỏ hơn ngày 03/11/2000");
								}
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error ");
					}
				}									
				Dieukhien(false);
			}
		});
		btnLuu.setBounds(329, 187, 100, 32);
		contentPane.add(btnLuu);
		
		btnSua = new JButton("Sửa");
		btnSua.setEnabled(false);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them=false;
				Dieukhien(true);
				txtmanv.setEditable(false);
			}
		});
		btnSua.setBounds(460, 187, 100, 32);
		contentPane.add(btnSua);
		
		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "Thông báo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{	
					Container frame = btnThoat.getParent();
		            do 
		                frame = frame.getParent(); 
		            while (!(frame instanceof JFrame));                                      
		            ((JFrame) frame).dispose();
				}
			}
		});
		btnThoat.setBounds(604, 187, 99, 32);
		contentPane.add(btnThoat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 271, 643, 227);
		contentPane.add(scrollPane);
		
		tableMode.setColumnIdentifiers(colsName);
				
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String mnv = (table.getModel().getValueAt(row, 0).toString());
				ResultSet rs;	
				try {
					rs = nv.Shownvpma(mnv);
					if(rs.next()) {
						txtmanv.setText(rs.getString(1));
						txttennv.setText(rs.getString(2));
						dcngaysinh.setDate(rs.getDate(3));
					}
				}
				catch (Exception el) {
					// TODO: handle exception
					el.printStackTrace();
				}
				//Dieukhien(true);
				txtmanv.setEditable(true);
				txttennv.setEditable(true);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnThem.setEnabled(false);
			}			
		});
		table.setModel(tableMode);
		ShowData();			
		scrollPane.setViewportView(table);	
		
		txtmanv = new JTextField();
		txtmanv.setEditable(false);
		txtmanv.setColumns(10);
		txtmanv.setBounds(170, 87, 203, 30);
		contentPane.add(txtmanv);
		
		txttennv = new JTextField();
		txttennv.setEditable(false);
		txttennv.setColumns(10);
		txttennv.setBounds(170, 128, 533, 30);
		contentPane.add(txttennv);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(60, 72, 100, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(60, 115, 100, 58);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(403, 71, 82, 58);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		dcngaysinh = new JDateChooser();
		dcngaysinh.setBounds(506, 87, 197, 30);			
		contentPane.add(dcngaysinh);
		dcngaysinh.setDateFormatString("yyyy-MM-dd");	
	}
}
