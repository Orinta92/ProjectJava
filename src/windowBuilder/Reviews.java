package windowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.ConnectToDB;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Reviews extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_ratings;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Reviews frame = new Reviews();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	public Reviews() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("Menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu();
				menu.setVisible(true);
			}
		});
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(667, 4, 89, 23);
		contentPane.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 782, 98);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		ConnectToDB.loadComments(table);

		JLabel label = new JLabel("Patients reviews");
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label.setBounds(10, 24, 170, 22);
		contentPane.add(label);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(142, 188, 380, 116);
		contentPane.add(scrollPane_1);

		table_ratings = new JTable();
		scrollPane_1.setViewportView(table_ratings);

		ConnectToDB.loadRatings(table_ratings);

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
		lbl_signout.setBounds(746, 4, 46, 23);
		contentPane.add(lbl_signout);
	}
}
