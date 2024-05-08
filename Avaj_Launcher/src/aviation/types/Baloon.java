package aviation.types;

import aviation.aircraft.Aircraft;
import aviation.consts.Constants;
import aviation.models.Coordinates;
import aviation.utils.WeatherFrasesGeneration;

public class Baloon extends Aircraft {

	public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		int newHeight = 0;
		int newLatitude = 0;
		int newLongitude = 0;

		String whether = weatherTower.getWeather(coordinates);

		if (whether.equals(Constants.WEATERTYPES[Constants.SUN])) {
			newLongitude = coordinates.getLongitude() + 2;
			newHeight = coordinates.getHeight() + 4;
		} else if (whether.equals(Constants.WEATERTYPES[Constants.RAIN])) {
			newHeight = coordinates.getHeight() - 5;
		} else if (whether.equals(Constants.WEATERTYPES[Constants.FOG])) {
			newHeight = coordinates.getHeight() - 3;
		} else {
			newHeight = coordinates.getHeight() - 15;
		}

		if (newHeight > 100) {
			newHeight = 100;
		}
		newLatitude  = coordinates.getLatitude() % 100;
		newLongitude  = coordinates.getLongitude() % 100;
		coordinates = new Coordinates(newLongitude, newLatitude, newHeight);

		WeatherFrasesGeneration generation = WeatherFrasesGeneration.getInstance();

		if (whether.equals(Constants.WEATERTYPES[Constants.SUN])) {
			System.out.println(this.toString() + ": " + generation.getSunFrase());
		} else if (whether.equals(Constants.WEATERTYPES[Constants.RAIN])) {
			System.out.println(this.toString() + ": " + generation.getRainFrase());
		} else if (whether.equals(Constants.WEATERTYPES[Constants.FOG])) {
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
		return Constants.TYPES[Constants.BALOON] + "#" + name + "(" + String.valueOf(id) + ")";
	}
}
