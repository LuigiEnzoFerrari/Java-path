package aviation.aircraft;
import aviation.consts.Constants;
import aviation.flyable.Flyable;
import aviation.models.Coordinates;
import aviation.utils.WeatherPhrasesGeneration;

public class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;

		int newHeight = 0;
		int newLatitude = 0;
		int newLongitude = 0;

		if (coordinates.getHeight() > 100) {
			newHeight = 100;
		} else {
			newHeight = coordinates.getHeight();
		}
		newLatitude  = coordinates.getLatitude() % 100;
		newLongitude  = coordinates.getLongitude() % 100;
		coordinates = new Coordinates(newLongitude, newLatitude, newHeight);
	};

	protected void speak(String weather, String format, int height) {
		WeatherPhrasesGeneration generation = WeatherPhrasesGeneration.getInstance();
		if (height <= 0) {
			if (weather.equals(Constants.WEATHERTYPES[Constants.SUN])) {
				System.out.println(format + generation.getLastPhrases(Constants.SUN));
			} else if (weather.equals(Constants.WEATHERTYPES[Constants.RAIN])) {
				System.out.println(format + generation.getLastPhrases(Constants.RAIN));
			} else if (weather.equals(Constants.WEATHERTYPES[Constants.FOG])) {
				System.out.println(format + generation.getLastPhrases(Constants.FOG));
			} else {
				System.out.println(format + generation.getLastPhrases(Constants.SNOW));
			}
		} else if (weather.equals(Constants.WEATHERTYPES[Constants.SUN])) {
			System.out.println(format + generation.getSunPhrase());
		} else if (weather.equals(Constants.WEATHERTYPES[Constants.RAIN])) {
			System.out.println(format + generation.getRainPhrase());
		} else if (weather.equals(Constants.WEATHERTYPES[Constants.FOG])) {
			System.out.println(format + generation.getFogPhrase());
		} else {
			System.out.println(format + generation.getSnowPhrase());
		}
	}

	@Override
	public void updateConditions() {}
}
