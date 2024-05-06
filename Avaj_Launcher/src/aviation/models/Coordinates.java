package aviation.models;
public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	public Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.height = p_height;
		this.latitude = p_latitude;
		this.longitude = p_longitude;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}
}
