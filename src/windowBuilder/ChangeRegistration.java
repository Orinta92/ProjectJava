package windowBuilder;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.ConnectToDB;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class ChangeRegistration extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton buttonMenu;
	private JButton btnLoad;
	private JLabel lblGoToRegist;
	private JLabel lbl_signout;


	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ChangeRegistration frame = new
	 * ChangeRegistration(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	public ChangeRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 576, 88);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ConnectToDB.cancelVisit(table, lblGoToRegist);
				ConnectToDB.loadVisits(table);
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblClickVisit = new JLabel("");
		lblClickVisit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClickVisit.setBounds(10, 66, 256, 25);
		contentPane.add(lblClickVisit);

		buttonMenu = new JButton("Menu");
		buttonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu();
				menu.setVisible(true);
			}
		});
		buttonMenu.setBackground(SystemColor.activeCaption);
		buttonMenu.setBounds(441, 4, 89, 23);
		contentPane.add(buttonMenu);

		btnLoad = new JButton("Load your visits");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ConnectToDB.loadVisits(table);

				int rowCount = table.getModel().getRowCount();
				if (rowCount == 0) {
					scrollPane.setViewportView(null);
					JOptionPane.showMessageDialog(contentPane, "You have no upcoming visits.");
				} else {
					scrollPane.setViewportView(table);
					lblClickVisit.setText("Click on the visit you want to change:");
				}
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLoad.setBounds(10, 22, 216, 33);
		contentPane.add(btnLoad);

		lblGoToRegist = new JLabel("");
		lblGoToRegist.setForeground(new Color(0, 0, 0));
		lblGoToRegist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGoToRegist.setForeground(Color.BLUE);
			}

			@Override
			public final void mouseExited(MouseEvent e) {
				lblGoToRegist.setForeground(Color.BLACK);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				RegistrationDoct registrationDoct = new RegistrationDoct();
				registrationDoct.setVisible(true);
			}
		});
		lblGoToRegist.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblGoToRegist.setBounds(42, 211, 346, 25);
		contentPane.add(lblGoToRegist);

		lbl_signout = new JLabel("");
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
		lbl_signout.setBounds(540, 4, 46, 25);
		contentPane.add(lbl_signout);

	}
}
