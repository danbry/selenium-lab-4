package se.omegapoint.selenium.browser;

import se.omegapoint.selenium.infra.Config;

/**
 * Util to select the configured browser
 */
public class BrowserSelector {

    public static BrowserDriver getConfiguredBrowser() {
        String configuredBrowser = Config.getStringValue(Config.Value.BROWSER);

        switch(configuredBrowser) {
            case "Chrome": return new Chrome();
            case "Chrome-headless": return new ChromeHeadless();
            case "Firefox": return new Firefox();
            case "Safari": return new Safari();
            default: return new Chrome();
        }
    }
}
