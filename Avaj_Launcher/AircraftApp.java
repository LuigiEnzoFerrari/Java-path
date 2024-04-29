public class AircraftApp {
    public static void main(String[] args) {
		AircraftFactory factory = new AircraftFactory();
		Flyable helicopter = factory.newAircraft("Helicopter", "Helicopter", null);
		helicopter.updateConditions();
        System.out.println("Hello, World!");
    }
}