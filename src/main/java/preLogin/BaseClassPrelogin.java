package preLogin;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClassPrelogin {
	
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
	    
	    d.get("https://www.mobicip.com");
//	    d.get("https://webs.prgr.in");
	    	
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='company_logo']")));
	}
	
	
	@AfterSuite
	public void CloseBrowser()
	{
		d.quit();
	}

}