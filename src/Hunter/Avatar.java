package Hunter;

import core.Agent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by decottignies on 18/01/17.
 */
public class Avatar extends Agent implements KeyListener {

    private int dirX = 0, dirY = 0;

    public void decide(){
        setPosX(getPosX() + dirX);
        setPosY(getPosY() + dirY);
    }

    /**
     * Move the avatar with arrows
     * @param e
     */
    public void keyPressed(KeyEvent e){

        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                dirX = -1;
                break;
            case KeyEvent.VK_RIGHT:
                dirX = 1;
                break;
            case KeyEvent.VK_UP:
                dirY = 1;
                break;
            case KeyEvent.VK_DOWN:
                dirY = -1;
                break;
        }

    }

    public void keyReleased(KeyEvent e){

        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                dirX = 0;
                break;
            case KeyEvent.VK_RIGHT:
                dirX = 0;
                break;
            case KeyEvent.VK_UP:
                dirY = 0;
                break;
            case KeyEvent.VK_DOWN:
                dirY = 0;
                break;
        }

    }

    public void keyTyped(KeyEvent e){
    }

}
