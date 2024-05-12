package assessmentPCCW;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Negative extends TestExecution {
	public static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

	static void incorrectUser() throws InterruptedException, NoSuchElementException {
		System.out.println("---------------------------------------------------");
		System.out.println("----------- INCORRECT USERNAME SCENARIO -----------");
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
			
			if (usernameTxtfield.isDisplayed()) {
				usernameTxtfield.sendKeys("incorrectUser");
				passwordTxtfield.sendKeys("Password123");
				
				System.out.println("PASSED - Username and password is inputted.");

				submitBtn.click();
				System.out.println("PASSED - Submit button is clicked.");	
			} else
				System.out.println("FAILED - Username and password fields were not found.");
			
		} catch (Exception e) {
			System.out.println("FAILED - An error has occurred while trying to log in."); 
		}
	
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"error\"]"));
			if (errorMessage.isDisplayed()) {
				System.out.println("PASSED - Validated error message is displayed.");
				
				String strErrorMssg = errorMessage.getText();
				if (strErrorMssg.contains("Your username is invalid!")) {
					System.out.println("PASSED - Validated error message text is correct.");
				} else {
					System.out.println("FAILED - Error message text is incorrect.");
				}
			} else {
				System.out.println("FAILED - Error message is not displayed.");
			}
		} catch (Exception e) {
			System.out.println("FAILED - Unable to validate the error message.");
		}
		
		Thread.sleep(3000);
		
		System.out.println("---------------------------------------------------");
		System.out.println("---------- Scenario execution is finished ---------");
		System.out.println("---------------------------------------------------");
	}
	
	/*
	 * 
	 * 
	 */
	
	static void incorrectPass() throws InterruptedException, NoSuchElementException {
		System.out.println("---------------------------------------------------");
		System.out.println("----------- INCORRECT PASSWORD SCENARIO -----------");
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
			
			if (usernameTxtfield.isDisplayed()) {
				usernameTxtfield.sendKeys("student");
				passwordTxtfield.sendKeys("incorrectPassword");
				
				System.out.println("PASSED - Username and password is inputted.");

				submitBtn.click();
				System.out.println("PASSED - Submit button is clicked.");	
			} else
				System.out.println("FAILED - Username and password fields were not found.");
			
		} catch (Exception e) {
			System.out.println("FAILED - An error has occurred while trying to log in."); 
		}
		
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"error\"]"));
			if (errorMessage.isDisplayed()) {
				System.out.println("PASSED - Validated error message is displayed.");
				
				String strErrorMssg = errorMessage.getText();
				if (strErrorMssg.contains("Your password is invalid!")) {
					System.out.println("PASSED - Validated error message text is correct.");
				} else {
					System.out.println("FAILED - Error message text is incorrect.");
				}
			} else {
				System.out.println("FAILED - Error message is not displayed.");
			}
		} catch (Exception e) {
			System.out.println("FAILED - Unable to validate the error message.");
		}
		
		Thread.sleep(3000);

		System.out.println("---------------------------------------------------");
		System.out.println("---------- Scenario execution is finished ---------");
		System.out.println("---------------------------------------------------");
	}
	
}
