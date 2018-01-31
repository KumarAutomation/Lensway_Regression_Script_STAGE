package testScripts;

import lenswayPages.HomePage;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TC_002_STAGE_Lensway_LoginValidation extends TestBase {

    HomePage homePage;

    @Test

    public void TC_002_STAGE_LoginValidation() throws InterruptedException {
        log.info("######################################################### Starting test to verify login details #####################################################");
        init();
        homePage=new HomePage(driver);
        homePage.login_Lensway("Testuat@lensway.com", "Test@1231");
        Thread.sleep(500);
        //TC_002_STAGE_Lensway_LoginValidation.getScreenShots(driver);
        log.info("######################################################### Finished test to verify login details #####################################################");
        driver.close();
    }
}


