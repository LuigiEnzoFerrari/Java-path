package aviation.types;

import aviation.aircraft.Aircraft;
import aviation.consts.Constants;
import aviation.models.Coordinates;

public class JetPlane extends Aircraft {

	public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		int newHeight = coordinates.getHeight();
		int newLatitude = coordinates.getLatitude();
		int newLongitude = coordinates.getLongitude();

		String weather = weatherTower.getWeather(coordinates);

		if (weather.equals(Constants.WEATHERTYPES[Constants.SUN])) {
			newLatitude = coordinates.getLatitude() + 10;
			newHeight = coordinates.getHeight() + 4;
		} else if (weather.equals(Constants.WEATHERTYPES[Constants.RAIN])) {
			newLatitude = coordinates.getLatitude() + 5;
		} else if (weather.equals(Constants.WEATHERTYPES[Constants.FOG])) {
			newLatitude = coordinates.getLatitude() + 1;
		} else {
			newHeight = coordinates.getHeight() - 7;
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
		return Constants.TYPES[Constants.JETPLANE] + "#" + name + "(" + String.valueOf(id) + ")";
	}
}
