import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BAI2.QLNV;
import BAI3.NHANVIENGUI;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Label;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class BAI1GUI extends JFrame {

	private JPanel contentPane;
	JButton btnbt1;
	JButton btnbt2;
	JButton btnbt3;
	JButton btnbt4;
	JButton btnbt5;
	JMenu mnfile;
	JMenuItem mntmsave;
	JMenuItem mntmsaveas;
	JMenuItem mntmexit;
	JMenu mnconsole;
	JMenuItem mntmbt1;
	JMenu mnbtgui;
	JMenuItem mntmgui1;
	JMenuItem mntmgui2;
	JMenu mnabout;
	JMenuItem mntmtacgia;
	JMenuItem mntmchuongtrinh;
	
	JLabel lbttsv;
	JLabel lbbackground;
	JLabel lbtacgia;
	JLabel lbemail;
	JPanel panel_1;
	JPanel panel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BAI1GUI frame = new BAI1GUI();
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

	public BAI1GUI() {
		setTitle("Mai Xuân Lợi - 2118110127");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 573);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnfile = new JMenu("File");
		mnfile.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnfile);
		
		mntmsave = new JMenuItem("Save");
		mnfile.add(mntmsave);
		
		mntmsaveas = new JMenuItem("Save as");
		mnfile.add(mntmsaveas);
		
		mntmexit = new JMenuItem("Exit");
		mntmexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "Thông báo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{
					System.exit(0);	
				}
			}
		});
		mnfile.add(mntmexit);
		
		mnconsole = new JMenu("Bài tập Console");
		mnconsole.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnconsole);
		
		mntmbt1 = new JMenuItem("Bài tập 1");
		mntmbt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLNV qlnv = new QLNV();
				qlnv.main(null);
			}
		});
		mnconsole.add(mntmbt1);
		
		mnbtgui = new JMenu("Bài tập GUI");
		mnbtgui.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnbtgui);
		
		mntmgui1 = new JMenuItem("GUI 1");
		mnbtgui.add(mntmgui1);
		
		mntmgui2 = new JMenuItem("GUI 2");
		mntmgui2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NHANVIENGUI nvgui;
				try {
					nvgui = new NHANVIENGUI();
					nvgui.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}														
			}
		});
		mnbtgui.add(mntmgui2);
		
		mnabout = new JMenu("About");
		mnabout.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnabout);
		
		mntmtacgia = new JMenuItem("Tác giả");
		mntmtacgia.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {				
				//lbbackground.hide();
				String t = "Tên tác giả: Mai Xuân Lợi\n         ";
				String m = "Mã số sinh viên: 2118110127\n       ";
				String l = "Lớp: CCQ1811B\n                     ";
				String k = "Khóa: 2018                          ";
				lbbackground.setIcon(new ImageIcon("null"));
				lbbackground.setText(t + m + l + k);
				
			}
		});
		mnabout.add(mntmtacgia);
		
		mntmchuongtrinh = new JMenuItem("Chương trình");
		mnabout.add(mntmchuongtrinh);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 149, 505);
		panel.setBackground(new Color(255, 222, 173));
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createRigidArea(new Dimension(0,20)));
		
		btnbt1 = new JButton("            Bài tập 1            ");
		panel.add(btnbt1);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		
		btnbt2 = new JButton("            Bài tạp 2            ");
		panel.add(btnbt2);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		
		btnbt3 = new JButton("            Bài tập 3            ");
		panel.add(btnbt3);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		
		btnbt4 = new JButton("            Bài tập 4            ");
		panel.add(btnbt4);
		Component rigidArea = Box.createRigidArea(new Dimension(0,10));
		panel.add(rigidArea);
		
		btnbt5 = new JButton("            Bài tập 5            ");
		panel.add(btnbt5);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		
		panel_1 = new JPanel();
		panel_1.setBounds(152, 5, 643, 419);
		contentPane.add(panel_1);
		panel_1.setLayout(null);	
		
		
		lbbackground = new JLabel("");
		lbbackground.setEnabled(true);
		lbbackground.setForeground(new Color(0, 0, 0));
		lbbackground.setBackground(Color.LIGHT_GRAY);
		lbbackground.setIcon(new ImageIcon("C:\\Users\\COMPUTER\\eclipse-workspace\\BTLONJAVA\\Image\\imac.jpg"));
		lbbackground.setBounds(0, 0, 643, 421);
		panel_1.add(lbbackground);
				
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(152, 424, 643, 86);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lbtacgia = new JLabel("Tác giả: Mai Xuân Lợi");
		lbtacgia.setEnabled(true);
		lbtacgia.setBounds(358, 26, 157, 19);
		lbtacgia.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(lbtacgia);
		
		lbemail = new JLabel("Email: xuanloi.2017mwg@gmail.com");
		lbemail.setBackground(Color.WHITE);
		lbemail.setEnabled(true);
		lbemail.setBounds(358, 56, 275, 19);
		lbemail.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(lbemail);	
	}
}
