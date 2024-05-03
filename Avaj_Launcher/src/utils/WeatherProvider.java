package utils;

import coordinates.Coordinates;

public class WeatherProvider {

	private static WeatherProvider instance;
	private String[] weather;
	private WeatherProvider() {
		weather = new String[4];
		weather[0] = "RAIN";
		weather[1] = "FOG";
		weather[2] = "SUN";
		weather[3] = "SNOW";
	}
	public String getCurrentWeather(Coordinates p_coordinates) {
		if (instance == null) {
			instance = new WeatherProvider();
		};
		return weather[2];
	};

	public static WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}
}
