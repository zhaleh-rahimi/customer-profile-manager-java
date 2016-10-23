package util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {

    private static Logger logger = Logger.getLogger("Logger");
    private  LoggerUtil() throws IOException {

    }
    public static Logger getLogger() {
        return logger;
    }
}
