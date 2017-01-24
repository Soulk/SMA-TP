package Hunter;

import core.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by decottignies on 18/01/17.
 */
public class Avatar extends Agent implements KeyListener {

    private int dirX = 0, dirY = 0;
    
    public Avatar(int posX, int posY, MyColor color, String direction){
        super(posX, posY, color, direction);
    }

	public void decide(){
        if(SMA.nbTicks % Integer.parseInt(PropertiesReader.getInstance().getProperties("speedAvatar"))== 0) {
            setPosXTmp(getPosX() + dirX);
            setPosYTmp(getPosY() + dirY);

            checkBounds();
            if (interditDeplacement()) {
                Environment.getTab()[getPosX()][getPosY()] = null;

                setPosX(getPosXTmp());
                setPosY(getPosYTmp());

                Environment.getTab()[getPosX()][getPosY()] = this;
            }
        }

    }
    public boolean interditDeplacement() {
        return Environment.getTab()[getPosXTmp()][getPosYTmp()] == null;
    }
    /**
     * Move the avatar with arrows
     * @param e
     */
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                dirY = -1;
                break;
            case KeyEvent.VK_RIGHT:
                dirY = 1;
                break;
            case KeyEvent.VK_UP:
                dirX = -1;
                break;
            case KeyEvent.VK_DOWN:
                dirX = 1;
                break;
        }
    }

    public void keyReleased(KeyEvent e){

       switch(e.getKeyCode()){
          	case KeyEvent.VK_LEFT:
                dirY = 0;
                break;
            case KeyEvent.VK_RIGHT:
                dirY = 0;
                break;
            case KeyEvent.VK_UP:
                dirX = 0;
                break;
            case KeyEvent.VK_DOWN:
                dirX = 0;
                break;
        }

    }

    public void keyTyped(KeyEvent e){
    }

}
