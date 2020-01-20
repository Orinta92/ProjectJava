package objects;

import java.util.ArrayList;

public class VisitListBuilder {

	public static ArrayList<Visit> visits = new ArrayList<>();

	public static void addVisits(int doctorId, String... dateAndTime) {

		for (String date : dateAndTime) {
			visits.add(new Visit(doctorId, date));
		}
	}
}
