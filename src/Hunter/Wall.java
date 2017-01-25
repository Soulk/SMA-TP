package Hunter;

import core.Agent;
import core.MyColor;

/**
 * Created by decottignies on 18/01/17.
 */
public class Wall extends Agent {

    public Wall(int posX, int posY, MyColor color, String direction) {
        super(posX, posY, color, direction);
    }
    @Override
    public void decide() {
        // He doesn't move
    }



}
