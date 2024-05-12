package assessmentPCCW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestExecution {
	
	public static final String URL = "https://practicetestautomation.com/practice-test-login/";
	public static final WebDriver driver = new ChromeDriver();
	
	public static void appConn () {
		driver.get(URL);
		driver.manage().window().maximize();
		System.out.println("Application has opened.");
	}
	
	public static void closeConn () throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Application has closed.\n");
	}
	
	public static void main(String[] args) throws Exception{
		HappyPath.main();
		Negative.incorrectUser();
		Negative.incorrectPass();
		
		closeConn();
	}
}
