package Utils;

public class  Direction {

	public static String[] dir = {"N","S","W","E","NW","NE", "SW", "SE"};
	
	public static String getAntiDir(String direction) {
		switch (direction) {
		case "N":
			return "S";
		case "S":
			return "N";
		case "W":
			return "E";
		case "E":
			return "W";
		case "NW":
			return "SE";
		case "NE":
			return "SW";
		case "SW":
			return "NE";
		case "SE":
			return "NW";
		default:
			return null;
		}
	}
}
