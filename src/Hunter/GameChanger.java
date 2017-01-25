package Hunter;

import core.PropertiesReader;
import core.SMA;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by David on 24/01/2017.
 */
public class GameChanger implements KeyListener {
    public static int speedHunter;
    public GameChanger(){
        speedHunter = Integer.parseInt(PropertiesReader.getInstance().getProperties("speedHunter"));
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                if(!SMA.stopped) {
                    SMA.stopped = true;
                } else {
                    SMA.stopped = false;
                }
                break;
            case KeyEvent.VK_W:
                if(SMA.delay != 1) {
                    if(SMA.delay - 50 > 0 ) {
                        SMA.delay -= 50;
                    } else {
                        SMA.delay = 1;
                    }
                }  else {
                    SMA.delay = 1;
                }
                break;
            case KeyEvent.VK_X:
                SMA.delay += 50;
                break;
            case KeyEvent.VK_A:
                if(speedHunter != 1) {
                    if(speedHunter - 10 > 0 ) {
                        speedHunter -= 10;
                    } else {
                        speedHunter = 1;
                    }
                }  else {
                    speedHunter = 1;
                }
                break;
            case KeyEvent.VK_Z:
                speedHunter += 10;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
