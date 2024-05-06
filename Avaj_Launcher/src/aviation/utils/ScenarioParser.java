package aviation.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import aviation.error.ParserErrorHandler;

public class ScenarioParser extends ParserErrorHandler {
	// Protected File;
	private BufferedReader reader;

	public ScenarioParser(String fileName) {
		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	public List<String[]>getFields() {
		String[] nRuntimes= {getRunTimes()};
		List<String[]> list = new ArrayList<>();
		list.add(nRuntimes);
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.isEmpty() == false) {
					list.add(getField(line));
				}
			}
		} catch (IOException io) {
			io.printStackTrace();
			System.exit(1);
		}
		handleEmptyAircraft(list);
		return list;
	}

	private String[] getField(String field) {
		String[] words = field.split("\\s+");
		if (words.length == 0) {
			return null;
		}

		handleValues(words);
		handleType(words[0]);

		for (int i = 2; i < 5; i++) {
			handleCoordinates(words[i]);
		}
		return words;
	}

	private String getRunTimes() {
		String line = null;

		try {
			while ((line = reader.readLine()) != null) {
				if (line.isEmpty() == false) {
					handleRunTimes(line);
					return line;
				}
			}
		} catch (IOException io) {
			io.printStackTrace();
			System.exit(1);
		}
		handleEmptyFile(line);
		return line;
	}
}
