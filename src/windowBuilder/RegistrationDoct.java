package windowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.ConnectToDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class RegistrationDoct extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_smaller;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { RegistrationDoct frame = new
	 * RegistrationDoct(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	public RegistrationDoct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("With what specialist do you want to register for?");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(31, 28, 372, 36);
		contentPane.add(lblTitle);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(10, 79, 182, 36);
		contentPane.add(comboBox);

		ConnectToDB.fillComboBox(comboBox);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(99, 263, 231, 88);
		contentPane.add(scrollPane_1);

		table_smaller = new JTable();
		table_smaller.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConnectToDB.insertRegistration(table_smaller);
				ConnectToDB.getValuesFromTable(table, table_smaller);
			}
		});
		scrollPane_1.setViewportView(table_smaller);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 473, 94);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConnectToDB.getValuesFromTable(table, table_smaller);

				int rowCount = table_smaller.getModel().getRowCount();
				if (rowCount == 0) {
					scrollPane_1.setViewportView(null);
					JOptionPane.showMessageDialog(contentPane,
							"There is no available visits at this moment. " + "Please choose another doctor.");
				} else {
					scrollPane_1.setViewportView(table_smaller);
				}
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblAfterTable = new JLabel("");
		lblAfterTable.setBounds(10, 229, 483, 23);
		contentPane.add(lblAfterTable);

		JButton btn = new JButton("Load this area specialists");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectToDB.relateComboBox(comboBox, table);
				lblAfterTable
						.setText("Select above which doctor you want to register with and then select a visit below:");
				scrollPane_1.setViewportView(null);
			}
		});
		btn.setBounds(221, 92, 182, 23);
		contentPane.add(btn);

		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu();
				menu.setVisible(true);
			}
		});
		btnMenu.setBackground(SystemColor.activeCaption);
		btnMenu.setBounds(360, 0, 89, 23);
		contentPane.add(btnMenu);

		JLabel lbl_signout = new JLabel("");
		lbl_signout.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_signout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login.main(null);
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		lbl_signout.setIcon(new ImageIcon(img));
		lbl_signout.setBounds(435, 0, 48, 30);
		contentPane.add(lbl_signout);

	}
}
