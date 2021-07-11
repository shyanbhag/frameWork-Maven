package frameWork.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rDriver) 
	{
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logout;
	
	public void setUsername(String uname) 
	{
		
		txtUsername.sendKeys(uname);
	}
	public void setPassword(String pwd) 
	{
		
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() 
	{
		btnLogin.click();
	}
	public void clicklogout() 
	{
		logout.click();
	}
}
