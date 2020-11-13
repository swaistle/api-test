package bpdts.utility;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScenarioContext {
    private static final Logger LOG = LoggerFactory.getLogger(ScenarioContext.class);

    private static final String URL_PROP = "APP_URL";

    @Getter
    private static String url = "http://bpdts-test-app-v2.herokuapp.com";

    private static void setUrl() {
        String _url = System.getenv(URL_PROP);
        if (_url != null) {
            url = _url;
            LOG.debug(URL_PROP + "=" + url);
        } else {
            LOG.debug(URL_PROP + " is null, keeping default value:");
            LOG.debug(URL_PROP + "=" + url);
        }
    }
}
