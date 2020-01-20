package objects;

import java.util.ArrayList;

import jdbc.ConnectToDB;

public class Main {

	public static void main(String[] args) {

		ArrayList<Doctor> doctors = new ArrayList<>();

		doctors.add(new Doctor("Eve", "Evans", "General practitioner"));
		doctors.add(new Doctor("Ruth", "Ruttens", "General practitioner"));
		doctors.add(new Doctor("Tim", "Timmerson", "General practitioner"));
		doctors.add(new Doctor("Mark", "Martins", "General practitioner"));
		doctors.add(new Doctor("Maria", "Maranders", "Dermatologist"));
		doctors.add(new Doctor("Catherine", "Camerton", "Dermatologist"));
		doctors.add(new Doctor("Patrick", "Patterson", "Dermatologist"));
		doctors.add(new Doctor("Jack", "Jackson", "Dermatologist"));
		doctors.add(new Doctor("Michelle", "Mickerston", "Allergist"));
		doctors.add(new Doctor("Jennifer", "Jenshon", "Allergist"));
		doctors.add(new Doctor("Edward", "Eddison", "Allergist"));
		doctors.add(new Doctor("Dan", "Daniels", "Allergist"));
		doctors.add(new Doctor("Ellie", "Ellison", "Dentist"));
		doctors.add(new Doctor("Julia", "Julson", "Dentist"));
		doctors.add(new Doctor("Frank", "Frankenshtein", "Dentist"));
		doctors.add(new Doctor("Harry", "Harrison", "Dentist"));
		doctors.add(new Doctor("Grace", "Conner", "Endocrinologist"));
		doctors.add(new Doctor("Maite", "Buckley", "Endocrinologist"));
		doctors.add(new Doctor("Camilla", "Mccoy", "Hematologist"));
		doctors.add(new Doctor("Wang", "Dunn", "Hematologist"));
		doctors.add(new Doctor("Orla", "Jordan", "Hematologist"));
		doctors.add(new Doctor("Duncan", "Rivera", "Dietitian"));
		doctors.add(new Doctor("Zeph", "Lopez", "Dietitian"));
		doctors.add(new Doctor("Knox", "Gonzales", "Cardiologist"));
		doctors.add(new Doctor("Alexa", "Sullivan", "Cardiologist"));
		doctors.add(new Doctor("Penelope", "Lowe", "Neurologist"));
		doctors.add(new Doctor("Byron", "Byers", "Neurologist"));
		doctors.add(new Doctor("Jane", "Turner", "Nephrologist"));
		doctors.add(new Doctor("Laurel", "Vance", "Nephrologist"));
		doctors.add(new Doctor("Brent", "Gardner", "Nephrologist"));

		//ConnectToDB.insertDoctors(doctors);

		VisitListBuilder.addVisits(1, "2020-01-14 08:00", "2020-01-15 09:50", "2020-01-20 10:30", "2020-01-22 11:20");
		VisitListBuilder.addVisits(2, "2020-01-15 07:40", "2020-01-16 09:30", "2020-01-17 10:50", "2020-01-17 12:00");
		VisitListBuilder.addVisits(3, "2020-01-21 13:00");
		VisitListBuilder.addVisits(4, "2020-01-14 14:00", "2020-01-14 15:10", "2020-01-16 15:30", "2020-01-17 16:40");
		VisitListBuilder.addVisits(5, "2020-01-17 09:40", "2020-01-20 11:00", "2020-01-23 12:00");
		VisitListBuilder.addVisits(7, "2020-01-21 13:00", "2020-01-24 15:00");
		VisitListBuilder.addVisits(8, "2020-01-27 12:30", "2020-01-29 14:00");
		VisitListBuilder.addVisits(10, "2020-01-27 08:50", "2020-01-29 10:00", "2020-01-31 11:30", "2020-02-03 09:20");
		VisitListBuilder.addVisits(11, "2020-01-28 12:40", "2020-01-30 15:00");
		VisitListBuilder.addVisits(12, "2020-01-29 13:00");
		VisitListBuilder.addVisits(13, "2020-01-20 09:50", "2020-01-20 12:00", "2020-01-21 11:20");
		VisitListBuilder.addVisits(14, "2020-01-22 09:00", "2020-01-22 11:10");
		VisitListBuilder.addVisits(15, "2020-01-23 14:15");
		VisitListBuilder.addVisits(17, "2020-01-15 08:05", "2020-01-16 11:50", "2020-01-19 11:30", "2020-01-21 12:20");
		VisitListBuilder.addVisits(18, "2020-01-16 09:50", "2020-01-19 10:50", "2020-01-20 11:00", "2020-01-22 12:00");
		VisitListBuilder.addVisits(20, "2020-01-23 14:00");
		VisitListBuilder.addVisits(21, "2020-01-14 15:00", "2020-01-15 16:10", "2020-01-19 13:30", "2020-01-20 14:40");
		VisitListBuilder.addVisits(22, "2020-01-19 10:40", "2020-01-26 08:00", "2020-01-26 13:00");
		VisitListBuilder.addVisits(23, "2020-01-22 12:00", "2020-01-22 15:00");
		VisitListBuilder.addVisits(25, "2020-01-26 13:30", "2020-01-27 15:00");
		VisitListBuilder.addVisits(26, "2020-01-27 10:50", "2020-01-29 12:00", "2020-01-29 12:30", "2020-01-30 11:20");
		VisitListBuilder.addVisits(27, "2020-01-28 14:40", "2020-01-29 13:00");
		VisitListBuilder.addVisits(28, "2020-01-30 11:00");
		VisitListBuilder.addVisits(29, "2020-02-02 07:50", "2020-02-03 11:00", "2020-02-03 11:50");
		VisitListBuilder.addVisits(30, "2020-01-26 10:00", "2020-02-02 13:10");

		//ConnectToDB.insertVisits(VisitListBuilder.visits);

	}

}
