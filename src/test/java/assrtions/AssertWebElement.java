package assrtions;

import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.AbstractAssert;

public class AssertWebElement extends AbstractAssert<AssertWebElement, MobileElement> {

    private Logger logger = (Logger) LogManager.getLogger(AssertWebElement.class);

    public AssertWebElement(MobileElement mobileElement) {
        super(mobileElement, AssertWebElement.class);
    }

    public static AssertWebElement assertThat(MobileElement mobileElement) {
        return new AssertWebElement(mobileElement);
    }

    public AssertWebElement elementIsNotDisplayed() {
        isNotNull();
        if (!actual.isDisplayed()) {
            failWithMessage("User loged in");
        }
        logger.info("User can't log in with invalid credentials");
        return this;
    }
}
