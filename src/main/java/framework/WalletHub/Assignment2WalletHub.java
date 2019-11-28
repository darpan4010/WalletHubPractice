package framework.WalletHub;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pagefactory.WalletHubPages;



public class Assignment2WalletHub {

	WebDriver driver;

	@BeforeTest
	public void getDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Resources//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Parameters({ "userName", "passWord" })
	@Test
	public void performActionsWH(String userName, String passWord) throws InterruptedException{

		driver.get("https://wallethub.com/join/light");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		WalletHubPages wp = new WalletHubPages(driver);
		WebDriverWait wait = new WebDriverWait(driver, 240);

		//Wait till Email Address Field is visible.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']")));Thread.sleep(5000);

		//Enter Email ID
		wp.tbxEmailid.click();
		wp.tbxEmailid.sendKeys(userName);
		//Enter Password
		wp.tbxPassword.click();
		wp.tbxPassword.sendKeys(passWord);

		//Enter Password in confirm password textbox
		wp.tbxConfirmPwd.click();
		wp.tbxConfirmPwd.sendKeys(passWord);

		//Click on the checkbox
		wp.chkbxgreecresitScore.click();Thread.sleep(2000);

		//Click on Join Button
		wp.btnJoin.click();

		//Check if user is existing user if yes then login with credentials. 
		try {
			if(wp.txtExistingaccount.getText().toString().trim().equals("Email Already In Use!")) {

				wp.tbxPwdExisting.click();
				wp.tbxPwdExisting.sendKeys(passWord);
				wp.btnLogin.click();Thread.sleep(5000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("This is new Account");
		}

		//Navigate to Profile review page.
		driver.navigate().to("http://wallethub.com/profile/test_insurance_company/");

		//Hover all start one by one till star get lit up and Click on 5th Star.
		WebElement target = driver.findElement(By.xpath("(//*[@class='rvs-star-svg'])[11]"));
		Actions action = new Actions(driver);
		for(int i=11;i<15;i++) {			
			action.moveToElement(driver.findElement(By.xpath("(//*[@class='rvs-star-svg'])["+i+"]"))).perform();Thread.sleep(2000);
		}
		//Click on 5th Star for 5* review.		
		driver.findElement(By.xpath("(//*[@class='rvs-star-svg'])[14]")).click();

		//Click on the dropdown
		driver.findElement(By.xpath("//span[contains(text(),'Select...')]")).click();Thread.sleep(3000);

		//Select Health Insurance from the dropdown
		driver.findElement(By.xpath("//li[contains(text(),'Health Insurance')]")).click();

		//Write your review
		driver.findElement(By.xpath("//textarea[@placeholder='Write your review...']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Write your review...']")).sendKeys("This is a really long message. This is a really long message. This is a really long message. This is a really long message. This is a really long message. This is at least 200 chars long.This is a really long message. This is a really long message. This is a really long message. This is a really long message.");
		String url = driver.getCurrentUrl().toString().trim();
		System.out.println(url);		
		String arr[] = url.split("/");
		String arr1[] = arr[4].split("-");
		System.out.println(arr1[3]);
	
		//Click on Submit
		driver.findElement(By.xpath("//div[@class='sbn-action semi-bold-font btn fixed-w-c tall']")).click();Thread.sleep(3000);
		
		//Navigate to the Profile
		driver.navigate().to("https://wallethub.com/profile/"+arr1[3]);
		
		String ar[] = userName.split("@");
		String usernm = ar[0].replace(".", "_");
		System.out.println(usernm);
		try {
			boolean flag = driver.findElement(By.xpath("//span[@class='rvtab-ci-name'][contains(text(),'"+usernm+"')]")).isDisplayed();
			if(flag ==true) {
				
//				assertEquals(actual, expected);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
}

	@AfterTest
	public void closeDriver() {
		//		driver.close();
	}
}
