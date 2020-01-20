package windowBuilder;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println("Menu");
	 * 
	 * EventQueue.invokeLater(new Runnable() { public void run() { try { Menu frame
	 * = new Menu(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("Register with a doctor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegistrationDoct registrationDoct = new RegistrationDoct();
				registrationDoct.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setBounds(31, 21, 269, 40);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Change your registration");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ChangeRegistration changeRegistration = new ChangeRegistration();
				changeRegistration.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setBounds(31, 72, 269, 40);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("View your visits & written comments");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewVisits viewVisits = new ViewVisits();
				viewVisits.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setBounds(31, 123, 269, 40);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Leave a comment about the doctor");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Comment comment = new Comment();
				comment.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setBounds(31, 174, 269, 40);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Read reviews about doctors");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Reviews reviews = new Reviews();
				reviews.setVisible(true);
			}
		});
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setBounds(31, 225, 269, 40);
		contentPane.add(btnNewButton_5);

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
		lbl_signout.setBounds(378, 0, 46, 27);
		contentPane.add(lbl_signout);

	}
}
