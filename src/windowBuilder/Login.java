package windowBuilder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import jdbc.ConnectToDB;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("CLINIC LOGIN PAGE");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Microsoft Tai Le", Font.BOLD, 15));
		lblTitle.setBounds(101, 11, 230, 30);
		frame.getContentPane().add(lblTitle);

		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setBounds(25, 77, 72, 14);
		frame.getContentPane().add(lblUserName);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(25, 102, 72, 14);
		frame.getContentPane().add(lblPassword);

		JTextField textUserName = new JTextField();
		textUserName.setBounds(101, 74, 151, 20);
		textUserName.setColumns(10);
		frame.getContentPane().add(textUserName);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(101, 99, 151, 20);
		frame.getContentPane().add(passwordField);

		JLabel lblNewUser = new JLabel("Are you a new user?");
		lblNewUser.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				lblNewUser.setForeground(Color.MAGENTA);
			}

			public final void mouseExited(MouseEvent e) {
				lblNewUser.setForeground(Color.BLUE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Register register = new Register();
				register.setVisible(true);
			}
		});
		lblNewUser.setForeground(new Color(0, 0, 204));
		lblNewUser.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewUser.setBounds(101, 130, 133, 14);
		frame.getContentPane().add(lblNewUser);

		JButton btnLogin = new JButton("Sign In");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String textPassword = new String(passwordField.getPassword());

				if (ConnectToDB.login(textUserName.getText(), textPassword) == false) {
					JOptionPane.showMessageDialog(null, "Username and password are correct");

					frame.dispose();
					Menu menu = new Menu();
					menu.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid username or password. Try again");
				}
			}
		});
		btnLogin.setBounds(32, 200, 89, 23);
		frame.getContentPane().add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textUserName.setText(null);
				passwordField.setText(null);
			}
		});
		btnReset.setBounds(309, 200, 89, 23);
		frame.getContentPane().add(btnReset);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 384, 2);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 176, 384, 2);
		frame.getContentPane().add(separator_1);

		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Health.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(278, 52, 133, 126);
		frame.getContentPane().add(label);
	}

}
