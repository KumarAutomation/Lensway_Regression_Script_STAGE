package testScripts;

import lenswayPages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TC_001_STAGE_Lensway_UserRegistration extends TestBase {

    HomePage homePage;

    @Test

    public void TC_001_STAGE_UserRegistration() {

        log.info("############################################# Starting test to verify User registration details ######################################################");
        init();
        homePage = new HomePage(driver);
        homePage.registration_Lensway();
        // homePage.registrationSuccess();
        // Assert.assertEquals(false,homePage.registrationSuccess());

        log.info("############################################### Finished test to User registration details ##########################################################");
        driver.close();
    }
}