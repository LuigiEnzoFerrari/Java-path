package utils.Parser;

import java.util.List;

import consts.Constants;

public class ParserErrorHandler {

	protected void handleEmptyAircraft(List<String[]> list) {
		try {
			checkIfEmptyAircrafts(list);
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
	}

	protected void handleEmptyFile(String file) {
		try {
			checkIfIsEmpty(file);
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
	}

	protected void handleValues(String[] words) {
		try {
			checkValue(words);
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
	}

	protected void handleType(String word) {
		try {
			checkType(word);
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
	}

	protected void handleCoordinates(String coordinate) {
		try {
			Integer.parseInt(coordinate);
		} catch(NumberFormatException e) {
			System.err.println("The coordinates should be a Integer");
			System.exit(1);
		}
	}

	protected void handleRunTimes(String number) {
		try {
			Integer.parseInt(number);
		} catch(NumberFormatException e) {
			System.err.println("The First line should be a Integer");
			System.exit(1);
		}
	}

	private void checkIfEmptyAircrafts(List<String[]> list) throws Exception {
		if (list.size() == 1) {
			throw new Exception("Should have at least 1 Aircraft");
		}
	}

	private void checkIfIsEmpty(String file) throws Exception {
		if (file == null) {
			throw new Exception("Empty file");
		}
	}

	private void checkValue(String[] words) throws Exception {
		if (words.length != 5) {
			throw new Exception("Each line should after the first line should contain 5 fields");
		}
	}

	private void checkType(String word) throws Exception {
		boolean find = false;
		for(String type : Constants.TYPES) {
			if (type.equalsIgnoreCase(word)) {
				find = true;
			}
		}
		if (find == false) {
			throw new Exception("This type does not exist");
		}
	}
}
