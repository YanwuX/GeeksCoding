package FunTryOuts;

import java.util.ArrayList;

import Util.Triplet;

public class CalendarConflicts {
	
	public static String isConflict(ArrayList<Triplet<String>> events) {
		if (events == null || events.size() == 0) {
			return "No events found";
		}
		
		StringBuilder sb = new StringBuilder();
		
		int time = Integer.valueOf(events.get(0).getO2());
		String currentEvent = events.get(0).getO3();

		for (int i = 1; i < events.size(); ++i) {
			if (Integer.valueOf(events.get(i).getO1()) < time) {
				sb.append(currentEvent);
				sb.append(" confilcts with ");
				sb.append(events.get(i).getO3());
				sb.append("\n");
			} else {
				time = Integer.valueOf(events.get(i).getO2());
				currentEvent = events.get(i).getO3();
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		ArrayList<Triplet<String>> events = new ArrayList<Triplet<String>>();
		events.add(new Triplet<String>("1", "2", "a"));
		events.add(new Triplet<String>("3", "5", "b"));
		events.add(new Triplet<String>("4", "6", "c"));
		events.add(new Triplet<String>("4", "7", "d"));
		events.add(new Triplet<String>("7", "12", "e"));
		events.add(new Triplet<String>("8", "10", "f"));
		events.add(new Triplet<String>("11", "12", "g"));
		System.out.println(isConflict(events));
	}

}
