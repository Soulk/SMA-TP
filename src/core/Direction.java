package core;

import java.util.Random;

public class  Direction {

	public static String[] dir = {"N","S","W","E","NW","NE", "SW", "SE"};

	public static String getRandomDirection(){
		Random r = new Random();
		return dir[r.nextInt(dir.length)];
	}
	
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

	public static DijsktraElement getDirection(String direction){
		switch (direction) {
			case "N":
				return new DijsktraElement(-1, 0);
			case "S":
				return new DijsktraElement(1, 0);
			case "W":
				return new DijsktraElement(0, -1);
			case "E":
				return new DijsktraElement(0, 1);
			case "NW":
				return new DijsktraElement(-1, -1);
			case "NE":
				return new DijsktraElement(-1, 1);
			case "SW":
				return new DijsktraElement(1, -1);
			case "SE":
				return new DijsktraElement(1, 1);
			default:
				return null;
		}
	}
}
