package Hunter;

import core.SMA;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by David on 24/01/2017.
 */
public class GameChanger implements KeyListener {

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
                    if(SMA.delay - 10 > 0 ) {
                        SMA.delay -= 10;
                    } else {
                        SMA.delay = 1;
                    }
                }  else {
                    SMA.delay = 1;
                }
                break;
            case KeyEvent.VK_X:
                SMA.delay += 10;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
