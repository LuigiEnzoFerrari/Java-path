package aviation.control;
import aviation.models.Coordinates;
import aviation.provider.WeatherProvider;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates p_coordinates){
		WeatherProvider weatherProvider = WeatherProvider.getInstance();
		return weatherProvider.getCurrentWeather(p_coordinates);
	}
	public void changeWeather() {
		this.conditionChanged();
	};
}
