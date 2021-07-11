package frameWork.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWork.PageObjects.LoginPage;
import frameWork.utilities.XLUtils;

public class Login_DDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String uname, String pwd) throws InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUsername(uname);
		log.info("UserName Provided");
		lp.setPassword(pwd);
		log.info("Password Provided");
		lp.clickSubmit();
		//Thread.sleep(2000);
		
		if(isAlertpresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			log.warn("Login Failed");
			Assert.assertTrue(false);
			
		}
		else {
			Assert.assertTrue(true);
			log.info("Login Passed");
			lp.clicklogout();
			//Thread.sleep(1000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertpresent()
	{
		try {

			driver.switchTo().alert();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"./XLFiles/XlUtils.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getcolumnCount(path, "Sheet1", 1);

		String logindata[][]=new String[rownum][colcount];

		for (int i = 1; i <rownum; i++) 
		{

			for (int j = 0; j < colcount; j++) 
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);

			}

		}
		return logindata;

	}


}
