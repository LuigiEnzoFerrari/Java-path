package aviation.factory;
import aviation.flyable.Flyable;
import aviation.models.Coordinates;
import aviation.types.Baloon;
import aviation.types.Helicopter;
import aviation.types.JetPlane;


public class AircraftFactory {

	private static AircraftFactory instance;
	private long id;
	private AircraftFactory () {};

	public static AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		instance.id = -1;
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		id += 1;
		if (p_type.equalsIgnoreCase("JetPlane")) {
			return new JetPlane(id, p_name, p_coordinates);
		} else if (p_type.equalsIgnoreCase("Helicopter")) {
			return new Helicopter(id, p_name, p_coordinates);
		} else if (p_type.equalsIgnoreCase("Baloon")) {
			return new Baloon(id, p_name, p_coordinates);
		}
		return null;
	}
}