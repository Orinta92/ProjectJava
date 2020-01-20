package windowBuilder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import jdbc.ConnectToDB;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Register extends JFrame {

	private JPanel contentPane;

	/*
	 * public static void main(String[] args) { System.out.println("Register");
	 * EventQueue.invokeLater(new Runnable() { public void run() { try { Register
	 * frame = new Register(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRegisterForm = new JLabel("Register Form");
		lblRegisterForm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegisterForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterForm.setBounds(144, 11, 104, 23);
		contentPane.add(lblRegisterForm);

		JLabel lblStar = new JLabel("* The field must be filled in");
		lblStar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStar.setForeground(Color.RED);
		lblStar.setBounds(221, 198, 165, 14);
		contentPane.add(lblStar);
		lblStar.setVisible(false);

		JLabel lblUserName = new JLabel("USERNAME:");
		lblUserName.setBounds(27, 44, 70, 14);
		contentPane.add(lblUserName);

		JLabel lblUserNameMsg = new JLabel("");
		lblUserNameMsg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserNameMsg.setForeground(Color.RED);
		lblUserNameMsg.setBounds(165, 66, 26, 20);
		contentPane.add(lblUserNameMsg);

		JLabel lblCheckDuplicate = new JLabel("");
		lblCheckDuplicate.setForeground(Color.RED);
		lblCheckDuplicate.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblCheckDuplicate.setBounds(27, 87, 184, 9);
		contentPane.add(lblCheckDuplicate);

		JTextField textUserName = new JTextField();
		textUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textUserName.getText().equals("")) {
					lblUserNameMsg.setText("*");
					lblStar.setVisible(true);
				} else {
					lblUserNameMsg.setText("");
				}

				if (ConnectToDB.duplicateUsername(textUserName.getText()) == true) {
					lblCheckDuplicate.setText("Such username already exists!");
				} else {
					lblCheckDuplicate.setText("");
				}
			}
		});

		textUserName.setBounds(27, 66, 136, 20);
		textUserName.setColumns(10);
		contentPane.add(textUserName);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(27, 97, 86, 14);
		contentPane.add(lblPassword);

		JLabel lblPasswordMsg = new JLabel("");
		lblPasswordMsg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPasswordMsg.setForeground(Color.RED);
		lblPasswordMsg.setBounds(165, 119, 26, 20);
		contentPane.add(lblPasswordMsg);

		JTextField textPassword = new JTextField();
		textPassword.setFont(new Font("Symbol", Font.PLAIN, 11));
		textPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textPassword.getText().equals("")) {
					lblPasswordMsg.setText("*");
					lblStar.setVisible(true);
				} else {
					lblPasswordMsg.setText("");
				}
			}
		});
		textPassword.setColumns(10);
		textPassword.setBounds(27, 119, 136, 20);
		contentPane.add(textPassword);

		JLabel lblRepeatPassw = new JLabel("REPEAT PASSWORD:");
		lblRepeatPassw.setBounds(27, 150, 136, 14);
		contentPane.add(lblRepeatPassw);

		JLabel lblRepeatPasswMsg = new JLabel("");
		lblRepeatPasswMsg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRepeatPasswMsg.setForeground(Color.RED);
		lblRepeatPasswMsg.setBounds(165, 169, 26, 20);
		contentPane.add(lblRepeatPasswMsg);

		JLabel lblMatchPassw = new JLabel("");
		lblMatchPassw.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMatchPassw.setForeground(Color.RED);
		lblMatchPassw.setBounds(27, 190, 184, 9);
		contentPane.add(lblMatchPassw);

		JTextField textRepPassw = new JTextField();
		textRepPassw.setFont(new Font("Symbol", Font.PLAIN, 11));
		textRepPassw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textRepPassw.getText().equals("")) {
					lblRepeatPasswMsg.setText("*");
					lblStar.setVisible(true);
				} else {
					lblRepeatPasswMsg.setText("");
				}

				if (!textRepPassw.getText().equals(textPassword.getText())) {
					lblMatchPassw.setText("Passwords do not match!");
				} else {
					lblMatchPassw.setText("");
				}
			}
		});
		textRepPassw.setColumns(10);
		textRepPassw.setBounds(27, 169, 136, 20);
		contentPane.add(textRepPassw);

		JLabel lblFirstName = new JLabel("FIRST NAME:");
		lblFirstName.setBounds(27, 198, 86, 14);
		contentPane.add(lblFirstName);

		JLabel lblFirstNameMsg = new JLabel("");
		lblFirstNameMsg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstNameMsg.setForeground(Color.RED);
		lblFirstNameMsg.setBounds(165, 217, 26, 20);
		contentPane.add(lblFirstNameMsg);

		JTextField textFirstName = new JTextField();
		textFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textFirstName.getText().equals("")) {
					lblFirstNameMsg.setText("*");
					lblStar.setVisible(true);
				} else {
					lblFirstNameMsg.setText("");
				}
			}
		});
		textFirstName.setColumns(10);
		textFirstName.setBounds(27, 217, 136, 20);
		contentPane.add(textFirstName);

		JLabel lblLastName = new JLabel("LAST NAME:");
		lblLastName.setBounds(27, 247, 70, 14);
		contentPane.add(lblLastName);

		JLabel lblLastNameMsg = new JLabel("");
		lblLastNameMsg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastNameMsg.setForeground(Color.RED);
		lblLastNameMsg.setBounds(165, 266, 26, 20);
		contentPane.add(lblLastNameMsg);

		JTextField textLastName = new JTextField();
		textLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textLastName.getText().equals("")) {
					lblLastNameMsg.setText("*");
					lblStar.setVisible(true);
				} else {
					lblLastNameMsg.setText("");
				}
			}
		});
		textLastName.setColumns(10);
		textLastName.setBounds(27, 266, 136, 20);
		contentPane.add(textLastName);

		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setBounds(27, 296, 70, 14);
		contentPane.add(lblEmail);

		JLabel lblEmailMsg = new JLabel("");
		lblEmailMsg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailMsg.setForeground(Color.RED);
		lblEmailMsg.setBounds(165, 321, 26, 20);
		contentPane.add(lblEmailMsg);

		JTextField textEmail = new JTextField();
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textEmail.getText().equals("")) {
					lblEmailMsg.setText("*");
					lblStar.setVisible(true);
				} else {
					lblEmailMsg.setText("");
				}
			}
		});
		textEmail.setColumns(10);
		textEmail.setBounds(27, 321, 136, 20);
		contentPane.add(textEmail);

		JLabel lblMobile = new JLabel("MOBILE:");
		lblMobile.setBounds(223, 44, 70, 14);
		contentPane.add(lblMobile);

		JLabel lblMobileMsg = new JLabel("");
		lblMobileMsg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMobileMsg.setForeground(Color.RED);
		lblMobileMsg.setBounds(360, 66, 26, 20);
		contentPane.add(lblMobileMsg);

		JTextField textMobile = new JTextField();
		textMobile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textMobile.getText().equals("")) {
					lblMobileMsg.setText("*");
					lblStar.setVisible(true);
				} else {
					lblMobileMsg.setText("");
				}
			}
		});
		textMobile.setColumns(10);
		textMobile.setBounds(221, 66, 136, 20);
		contentPane.add(textMobile);

		JLabel lblStreet = new JLabel("STREET:");
		lblStreet.setBounds(223, 97, 70, 14);
		contentPane.add(lblStreet);

		JLabel lblStreetMsg = new JLabel("");
		lblStreetMsg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStreetMsg.setForeground(Color.RED);
		lblStreetMsg.setBounds(360, 119, 26, 20);
		contentPane.add(lblStreetMsg);

		JTextField textStreet = new JTextField();
		textStreet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textStreet.getText().equals("")) {
					lblStreetMsg.setText("*");
					lblStar.setVisible(true);
				} else {
					lblStreetMsg.setText("");
				}
			}
		});
		textStreet.setColumns(10);
		textStreet.setBounds(221, 119, 136, 20);
		contentPane.add(textStreet);

		JLabel lblCity = new JLabel("CITY:");
		lblCity.setBounds(221, 150, 70, 14);
		contentPane.add(lblCity);

		JLabel lblCityMsg = new JLabel("");
		lblCityMsg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCityMsg.setForeground(Color.RED);
		lblCityMsg.setBounds(360, 169, 26, 20);
		contentPane.add(lblCityMsg);

		JTextField textCity = new JTextField();
		textCity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textCity.getText().equals("")) {
					lblCityMsg.setText("*");
					lblStar.setVisible(true);
				} else {
					lblCityMsg.setText("");
				}
			}
		});
		textCity.setColumns(10);
		textCity.setBounds(221, 169, 136, 20);
		contentPane.add(textCity);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textUserName.getText().equals("") && !textPassword.getText().equals("")
						&& !textRepPassw.getText().equals("") && !textFirstName.getText().equals("")
						&& !textLastName.getText().equals("") && !textEmail.getText().equals("")
						&& !textMobile.getText().equals("") && !textStreet.getText().equals("")
						&& !textCity.getText().equals("") && !lblMatchPassw.getText().equals("Passwords do not match!")
						&& !lblCheckDuplicate.getText().equals("Such username already exists!")) {

					ConnectToDB.insertPatients(textFirstName.getText(), textLastName.getText(), textEmail.getText(),
							textMobile.getText(), textStreet.getText(), textCity.getText());

					ConnectToDB.insertLogins(textUserName.getText(), textPassword.getText());

					JOptionPane.showMessageDialog(null, "Registration successful", "Informational message",
							JOptionPane.INFORMATION_MESSAGE);

					dispose();
					Login.main(null);

				} else if (textUserName.getText().equals("") || textPassword.getText().equals("")
						|| textRepPassw.getText().equals("") || textFirstName.getText().equals("")
						|| textLastName.getText().equals("") || textEmail.getText().equals("")
						|| textMobile.getText().equals("") || textStreet.getText().equals("")
						|| textCity.getText().equals("") || lblMatchPassw.getText().equals("Passwords do not match!")
						|| lblCheckDuplicate.getText().equals("Such username already exists!")) {

					JOptionPane.showMessageDialog(null, "Registration failed. Please fill in all the fields.",
							"Informational message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/signup.png")).getImage();
		btnSignUp.setIcon(new ImageIcon(img));
		btnSignUp.setBackground(new Color(169, 169, 169));
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignUp.setBounds(234, 233, 104, 43);
		contentPane.add(btnSignUp);

		JLabel label_back = new JLabel("");
		label_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login.main(null);
			}
		});
		label_back.setHorizontalAlignment(SwingConstants.LEFT);
		Image img3 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		label_back.setIcon(new ImageIcon(img3));
		label_back.setBounds(434, 318, 32, 23);
		contentPane.add(label_back);

	}
}
