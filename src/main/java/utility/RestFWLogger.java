package utility;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class RestFWLogger {
    private static final Logger Log = LogManager.getLogger(RestFWLogger.class);

    public static void initLogger() {
        PropertyConfigurator.configure("log4j.properties");
    }

    // This is to print log for the beginning of the test case
    public static void startTestCase(String sTestCaseName) {

        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
        Log.info("$$$$$$$$$$$$$$$$$$$$$            " + sTestCaseName + "         $$$$$$$$$$$$$$$$$$$$$$$$$");
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");

    }
}
