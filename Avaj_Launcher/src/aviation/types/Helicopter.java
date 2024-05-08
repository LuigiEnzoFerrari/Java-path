package aviation.types;

import aviation.aircraft.Aircraft;
import aviation.models.Coordinates;
import aviation.utils.WeatherFrasesGeneration;

public class Helicopter extends Aircraft {

	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		int newHeight = 0;
		int newLatitude = 0;
		int newLongitude = 0;

		String whether = weatherTower.getWeather(coordinates);

		if (whether.equals("SUN")) {
			newLongitude = coordinates.getLongitude() + 10;
			newHeight = coordinates.getHeight() + 2;
		} else if (whether.equals("RAIN")) {
			newLongitude = coordinates.getLongitude() + 5;
		} else if (whether.equals("FOG")) {
			newLongitude = coordinates.getLongitude() + 1;
		} else {
			newHeight = coordinates.getHeight() - 12;
		}

		if (newHeight > 100) {
			newHeight = 100;
		}
		newLatitude  = coordinates.getLatitude() % 100;
		newLongitude  = coordinates.getLongitude() % 100;
		coordinates = new Coordinates(newLongitude, newLatitude, newHeight);

		WeatherFrasesGeneration generation = WeatherFrasesGeneration.getInstance();

		if (whether.equals("SUN")) {
			System.out.println(this.toString() + ": " + generation.getSunFrase());
		} else if (whether.equals("RAIN")) {
			System.out.println(this.toString() + ": " + generation.getRainFrase());
		} else if (whether.equals("FOG")) {
			System.out.println(this.toString() + ": " + generation.getFogFrase());
		} else {
			System.out.println(this.toString() + ": " + generation.getSnowFrase());
		}
		if (newHeight <= 0) {
			weatherTower.unregister(this);
		}
	}

	@Override
	public String toString() {
		return "Helicopter" + "#" + name + "(" + String.valueOf(id) + ")";
	}
}
