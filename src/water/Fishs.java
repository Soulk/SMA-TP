package water;

import java.awt.Color;

import core.Agent;
import core.Direction;
import core.Environment;
import core.MyColor;
import core.PropertiesReader;

public class Fishs extends Agent{

	int fishBreedTime;
	
	public Fishs(int x, int y, MyColor color, String direction) {
		super(x, y, color, direction);
		this.fishBreedTime = Integer.parseInt(PropertiesReader.getInstance().getProperties("fishBreedTime"));
	}
	
	@Override
	public void decide() {
		fishBreedTime--;
		
		//make the move
		findNewPosition();
		makeAction();
		
		//check if it can have a child
		int oldX = this.getPosX();
		int oldY = this.getPosY();
		if(fishBreedTime == 0 && madeAMove(oldX, oldY)){
			Agent fish = new Fishs(oldX, oldY, MyColor.Vert, Direction.getRandomDirection());
			Environment.getTab()[oldX][oldY] = fish;
			fishBreedTime = Integer.parseInt(PropertiesReader.getInstance().getProperties("fishBreedTime"));
		}
	}

}
