package postLogin;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class baseClass {

	public static WebDriver d;
	
	@BeforeSuite
	public void OpenBrowser()
	{
	    System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver-win64_122\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		d=new ChromeDriver(options);
		
	    try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	    
	    d.manage().window().maximize();
	    
//	    d.get("https://www.mobicip.com/login");
	    d.get("https://webs.prgr.in/login");
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));

		//---Login---
		d.findElement(By.xpath("//input[@name='login_email']")).sendKeys("vikram+1@mobicip.com");
		d.findElement(By.xpath("//input[@name='login_password']")).sendKeys("12345");
		d.findElement(By.xpath("//button[@type='submit']")).click();
		new WebDriverWait(d,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));
	}
	
	@AfterSuite
	public void CloseBrowser()
	{
		d.quit();
	}
}
