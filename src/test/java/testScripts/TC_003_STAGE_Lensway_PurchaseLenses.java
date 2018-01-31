package testScripts;

import lenswayPages.LensPage;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TC_003_STAGE_Lensway_PurchaseLenses extends TestBase {

    @Test

    public void TC_003_STAGE_LensValidation() throws InterruptedException {
        log.info("############################################################## Starting test to LensValidation ######################################################");
        //homePage=new HomePage(driver);
        init();
        lensPage=new LensPage(driver);
        //homePage.login_Lensway("Testuat@lenswaygroup.com", "Test@1231");
        lensPage.LensProduct();
        Thread.sleep(1000);
        //TC_003_STAGE_Lensway_PurchaseLenses.getScreenShots(driver);
        log.info("############################################################### Finished test to LensValidation ####################################################");
        driver.close();
    }
}

