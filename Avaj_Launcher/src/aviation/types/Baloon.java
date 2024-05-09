package aviation.types;

import aviation.aircraft.Aircraft;
import aviation.consts.Constants;
import aviation.models.Coordinates;

public class Baloon extends Aircraft {

	public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		int newHeight = coordinates.getHeight();
		int newLatitude = coordinates.getLatitude();
		int newLongitude = coordinates.getLongitude();

		String weather = weatherTower.getWeather(coordinates);

		if (weather.equals(Constants.WEATHERTYPES[Constants.SUN])) {
			newLongitude = coordinates.getLongitude() + 2;
			newHeight = coordinates.getHeight() + 4;
		} else if (weather.equals(Constants.WEATHERTYPES[Constants.RAIN])) {
			newHeight = coordinates.getHeight() - 5;
		} else if (weather.equals(Constants.WEATHERTYPES[Constants.FOG])) {
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

		String format = this.toString() + ": ";
		speak(weather, format, newHeight);
		if (newHeight <= 0) {
			weatherTower.unregister(this);
		}
	}

	@Override
	public String toString() {
		return Constants.TYPES[Constants.BALOON] + "#" + name + "(" + String.valueOf(id) + ")";
	}
}
