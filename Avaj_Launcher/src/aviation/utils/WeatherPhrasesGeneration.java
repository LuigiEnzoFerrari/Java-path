package aviation.utils;

import java.util.Random;

public class WeatherPhrasesGeneration {
	protected String[] sunPhrases;
	protected String[] rainPhrases;
	protected String[] fogPhrases;
	protected String[] snowPhrases;
	protected String[] lastPhrases;

	private static WeatherPhrasesGeneration instance;
	private Random random = new Random();

	private WeatherPhrasesGeneration(){

		lastPhrases = new String[] {
			"This sun’s so bright, I think I'll just park here and sunbathe.",
			"Looks like we're swimming instead of flying today",
			"Lost in the fog! If found, please return to the nearest airport.",
			"Snow way we're landing on time today!",
		};

		sunPhrases = new String[] {
			"It's hot",
			"Sunscreen would have been a good idea up here!",
			"Let's not fly too high or we are toast",
			"Looks like the sun's trying to compete with my bright future!",
		};

		rainPhrases = new String[] {
			"It's rainning",
			"I think I need an umbrella!",
			"It's a good day for ducks, not for flying!",
			"At least the sky isn’t falling, just the water!",
		};

		fogPhrases = new String[] {
			"It's fogging",
			"Who put this cloud in my way",
			"Playing hide and seek with the runway today",
			"Time to trust the instruments more than my eyes",
		};

		snowPhrases = new String[] {
			"It's snowing",
			"Looks like we're inside a snow globe!",
			"Anyone up for high-altitude snowball fights",
			"Snow's so heavy, I think my plane just hibernated.",
		};
	}

	public static WeatherPhrasesGeneration getInstance() {
		if (instance == null) {
			instance = new WeatherPhrasesGeneration();
		}
		return instance;
	}

	public String getSunPhrase(){
		return sunPhrases[random.nextInt(sunPhrases.length)];
	}

	public String getRainPhrase(){
		return rainPhrases[random.nextInt(rainPhrases.length)];
	}

	public String getFogPhrase(){
		return fogPhrases[random.nextInt(fogPhrases.length)];
	}

	public String getSnowPhrase(){
		return snowPhrases[random.nextInt(snowPhrases.length)];
	}

	public String getLastPhrases(int weather){
		return lastPhrases[weather];
	}
}
