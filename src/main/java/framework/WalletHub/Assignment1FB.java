package framework.WalletHub;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pagefactory.Pages;
import utility.CommonMethods;

public class Assignment1FB {

	WebDriver driver;

	@BeforeTest
	public void getDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Resources//chromedriver.exe");
		//		 driver = new ChromeDriver();
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);

		//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
		driver = new ChromeDriver(options);

	}

	@Parameters({ "userName", "passWord" })
	@Test
	public void facebookPost(String userName, String passWord) throws InterruptedException{
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Pages page = new Pages(driver);
		page.txtUsername.click();
		page.txtUsername.sendKeys(userName);Thread.sleep(3000);
		page.txtPassword.click();
		page.txtPassword.sendKeys(passWord);Thread.sleep(3000);

		try {
			page.btnLogin.click();	
		} catch (Exception e) {
			// TODO: handle exception
			page.btnLogin1.click();
		}

		try {
			if((page.lnkNotnow.isDisplayed()) == true) {
				page.lnkNotnow.click();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Phone number popup is not displayed");
		}
		try {
			page.lnkNotnow.click();
		} catch (Exception e) {
			// TODO: handle exception
		}

		page.lblCreatePost.click();Thread.sleep(3000);

		//		page.txtWritePost.click();


		try {
			Thread.sleep(5000);
			page.txtWritePost.sendKeys("Hello World");	
		} catch (Exception e) {
			// TODO: handle exception
//			page.txtWritePost.click();Thread.sleep(5000);
			page.txtWritePost.sendKeys("Hello World");
		}

		try {
			if((page.btnPost.isEnabled())==true) {
				Thread.sleep(5000);
				page.btnPost.click();
			}
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("Post Button is not enabled.");
		}
		
	}

	@AfterTest
	public void closeDriver() {
//		driver.close();
	}
}
