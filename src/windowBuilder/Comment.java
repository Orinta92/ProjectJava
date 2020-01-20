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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Comment extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnSave;
	private JButton btnClear;
	private JLabel lblNotice;
	private JTextArea textArea;
	private JTextField textSlider;
	private JSlider slider;
	private JLabel lbl_signout;


	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Comment frame = new Comment();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */


	public Comment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 408);
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
		button.setBounds(380, 0, 89, 23);
		contentPane.add(button);

		JLabel lblSelectDoct = new JLabel("Select the doctor you want to leave a comment about:");
		lblSelectDoct.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 14));
		lblSelectDoct.setBounds(10, 20, 350, 23);
		contentPane.add(lblSelectDoct);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 491, 103);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textArea.setEnabled(true);
				textArea.setText(null);
				lblNotice.setText("");

				slider.setEnabled(true);
				textSlider.setEnabled(true);
				slider.setValue(50);
				textSlider.setText(null);
				btnSave.setEnabled(false);
			}
		});
		scrollPane.setViewportView(table);

		ConnectToDB.loadDoctors(table);

		textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textArea.getText().length() < 5) {
					lblNotice.setText("A comment must be at least of 5 symbols!");
					btnSave.setEnabled(false);
				} else {
					lblNotice.setText("");
					btnSave.setEnabled(true);
				}
			}
		});
		textArea.setEnabled(false);
		textArea.setBounds(10, 169, 491, 68);
		contentPane.add(textArea);

		btnSave = new JButton("Save comment");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textSlider.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "You have not made a rating!");
				} else {
					ConnectToDB.insertComments(table, textArea, textSlider);
					textArea.setText(null);
					slider.setValue(50);
					textSlider.setText(null);
					btnSave.setEnabled(false);
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBounds(10, 335, 140, 23);
		contentPane.add(btnSave);

		btnClear = new JButton("Clear comment and rate fields");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textArea.setText(null);
				slider.setValue(50);
				textSlider.setText(null);
				btnSave.setEnabled(false);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClear.setBounds(189, 335, 215, 23);
		contentPane.add(btnClear);

		lblNotice = new JLabel("");
		lblNotice.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNotice.setForeground(new Color(220, 20, 60));
		lblNotice.setBounds(30, 236, 306, 23);
		contentPane.add(lblNotice);

		slider = new JSlider();
		slider.setEnabled(false);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				textSlider.setText("" + slider.getValue());
			}
		});
		slider.setMajorTickSpacing(100);
		slider.setPaintLabels(true);
		slider.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		slider.setBounds(289, 282, 200, 42);
		contentPane.add(slider);

		JLabel lblRate = new JLabel("Rate the doctor:");
		lblRate.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblRate.setBounds(10, 282, 164, 23);
		contentPane.add(lblRate);

		textSlider = new JTextField();
		textSlider.setEnabled(false);
		textSlider.setHorizontalAlignment(SwingConstants.CENTER);
		textSlider.setFont(new Font("Serif", Font.BOLD, 23));
		textSlider.setBounds(214, 282, 65, 42);
		textSlider.setColumns(10);
		contentPane.add(textSlider);

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
		lbl_signout.setBounds(458, 0, 46, 28);
		contentPane.add(lbl_signout);

	}
}
