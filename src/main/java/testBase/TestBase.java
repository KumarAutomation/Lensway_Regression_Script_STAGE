package testBase;

import lenswayPages.HomePage;
import lenswayPages.LensPage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public final Logger log=Logger.getLogger(TestBase.class.getName());

    public static WebDriver driver;
    public HomePage homePage;
    public LensPage lensPage;
    public Properties properties;

    String url="https://stage-lw-se.lenslogistics.com/";
    String browser="chrome";


    public void init()

    {
        selectBrowser(browser);
        getUrl(url);
        String log4jconfpath = "log4j.properties";
        PropertyConfigurator.configure(log4jconfpath);
    }



    public  void selectBrowser(String Browser){

        if (Browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver.exe");
            driver= new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        else if(Browser.equalsIgnoreCase("chrome"))
        {

            //System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
            //System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/jobs/Lensway_Automation_Script/workspace/driver/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
            //System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/tools/chromedriver/chromedriver");
            log.info("Creating object of " +Browser);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1400,600");
            options.addArguments("no-sandbox");
            options.addArguments("headless");

            driver =new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }


        else if (Browser.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/driver/IEDriverServer.exe");
            driver= new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
    }


    public void getUrl(String url)

    {

        log.info("Navigating to " +url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }




    public static void getScreenShots(WebDriver driver) {

        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile method

            FileUtils.copyFile(src, new File("H:\\Screenshots"+System.currentTimeMillis()+".png"));
        }

        catch (IOException e)

        {

            System.out.println(e.getMessage());

        }

    }


}

