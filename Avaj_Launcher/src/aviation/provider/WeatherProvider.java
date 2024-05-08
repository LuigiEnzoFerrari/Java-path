package aviation.provider;

import java.util.Random;

import aviation.models.Coordinates;

public class WeatherProvider {
    private static final int LONGITUDE_SIZE = 100;
    private static final int LATITUDE_SIZE = 100;
    private static final int HEIGHT_SIZE = 100;
	private static WeatherProvider instance;
	private String[] weather;
	private Random random = new Random();

    private String determineWeather(int lat, int height) {
        // Adjust conditions based on latitude and altitude
        String weather;
        if (height > 80 || (lat < 20 || lat > 80 && height > 60)) {
            weather = "SNOW";
        } else if (height < 30) {
            if (lat < 20 || lat > 80) {
                weather = "FOG";
            } else if (lat < 40 || lat > 60) {
                weather = randomChoice(new String[]{"RAIN", "SUN"});
            } else {
                weather = "SUN";
            }
        } else {
            if (lat < 40 || lat > 60) {
                weather = randomChoice(new String[]{"FOG", "RAIN"});
            } else {
                weather = randomChoice(new String[]{"RAIN", "FOG", "SUN"});
            }
        }
        return weather;
    }

    private String randomChoice(String[] choices) {
        return choices[random.nextInt(choices.length)];
    }

	private WeatherProvider() {
		weather = new String[LONGITUDE_SIZE * LATITUDE_SIZE * HEIGHT_SIZE];
		for (int lon = 0; lon < LONGITUDE_SIZE; lon++) {
            for (int lat = 0; lat < LATITUDE_SIZE; lat++) {
                for (int height = 0; height < HEIGHT_SIZE; height++) {
                    int index = height + lat * LATITUDE_SIZE + lon * (LATITUDE_SIZE * HEIGHT_SIZE);  // Calculating the 1D index
                    String weatherCondition = determineWeather(lat, height);
                    weather[index] = weatherCondition;
                }
            }
        }
	}

	public String getCurrentWeather(Coordinates p_coordinates) {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return weather[
			p_coordinates.getHeight() +
			p_coordinates.getLatitude() * LATITUDE_SIZE +
			p_coordinates.getLongitude() * (LATITUDE_SIZE * HEIGHT_SIZE)];
	};

	public static WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}
}
