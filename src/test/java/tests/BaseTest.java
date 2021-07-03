package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driverManager.DriverManager;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import server.AppiumServer;
import java.util.Properties;

public class BaseTest {

    private final String androidFileName = "configuration.properties";

    @Step("Loading properties from properties file and starting appium server")
    @BeforeClass
    public void beforeClass(){
        AppiumServer.startAppiumServer();
        PropertiesLoader loader = new PropertiesLoader();
        Properties properties = loader.getPropertiesFromFile(androidFileName);
        ConfigurationProperties.setProperties(properties);
    }

    @Step("Setting initial configuration with getWebDriver() method ")
    @BeforeMethod
    public void getDriver(){
        DriverManager.getWebDriver();
    }

    @Step("Disposing driver and stopping appium server")
    @AfterMethod
    public void tearDown() {
        DriverManager.disposeDriver();
        AppiumServer.stop();
    }
}
