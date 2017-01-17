package water;

import core.Agent;
import core.MyColor;

/**
 * Created by decottignies on 16/01/17.
 */
public abstract class AbstractWater extends Agent {

    private boolean isBaby;
    private int timeOfLife;
    public AbstractWater(int x, int y, MyColor color, String direction){
        super(x, y, color, direction);
        this.isBaby = true;
        this.timeOfLife = 0;
    }

    public void decide(){
        if(isBaby && timeOfLife ==1) {
            if (this.getClass().equals(Shark.class)) {
                this.setColor(MyColor.Rouge);
            } else {
                this.setColor(MyColor.Bleu);
            }
            isBaby = !isBaby;
        }
        timeOfLife++;
    }

}
