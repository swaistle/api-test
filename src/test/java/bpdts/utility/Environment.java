package bpdts.utility;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Environment {
    private static final Logger LOG = LoggerFactory.getLogger(Environment.class);

    private static final String URL_PROP = "APP_URL";

    @Getter
    public static String appUrl = "http://bpdts-test-app-v2.herokuapp.com";

    public static String getAppUrl(){
        String _url = System.getenv("APP_URL");
        if (_url != null) {
            appUrl = _url;
            LOG.debug(URL_PROP + "=" + appUrl);
        } else {
            LOG.debug(URL_PROP + " is null, keeping default value:");
            LOG.debug(URL_PROP + "=" + appUrl);
        }

        return appUrl ;
    }
}
