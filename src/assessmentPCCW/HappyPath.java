package assessmentPCCW;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HappyPath extends TestExecution {
	public static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	
	public static void main() throws InterruptedException, NoSuchElementException {
		System.out.println("---------------------------------------------------");
		System.out.println("--------------- HAPPY PATH SCENARIO ---------------");
		System.out.println("---------------------------------------------------");
		
		appConn();
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login\"]")));
			System.out.println("Header is seen.");
		} catch (Exception e) {
			System.out.println("An error has occurred while trying to access the application."); 
		}
		
		try {
			WebElement usernameTxtfield = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			WebElement passwordTxtfield = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
		
			String usernameData= driver.findElement(By.xpath("//*[@id=\"login\"]/ul/li[2]/b[1]")).getText();
			String passwordData= driver.findElement(By.xpath("//*[@id=\"login\"]/ul/li[2]/b[2]")).getText();
	
		
			if (usernameTxtfield.isDisplayed()) {
				usernameTxtfield.sendKeys(usernameData);
				passwordTxtfield.sendKeys(passwordData);
				
				System.out.println("PASSED - Username and password is inputted.");

				submitBtn.click();
				System.out.println("PASSED - Submit button is clicked.");	
			} else {
				System.out.println("FAILED - Username and password fields were not found.");
			}
		} catch (Exception e) {
			System.out.println("FAILED - An error has occurred while trying to log in."); 
		} 
		
		try {
			String correctURL = "practicetestautomation.com/logged-in-successfully/";
			String currentURL = driver.getCurrentUrl();
			System.out.println("The current URL is: " + currentURL);
			
			if (currentURL.contains(correctURL)) {
				System.out.println("PASSED - Validated URL and is correct." );
			} else 
				System.out.println("FAILED - Incorrect URL" );
		} catch (Exception e) {
			System.out.println("FAILED - An error has occurred in validating URL."); 
		}
		
		try {
			Boolean successfulNotif = driver.findElement(By.xpath("//*[@class='post-content']/p/strong[contains(text(), \"Congratulations\")]")).isDisplayed();
			System.out.println("PASSED - Congratulations text is " +successfulNotif);
		} catch (Exception e) {
			System.out.println("FAILED - An error has occurred in validating congratulations text."); 
		}
		
		try {
			Boolean logoutBtn = driver.findElement(By.xpath("//*[@class='wp-block-button aligncenter is-style-fill']/a[contains (text(), \"Log out\")]")).isDisplayed();
			System.out.println("PASSED - Logout button/text is " +logoutBtn);
		} catch (Exception e) {
			System.out.println("FAILED - An error has occurred in validating logout button."); 
		}
		
		Thread.sleep(3000);
		
		System.out.println("---------------------------------------------------");
		System.out.println("---------- Scenario execution is finished ---------");
		System.out.println("---------------------------------------------------");
		
	}
}
