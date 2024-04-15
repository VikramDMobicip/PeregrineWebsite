package preLogin;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SupportPage extends BaseClassPrelogin{

    //Report setup
	ExtentReports extentreport;
	ExtentSparkReporter spark ;
		
	@BeforeClass
	public void beforeTest() 
	{
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("D:\\TestReports\\PreLoginTest\\SupportTest\\supportReport.html");
		extentreport.attachReporter(spark);
	}
	
	
	@Test
	public void a1_SupportPage()
	  {
		ExtentTest test=extentreport.createTest("Support Page","To check the Support web page title,header");
		  	
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Support' and @class='header_nav_anchor']")));
		d.findElement(By.xpath("//a[text()='Support' and @class='header_nav_anchor']")).click();
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='support_search_container']")));
		
			
		// page title
		String tit=d.getTitle();
		System.out.println(tit);
		tit = d.getTitle();
		if(tit.equals("Customer Support - Articles, Tutorials & FAQs | Mobicip"))
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
		}

	@Test
	public void a2_Section1() throws InterruptedException 
	{
		ExtentTest test1=extentreport.createTest("section 1","To check the Prelogin Support web page section 1");
		
		String p = d.findElement(By.xpath("//p[@class='older_version_text']")).getText();
		if(p.equals("If you are using the older version of Mobicip, please click here to view related articles, FAQs, and installation guides"))
		{test1.pass("Section 1 - Info text is correct");}
		else{test1.fail("Section 1 - Info text is not correct");}
	    
		boolean a=true;
		try{d.findElement(By.xpath("//p[@class='older_version_text']/a"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("'Click here' link is not present");}
	    if(a==true){test1.pass("'Click here' link is present");}
	    
	    String p1 = d.findElement(By.xpath("//div[@class='support_search_wrapper']/h1")).getText();
		if(p1.equals("How Can We Help You?"))
		{test1.pass("Title text is correct");}
		else{test1.fail("Title text is not correct");}
	    
		a=true;
		try{d.findElement(By.xpath("//div[@class='support_search_wrapper']/div[1]/input"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Search bar is not present");}
	    if(a==true){test1.pass("Search bar is present");}
	    
	    d.findElement(By.xpath("//input[@name='search_query']")).sendKeys("mac");
	    TimeUnit.SECONDS.sleep(10);
	    
	    a=true;
		try{d.findElement(By.xpath("//p[@class='articles_count']"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Search result - Count is not present");}
	    if(a==true){test1.pass("Search result - Count is present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//div[@class='search_dropdown_container']/ul"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Search result - articles list is not present");}
	    if(a==true){test1.pass("Search result - articles list is present");}
	    d.navigate().refresh();
	    
	    d.findElement(By.xpath("//input[@name='search_query']")).sendKeys("signup");
	    TimeUnit.SECONDS.sleep(10);
	    
	    String p22 = d.findElement(By.xpath("//div[@class='no_articles']")).getText();
		if(p22.equals("No Relevant Article Found"))
		{test1.pass("'No Relevant Article Found'text is correct");}
		else{test1.fail("'No Relevant Article Found'text is not correct");}
		d.navigate().refresh();
		
		d.findElement(By.xpath("//input[@name='search_query']")).sendKeys("is");
		TimeUnit.SECONDS.sleep(5);
		a=true;
		try{d.findElement(By.xpath("//div[@class='search_dropdown_wrapper']"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Minimum char check failed");}
	    if(a==true){test1.pass("Minimum char check pass");}
		d.navigate().refresh();
		
	    String p2 = d.findElement(By.xpath("//div[@class='resources_wrapper']/h2")).getText();
		if(p2.equals("Knowledge Base"))
		{test1.pass("Title text is correct");}
		else{test1.fail("Title text is not correct");}
		
		a=true;
		try{d.findElement(By.xpath("//ul[@class='resources_ul']"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Resources section is not present");}
	    if(a==true){test1.pass("Resources section is present");}
		
	    JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,200)");
	    
	    a=true;
		try{d.findElement(By.xpath("//ul[@class='resources_ul']/li[1]"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("1.'Getting Started' is not present");}
	    if(a==true){test1.pass("1.'Getting Started' is present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//ul[@class='resources_ul']/li[1]/a/span"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Title is not present");}
	    if(a==true){test1.pass("Title is present");}
	    
		a=true;
		try{d.findElement(By.xpath("//ul[@class='resources_ul']/li[2]"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("2.'Features Guide' is not present");}
	    if(a==true){test1.pass("2.'Features Guide' is present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//ul[@class='resources_ul']/li[2]/a/span"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Title is not present");}
	    if(a==true){test1.pass("Title is present");}
	     
		a=true;
		try{d.findElement(By.xpath("//ul[@class='resources_ul']/li[3]"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("3.'Account Management' is not present");}
	    if(a==true){test1.pass("3.'Account Management' is present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//ul[@class='resources_ul']/li[3]/a/span"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Title is not present");}
	    if(a==true){test1.pass("Title is present");}
	    
		a=true;
		try{d.findElement(By.xpath("//ul[@class='resources_ul']/li[4]"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("4.'Troubleshooting & FAQs' is not present");}
	    if(a==true){test1.pass("4.'Troubleshooting & FAQs' is present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//ul[@class='resources_ul']/li[4]/a/span"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Title is not present");}
	    if(a==true){test1.pass("Title is present");}
		
		a=true;
		try{d.findElement(By.xpath("//ul[@class='resources_ul']/li[5]"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("5.'Schools & Enterprises' is not present");}
	    if(a==true){test1.pass("5.'Schools & Enterprises' is present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//ul[@class='resources_ul']/li[5]/a/span"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("Title is not present");}
	    if(a==true){test1.pass("Title is present");}
	   
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(2);
		
		String p3 = d.findElement(By.xpath("//div[@class='still_question_wrapper']/h2")).getText();
		if(p3.equals("Still Have Questions?"))
		{test1.pass("Title text is correct");}
		else{test1.fail("Title text is not correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='switch_connect_container']/div[1]"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("'Drop us a line' is not present");}
	    if(a==true){test1.pass("'Drop us a line' is present");}
	    
	    String p4 = d.findElement(By.xpath("//div[@class='switch_connect_container']/div[1]/span")).getText();
		if(p4.equals("Drop us a line"))
		{test1.pass("Title is correct");}
		else{test1.fail("Title is not correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='switch_connect_container']/div[2]"));}
		catch(NoSuchElementException e) {a=false;
		test1.fail("'Let's talk' is not present");}
	    if(a==true){test1.pass("'Let's talk' is present");}
	    
	    String p5 = d.findElement(By.xpath("//div[@class='switch_connect_container']/div[2]/span")).getText();
		if(p5.equals("Let's talk"))
		{test1.pass("Title is correct");}
		else{test1.fail("Title is not correct");}
	}

	@Test
	public void a3_Section2() throws InterruptedException 
	{
		ExtentTest test2=extentreport.createTest("section 2","To check the Prelogin Support web page section 2");
		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,400)");
		TimeUnit.SECONDS.sleep(2);
		
		String p = d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[2]/div/div/h2")).getText();
		if(p.equals("Child Device Setup Videos"))
		{test2.pass("Section 2 - Title is correct");}
		else{test2.fail("Section 2 - Title is not correct");}
		
		boolean a=true;
		try{d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[1]"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("1.iPhone/iPad is not present");}
	    if(a==true){test2.pass("1.iPhone/iPad is present");}
		
		String p1 = d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[1]/span")).getText();
		if(p1.equals("iPhone/iPad"))
		{test2.pass("Title is correct");}
		else{test2.fail("Title is not correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='child_setup_video_wrapper']/div/iframe"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("Video is not present");}
	    if(a==true){test2.pass("Video is present");}
	    
	    d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[2]")).click();
	    TimeUnit.SECONDS.sleep(1);
	    
	    a=true;
		try{d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[2]"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("2.Android is not present");}
	    if(a==true){test2.pass("2.Android is present");}
		
		String p2 = d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[2]/span")).getText();
		if(p2.equals("Android"))
		{test2.pass("Title is correct");}
		else{test2.fail("Title is not correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='child_setup_video_wrapper']/div/iframe"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("Video is not present");}
	    if(a==true){test2.pass("Video is present");}
	    
	    d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[3]")).click();
	    TimeUnit.SECONDS.sleep(1);
	    
	    a=true;
		try{d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[3]"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("3.Kindle Fire is not present");}
	    if(a==true){test2.pass("3.Kindle Fire is present");}
		
		String p3 = d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[3]/span")).getText();
		if(p3.equals("Kindle Fire"))
		{test2.pass("Title is correct");}
		else{test2.fail("Title is not correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='child_setup_video_wrapper']/div/iframe"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("Video is not present");}
	    if(a==true){test2.pass("Video is present");}
	    
	    JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,100)");
		TimeUnit.SECONDS.sleep(2);
		
		d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[4]")).click();
		TimeUnit.SECONDS.sleep(1);
		
	    a=true;
		try{d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[4]"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("4.Chromebook is not present");}
	    if(a==true){test2.pass("4.Chromebook is present");}
		
		String p4 = d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[4]/span")).getText();
		if(p4.equals("Chromebook"))
		{test2.pass("Title is correct");}
		else{test2.fail("Title is not correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='child_setup_video_wrapper']/div/iframe"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("Video is not present");}
	    if(a==true){test2.pass("Video is present");}
	    
	    d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[5]")).click();
		TimeUnit.SECONDS.sleep(1);
		
	    a=true;
		try{d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[5]"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("5.Windows is not present");}
	    if(a==true){test2.pass("5.Windows is present");}
		
		String p5 = d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[5]/span")).getText();
		if(p5.equals("Windows"))
		{test2.pass("Title is correct");}
		else{test2.fail("Title is not correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='child_setup_video_wrapper']/div/iframe"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("Video is not present");}
	    if(a==true){test2.pass("Video is present");}
		
	    d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[6]")).click();
		TimeUnit.SECONDS.sleep(1);
	    
	    a=true;
		try{d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[6]"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("6.macOS is not present");}
	    if(a==true){test2.pass("6.macOS is present");}
		
		String p6 = d.findElement(By.xpath("//div[@class='child_setup_videos_container']/ul/li[6]/span")).getText();
		if(p6.equals("macOS"))
		{test2.pass("Title is correct");}
		else{test2.fail("Title is not correct");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='child_setup_video_wrapper']/div/iframe"));}
		catch(NoSuchElementException e) {a=false;
		test2.fail("Video is not present");}
	    if(a==true){test2.pass("Video is present");}
		
	}

	@Test
	public void a4_Section3() throws InterruptedException 
	{
		ExtentTest test3=extentreport.createTest("section 3","To check the Prelogin Support web page section 3");
		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(2);
		
		String p = d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[3]/div/div/h2")).getText();
		if(p.equals("Announcements & Updates"))
		{test3.pass("Section 3 - Title is correct");}
		else{test3.fail("Section 3 - Title is not correct");}
		
		String p1 = d.findElement(By.xpath("//ul[@class='announcement_container swiper_wrapper']/li[1]/p")).getText();
		if(p1.equals("We at Mobicip believe that steady and constant product improvements are essential for customer satisfaction. We monitor all reported issues/feedback from customers and release product updates with bug fixes and feature improvements.Recently, we rolled out updates for our Mac (583) and Windows (526) software. Please make sure you update Mobicip to the latest version on your devices for optimal performance."))
		{test3.pass("Description is correct");}
		else{test3.fail("Description is not correct");}
		
		JavascriptExecutor j1 = (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,580)");
		TimeUnit.SECONDS.sleep(2);	
	}
	
	@Test
	public void a5_Section4() throws InterruptedException 
	{
		ExtentTest test4=extentreport.createTest("section 4","To check the Prelogin Support web page section 4");
			
		String p = d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]/div/div/h2")).getText();
		if(p.equals("Recent Blog Articles"))
		{test4.pass("Section 4 - Title is correct");}
		else{test4.fail("Section 4 - Title is not correct");}
		
		boolean a=true;
		try{d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]//article[1]//div[1]/img"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("'Blog 1' image is not present");}
	    if(a==true){test4.pass("'Blog 1' image is present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]//article[1]/a/div[2]/h5"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("Title is not Present");}
	    if(a==true){test4.pass("Title is Present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]//article[1]/a/div[2]/div"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("Description is not Present");}
	    if(a==true){test4.pass("Description is Present");}
		
	    a=true;
		try{d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]//article[1]/a/div/span"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("Date is not Present");}
	    if(a==true){test4.pass("Date is Present");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]//article[2]//div[1]/img"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("'Blog 2' image is not present");}
	    if(a==true){test4.pass("'Blog 2' image is present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]//article[2]/a/div[2]/h5"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("Title is not Present");}
	    if(a==true){test4.pass("Title is Present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]//article[2]/a/div[2]/div"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("Description is not Present");}
	    if(a==true){test4.pass("Description is Present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]//article[2]/a/div/span"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("Date is not Present");}
	    if(a==true){test4.pass("Date is Present");}
		
		a=true;
		try{d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]//article[3]//div[1]/img"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("'Blog 3' image is not present");}
	    if(a==true){test4.pass("'Blog 3' image is present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]//article[3]/a/div[2]/h5"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("Title is not Present");}
	    if(a==true){test4.pass("Title is Present");}
	    
	    a=true;
		try{d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]//article[3]/a/div[2]/div"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("Description is not Present");}
	    if(a==true){test4.pass("Description is Present");}
		
	    a=true;
		try{d.findElement(By.xpath("//div[@class='main_wrapper']/div/section[4]//article[3]/a/div/span"));}
		catch(NoSuchElementException e) {a=false;
		test4.fail("Date is not Present");}
	    if(a==true){test4.pass("Date is Present");}
	}

	@Test
	public void a6_Section5() throws InterruptedException 
	{
		ExtentTest test5=extentreport.createTest("section 5","To check the Prelogin Support web page section 5");
		
		JavascriptExecutor j = (JavascriptExecutor)d;
		j.executeScript("window.scrollBy(0,500)");
		TimeUnit.SECONDS.sleep(3);
		
		boolean a=true;
		try {d.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
	    catch(NoSuchElementException e){a=false;
	    test5.fail("Support page - Footer is not present");}
	    if(a==true){test5.pass("Support page - Footer is present");}
	    try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();} 
	    
	    d.findElement(By.xpath("//a[@class='company_logo']")).click();
		new WebDriverWait(d,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main_container home_index_component']")));
	}
	
	@AfterTest
	public void teardown()
	  {
	    extentreport.flush(); 	
	   }

}
