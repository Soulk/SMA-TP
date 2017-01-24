package Hunter;

import core.*;
import core.Agent;
import core.PropertiesReader;
import core.SMA;

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
                    setPosYTmp(getPosX() + element.getX());
                    setPosXTmp(getPosY() + element.getY());

                    checkBounds();

                    if (dij[getPosX()][getPosY()] < currentValue) {
                        Environment.getTab()[getPosX()][getPosY()] = null;

                        setPosX(getPosX());
                        setPosY(getPosY());

                        Environment.getTab()[getPosX()][getPosY()] = this;
                    }
                }
            }
        }
    }

    public void setDij(int[][] dij) {
        this.dij = dij;
    }
}
