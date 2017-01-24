package Hunter;

import core.*;

/**
 * Created by decottignies on 18/01/17.
 */
public class Hunter extends Agent {

    int [][] dij;

    public Hunter(int posX, int posY, MyColor color, String direction){
        super(posX, posY, color, direction);
    }

    @Override
    public void decide() {
        if (SMA.nbTicks % Integer.parseInt(PropertiesReader.getInstance().getProperties("speedHunter")) == 0) {
            if (dij != null) {
                int currentValue = dij[getPosX()][getPosY()];
                for (int i = 0; i < Direction.dir.length; i++) {
                    DijsktraElement element = Direction.getDirection(Direction.dir[i]);
                    Hunter tmp = this;
                    tmp.setPosXTmp(getPosX() + element.getX());
                    tmp.setPosYTmp(getPosY() + element.getY());

                    tmp.checkBounds();

                    if (dij[tmp.getPosXTmp()][tmp.getPosYTmp()] < currentValue) {         	
                    	Environment.getTab()[getPosX()][getPosY()] = null;

                    	setPosX(tmp.getPosXTmp());
                    	setPosY(tmp.getPosYTmp());

                		Environment.getTab()[getPosX()][getPosY()] = this;
                		
                		break;
                    }
                }
            }
        }
    }

    public void setDij(int[][] dij) {
        this.dij = dij;
    }
}
