package app;
import java.util.Arrays;
import java.util.List;

import simulation.Simulation;
import tower.WeatherTower;

import utils.AircraftFactory;
import utils.Parser.ScenarioParser;


public class AircraftApp {

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Invalid number of arguments");
		}
		Simulation simulation = new Simulation();
		simulation.run(args[0]);
	}
}