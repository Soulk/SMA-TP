package water;

import core.Agent;
import core.MyColor;

/**
 * Created by decottignies on 16/01/17.
 */
public abstract class AbstractWater extends Agent {

    private boolean isBaby;

    public AbstractWater(int x, int y, MyColor color, String direction){
        super(x, y, color, direction);
        this.isBaby = true;
    }

    public void decide(){
        if(isBaby) {
            if (this.getClass().equals(Shark.class)) {
                this.setColor(MyColor.Rouge);
            } else {
                this.setColor(MyColor.Bleu);
            }
            isBaby = !isBaby;
        }
    }

}
