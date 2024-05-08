package aviation.aircraft;
import aviation.flyable.Flyable;
import aviation.models.Coordinates;

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

	@Override
	public void updateConditions() {}
}
