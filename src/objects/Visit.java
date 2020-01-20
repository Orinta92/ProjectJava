package objects;

public class Visit {

	private int doctorId;
	private String dateAndTime;

	public Visit(int doctorId, String dateAndTime) {
		this.doctorId = doctorId;
		this.dateAndTime = dateAndTime;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

}
