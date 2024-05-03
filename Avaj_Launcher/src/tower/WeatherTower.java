package tower;
import coordinates.Coordinates;
import utils.WeatherProvider;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates p_coordinates){
		WeatherProvider weatherProvider = WeatherProvider.getInstance();
		return weatherProvider.getCurrentWeather(p_coordinates);
	}
	public void changeWeather() {
		this.conditionChanged();
	};
}
