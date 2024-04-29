public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.height = p_height;
		this.latitude = p_latitude;
		this.longitude = p_longitude;
	}

	int getLongitude() {
		return this.longitude;
	}

	int getLatitude() {
		return this.latitude;
	}

	int getHeight() {
		return this.height;
	}
}
