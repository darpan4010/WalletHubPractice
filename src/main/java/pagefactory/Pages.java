package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages {

	public Pages(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='email']")
	public WebElement txtUsername;
	
	@FindBy(xpath="//input[@name='pass']")
	public WebElement txtPassword;
	
	@FindBy(xpath="//button[@name='login']")
	public WebElement btnLogin;
	
	@FindBy(xpath="//*[@id='loginbutton']/input")
	public WebElement btnLogin1;
	
	@FindBy(xpath="//input[@name='q']")
	public WebElement txtGoogle;
		
	@FindBy(xpath="//div[@id='notNowBox']/label/input")
	public WebElement lnkNotnow;
	
	@FindBy(xpath="//span[contains(text(),'Create post')]")
	public WebElement lblCreatePost;
	
	@FindBy(xpath="//div[@class='_5rpb']/div")
	public WebElement txtWritePost;
	
	@FindBy(xpath="//span[contains(text(),'Post')]")
	public WebElement btnPost;
	
	
	//div[@id='placeholder-erutn']
	
	
}
