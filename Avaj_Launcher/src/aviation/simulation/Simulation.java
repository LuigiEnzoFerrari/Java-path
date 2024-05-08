package aviation.simulation;

import java.util.List;

import aviation.control.WeatherTower;
import aviation.factory.AircraftFactory;
import aviation.flyable.Flyable;
import aviation.models.Coordinates;
import aviation.utils.ScenarioParser;

public class Simulation {
	int nRuntimes;

	public void run(String fileName) {
		List<String[]> fields = new ScenarioParser(fileName).getFields();
		this.nRuntimes = Integer.parseInt(fields.get(0)[0]);
		AircraftFactory aircraftFactory = AircraftFactory.getInstance();
		WeatherTower weatherTower = new WeatherTower();

		for (int i = 1; i < fields.size(); i++ ) {
			String[] field = fields.get(i);
			Coordinates coordinates = new Coordinates(Integer.parseInt(field[2]), Integer.parseInt(field[3]), Integer.parseInt(field[4]));
			Flyable newFlyable = aircraftFactory.newAircraft(field[0], field[1], coordinates);
			newFlyable.setWeatherTower(weatherTower);
			weatherTower.register(newFlyable);
		}

		for (int i = 0; i < nRuntimes; i++) {
			weatherTower.changeWeather();
		}
	}
}
