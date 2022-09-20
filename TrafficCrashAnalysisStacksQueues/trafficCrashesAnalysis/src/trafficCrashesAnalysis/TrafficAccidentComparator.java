package trafficCrashesAnalysis;

import java.util.Comparator;
/**
 * TrafficAccidentComparator.java - Compares two Traffic Accident Object Based on City
 * @author nsrao
 */
public class TrafficAccidentComparator implements Comparator<TrafficAccident>{

	@Override
    public int compare(TrafficAccident emp1, TrafficAccident emp2) {
		return emp1.getCity().compareTo(emp2.getCity());
    }
}
