package de.phonebook.core;

import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicatioManager app = new ApplicatioManager
            (System.getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        System.out.println("Before suite");
        app.init();
    }


    @AfterSuite(enabled = true)
    public void tearDown() {
        System.out.println("After suite");
        app.stop();
    }

    @BeforeMethod
    public void startTest(Method method) {
        logger.info("Start test{}", method.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: {}", result.getMethod().getMethodName());
        } else {
            logger.error("FAILED:  {}", result.getMethod().getMethodName() ,
                  app.getUser().takeScreenshot()  );

        }
        logger.info("Stop test");
        logger.info("*********************************");
    }
}
