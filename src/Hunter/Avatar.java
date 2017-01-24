package Hunter;

import core.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by decottignies on 18/01/17.
 */
public class Avatar extends Agent implements KeyListener {

    private int dirX = 0, dirY = 0, speedAvatar;
    
    public Avatar(int posX, int posY, MyColor color, String direction){
        super(posX, posY, color, direction);
        speedAvatar = Integer.parseInt(PropertiesReader.getInstance().getProperties("speedAvatar"));
    }

	public void decide(){
        if(SMA.nbTicks % speedAvatar == 0) {
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
                dirX = 0;
                break;
            case KeyEvent.VK_RIGHT:
                dirY = 1;
                dirX = 0;
                break;
            case KeyEvent.VK_UP:
                dirX = -1;
                dirY = 0;
                break;
            case KeyEvent.VK_DOWN:
                dirX = 1;
                dirY = 0;
                break;
            case KeyEvent.VK_O:
                if(speedAvatar != 1) {
                    if(speedAvatar - 10 > 0 ) {
                        speedAvatar -= 10;
                    } else {
                        speedAvatar = 1;
                    }
                }  else {
                    speedAvatar = 1;
                }
                break;
            case KeyEvent.VK_P:
                speedAvatar += 10;
                break;
        }
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){
    }

}
