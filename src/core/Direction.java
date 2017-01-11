package core;

public class  Direction {

	public static String[] dir = {"N","S","W","E","NW","NE", "SW", "SE"};
	
	public static String getAntiDir(String direction, String wall) {
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
			if(wall.equals("N")){
				return "SW";
			} else {
				return "NE";
			}
		case "NE":
			if(wall.equals("N")){
				return "SE";
			} else {
				return "NW";
			}
		case "SW":
			if(wall.equals("S")){
				return "NW";
			} else {
				return "SE";
			}
		case "SE":
			if(wall.equals("S")){
				return "NE";
			} else {
				return "SW";
			}
		default:
			return null;
		}
	}
}
