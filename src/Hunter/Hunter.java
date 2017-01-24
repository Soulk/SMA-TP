package Hunter;

import core.Agent;
import core.PropertiesReader;
import core.SMA;

/**
 * Created by decottignies on 18/01/17.
 */
public class Hunter extends Agent {

    @Override
    public void decide() {
        if (SMA.nbTicks % Integer.parseInt(PropertiesReader.getInstance().getProperties("speedHunter")) == 0) {

        }
    }
}
