package aviation.provider;

import java.util.Random;

import aviation.consts.Constants;
import aviation.models.Coordinates;

public class WeatherProvider {

	private static WeatherProvider instance;
	private String[] weather;
	private Random random = new Random();

    private String determineWeather(int lat, int height) {
        // Adjust conditions based on latitude and altitude

        String weather;
        if (height > 80 || (lat < 20 || lat > 80 && height > 60)) {
            weather = Constants.WEATERTYPES[Constants.SNOW];
        } else if (height < 30) {
            if (lat < 20 || lat > 80) {
                weather = Constants.WEATERTYPES[Constants.FOG];
            } else if (lat < 40 || lat > 60) {
                weather = randomChoice(new String[]{Constants.WEATERTYPES[Constants.RAIN], Constants.WEATERTYPES[Constants.SUN]});
            } else {
                weather = Constants.WEATERTYPES[random.nextInt(Constants.WEATERTYPES.length)];
            }
        } else {
            if (lat < 40 || lat > 60) {
                weather = randomChoice(new String[]{Constants.WEATERTYPES[Constants.FOG], Constants.WEATERTYPES[Constants.RAIN]});
            } else {
                weather = randomChoice(new String[]{Constants.WEATERTYPES[Constants.RAIN], Constants.WEATERTYPES[Constants.FOG], Constants.WEATERTYPES[Constants.SUN]});
            }
        }
        return weather;
    }

    private String randomChoice(String[] choices) {
        return choices[random.nextInt(choices.length)];
    }

	private WeatherProvider() {
		weather = new String[Constants.LONGITUDE_SIZE * Constants.LATITUDE_SIZE * Constants.HEIGHT_SIZE];
		for (int lon = 0; lon < Constants.LONGITUDE_SIZE; lon++) {
            for (int lat = 0; lat < Constants.LATITUDE_SIZE; lat++) {
                for (int height = 0; height < Constants.HEIGHT_SIZE; height++) {
                    int index = height + lat * Constants.LATITUDE_SIZE + lon * (Constants.LATITUDE_SIZE * Constants.HEIGHT_SIZE);  // Calculating the 1D index
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
			p_coordinates.getLatitude() * Constants.LATITUDE_SIZE +
			p_coordinates.getLongitude() * (Constants.LATITUDE_SIZE * Constants.HEIGHT_SIZE)];
	};

	public static WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}
}
