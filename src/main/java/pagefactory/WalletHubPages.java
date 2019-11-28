package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WalletHubPages extends Pages{

	public WalletHubPages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//input[@placeholder='Email Address']")
	public WebElement tbxEmailid;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	public WebElement tbxPassword;
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	public WebElement tbxConfirmPwd;
	
	@FindBy(xpath="//span[contains(text(),'Get my free credit score & report')]")
	public WebElement chkbxgreecresitScore;
	
	@FindBy(xpath="//span[contains(text(),'Join')]")
	public WebElement btnJoin;
		
	@FindBy(xpath="//h2[contains(text(),'Email Already In Use!')]")
	public WebElement txtExistingaccount;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	public WebElement tbxPwdExisting;
		
	@FindBy(xpath="//span[contains(text(),'Login')]")
	public WebElement btnLogin;
	
}
