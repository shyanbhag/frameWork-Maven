package frameWork.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAccount {

	WebDriver ldriver;

	public AddAccount(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);

	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[5]/a")
	WebElement newAccount;

	@FindBy(name="cusid")
	WebElement cID;

	@FindBy(name="selaccount")
	WebElement accountType;

	@FindBy(name="inideposit")
	WebElement iDeposit;

	@FindBy(name="button2")
	WebElement submit;
	
	public void newAccont() {
		newAccount.click();
		
	}
	public void addCID(String cusID) {

		cID.sendKeys(cusID);
	}
	public void addType(String type) {

		Select dropdown= new Select(accountType);
		dropdown.selectByValue(type);
	}
	public void addDeposit(String amount) {

		iDeposit.sendKeys(amount);
	}
	public void clickSubmit() {

		submit.click();
	}

}
