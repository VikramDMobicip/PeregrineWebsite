package preLogin;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class RequestQuote extends BaseClassPrelogin {
	//Report setup
	ExtentReports extentreport;
	ExtentSparkReporter spark ;
		
	@BeforeClass
	public void beforeTest() 
	{
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("D:\\TestReports\\PreLoginTest\\RequestQuoteTest\\requestQuoteReport.html");
		extentreport.attachReporter(spark);
	}
	
	
	@Test
	public void a1_RequestQuote() throws InterruptedException
	  {
		ExtentTest test=extentreport.createTest("Request Quote","To check the Request quote web page title,header,sec titles");
		  	
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

		WebElement l=d.findElement(By.xpath("//ul[@class='footer_ul']//a[text()='School']"));
	      // Javascript executor
	    ((JavascriptExecutor)d).executeScript("arguments[0].scrollIntoView(true);", l);
		TimeUnit.SECONDS.sleep(2);
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='footer_ul']//a[text()='School']")));
		d.findElement(By.xpath("//ul[@class='footer_ul']//a[text()='School']")).click();
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Request Quote']")));
		d.findElement(By.xpath("//a[text()='Request Quote']")).click();
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Request Quote']")));

		// page title
		String tit=d.getTitle();
		System.out.println(tit);
		tit = d.getTitle();
		if(tit.equals("Request Quote | Mobicip"))
		{test.pass("Page title is correct");}
		else{test.fail("Page title isn't correct");}
			
		//Header Elements
		boolean a=true;
		try {d.findElement(By.xpath("//a[@class='company_logo']"));
		d.findElement(By.xpath("//*[text()='Features']"));
		d.findElement(By.xpath("//*[text()='Pricing']"));
		d.findElement(By.xpath("//*[text()='Support']"));
		d.findElement(By.xpath("//*[text()='Testimonials']"));
		d.findElement(By.xpath("//*[text()='Login']"));
		d.findElement(By.xpath("//*[text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
		test.fail("Pre login - Header is incorrect");}
		if(a==true){test.pass("Pre login - Header is correct");}	
			
		// section title
		a=true;
		try{d.findElement(By.xpath("//*[text()='Request Quote']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("RQ Section - Title is not correct");}
		if(a==true){test.pass("RQ Section - Title is correct");}
			
		// section subtitle
		a=true;
		try{d.findElement(By.xpath("//*[text()='More than 20 devices']"));}
		catch(NoSuchElementException e) {a=false;
		test.fail("RQ Section - subtitle is not correct");}
		if(a==true){test.pass("RQ Section - subtitle is correct");}
		}
		
	@Test
	public void a2_InputFields()
	  {
	  	ExtentTest test1=extentreport.createTest("Input fields","To check the fields");
	  	boolean a=true;
	  		
	  	try{d.findElement(By.xpath("//input[@name='request_quote_name']"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Name field is not present");}
		if(a==true){test1.pass("Name field is present");}
		d.findElement(By.xpath("//input[@name='request_quote_name']")).click();
		
		try{d.findElement(By.xpath("//input[@name='request_quote_email']"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Email field is not present");}
		if(a==true){test1.pass("Email field is present");}
		d.findElement(By.xpath("//input[@name='request_quote_email']")).click();
		
		try{d.findElement(By.xpath("//input[@name='request_quote_organization']"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Organization field is not present");}
		if(a==true){test1.pass("Organization field is present");}
		d.findElement(By.xpath("//input[@name='request_quote_organization']")).click();
		
		try{d.findElement(By.xpath("//input[@name='request_quote_zip']"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("zip code field is not present");}
		if(a==true){test1.pass("zip code field is present");}
		d.findElement(By.xpath("//input[@name='request_quote_zip']")).click();
			
		try{d.findElement(By.xpath("//input[@name='request_quote_device_count']"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("device count field is not present");}
		if(a==true){test1.pass("device count field is present");}
		d.findElement(By.xpath("//input[@name='request_quote_device_count']")).click();
		
		try{d.findElement(By.xpath("//select[@name='request_quote_duration']"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("duration field is not present");}
		if(a==true){test1.pass("duration field is present");}
		
		try {d.findElement(By.xpath("//input[@name='request_quote_device_count']"));
		Select date =new Select(d.findElement(By.xpath("//input[@name='request_quote_device_count']//following::select")));
		date.selectByValue("2 Years");}
		catch(NoSuchElementException e){a=false;
		test1.fail("Duration selection is improper");}
		if(a==true){test1.pass("Duration selection is proper");}
		
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
			
		try {d.findElement(By.xpath("//span[text()='iOS']"));
		    d.findElement(By.xpath("//span[text()='Android']"));
		    d.findElement(By.xpath("//span[text()='Kindle Fire']"));
		    d.findElement(By.xpath("//span[text()='Windows']"));
		    d.findElement(By.xpath("//span[text()='Mac']"));
		    d.findElement(By.xpath("//span[text()='Chromebook']"));}
		catch(NoSuchElementException e){a=false;
		test1.fail("Platform inputs are not present");}
		if(a==true){test1.pass("Platform inputs are present");}
		
		try {d.findElement(By.xpath("//label[@for='ios']")).click();
		    d.findElement(By.xpath("//label[@for='android']")).click();
		    d.findElement(By.xpath("//label[@for='kindle']")).click();
		    d.findElement(By.xpath("//label[@for='windows']")).click();
		    d.findElement(By.xpath("//label[@for='mac']")).click();
		    d.findElement(By.xpath("//label[@for='chromebook']")).click();}
		catch(NoSuchElementException e){a=false;
		test1.fail("Platform inputs are improper");}
		if(a==true){test1.pass("Platform inputs are proper");}
			
		try{d.findElement(By.xpath("//textarea[@name='request_quote_message']"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("message field is not present");}
		if(a==true){test1.pass("message field is present");}
			
		try{d.findElement(By.xpath("//span[text()='1000']"));
		d.findElement(By.xpath("//*[@id=\"request_quote_form\"]/div[1]/div[8]/div/p"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("characters left text not present");}
		if(a==true){test1.pass("characters left text present");}
		d.navigate().refresh();	
	  }	

	@Test
	public void a3_RequiredFieldValidation() throws InterruptedException 
	  {
		ExtentTest test2=extentreport.createTest("Required Field Validation","To check Required field inputs");
	  	boolean a=true;
	  	
	  	JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,600)");
		
	  	TimeUnit.SECONDS.sleep(3);
		d.findElement(By.xpath("//button[text()='Submit']")).click();
		
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,-1000)");
		TimeUnit.SECONDS.sleep(2);
		
		try{d.findElement(By.xpath("//input[@name='request_quote_name']/following::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("Name Required Field - Failed");}
		if(a==true){test2.pass("Name Required Field - Displayed");}
		
		try{d.findElement(By.xpath("//input[@name='request_quote_email']/following::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("Email Required Field - Failed");}
		if(a==true){test2.pass("Email Required Field - Displayed");}
		
		try{d.findElement(By.xpath("//input[@name='request_quote_organization']/following::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("Organization Required Field - Failed");}
		if(a==true){test2.pass("Organization Required Field - Displayed");}
		
		try{d.findElement(By.xpath("//input[@name='request_quote_device_count']/following::span[text()='20+ Devices are required']"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("Device count Required Field - Failed");}
		if(a==true){test2.pass("Device count Required Field - Displayed");}
		
		try{d.findElement(By.xpath("//label[@for='chromebook']/following::span[text()='At least 1 required']"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("Platform Required Field - Failed");}
		if(a==true){test2.pass("Platform Required Field - Displayed");}
		
		try{d.findElement(By.xpath("//textarea[@name='request_quote_message']/following::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("Message Required Field - Failed");}
		if(a==true){test2.pass("Message Required Field - Displayed");}
		
		d.navigate().refresh();
	  }
	
	@Test
	public void a4_IndividualFieldValidation() throws InterruptedException
	  {
	  	ExtentTest test3=extentreport.createTest("Individual field validation","To check the specific fields validation");
	  	boolean a=true;
	  	
	  	d.findElement(By.xpath("//input[@name='request_quote_name']")).sendKeys("@");
	  	
	  	JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,700)");
		TimeUnit.SECONDS.sleep(2);
		
	  	d.findElement(By.xpath("//button[text()='Submit']")).click();
		
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,-1000)");
		TimeUnit.SECONDS.sleep(2);
		
		try{d.findElement(By.xpath("//input[@name='request_quote_name']/following::span[text()='Alphanumeric characters and -_(), only accepted']"));}
		catch(NoSuchElementException e) {a=false;
		test3.fail("Name field spl char - Failed");}
		if(a==true){test3.pass("Name - spl char validation - pass");}
		d.navigate().refresh();
		
		d.findElement(By.xpath("//input[@name='request_quote_name']")).sendKeys("suvetha123");
		
		JavascriptExecutor j2 = (JavascriptExecutor)d;
		j2.executeScript("window.scrollBy(0,700)");
		TimeUnit.SECONDS.sleep(2);
		
	  	d.findElement(By.xpath("//button[text()='Submit']")).click();
	  	
	  	JavascriptExecutor j3 = (JavascriptExecutor)d;
		j3.executeScript("window.scrollBy(0,-1000)");
		TimeUnit.SECONDS.sleep(2);
		
		try{d.findElement(By.xpath("//input[@name='request_quote_name']/following::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test3.fail("Name - text,letters validation - failed");}
		if(a==true){test3.pass("Name - text,letters validation - pass");}
		d.navigate().refresh();
		
		d.findElement(By.xpath("//input[@name='request_quote_name']")).sendKeys("suvetha(devices_22-1)");
		
		JavascriptExecutor j4 = (JavascriptExecutor)d;
		j4.executeScript("window.scrollBy(0,700)");
		TimeUnit.SECONDS.sleep(2);
		
	  	d.findElement(By.xpath("//button[text()='Submit']")).click();
	  	
		JavascriptExecutor j5 = (JavascriptExecutor)d;
		j5.executeScript("window.scrollBy(0,-1000)");
		TimeUnit.SECONDS.sleep(2);
		
		try{d.findElement(By.xpath("//input[@name='request_quote_name']/following::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test3.fail("Name field - Name with spl char (),-,_ - Failed");}
		if(a==true){test3.pass("Name - text,letters,spl char (),-,_ validation - pass");}
		d.navigate().refresh();
		
		d.findElement(By.xpath("//input[@name='request_quote_email']")).sendKeys("suve");

		JavascriptExecutor j6 = (JavascriptExecutor)d;
		j6.executeScript("window.scrollBy(0,700)");
		TimeUnit.SECONDS.sleep(2);

	  	d.findElement(By.xpath("//button[text()='Submit']")).click();

		JavascriptExecutor j7 = (JavascriptExecutor)d;
		j7.executeScript("window.scrollBy(0,-1000)");
		TimeUnit.SECONDS.sleep(2);
		
		try{d.findElement(By.xpath("//input[@name='request_quote_email']/following::span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e) {a=false;
		test3.fail("Email field - Only spl char - Failed");}
		if(a==true){test3.pass("Email - spl char validation - pass");}
		d.navigate().refresh();
		
		d.findElement(By.xpath("//input[@name='request_quote_email']")).sendKeys("suvetha+22@mobicip.com");

		JavascriptExecutor j8 = (JavascriptExecutor)d;
		j8.executeScript("window.scrollBy(0,700)");
		TimeUnit.SECONDS.sleep(2);

	  	d.findElement(By.xpath("//button[text()='Submit']")).click();

		JavascriptExecutor j9 = (JavascriptExecutor)d;
		j9.executeScript("window.scrollBy(0,-1000)");
		TimeUnit.SECONDS.sleep(2);
		
		try{d.findElement(By.xpath("//input[@name='request_quote_email']/following::span[text()='Required Field']"));}
		catch(NoSuchElementException e) {a=false;
		test3.fail("Email field - text,letters with spl char - Failed");}
		if(a==true){test3.pass("Email - text,letters,spl char validation - pass");}
		d.navigate().refresh();
		
		d.findElement(By.xpath("//input[@name='request_quote_email']")).sendKeys("suvetha+22@mobicip.");

		JavascriptExecutor j10 = (JavascriptExecutor)d;
		j10.executeScript("window.scrollBy(0,700)");
		TimeUnit.SECONDS.sleep(2);

	  	d.findElement(By.xpath("//button[text()='Submit']")).click();

		JavascriptExecutor j11 = (JavascriptExecutor)d;
		j11.executeScript("window.scrollBy(0,-1000)");
		TimeUnit.SECONDS.sleep(2);		
		
		try{d.findElement(By.xpath("//input[@name='request_quote_email']/following::span[text()='Invalid Email: Enter a valid email address']"));}
		catch(NoSuchElementException e) {a=false;
		test3.fail("Email field - Invalid syntax validation - Failed");}
		if(a==true){test3.pass("Email -  Invalid syntax validation - pass");}
		d.navigate().refresh();
		
		d.findElement(By.xpath("//input[@name='request_quote_organization']")).sendKeys("@");

		JavascriptExecutor j12 = (JavascriptExecutor)d;
		j12.executeScript("window.scrollBy(0,700)");
		TimeUnit.SECONDS.sleep(2);

	  	d.findElement(By.xpath("//button[text()='Submit']")).click();

		JavascriptExecutor j13 = (JavascriptExecutor)d;
		j13.executeScript("window.scrollBy(0,-1000)");
		TimeUnit.SECONDS.sleep(2);
		
		try{d.findElement(By.xpath("//input[@name='request_quote_organization']/following::span[text()='Alphanumeric characters and -_(), only accepted']"));}
		catch(NoSuchElementException e) {a=false;
		test3.fail("Organization field spl char - Failed");}
		if(a==true){test3.pass("Organization - spl char validation - pass");}
		d.navigate().refresh();
		
		d.findElement(By.xpath("//input[@name='request_quote_organization']")).sendKeys("ABC123");

		JavascriptExecutor j14 = (JavascriptExecutor)d;
		j14.executeScript("window.scrollBy(0,700)");
		TimeUnit.SECONDS.sleep(2);

	  	d.findElement(By.xpath("//button[text()='Submit']")).click();

		JavascriptExecutor j15 = (JavascriptExecutor)d;
		j15.executeScript("window.scrollBy(0,-1000)");
		TimeUnit.SECONDS.sleep(2);
		
		try{d.findElement(By.xpath("//input[@name='request_quote_organization']/following::span[text()='20+ Devices are required']"));}
		catch(NoSuchElementException e) {a=false;
		test3.fail("Organization - text,letters validation - failed");}
		if(a==true){test3.pass("Organization - text,letters validation - pass");}
		d.navigate().refresh();
		
		d.findElement(By.xpath("//input[@name='request_quote_organization']")).sendKeys("(ABC_22-1)Organization");
		
		JavascriptExecutor j16 = (JavascriptExecutor)d;
		j16.executeScript("window.scrollBy(0,700)");
		TimeUnit.SECONDS.sleep(2);

	  	d.findElement(By.xpath("//button[text()='Submit']")).click();

		JavascriptExecutor j17 = (JavascriptExecutor)d;
		j17.executeScript("window.scrollBy(0,-1000)");
		TimeUnit.SECONDS.sleep(2);

		try{d.findElement(By.xpath("//input[@name='request_quote_organization']/following::span[text()='20+ Devices are required']"));}
		catch(NoSuchElementException e) {a=false;
		test3.fail("Name field - Organization with letters,spl char (),-,_ - Failed");}
		if(a==true){test3.pass("Organization - text,letters,spl char (),-,_ validation - pass");}
		d.navigate().refresh();
		
		d.findElement(By.xpath("//input[@name='request_quote_zip']")).sendKeys("@");

		JavascriptExecutor j18 = (JavascriptExecutor)d;
		j18.executeScript("window.scrollBy(0,700)");
		TimeUnit.SECONDS.sleep(2);

	  	d.findElement(By.xpath("//button[text()='Submit']")).click();

		JavascriptExecutor j19 = (JavascriptExecutor)d;
		j19.executeScript("window.scrollBy(0,-1000)");
		TimeUnit.SECONDS.sleep(2);

		try{d.findElement(By.xpath("//input[@name='request_quote_zip']/following::span[text()='Alphanumeric characters and -_(), only accepted']"));}
		catch(NoSuchElementException e) {a=false;
		test3.fail("zip code field spl char - Failed");}
		if(a==true){test3.pass("zip code field spl char validation - pass");}
		d.navigate().refresh();
		
		d.findElement(By.xpath("//input[@name='request_quote_device_count']")).sendKeys("19");

		JavascriptExecutor j20 = (JavascriptExecutor)d;
		j20.executeScript("window.scrollBy(0,700)");
		TimeUnit.SECONDS.sleep(2);

	  	d.findElement(By.xpath("//button[text()='Submit']")).click();

		JavascriptExecutor j21 = (JavascriptExecutor)d;
		j21.executeScript("window.scrollBy(0,-1000)");
		TimeUnit.SECONDS.sleep(2);

		try{d.findElement(By.xpath("//input[@name='request_quote_device_count']/following::span[text()='20+ Devices are required']"));}
		catch(NoSuchElementException e) {a=false;
		test3.fail("Device count - less than 20 count - Failed");}
		if(a==true){test3.pass("Device count - less than 20 count validation - pass");}
		d.navigate().refresh();
		
		TimeUnit.SECONDS.sleep(5);
	  }
	
	@Test
	public void a5_ValidDataValidation() throws InterruptedException
	  {
	  	ExtentTest test4=extentreport.createTest("Valid Data Validation","To check the Valid data");
	  	boolean a=true;
	  	
	  	d.findElement(By.xpath("//input[@name='request_quote_name']")).sendKeys("suvetha");
	  	try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	  	d.findElement(By.xpath("//input[@name='request_quote_email']")).sendKeys("suvetha+55@mobicip.com");
	  	try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	  	d.findElement(By.xpath("//input[@name='request_quote_organization']")).sendKeys("ABC");
	  	try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	  	
	  	JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,200)");
		
	  	d.findElement(By.xpath("//input[@name='request_quote_zip']")).sendKeys("654321");
	  	try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	  	d.findElement(By.xpath("//input[@name='request_quote_device_count']")).sendKeys("22");
	  	try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	  	d.findElement(By.xpath("//input[@name='request_quote_device_count']"));
	  	
		Select date =new Select(d.findElement(By.xpath("//input[@name='request_quote_device_count']//following::select")));
		date.selectByValue("3 Years");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//label[@for='ios']")).click();
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
		
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(2);
		
	  	d.findElement(By.xpath("//textarea[@name='request_quote_message']")).sendKeys("QA testing - Pls ignore and close tickets!!!");
	  	try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	  	
	  	j.executeScript("window.scrollBy(0,200)");
	  	
	  	d.findElement(By.xpath("//button[text()='Submit']")).click();
	  	
	  	new WebDriverWait(d,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='backend_message error']")));
		
		try{d.findElement(By.xpath("//*[text()='Complete the form and resubmit']"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("Your request failed");}
		if(a==true){test4.pass("Your request has been sent.");}
		
	  }

	@Test
	public void a6_section2() throws InterruptedException
	  {
		ExtentTest test5=extentreport.createTest("section 2,3","To check the Prelogin RequestQuote web page section 2,3");
		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,700)");
		TimeUnit.SECONDS.sleep(2);
		
		boolean a=true;
	    try {d.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
        d.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
        d.findElement(By.xpath("//a[@class='primary_button sign_up']"));}
        catch(NoSuchElementException e){a=false;
        test5.fail("RequestQuote page - Build better is not present");}
        if(a==true){test5.pass("RequestQuote page - Build better is present");}
        
        JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);
		
		a=true;
		try {d.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
	    catch(NoSuchElementException e){a=false;
	    test5.fail("RequestQuote page - Footer is not present");}
	    if(a==true){test5.pass("RequestQuote page - Footer is present");}
	    try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();} 
	    d.findElement(By.xpath("//a[@class='company_logo']")).click();
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));

	  } 
	
	@AfterClass
	public void teardown()
	  {
	    extentreport.flush(); 	
	   }	
}	
