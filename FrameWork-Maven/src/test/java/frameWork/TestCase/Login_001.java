package frameWork.TestCase;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import frameWork.PageObjects.LoginPage;

public class Login_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException 
	{
		log.info("Opening URL");
		LoginPage lp= new LoginPage(driver);
		lp.setUsername(uname);
		lp.setPassword(pwd);
		lp.clickSubmit();

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{

			Assert.assertTrue(true);
			log.info("Test Is passed");
		}
		else 	
		{	
			captureScreenshot(driver, "loginTest");
			log.info("Test Is failed");
			Assert.assertTrue(false);
		}

	} 

}
