
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementsUtils {
    
    /**
     * Waits until the element is visible AND its text stays unchanged for `stableFor`.
     * Useful for React/animated counters to avoid reading intermediate values.
     */
    public static String waitForStableText(WebDriver driver, By locator,
                                           Duration timeout, Duration stableFor) {

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        // ensure it's in the DOM and visible first
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        long deadline = System.currentTimeMillis() + timeout.toMillis();
        String last = el.getText().trim();
        long lastChange = System.currentTimeMillis();

        while (System.currentTimeMillis() < deadline) {
            try { Thread.sleep(120); } catch (InterruptedException ignored) {}

            String now = el.getText().trim();
            if (!now.equals(last)) {
                last = now;
                lastChange = System.currentTimeMillis();
                continue;
            }
            if (!now.isBlank() && System.currentTimeMillis() - lastChange >= stableFor.toMillis()) {
                return now; // text has been stable long enough
            }
        }
        throw new TimeoutException("Text did not stabilize for locator: " + locator);
    }
}
