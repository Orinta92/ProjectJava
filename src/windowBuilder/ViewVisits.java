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

public class ViewVisits extends JFrame {

	private JPanel contentPane;
	private JTable table_visits;
	private JLabel lblUpcomingV;
	private JTable table_comments;
	private JScrollPane scrollPane_1;
	private JLabel lblCommentsW;
	private JLabel lbl_signout;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewVisits frame = new ViewVisits();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	public ViewVisits() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 321);
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
		button.setBounds(462, 4, 89, 23);
		contentPane.add(button);

		lblUpcomingV = new JLabel("YOUR UPCOMING VISITS:");
		lblUpcomingV.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblUpcomingV.setBounds(10, 26, 276, 23);
		contentPane.add(lblUpcomingV);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 570, 70);
		contentPane.add(scrollPane);

		table_visits = new JTable();
		scrollPane.setViewportView(table_visits);

		ConnectToDB.viewVisits(table_visits);

		lblCommentsW = new JLabel("COMMENTS YOU HAVE WRITTEN:");
		lblCommentsW.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		lblCommentsW.setBounds(10, 148, 276, 23);
		contentPane.add(lblCommentsW);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 180, 570, 70);
		contentPane.add(scrollPane_1);

		table_comments = new JTable();
		scrollPane_1.setViewportView(table_comments);

		ConnectToDB.viewComments(table_comments);

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
		lbl_signout.setBounds(539, 4, 46, 29);
		contentPane.add(lbl_signout);

	}
}
