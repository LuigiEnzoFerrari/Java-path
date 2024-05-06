package aviation.aircraft;
import aviation.control.WeatherTower;
import aviation.flyable.Flyable;
import aviation.models.Coordinates;

public class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
		this.weatherTower = new WeatherTower();
	};

	@Override
	public void updateConditions() {
		this.weatherTower.changeWeather();
	}
}