package water;

import java.awt.Color;

import core.*;

public class Fish extends AbstractWater{

	int fishBreedTime;
	
	public Fish(int posX, int posY, MyColor color, String direction) {
		super(posX, posY, color, direction);
		this.fishBreedTime = Integer.parseInt(PropertiesReader.getInstance().getProperties("fishBreedTime"));
	}
	
	@Override
	public void decide() {
		super.decide();
		fishBreedTime--;

		int oldX = this.getPosX();
		int oldY = this.getPosY();

		//make the move
		findNewPosition();
		makeAction();
		
		//check if it can have a child

		if(fishBreedTime == 0 && madeAMove(oldX, oldY)){
			Agent fish = new Fish(oldX, oldY, MyColor.Vert, Direction.getRandomDirection());
			Environment.getTab()[oldX][oldY] = fish;
			SMA.listAgent.add(fish);

			printCSV("Fish", "Birth");

			fishBreedTime = Integer.parseInt(PropertiesReader.getInstance().getProperties("fishBreedTime"));
		} else if(fishBreedTime < 0 ) {
			fishBreedTime = Integer.parseInt(PropertiesReader.getInstance().getProperties("fishBreedTime"));
		}
		setDirection(Direction.getRandomDirection());
	}

}
