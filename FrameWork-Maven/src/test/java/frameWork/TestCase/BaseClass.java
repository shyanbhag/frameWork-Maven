package frameWork.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import frameWork.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig=new ReadConfig();

	public String baseUrl=readConfig.getURL();
	public String uname= readConfig.username();
	public String pwd=readConfig.password();
	public static WebDriver driver;
	public static Logger log;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) 
	{
		log= Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.firefoxpath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.chromepath());
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown(){

		driver.quit();
	}

	public void captureScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target=new File("./FrameWork.Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken");
	}
	
	//To create random string
	public String randomString() {

		String rmail=RandomStringUtils.randomAlphabetic(5);
		return rmail;
	}

}
