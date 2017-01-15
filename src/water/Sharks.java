package water;

import core.Agent;
import core.Direction;
import core.Environment;
import core.MyColor;
import core.PropertiesReader;

public class Sharks extends Agent{

	int sharkBreedTime, sharkStarveTime;
		
	public Sharks(int x, int y, MyColor color, String direction, int sharkBreedTime, int sharkStarveTime){
		super(x, y, color, direction);
		this.sharkBreedTime = sharkBreedTime;
		this.sharkStarveTime = sharkStarveTime;
	}
	@Override
	public void decide() {
		//check if fish are around it
		if(){
			
		} else {
			findNewPosition();
			makeAction();
			/*
			int oldX = this.getPosX();
			int oldY = this.getPosY();
			if(shakBreedTime == 0 && madeAMove(oldX, oldY)){
				Agent fish = new Fishs(oldX, oldY, MyColor.Vert, Direction.getRandomDirection());
				Environment.getTab()[oldX][oldY] = fish;
				fishBreedTime = Integer.parseInt(PropertiesReader.getInstance().getProperties("fishBreedTime"));
			}*/
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Fishs isAFishAround(){
		
	}

}
