package utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by David on 18/01/2017.
 */
public class LoggerSMA {
    public static Logger logger;
    public LoggerSMA(Level level){
        logger = Logger.getAnonymousLogger();
        logger.setLevel(level);
    }
}
