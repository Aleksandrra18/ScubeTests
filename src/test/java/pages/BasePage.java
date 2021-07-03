package pages;

import driverManager.DriverManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getWebDriver()), this);
    }

    public Logger log(){
        return logger;
    }
}
