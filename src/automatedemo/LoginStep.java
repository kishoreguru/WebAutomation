package automatedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginStep {
		
		
		public static void main(String[] args) {
		
			LoginStep login = new LoginStep();
			login.loginTest();;
			}

		@Test
		public void loginTest() {
			ExtentReports extent;
			ExtentTest test;
			
			extent = new ExtentReports("C:\\Users\\Pirai\\workspace\\AutomateWebApp_Test\\test_reports\\\\loginTest.html",true);
			test = extent.startTest("Login Test");
			
			System.setProperty("webdriver.gecko.driver","D:\\firefoxDriver\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			WebDriver driver = new FirefoxDriver(capabilities);
			//To go to a web page
			test.log(LogStatus.INFO, "Browser is been opened");
			
			driver.manage().window().maximize();
			driver.navigate().to("http://automationpractice.com/index.php");
			//To maximize the window
			
			driver.findElement(By.className("login")).click();
			
			test.log(LogStatus.PASS, "Navigates into the Login page");
			
			driver.findElement(By.name("email")).sendKeys("aabbccxyz123@gmail.com");
			driver.findElement(By.name("passwd")).sendKeys("Password..");
			//To login
			test.log(LogStatus.PASS, "User's login credentials are entered");
			
			driver.findElement(By.id("SubmitLogin")).click();
			test.log(LogStatus.PASS, "Logged into the user account");
			
			extent.endTest(test);
			extent.flush();

		}
}