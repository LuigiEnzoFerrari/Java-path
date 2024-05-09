package aviation.types;

import aviation.aircraft.Aircraft;
import aviation.consts.Constants;
import aviation.models.Coordinates;

public class Helicopter extends Aircraft {

	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		int newHeight = coordinates.getHeight();
		int newLatitude = coordinates.getLatitude();
		int newLongitude = coordinates.getLongitude();

		String weather = weatherTower.getWeather(coordinates);

		if (weather.equals(Constants.WEATHERTYPES[Constants.SUN])) {
			newLongitude = coordinates.getLongitude() + 10;
			newHeight = coordinates.getHeight() + 2;
		} else if (weather.equals(Constants.WEATHERTYPES[Constants.RAIN])) {
			newLongitude = coordinates.getLongitude() + 5;
		} else if (weather.equals(Constants.WEATHERTYPES[Constants.FOG])) {
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

		String format = this.toString() + ": ";

		speak(weather, format, newHeight);
		if (newHeight <= 0) {
			weatherTower.unregister(this);
		}
	}

	@Override
	public String toString() {
		return Constants.TYPES[Constants.HELICOPTER] + "#" + name + "(" + String.valueOf(id) + ")";
	}
}
