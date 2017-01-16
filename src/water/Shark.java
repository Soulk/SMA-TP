package water;

import core.Agent;
import core.Direction;
import core.Environment;
import core.MyColor;
import core.PropertiesReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shark extends AbstractWater{

	int sharkBreedTime, sharkStarveTime;

    public Shark(int posX, int posY, MyColor color, String direction){
        super(posX, posY, color, direction);
        this.sharkBreedTime = Integer.parseInt(PropertiesReader.getInstance().getProperties("sharkBreedTime"));
        this.sharkStarveTime = Integer.parseInt(PropertiesReader.getInstance().getProperties("sharkStarveTime"));
    }
	@Override
	public void decide() {
        super.decide();
		sharkBreedTime--;
		sharkStarveTime--;

		if(sharkStarveTime > 0) {
			int oldX, oldY;
			List<Fish> l_fish = isAFishAround();
			//check if fish are around it
			if (!l_fish.isEmpty()) {
				// eat the fish
				Random r = new Random();
				Fish toRemove = l_fish.get(r.nextInt(l_fish.size()));
				Environment.getTab()[toRemove.getPosX()][toRemove.getPosY()] = null;

				// move the shark
				Environment.getTab()[getPosX()][getPosY()] = null;

				oldX = this.getPosX();
				oldY = this.getPosY();

				setPosX(toRemove.getPosX());
				setPosY(toRemove.getPosY());

				Environment.getTab()[getPosX()][getPosY()] = this;

                sharkStarveTime =  Integer.parseInt(PropertiesReader.getInstance().getProperties("sharkStarveTime"));
			} else {

				oldX = this.getPosX();
				oldY = this.getPosY();

				findNewPosition();
				makeAction();
			}

			if (sharkBreedTime == 0 && madeAMove(oldX, oldY)) {
				Agent shark = new Shark(oldX, oldY, MyColor.Rose, Direction.getRandomDirection());
				Environment.getTab()[oldX][oldY] = shark;
				sharkBreedTime = Integer.parseInt(PropertiesReader.getInstance().getProperties("sharkBreedTime"));
			} else if(sharkBreedTime == 0){
				sharkBreedTime = Integer.parseInt(PropertiesReader.getInstance().getProperties("sharkBreedTime"));
			}
		} else {
			Environment.getTab()[getPosX()][getPosY()] = null;
		}

	}
	
	/*
	 * 
	 * @return
	 */
	public List<Fish> isAFishAround(){
		int x = 0, y = 0;
		List<Fish> l_fish = new ArrayList<Fish>();
		for(int i=0;i<Direction.dir.length; i++) {

			switch (Direction.dir[i]) {
				case "N":
					x = getPosX() - 1;
					y = getPosY();
					break;
				case "S":
					x = getPosX() + 1;
					y = getPosY();
					break;
				case "W":
					x = getPosX();
					y = getPosY() - 1;
					break;
				case "E":
					x = getPosX();
					y = getPosY() + 1;
					break;
				case "NW":
					x = getPosX() - 1;
					y = getPosY() - 1;
					break;
				case "NE":
					x = getPosX() - 1;
					y = getPosY() + 1;
					break;
				case "SW":
					x = getPosX() + 1;
					y = getPosY() - 1;
					break;
				case "SE":
					x = getPosX() + 1;
					y = getPosY() + 1;
					break;
			}
			if(x > -1 && x < Environment.getTailleX() && y > -1 && y < Environment.getTailleY())
				if(Environment.getTab()[x][y] != null && Environment.getTab()[x][y].getClass().equals(Fish.class))
					l_fish.add((Fish)Environment.getTab()[x][y]);
		}

		return l_fish;
	}

}
