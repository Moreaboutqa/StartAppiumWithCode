package com.yousafzai;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class StartServer {

    @BeforeTest
    public static void startAppiumServer() {
        HashMap<String, String> environment = new HashMap();
        //path to carthage
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File("C:\\Users\\rashid.ali\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withEnvironment(environment)
                .withTimeout(Duration.ofSeconds(300))
                //.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                //.withArgument(GeneralServerFlag.LOG_LEVEL, "WARN")
                .withLogFile(new File("AppiumLog.txt"));

        AppiumDriverLocalService service;
         service = AppiumDriverLocalService.buildService(builder);
        service.start();

    }
    @Test
    public void test() {
        // test code goes here
        System.out.println("Test 1");
    }
}