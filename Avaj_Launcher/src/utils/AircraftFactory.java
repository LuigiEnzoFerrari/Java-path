package utils;
import coordinates.Coordinates;
import interfaces.Flyable;
import models.Baloon;
import models.Helicopter;
import models.JetPlane;


public class AircraftFactory {

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		if (p_type.equalsIgnoreCase("JetPlane")) {
			return new JetPlane(0, p_name, p_coordinates);
		} else if (p_type.equalsIgnoreCase("Helicopter")) {

			return new Helicopter(0, p_name, p_coordinates);
		} else if (p_type.equalsIgnoreCase("Baloon")) {
			return new Baloon(0, p_name, p_coordinates);
		}
		return new Baloon(0, p_name, p_coordinates);
	}
}
