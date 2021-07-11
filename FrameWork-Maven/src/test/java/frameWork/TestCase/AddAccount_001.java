package frameWork.TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameWork.PageObjects.AddAccount;
import frameWork.PageObjects.LoginPage;

public class AddAccount_001 extends BaseClass {
	
	@Test
	public void addNewAccount(){
		
		LoginPage lPage=new LoginPage(driver);
		lPage.setUsername(uname);
		lPage.setPassword(pwd);
		lPage.clickSubmit();
		
		AddAccount ad=new AddAccount(driver);
		ad.newAccont();
		ad.addCID("48710");
		ad.addType("Current");
		ad.addDeposit("10000");
		ad.clickSubmit();
		
		boolean resString=driver.getPageSource().contains("Account Generated Successfully!!!");
		
		if(resString==true) {
			Assert.assertTrue(true);
			log.info("Account Created");
			
		}
		else {
			log.info("Account Creation failed");
			Assert.assertTrue(false);
		}
	}

}
