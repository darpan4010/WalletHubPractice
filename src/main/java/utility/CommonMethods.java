package utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class CommonMethods {

	
	public boolean isAlertpresent(WebDriver driver) {

		try {
		driver.switchTo().alert().accept();
		
		return true;
			
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			return false;
		}		
	}
}
