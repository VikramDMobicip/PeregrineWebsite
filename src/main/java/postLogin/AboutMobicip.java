package postLogin;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AboutMobicip extends baseClass{
	
	ExtentReports extentreport;
	ExtentSparkReporter spark ;
	
	@BeforeClass
    public void beforeTest() 
    {
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("D:\\TestReports\\TestAboutMobicip\\reportAboutMobicip.html");
		extentreport.attachReporter(spark);
    }
	
	public void ClickwithDelay(WebDriver driver,String element)
	{
		new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		d.findElement(By.xpath(element)).click();
	}
	
    //Checking for the title of home page and About mobicip page
	@Test(priority=1)
	public void a1_homepage()
	{
  		ExtentTest test=extentreport.createTest("About Mobicip page","Checking the title of the About Mobicip page ");
 
		//---Dash board---
		String tit=d.getTitle();
		if(tit.equals("Dashboard | Mobicip"))
		{test.pass("Dashboard - title is correct ");}
		else{test.fail("Dashboard - title isn't correct ");}
		boolean a=true;
		try {d.findElement(By.xpath("//p[text()='Hello Vikram!']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Dashboard - Header was Incorrect");}
		if(a==true){test.pass("Dashboard - Header was correct");}
			
		//---About Mobicip---
		ClickwithDelay(d,"//div[@class='user_profile_container']");
		ClickwithDelay(d,"//span[text()='About Mobicip']");
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='About Mobicip']")));
		
		//---Validation - About Mobicip ---
		//Title
		tit=d.getTitle();
		if(tit.equals("About Mobicip | Mobicip"))
		{test.pass("About Mobicip - page opened and title is correct ");}
		else{test.fail("About Mobicip - title isn't correct ");}
    }
	
	//Checking the header components 
  	@Test(priority=2)
	public void a2_AboutMobicipHeader() {
  		ExtentTest test2=extentreport.createTest("About Mobicip - Header","Checking the header components");
  		boolean a = true;
  		try{d.findElement(By.xpath("//a[@class='logo']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Mobicip logo is not found");}
		if(a==true) {test2.pass("Mobicip logo is present");}
		
		a=true;
		try{d.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Back button is not found");}
		if(a==true) {test2.pass("Back button is present");}
		
		a=true;
		try{d.findElement(By.xpath("//p[text()='About Mobicip']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("About Mobicip -  Header is incorrect");}
		if(a==true) {test2.pass("About Mobicip - Header is correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='user_profile_container']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Profile icon is not present");}
		if(a==true) {test2.pass("Profile icon is present");}
		
		a=true;
		try{d.findElement(By.xpath("//a[@class='help_icon']"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Help icon is not present");}
		if(a==true) {test2.pass("Help icon is present");}

		a=true;
		try{d.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));} 
		catch(NoSuchElementException e){a=false;
		test2.fail("Notification icon is not present");}
		if(a==true) {test2.pass("Notification icon is present");}
	}
  	
	//Checking the header components 
  	@Test(priority=3)
	public void a3_TermsandConditions() {
  		ExtentTest test3=extentreport.createTest("Terms and Conditions","Checking the Terms and Conditions components");
  		boolean a = true;
  		try{d.findElement(By.xpath("//p[text()='Terms and Conditions']")); 
  		d.findElement(By.xpath("//p[text()='Terms and Conditions']/following-sibling::span[@class='icon_right_arrow']"));}
		catch(NoSuchElementException e){a=false;
		test3.fail("Mobicip Terms and Conditions row is not found");}
		if(a==true) {test3.pass("Mobicip Terms and Conditions is present");}
		
		a = true;
		d.findElement(By.xpath("//p[text()='Terms and Conditions']")).click();
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Terms & Conditions']")));
		String tit = d.getTitle();
		if(tit.equals("Terms & Conditions | Mobicip"))
		{test3.pass("Terms & Conditions title is correct");}
		else{test3.fail("Terms & Conditions title isn't correct");}
		
		a = true;
		try{d.findElement(By.xpath("//a[@class='logo']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Mobicip logo is not found");}
		if(a==true) {test3.pass("Mobicip logo is present");}
		
		a=true;
		try{d.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Back button is not found");}
		if(a==true) {test3.pass("Back button is present");}
		
		a=true;
		try{d.findElement(By.xpath("//p[text()='Terms & Conditions']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Terms & Conditions  -  Header is incorrect");}
		if(a==true) {test3.pass("Terms & Conditions - Header is correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='user_profile_container']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Profile icon is not present");}
		if(a==true) {test3.pass("Profile icon is present");}
		
		a=true;
		try{d.findElement(By.xpath("//a[@class='help_icon']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Help icon is not present");}
		if(a==true) {test3.pass("Help icon is present");}
		
		a=true;
		try{d.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Notification icon is not present");}
		if(a==true) {test3.pass("Notification icon is present");}
		
		a=true;
		try{d.findElement(By.xpath("//span[text()='Mobicip Services']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Mobicip Services section  is not present");}
		if(a==true) {test3.pass("Mobicip section icon is present");}

		a=true;
		try{d.findElement(By.xpath("//span[text()='Disclaimer for Mobicip Service']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Disclaimer for Mobicip Service section  is not present");}
		if(a==true) {test3.pass("Disclaimer for Mobicip Service icon is present");}
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,600)"); 
		j.executeScript("window.scrollBy(0,300)"); 
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Payment']")));
	    a=true;
		try{d.findElement(By.xpath("//span[text()='Payment']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Payment section  is not present");}
		if(a==true) {test3.pass("Payment  icon is present");}

		j.executeScript("window.scrollBy(0,3000)"); 
		a=true;
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Patents']")));
		try{d.findElement(By.xpath("//span[text()='Patents']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Patents section  is not present");}
		if(a==true) {test3.pass("Patents icon is present");}
		d.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']")).click();
  	}
  	
	//Checking the header components 
  	@Test(priority=4)
	public void a4_TermsandConditions() {
  		ExtentTest test3=extentreport.createTest("Privacy Policy","Checking the Privacy Policy components");
  		boolean a = true;
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Privacy Policy']")));
  		try{d.findElement(By.xpath("//p[text()='Privacy Policy']")); 
  		d.findElement(By.xpath("//p[text()='Privacy Policy']/following-sibling::span[@class='icon_right_arrow']"));}
		catch(NoSuchElementException e){a=false;
		test3.fail("Mobicip Privacy Policy row is not found");}
		if(a==true) {test3.pass("Mobicip Privacy Policy is present");}
		
		a = true;
		d.findElement(By.xpath("//p[text()='Privacy Policy']")).click();
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Privacy Policy']")));
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		String tit = d.getTitle();
		if(tit.equals("Privacy Policy | Mobicip"))
		{test3.pass("Privacy Policy title is correct");}
		else{test3.fail("Privacy Policy title isn't correct");}
		
		a = true;
		try{d.findElement(By.xpath("//a[@class='logo']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Mobicip logo is not found");}
		if(a==true) {test3.pass("Mobicip logo is present");}
		
		a=true;
		try{d.findElement(By.xpath("//span[@class='header_back' and @id='headerBack']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Back button is not found");}
		if(a==true) {test3.pass("Back button is present");}
		
		a=true;
		try{d.findElement(By.xpath("//p[text()='Privacy Policy']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Privacy Policy  -  Header is incorrect");}
		if(a==true) {test3.pass("Privacy Policy - Header is correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='user_profile_container']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Profile icon is not present");}
		if(a==true) {test3.pass("Profile icon is present");}
		
		a=true;
		try{d.findElement(By.xpath("//a[@class='help_icon']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Help icon is not present");}
		if(a==true) {test3.pass("Help icon is present");}

		a=true;
		try{d.findElement(By.xpath("//a[starts-with(@class,'icon_notification ')]"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Notification icon is not present");}
		if(a==true) {test3.pass("Notification icon is present");}
		
		a=true;
		try{d.findElement(By.xpath("//span[text()='Parent Privacy']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Parent Privacy section  is not present");}
		if(a==true) {test3.pass("Parent Privacy icon is present");}
		

  		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,600)"); 
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Third-Party Information Sharing']")));

		a=true;
		try{d.findElement(By.xpath("//span[text()='Third-Party Information Sharing']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Third-Party Information Sharing section  is not present");}
		if(a==true) {test3.pass("Third-Party Information Sharing icon is present");}
		
		j.executeScript("window.scrollBy(0,500)"); 
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Child Privacy']")));
	    a=true;
		try{d.findElement(By.xpath("//span[text()='Child Privacy']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Child Privacy section  is not present");}
		if(a==true) {test3.pass("Child Privacy  icon is present");}
		
		j.executeScript("window.scrollBy(0,3000)"); 
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Data Collection and Reporting']")));
		a=true;
		try{d.findElement(By.xpath("//span[text()='Data Collection and Reporting']"));} 
		catch(NoSuchElementException e){a=false;
		test3.fail("Data Collection And Reporting section  is not present");}
		if(a==true) {test3.pass("Data Collection And Reporting icon is present");}

		// redirect to dashboard
		d.findElement(By.xpath("//a[@class='logo']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Hello Vikram!']")));
  	}
  	
  	@AfterClass
    public void teardown() 
    {
//  		d.quit();
    	extentreport.flush();
    }
}