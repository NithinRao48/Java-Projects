package trafficCrashesAnalysis;

import java.util.Comparator;

/**
 * TrafficAccidentVehicleIdComparator.java - Compares two Traffic Accident Object Based on VehicleID
 * @author nsrao
 */

public class TrafficAccidentVehicleIdComparator implements Comparator<TrafficAccident>{

	@Override
    public int compare(TrafficAccident emp1, TrafficAccident emp2) {
        return Integer.parseInt(emp1.getVehicleId()) - Integer.parseInt(emp2.getVehicleId());
    }
}
