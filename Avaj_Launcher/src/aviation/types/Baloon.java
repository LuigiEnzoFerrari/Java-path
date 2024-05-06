package aviation.types;
import aviation.aircraft.Aircraft;
import aviation.models.Coordinates;

public class Baloon extends Aircraft {
	public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		// this.weatherTower = new WeatherTower();
		System.out.println(name);
	}
}
