package aviation.main;

import aviation.simulation.Simulation;


public class Main {

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Invalid number of arguments");
		}
		Simulation simulation = new Simulation();
		simulation.run(args[0]);
	}
}