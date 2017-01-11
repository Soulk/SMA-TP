package particules;

import core.Agent;
import core.MyColor;

/**
 * Created by decottignies on 11/01/17.
 */
public class Particules extends Agent {

    public Particules(int x, int y, MyColor color, String direction){
        super(x, y, color, direction);
    }

    @Override
    public void decide() {
        findNewPosition();
        makeAction();
    }
}
