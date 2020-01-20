package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;
import objects.Doctor;
import objects.LoggedInUser;
import objects.Patient;
import objects.Visit;

import java.util.ArrayList;

public class ConnectToDB {


	static String url = "jdbc:sqlite:D:\\myProject\\eclipse for Windows\\Project Java\\clinic.db";
	static Connection conn = connect();

	private static Connection connect() {

		try {
			if (conn == null) {
				conn = DriverManager.getConnection(url);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void createPatientsTable() {

		String sql = "CREATE TABLE IF NOT EXISTS patients (\n" 
				+ "    PatientId integer PRIMARY KEY,\n"
				+ "    FirstName text,\n" 
				+ "    LastName text,\n" 
				+ "    Email text,\n" 
				+ "    Mobile text,\n"
				+ "    Street text,\n" 
				+ "    City text\n" 
				+ ");";

		try (Statement stmt = conn.createStatement()) {

			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createLoginsTable() {

		String sql = "CREATE TABLE IF NOT EXISTS logins (\n" 
				+ "    LoginId integer PRIMARY KEY,\n"
				+ "    PatientId integer,\n" 
				+ "    Username text,\n" 
				+ "    Password text,\n"
				+ "    FOREIGN KEY (PatientId) REFERENCES patients (PatientId)\n" 
				+ ");";

		try (Statement stmt = conn.createStatement()) {

			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createDoctorsTable() {

		String sql = "CREATE TABLE IF NOT EXISTS doctors (\n" 
				+ "    DoctorId integer PRIMARY KEY,\n"
				+ "    Name text,\n" 
				+ "    Surname text,\n" 
				+ "    Specialization text\n" 
				+ ");";

		try (Statement stmt = conn.createStatement()) {

			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createVisitsTable() {

		String sql = "CREATE TABLE IF NOT EXISTS visits (\n" 
				+ "    VisitId integer PRIMARY KEY,\n"
				+ "    DoctorId integer,\n" 
				+ "    VisitDateAndTime text,\n" 
				+ "    PatientId integer,\n"
				+ "    FOREIGN KEY (DoctorId) REFERENCES doctors (DoctorId),\n"
				+ "    FOREIGN KEY (PatientId) REFERENCES patients (PatientId)\n" 
				+ ");";

		try (Statement stmt = conn.createStatement()) {

			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createCommentsTable() {

		String sql = "CREATE TABLE IF NOT EXISTS comments (\n" 
				+ "    CommentId integer PRIMARY KEY,\n"
				+ "    DoctorId integer,\n" 
				+ "    Comment text,\n" 
				+ "    Rating integer,\n"
				+ "    PatientId integer,\n" 
				+ "    FOREIGN KEY (DoctorId) REFERENCES doctors (DoctorId),\n"
				+ "    FOREIGN KEY (PatientId) REFERENCES patients (PatientId)\n" 
				+ ");";

		try (Statement stmt = conn.createStatement()) {

			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertPatients(String firstname, String lastname, String email, String mobile, String street,
			String city) {
		String sql = "INSERT INTO patients(FirstName,LastName,Email,Mobile,Street,City) " 
				+ "VALUES(?,?,?,?,?,?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, firstname);
			pstmt.setString(2, lastname);
			pstmt.setString(3, email);
			pstmt.setString(4, mobile);
			pstmt.setString(5, street);
			pstmt.setString(6, city);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertLogins(String username, String password) {

		String sql = "INSERT INTO logins(PatientId,Username,Password) "
				+ "VALUES((SELECT MAX(PatientId) FROM patients),?,?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, username);
			pstmt.setString(2, password);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertDoctors(ArrayList<Doctor> list) {

		String sql = "INSERT INTO doctors(Name,Surname,Specialization) VALUES(?,?,?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (Doctor doctor : list) {

				pstmt.setString(1, doctor.getName());
				pstmt.setString(2, doctor.getSurname());
				pstmt.setString(3, doctor.getSpecialization());
				pstmt.addBatch();
			}

			pstmt.executeBatch();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertVisits(ArrayList<Visit> list) {

		String sql = "INSERT INTO visits(DoctorId,VisitDateAndTime) VALUES(?,?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (Visit visit : list) {

				pstmt.setInt(1, visit.getDoctorId());
				pstmt.setString(2, visit.getDateAndTime());
				pstmt.addBatch();
			}

			pstmt.executeBatch();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertComments(JTable table, JTextArea textArea, JTextField textSlider) {

		int row = table.getSelectedRow();
		int DoctorId_ = (int) table.getModel().getValueAt(row, 0);

		String sql = "INSERT INTO comments(DoctorId,Comment,Rating,PatientId) VALUES(?,?,?,?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, DoctorId_);
			pstmt.setString(2, textArea.getText());
			pstmt.setString(3, textSlider.getText());
			pstmt.setInt(4, LoggedInUser.userId);

			pstmt.executeUpdate();

			JOptionPane.showMessageDialog(textArea, "Comment added");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean login(String username, String password) {

		String sql = "SELECT * FROM logins WHERE Username = ? AND Password = ?";

		boolean isEmpty = false;

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				LoggedInUser.userId = rs.getInt("PatientId");
				isEmpty = false;
			} else {
				isEmpty = true;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return isEmpty;
	}

	public static boolean duplicateUsername(String username) {

		String sql = "SELECT * FROM logins WHERE Username = ?";

		boolean isDuplicate = false;

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				isDuplicate = true;
			} else {
				isDuplicate = false;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return isDuplicate;
	}

	public static void fillComboBox(JComboBox comboBox) {

		String sql = "SELECT DISTINCT Specialization FROM doctors";

		try (PreparedStatement pstmt = conn.prepareStatement(sql); 
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				comboBox.addItem(rs.getString("Specialization"));
				comboBox.setSelectedItem(null);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public static void relateComboBox(JComboBox comboBox, JTable table) {

		String sql = "SELECT DoctorId, Name, Surname, Specialization " + "FROM doctors WHERE Specialization = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, (String) comboBox.getSelectedItem());

			ResultSet rs = pstmt.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public static void getValuesFromTable(JTable table, JTable table_smaller) {

		int row = table.getSelectedRow();
		int DoctorId_ = (int) table.getModel().getValueAt(row, 0);

		String sql = "SELECT VisitId, VisitDateAndTime AS 'Visit date and time:' FROM visits WHERE DoctorId = ?"
				+ " AND PatientId is ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, DoctorId_);
			pstmt.setString(2, null);

			ResultSet rs = pstmt.executeQuery();

			table_smaller.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public static void insertRegistration(JTable table) {

		int answer = JOptionPane.showConfirmDialog(null, "Are you want to register?", "Registration confirmation",
				JOptionPane.YES_NO_OPTION);

		if (answer == 0) {
			int row = table.getSelectedRow();
			int VisitId_ = (int) table.getModel().getValueAt(row, 0);

			String sql = "UPDATE visits SET PatientId = ? WHERE VisitId = ?";

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				pstmt.setInt(1, LoggedInUser.userId);
				pstmt.setInt(2, VisitId_);

				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Registration is successful");

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}

	}

	public static void loadVisits(JTable table) {

		String sql = "SELECT v.VisitId, v.VisitDateAndTime AS 'Visit date and time:', "
				+ "d.Name AS 'Doctor name', d.Surname AS 'Doctor surname', d.Specialization "
				+ "FROM visits v JOIN doctors d ON v.DoctorId = d.DoctorId WHERE v.PatientId = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, LoggedInUser.userId);

			ResultSet rs = pstmt.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public static void cancelVisit(JTable table, JLabel label) {

		int answer = JOptionPane.showConfirmDialog(null, "Do you want to cancel this visit?",
				"Cancellation confirmation", JOptionPane.YES_NO_OPTION);

		if (answer == 0) {
			int row = table.getSelectedRow();
			int VisitId_ = (int) table.getModel().getValueAt(row, 0);

			String sql = "UPDATE visits SET PatientId = ? WHERE VisitId = ?";

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				pstmt.setString(1, null);
				pstmt.setInt(2, VisitId_);

				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "The visit is cancelled");

				label.setText("--> Click here to register to another doctor");

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}

	}

	public static void viewVisits(JTable table) {

		String sql = "SELECT v.VisitDateAndTime AS 'Visit date and time:', "
				+ "d.Name AS 'Doctor name', d.Surname AS 'Doctor surname', d.Specialization "
				+ "FROM visits v JOIN doctors d ON v.DoctorId = d.DoctorId WHERE v.PatientId = ? "
				+ "ORDER BY v.VisitDateAndTime";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, LoggedInUser.userId);

			ResultSet rs = pstmt.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public static void viewComments(JTable table) {

		String sql = "SELECT d.Name AS 'Doctor name', d.Surname AS 'Doctor surname', c.Comment, c.Rating "
				+ "FROM doctors d JOIN comments c ON d.DoctorId = c.DoctorId WHERE c.PatientId = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, LoggedInUser.userId);

			ResultSet rs = pstmt.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public static void loadDoctors(JTable table) {

		String sql = "SELECT * FROM doctors";

		try (PreparedStatement pstmt = conn.prepareStatement(sql); 
				ResultSet rs = pstmt.executeQuery()) {

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public static void loadComments(JTable table) {

		String sql = "SELECT d.Name AS 'Doctor name', d.Surname AS 'Doctor surname', d.Specialization,c.Comment "
				+ "FROM doctors d JOIN comments c ON d.DoctorId = c.DoctorId";

		try (PreparedStatement pstmt = conn.prepareStatement(sql); 
				ResultSet rs = pstmt.executeQuery()) {

			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.getColumnModel().getColumn(0).setPreferredWidth(7);
			table.getColumnModel().getColumn(1).setPreferredWidth(7);
			table.getColumnModel().getColumn(2).setPreferredWidth(7);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public static void loadRatings(JTable table) {

		String sql = "SELECT d.DoctorId, d.Name AS 'Doctor name', d.Surname AS 'Doctor surname', ROUND((AVG(c.Rating)),1) AS 'Rating %' "
				+ "FROM doctors d JOIN comments c ON d.DoctorId = c.DoctorId GROUP BY d.DoctorId ORDER BY Rating DESC";

		try (PreparedStatement pstmt = conn.prepareStatement(sql); 
				ResultSet rs = pstmt.executeQuery()) {

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

}
