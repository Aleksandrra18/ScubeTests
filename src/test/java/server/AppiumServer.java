package server;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.qameta.allure.Step;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AppiumServer {

    private static AppiumDriverLocalService service;

    @Step("Initializing appium server")
    public static AppiumDriverLocalService startAppiumServer(){
        if(AppiumServer.service == null){
            initAppiumService().start();
        }
        return service;
    }

    public static URL getServiceUrl() {
        return service.getUrl();
    }

    private static AppiumDriverLocalService initAppiumService() {
        Map<String, String> env = new HashMap<>(System.getenv());
        env.put("ANDROID_HOME", "/home/ola/Android/Sdk");
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .withEnvironment(env)
                .usingAnyFreePort()
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
        return service;
    }

    @Step("Stopping appium server")
    public static void stop(){
        initAppiumService().stop();
        service = null;
    }
}
