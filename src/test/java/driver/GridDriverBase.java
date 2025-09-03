package driver;


import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GridDriverBase {
    private static final List<GridDriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<GridDriverFactory>());
    private static ThreadLocal<GridDriverFactory> driverThread;
    private String browser;

    @BeforeSuite(alwaysRun = true)
    public static void initWebDriverObject() {
        driverThread = ThreadLocal.withInitial(() -> {
            GridDriverFactory gridDriverFactory = new GridDriverFactory();
            webDriverThreadPool.add(gridDriverFactory);
            return gridDriverFactory;
        });
    }

    public RemoteWebDriver getDriver(String browser) throws MalformedURLException {
        this.browser = browser;
        return driverThread.get().getDriver(browser);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("Count thread local" + webDriverThreadPool.size());

        for (GridDriverFactory driver : webDriverThreadPool) {
            driver.quitDriver();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) throws MalformedURLException {
        System.out.println("Taking a screenshot \n");
//        getDriver().manage().deleteAllCookies();
        if (ITestResult.FAILURE == result.getStatus() || ITestResult.SUCCESS == result.getStatus()) {
            // get the test method name
            String testMethod = result.getName();
            // take time
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH);
            int d = calendar.get(Calendar.DATE);
            int h = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int s = calendar.get(Calendar.SECOND);

            String takenTime = y + "-" + m + "-" + d + "-" + h + "-" + min + "-" + s;

            // declare location file
            String fileLocation = System.getProperty("user.dir") + "/screenshots/" + testMethod + takenTime + ".png";

            // save the screenshots to the system
            File screenshot = ((TakesScreenshot) driverThread.get().getDriver(this.browser)).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File(fileLocation));
                Path content = Paths.get(fileLocation);
                InputStream is = Files.newInputStream(content);
                Allure.addAttachment(testMethod, is);
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}