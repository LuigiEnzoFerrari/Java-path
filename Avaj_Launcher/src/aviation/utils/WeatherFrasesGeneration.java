package aviation.utils;

import java.util.Random;

public class WeatherFrasesGeneration {
	protected String[] sunFrases;
	protected String[] rainFrases;
	protected String[] fogFrases;
	protected String[] snowFrases;

	private static WeatherFrasesGeneration instance;
	private Random random = new Random();

	private WeatherFrasesGeneration(){
		sunFrases = new String[] {
			"Sun #1",
			"Sun #2",
			"Sun #3",
			"Sun #4",
		};

		rainFrases = new String[] {
			"Rain #1",
			"Rain #2",
			"Rain #3",
			"Rain #4",
		};

		fogFrases = new String[] {
			"Fog #1",
			"Fog #2",
			"Fog #3",
			"Fog #4",
		};

		snowFrases = new String[] {
			"Snow #1",
			"Snow #2",
			"Snow #3",
			"Snow #4",
		};
	}

	public static WeatherFrasesGeneration getInstance() {
		if (instance == null) {
			instance = new WeatherFrasesGeneration();
		}
		return instance;
	}

	public String getSunFrase(){
		return sunFrases[random.nextInt(sunFrases.length)];
	}

	public String getRainFrase(){
		return rainFrases[random.nextInt(rainFrases.length)];
	}

	public String getFogFrase(){
		return fogFrases[random.nextInt(fogFrases.length)];
	}

	public String getSnowFrase(){
		return snowFrases[random.nextInt(snowFrases.length)];
	}
}
