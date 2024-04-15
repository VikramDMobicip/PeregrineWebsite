package preLogin;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//Please check the website to check whether its staging or Live
//Staging : https://www.webs.prgr.in   Live : https://www.mobicip.com

public class Features {

	WebDriver d;
	ExtentReports extentreport;
	ExtentSparkReporter spark;
	
	@BeforeSuite
    public void beforeTest()
    {
		
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("D:\\TestReports\\TestFeatures\\reportFeatures.html");
		extentreport.attachReporter(spark);
    }
	
    //Checking the Home page opening properly
	@Test
	public void a1_Homepage()
	{
  		ExtentTest test=extentreport.createTest("Home page","Checking the Home page opening properly");
  		System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver-win64_122\\chromedriver.exe");
 		ChromeOptions options = new ChromeOptions();
 		options.addArguments("--remote-allow-origins=*");
 		d=new ChromeDriver(options);
 		
 	    try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
 	    
 	    d.manage().window().maximize();
  		
//  		Firefox
 	
//  		System.setProperty("webdriver.gecko.driver","D:\\geckodriver_w10\\geckodriver.exe"); // Setting system properties of FirefoxDriver
//  		d = new FirefoxDriver(); //Creating an object of FirefoxDriver
//  		d.manage().window().maximize();
	
 	    d.get("https://www.mobicip.com");   
		String tit = d.getTitle();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
	    if(tit.equals("Best Parental Control App for Busy Parents | Mobicip"))
	    {test.pass("Homepage title is correct");}
	    else{test.fail("Homepage title is incorrect");}
    }
	
	//Checking the Features button is present properly in home page
	@Test
	public void a2_Featuresbutton()
	{
  		ExtentTest test=extentreport.createTest("Features button","Checking the Features button is present properly in home page");
  		boolean a=true;
  		try {d.findElement(By.xpath("//span[text()='Features']")).click();}
		catch(NoSuchElementException e){a=false;
			test.fail("Features button is not present in home page");}
		if(a==true){test.pass("Features button is present properly in home page");}
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

		a=true;
  		try {d.findElement(By.xpath("//span[text()='Screen Time Scheduler']"));
  		d.findElement(By.xpath("//p[text()='Create schedules to limit screen ' and text()=' time & app usage']"));
  		d.findElement(By.xpath("//span[text()='Social Media Monitor']"));
  		d.findElement(By.xpath("//p[text()='Monitor social media & prevent ' and text()=' risky behavior']"));
  		d.findElement(By.xpath("//span[@class='title' and text()='App Blocker']"));
  		d.findElement(By.xpath("//p[text()='Limit and block distractive ' and text()=' apps']"));
  		d.findElement(By.xpath("//span[@class='title' and text()='Activity Summary']"));
  		d.findElement(By.xpath("//p[text()='Keep track of how your children ' and text()=' spend their time online']"));
  		d.findElement(By.xpath("//span[@class='title' and text()='Website Blocker']"));
  		d.findElement(By.xpath("//p[text()='Monitor & block adult ' and text()=' websites']"));
  		d.findElement(By.xpath("//span[@class='title' and text()='Family Locator']"));
  		d.findElement(By.xpath("//p[text()='Locate your children and set geo-boundaries to ensure their safety']"));
  		d.findElement(By.xpath("//span[@class='title' and text()='Expert Advice']"));
  		d.findElement(By.xpath("//p[text()='Learn parenting tips from experts on digital wellness']"));
  		d.findElement(By.xpath("//span[@class='title' and text()='Collaboration']"));
  		d.findElement(By.xpath("//p[text()='Team up with co-parents / guardians & your child']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("All Features are not shown in Features pop-up");}
		if(a==true){test.pass("All Features are shown in Features pop-up");}
    }
	
	//Checking the elements in Screen time page Screen time - Title, Screen time - Header, Screen time - Defination, Screen time - Start free trail button, Screen time - Features, Screen time - Importance, Screen time - Effects, Screen time - Why Mobicip ?, Screen time - Customer review, Screen time - Build better section, Screen time - Footer.
	@Test
	public void a3_Screentimepage()
	{
  		ExtentTest test=extentreport.createTest("Screen time page","Checking the elements in Screen time page Screen time ");
  		d.findElement(By.xpath("//span[text()='Screen Time Scheduler']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Title
		String tit = d.getTitle();
	    if(tit.equals("Screen Time Parental Controls | Mobicip"))
	    {test.pass("Screen time page title is correct");}
	    else{test.fail("Screen time page title is incorrect");}
	    //Header
  		boolean a=true;
  		try {d.findElement(By.xpath("//span[@class='icon_menu']"));
  		d.findElement(By.xpath("//a[text()='Pricing']"));
  		d.findElement(By.xpath("//span[text()='Features']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
  		d.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
  		d.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Screen time page Header is incorrect");}
		if(a==true){test.pass("Screen time page Header is correct");}
		//List of features
		a=true;
  		try {d.findElement(By.xpath("//ul[@class='feature_ul']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Screen time page List of features is present");}
		if(a==true){test.pass("Screen time page List of features is present");}
		//Defination
		a=true;
  		try {d.findElement(By.xpath("//h1[text()='SCREEN TIME']"));
  		d.findElement(By.xpath("//span[text()='Schedule Screen Time & App Usage']"));
  		d.findElement(By.xpath("//p[contains(text(),'Set daily schedules with restricted access to apps and websites. Limit daily screen time by category and lock the screens on demand. View usage reports and adjust screen time allowances.')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Screen time page Defination is incorrect");}
		if(a==true){test.pass("Screen time page Defination is correct");}
		//start free trail
		a=true;
  		try {d.findElement(By.xpath("//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Screen time page Start Free Trial button is not present");}
		if(a==true){test.pass("Screen time page Start Free Trial button is present");}
		//Features
		JavascriptExecutor j= (JavascriptExecutor) d;
		j.executeScript("window.scrollBy(0,568)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[text()='Features of Mobicip Screen Time Scheduler']"));
  		d.findElement(By.xpath("//h3[text()='Schedules']"));
  		d.findElement(By.xpath("//p[contains(text(),'Set schedules for activities like school, homework and sleep to ensure productive learning and healthy habits. Block specific apps and websites, and manage screen time during a schedule.')]"));
  		d.findElement(By.xpath("//h3[text()=' Daily Free Time Limit']"));
  		d.findElement(By.xpath("//p[contains(text(),'Set daily screen time allowed for entertainment with access to games, social media and movies.')]"));
  		j.executeScript("window.scrollBy(0,380)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//h3[text()='Family Time']"));
  		d.findElement(By.xpath("//p[contains(text(),'Set schedules for activities like school, homework and sleep to ensure productive learning and healthy habits. Block specific apps and websites, and manage screen time during a schedule.')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Screen time page Features is not present");}
		if(a==true){test.pass("Screen time page Features is present");}
		//Importance
		j.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[text()='Why Limiting Screen Time is Important?']"));
  		d.findElement(By.xpath("//p[@class='paragraph_content' and  contains(text(),' Kids are spending more time on screens than ever before.')]"));
  		d.findElement(By.xpath("//a[contains(text(),'How To Bypass Screen Time: 12 Apple Parental Control Hacks')]"));
  		d.findElement(By.xpath("//a[contains(text(),'Digital Detox - Old School is the New Cool')]"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Screen time page Importance is not present");}
  		if(a==true){test.pass("Screen time page Importance is present");}
  		j.executeScript("window.scrollBy(0,350)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
  		//Effects
  		try {d.findElement(By.xpath("//h2[text()='Effects of Screen Time on Sleep & Sight']"));
  		d.findElement(By.xpath("//p[@class='paragraph_content' and  contains(text(),'The National Sleep Foundation recommends that you should stop using tablets & smartphones at least 30')]"));
  		d.findElement(By.xpath("//ul[@class='paragraph_ul']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Screen time page Effects is not present");}
  		if(a==true){test.pass("Screen time page Effects is present");}
  		j.executeScript("window.scrollBy(0,700)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Why Mobicip ?
  		try {d.findElement(By.xpath("//h2[contains(text(),'Why Choose Mobicip')]"));
  		d.findElement(By.xpath("//span[text()='Apple']/parent::p[@class='paragraph_content']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Screen time page - Why Mobicip ? is not present");}
  		if(a==true){test.pass("Screen time page - Why Mobicip ? is present");}
  		j.executeScript("window.scrollBy(0,800)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Customer review
  		try {d.findElement(By.xpath("//p[@class='review_msg']/following::p[text()='Playstore']"));
  		d.findElement(By.xpath("//p[@class='review_msg']/following::p[text()='Appstore']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Screen time page - Customer review is not present");}
  		if(a==true){test.pass("Screen time page - Customer review is present");}
  		j.executeScript("window.scrollBy(0,300)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Build better
  		try {d.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
  		d.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
  		d.findElement(By.xpath("//a[@class='primary_button sign_up']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Screen time page - Build better is not present");}
  		if(a==true){test.pass("Screen time page - Build better is present");}
  		j.executeScript("window.scrollBy(0,550)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Footer
  		try {d.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Screen time page - Footer is not present");}
  		if(a==true){test.pass("Screen time page - Footer is present");}
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
	}
	
	//Checking the elements in Social media monitor.
	@Test
	public void a5_SocialMediaMoniter()
	{
  		ExtentTest test=extentreport.createTest("Social media monitor ","Checking the elements in Social media monitor page Screen time ");
  		JavascriptExecutor j1= (JavascriptExecutor) d;
		j1.executeScript("window.scrollBy(0,-5500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//a[@class='feature_anchor social_media_monitor ']//span[text()='Social Media Monitor']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Title
		String tit = d.getTitle();
		System.out.println(tit);
	    if(tit.equals("Powerful Social Media Monitoring & Parental Control Software | Mobicip"))
	    {test.pass("Social Media Monitor page title is correct");}
	    else{test.fail("Social Media Monitor page title is incorrect");}
	    //Header
  		boolean a=true;
  		try {d.findElement(By.xpath("//span[@class='icon_menu']"));
  		d.findElement(By.xpath("//a[text()='Pricing']"));
  		d.findElement(By.xpath("//span[text()='Features']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
  		d.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
  		d.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Social Media Monitor page Header is incorrect");}
		if(a==true){test.pass("Social Media Monitor page Header is correct");}
		//List of features
		a=true;
  		try {d.findElement(By.xpath("//ul[@class='feature_ul']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Social Media Monitor page List of features is present");}
		if(a==true){test.pass("Social Media Monitor page List of features is present");}
		//Defination
		a=true;
  		try {d.findElement(By.xpath("//h1[text()='SOCIAL MEDIA MONITOR']"));
  		d.findElement(By.xpath("//span[text()='Parental Monitoring of Social Media']"));
  		d.findElement(By.xpath("//p[contains(text(),'Receive real-time alerts on dangerous interactions and unhealthy behavior.')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Social Media Monitor page Defination is incorrect");}
		if(a==true){test.pass("Social Media Monitor page Defination is correct");}
		//start free trail
		a=true;
  		try {d.findElement(By.xpath("//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Social Media Monitor page Start Free Trial button is not present");}
		if(a==true){test.pass("Social Media Monitor page Start Free Trial button is present");}
		//Features
		JavascriptExecutor j= (JavascriptExecutor) d;
		j.executeScript("window.scrollBy(0,568)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[text()='Features of Mobicip Social Media Monitor']"));
  		d.findElement(By.xpath("//h3[text()='Social Media Monitor']"));
  		d.findElement(By.xpath("//p[contains(text(),' Facebook and Snapchat for harmful content. Real-time alerts help you to prevent cyberbullying and predatory attacks.')]"));
  		d.findElement(By.xpath("//h3[text()='Alerts']"));
  		d.findElement(By.xpath("//p[contains(text(),'Receive alerts in real time when potentially harmful or inappropriate activity is detected.')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Social Media Monitor page Features is not present");}
		if(a==true){test.pass("Social Media Monitor page Features is present");}
		//Importance
		j.executeScript("window.scrollBy(0,650)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[text()='Why Monitor Social Media?']"));
  		d.findElement(By.xpath("//h2[text()='Why Monitor Social Media?']/following::div[@class='paragraph_content_container']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Social Media Monitor page Importance is not present");}
  		if(a==true){test.pass("Social Media Monitor page Importance is present");}
  		j.executeScript("window.scrollBy(0,600)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
  		//Customer review
  		try {d.findElement(By.xpath("//ul[@class='review_container feature swiper_wrapper']"));
  		d.findElement(By.xpath("//p[@class='review_msg']/following::p[text()='Appstore']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Social Media Monitor page - Customer review is not present");}
  		if(a==true){test.pass("Social Media Monitor page - Customer review is present");}
  		j.executeScript("window.scrollBy(0,300)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Build better
  		try {d.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
  		d.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
  		d.findElement(By.xpath("//a[@class='primary_button sign_up']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Social Media Monitor page - Build better is not present");}
  		if(a==true){test.pass("Social Media Monitor time - Build better is present");}
  		j.executeScript("window.scrollBy(0,650)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Footer
  		try {d.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Screen time page - Footer is not present");}
  		if(a==true){test.pass("Screen time page - Footer is present");}
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
    }
	
	//Checking the elements in App Blocker page 
	@Test
	public void a6_Appblocker()
	{
  		ExtentTest test=extentreport.createTest("App Blocker page","Checking the elements in App Blocker page ");
  		JavascriptExecutor j1= (JavascriptExecutor) d;
		j1.executeScript("window.scrollBy(0,-5500)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//a[@class='feature_anchor app_blocker ']//span[text()='App Blocker']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Title
		String tit = d.getTitle();
	    System.out.println(tit);
	    if(tit.equals("App Limits Parental Controls | Mobicip"))
	    {test.pass("App Blocker page title is correct");}
	    else{test.fail("App Blocker page title is incorrect");}
	    //Header
  		boolean a=true;
  		try {d.findElement(By.xpath("//span[@class='icon_menu']"));
  		d.findElement(By.xpath("//a[text()='Pricing']"));
  		d.findElement(By.xpath("//span[text()='Features']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
  		d.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
  		d.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("App Blocker page Header is incorrect");}
		if(a==true){test.pass("App Blocker page Header is correct");}
		//List of features
		a=true;
  		try {d.findElement(By.xpath("//ul[@class='feature_ul']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("App Blocker page List of features is present");}
		if(a==true){test.pass("App Blocker page List of features is present");}
		//Defination
		a=true;
  		try {d.findElement(By.xpath("//h1[text()='APP BLOCKER']"));
  		d.findElement(By.xpath("//span[text()='Set Healthy Time Limits on Apps']"));
  		d.findElement(By.xpath("//p[contains(text(),'stay focused by blocking and limiting time spent on distracting apps, social media and entertainment.')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("App Blocker page Defination is incorrect");}
		if(a==true){test.pass("App Blocker page Defination is correct");}
		//start free trail
		a=true;
  		try {d.findElement(By.xpath("//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("App Blocker page Start Free Trial button is not present");}
		if(a==true){test.pass("App Blocker page Start Free Trial button is present");}
		//Features
		JavascriptExecutor j= (JavascriptExecutor) d;
		j.executeScript("window.scrollBy(0,568)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[text()='Features of Mobicip App Blocker']"));
  		d.findElement(By.xpath("//h3[text()='Limit App Usage']"));
  		d.findElement(By.xpath("//p[contains(text(),'Set screen time allowance to ')]"));
  		d.findElement(By.xpath("//h3[text()='App Blocker']"));
  		d.findElement(By.xpath("//p[contains(text(),'Social media and gaming apps distract children from being productive; even leading to screen addiction in some cases.')]"));}
  		catch(NoSuchElementException e){a=false;
			test.fail("App Blocker page Features is not present");}
		if(a==true){test.pass("App Blocker page Features is present");}
		//Importance
		j.executeScript("window.scrollBy(0,700)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[text()='Why Block Apps?']"));
  		d.findElement(By.xpath("//p[@class='paragraph_content' and  contains(text(),'Mobicip shows you all the apps installed on your child')]"));
  		d.findElement(By.xpath("//a[contains(text(),'How do I Block Youtube?')]"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("App Blocker page Importance is not present");}
  		if(a==true){test.pass("App Blocker page Importance is present");}
  		j.executeScript("window.scrollBy(0,350)");
  		//Why Mobicip ?
  		try {d.findElement(By.xpath("//h2[contains(text(),'Why Choose Mobicip')]"));
  		d.findElement(By.xpath("//strong[text()='Apple']/parent::p[@class='paragraph_content']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("App Blocker page - Why Mobicip ? is not present");}
  		if(a==true){test.pass("App Blocker page - Why Mobicip ? is present");}
  		j.executeScript("window.scrollBy(0,500)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Customer review
  		try {d.findElement(By.xpath("//ul[@class='review_container feature swiper_wrapper']"));
  		d.findElement(By.xpath("//p[@class='review_msg']/following::p[text()='Appstore']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("App Blocker page - Customer review is not present");}
  		if(a==true){test.pass("App Blocker page - Customer review is present");}
  		j.executeScript("window.scrollBy(0,300)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Build better
  		try {d.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
  		d.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
  		d.findElement(By.xpath("//a[@class='primary_button sign_up']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("App Blocker page - Build better is not present");}
  		if(a==true){test.pass("App Blocker page - Build better is present");}
  		j.executeScript("window.scrollBy(0,750)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Footer
  		try {d.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("App Blocker page - Footer is not present");}
  		if(a==true){test.pass("App Blocker page - Footer is present");}
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
	}
	
	//Checking the elements in Activity summary page 
	@Test
	public void a7_ActivitySummary(){
  		ExtentTest test=extentreport.createTest("Activity summary page","Checking the elements in Activity summary page");
  		JavascriptExecutor j1= (JavascriptExecutor) d;
		j1.executeScript("window.scrollBy(0,-5680)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//a[@class='feature_anchor activity_summary ']//span[text()='Activity Summary']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Title
		String tit = d.getTitle();
	    if(tit.equals("Activity Summary Parental Control Software | Mobicip"))
	    {test.pass("Activity summary page title is correct");}
	    else{test.fail("Activity summary page title is incorrect");}
	    //Header
  		boolean a=true;
  		try {d.findElement(By.xpath("//span[@class='icon_menu']"));
  		d.findElement(By.xpath("//a[text()='Pricing']"));
  		d.findElement(By.xpath("//span[text()='Features']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
  		d.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
  		d.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Activity summary page Header is incorrect");}
		if(a==true){test.pass("Activity summary page Header is correct");}
		//List of features
		a=true;
  		try {d.findElement(By.xpath("//ul[@class='feature_ul']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Activity summary page List of features is present");}
		if(a==true){test.pass("Activity summary page List of features is present");}
		//Defination
		a=true;
  		try {d.findElement(By.xpath("//h1[text()='ACTIVITY SUMMARY']"));
  		d.findElement(By.xpath("//span[contains(text(),'Digital Journey')]"));
  		d.findElement(By.xpath("//p[contains(text(),'online activity from an intuitive Parent Dashboard. Get peace of mind by building healthy digital habits.')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Activity summary page Defination is incorrect");}
		if(a==true){test.pass("Activity summary page Defination is correct");}
		//start free trail
		a=true;
  		try {d.findElement(By.xpath("//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Activity summary page Start Free Trial button is not present");}
		if(a==true){test.pass("Activity summary page Start Free Trial button is present");}
		//Features
		JavascriptExecutor j= (JavascriptExecutor) d;
		j.executeScript("window.scrollBy(0,568)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[text()='Features of Mobicip Activity Summary']"));
  		d.findElement(By.xpath("//h3[text()='Screen time trends']"));
  		d.findElement(By.xpath("//p[contains(text(),'Keep track of daily screen time consumption and compare against recommended limits. Track usage & time spent on social media, chat and video apps.')]"));
  		d.findElement(By.xpath("//h3[text()='Browsing history']"));
  		d.findElement(By.xpath("//p[contains(text(),'View online browsing history in a rich interface that displays websites visited, videos watched, and more.')]"));
		d.findElement(By.xpath("//h3[text()='Access requests']"));
  		d.findElement(By.xpath("//p[contains(text(),'request for more screen time or access to blocked websites & apps.')]"));
  		d.findElement(By.xpath("//h3[text()='Location history']"));
  		d.findElement(By.xpath("//p[contains(text(),'View locations visited by your children in a given day.')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Activity summary page Features is not present");}
		if(a==true){test.pass("Activity summary page Features is present");}
		j.executeScript("window.scrollBy(0,700)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();} 
  		//Customer review
  		try {d.findElement(By.xpath("//p[@class='review_msg']/following::p[text()='Playstore']"));
  		d.findElement(By.xpath("//p[@class='review_msg']/following::p[text()='Appstore']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Activity summary page - Customer review is not present");}
  		if(a==true){test.pass("Activity summary page - Customer review is present");}
  		j.executeScript("window.scrollBy(0,360)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Build better
  		try {d.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
  		d.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
  		d.findElement(By.xpath("//a[@class='primary_button sign_up']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Activity summary page - Build better is not present");}
  		if(a==true){test.pass("Activity summary page - Build better is present");}
  		j.executeScript("window.scrollBy(0,550)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Footer
  		try {d.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Activity summary page - Footer is not present");}
  		if(a==true){test.pass("Activity summary page - Footer is present");}
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
	}
	
	@Test
	public void a8_WebsiteBlocker()
	{
  		ExtentTest test=extentreport.createTest("Website Blocker","Checking the elements in Website Blocker time page");
  		JavascriptExecutor j1= (JavascriptExecutor) d;
		j1.executeScript("window.scrollBy(0,-5680)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//a[@class='feature_anchor website_blocker ']//span[text()='Website Blocker']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Title
		String tit = d.getTitle();
	    if(tit.equals("Website Blocker Parental Controls | Mobicip"))
	    {test.pass("Website Blocker page title is correct");}
	    else{test.fail("Website Blocker page title is incorrect");}
	    //Header
  		boolean a=true;
  		try {d.findElement(By.xpath("//span[@class='icon_menu']"));
  		d.findElement(By.xpath("//a[text()='Pricing']"));
  		d.findElement(By.xpath("//span[text()='Features']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
  		d.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
  		d.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Website Blocker page Header is incorrect");}
		if(a==true){test.pass("Website Blocker page Header is correct");}
		//List of features
		a=true;
  		try {d.findElement(By.xpath("//ul[@class='feature_ul']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Website Blocker page List of features is present");}
		if(a==true){test.pass("Website Blocker page List of features is present");}
		//Defination
		a=true;
  		try {d.findElement(By.xpath("//h1[text()='WEBSITE BLOCKER']"));
  		d.findElement(By.xpath("//span[text()='Website Blocker & Internet Filter: Protect Your Kids Online']"));
  		d.findElement(By.xpath("//p[contains(text(),'Block websites and filter inappropriate content across any browser, YouTube, or other social media.')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Website Blocker page Defination is incorrect");}
		if(a==true){test.pass("Website Blocker page Defination is correct");}
		//start free trail
		a=true;
  		try {d.findElement(By.xpath("//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Website Blocker page Start Free Trial button is not present");}
		if(a==true){test.pass("Website Blocker page Start Free Trial button is present");}
		//Features
		JavascriptExecutor j= (JavascriptExecutor) d;
		j.executeScript("window.scrollBy(0,568)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[text()='Features of Mobicip Website Blocker']"));
  		d.findElement(By.xpath("//h3[text()='Website Filter']"));
  		d.findElement(By.xpath("//p[contains(text(),'Block age-inappropriate websites and 20 web categories.')]"));
  		d.findElement(By.xpath("//h3[text()='Porn Blocker']"));
  		d.findElement(By.xpath("//p[contains(text(),'Nearly 70% of kids inadvertently stumble upon websites displaying porn & violence while searching for something completely innocent online.')]"));
  		j.executeScript("window.scrollBy(0,380)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//h3[text()='Youtube Filter']"));
  		d.findElement(By.xpath("//p[contains(text(),'Are your kids spending too much time on YouTube? With Mobicip, you can')]"));
  		d.findElement(By.xpath("//h3[text()='Whitelist-Only Mode']"));
  		d.findElement(By.xpath("//p[contains(text(),'Only allow websites that you want your kids to access. Everything else online will be blocked.')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Website Blocker page Features is not present");}
		if(a==true){test.pass("Website Blocker page Features is present");}
		//Importance
		j.executeScript("window.scrollBy(0,320)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[text()='Why Block Websites or Filter the Internet?']"));
  		d.findElement(By.xpath("//p[@class='paragraph_content' and  contains(text(),'The internet has greatly facilitated a free exchange')]")); }
  		catch(NoSuchElementException e){a=false;
		test.fail("Website Blocker page Importance is not present");}
  		if(a==true){test.pass("Website Blocker page Importance is present");}
  		j.executeScript("window.scrollBy(0,500)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
  		//Why Mobicip?
  		try {d.findElement(By.xpath("//h2[contains(text(),'Why Choose Mobicip')]"));
  		d.findElement(By.xpath("//strong[contains(text(),'internet filtering software')]/parent::p[@class='paragraph_content']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Website Blocker page - Why Mobicip ? is not present");}
  		if(a==true){test.pass("Website Blocker page - Why Mobicip ? is present");}
  		j.executeScript("window.scrollBy(0,500)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Customer review
  		try {d.findElement(By.xpath("//p[@class='review_msg']/following::p[text()='Playstore']"));
  		d.findElement(By.xpath("//p[@class='review_msg']/following::p[text()='Appstore']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Website Blocker page - Customer review is not present");}
  		if(a==true){test.pass("Website Blocker page - Customer review is present");}
  		j.executeScript("window.scrollBy(0,300)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Build better
  		try {d.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
  		d.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
  		d.findElement(By.xpath("//a[@class='primary_button sign_up']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Website Blocker page - Build better is not present");}
  		if(a==true){test.pass("Website Blocker page - Build better is present");}
  		j.executeScript("window.scrollBy(0,750)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Footer
  		try {d.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Website Blocker page - Footer is not present");}
  		if(a==true){test.pass("Website Blocker page - Footer is present");}
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}

	
	@Test
	public void a9_Familylocator()
	{
  		ExtentTest test=extentreport.createTest("Family locator","Checking the elements in Family locator time page");
  		JavascriptExecutor j1= (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,-5680)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//a[@class='feature_anchor family_locator ']//span[text()='Family Locator']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Title
		String tit = d.getTitle();
	    if(tit.equals("Family Locator Parental Controls | Mobicip"))
	    {test.pass("Family Locator page title is correct");}
	    else{test.fail("Family Locator page title is incorrect");}
	    //Header
  		boolean a=true;
  		try {d.findElement(By.xpath("//span[@class='icon_menu']"));
  		d.findElement(By.xpath("//a[text()='Pricing']"));
  		d.findElement(By.xpath("//span[text()='Features']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
  		d.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
  		d.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Family Locator page Header is incorrect");}
		if(a==true){test.pass("Family Locator page Header is correct");}
		//List of features
		a=true;
  		try {d.findElement(By.xpath("//ul[@class='feature_ul']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Family Locator page List of features is present");}
		if(a==true){test.pass("Family Locator page List of features is present");}
		//Defination
		a=true;
  		try {d.findElement(By.xpath("//h1[text()='FAMILY TRACKER']"));
  		d.findElement(By.xpath("//span[text()='Track Location: Instantly Know Where Your Child Is']"));
  		d.findElement(By.xpath("//strong[contains(text(),'track your family')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Family Locator page Defination is incorrect");}
		if(a==true){test.pass("Family Locator page Defination is correct");}
		//start free trail
		a=true;
  		try {d.findElement(By.xpath("//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Family Locator page Start Free Trial button is not present");}
		if(a==true){test.pass("Family Locator page Start Free Trial button is present");}
		//Features
		JavascriptExecutor j= (JavascriptExecutor) d;
		j.executeScript("window.scrollBy(0,568)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[text()='Features of Mobicip Family Locator']"));
  		d.findElement(By.xpath("//h3[text()='Family Locator']"));
  		d.findElement(By.xpath("//p[contains(text(),'Locate your family anytime using the GPS location tracker and the family map.')]"));
  		d.findElement(By.xpath("//h3[text()='Location Sharing']"));
  		d.findElement(By.xpath("//p[contains(text(),'Share your real-time location to your loved ones to ')]"));
  		j.executeScript("window.scrollBy(0,380)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//h3[text()='Geofencing']"));
  		d.findElement(By.xpath("//p[contains(text(),'Easily check if your child reached school or a local park. Create')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Family Locator page Features is not present");}
		if(a==true){test.pass("Family Locator page Features is present");}
		//Importance
		j.executeScript("window.scrollBy(0,300)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[contains(text(),'Should You Track Your Child')]"));
  		d.findElement(By.xpath("//p[@class='paragraph_content' and  contains(text(),'In the United States alone, an estimated 460,000 children')]")); }
  		catch(NoSuchElementException e){a=false;
		test.fail("Family Locator page Importance is not present");}
  		if(a==true){test.pass("Family Locator page Importance is present");}
  		j.executeScript("window.scrollBy(0,250)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
  		//Why Mobicip?
  		try {d.findElement(By.xpath("//h2[contains(text(),'Why Choose Mobicip')]"));
  		d.findElement(By.xpath("//p[contains(text(),'offer at most 2 of the following location tracking features:')]"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Family Locator page - Why Mobicip ? is not present");}
  		if(a==true){test.pass("Family Locator page - Why Mobicip ? is present");}
  		j.executeScript("window.scrollBy(0,500)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Customer review
  		try {d.findElement(By.xpath("//p[text()='Mobicip Dad, Alabama']"));
  		d.findElement(By.xpath("//p[text()='Mobicip Mom, Vermont']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Family Locator page - Customer review is not present");}
  		if(a==true){test.pass("Family Locator page - Customer review is present");}
  		j.executeScript("window.scrollBy(0,400)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Build better
  		try {d.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
  		d.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
  		d.findElement(By.xpath("//a[@class='primary_button sign_up']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Family Locator page - Build better is not present");}
  		if(a==true){test.pass("Family Locator page - Build better is present");}
  		j.executeScript("window.scrollBy(0,850)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Footer
  		try {d.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Family Locator page - Footer is not present");}
  		if(a==true){test.pass("Family Locator page - Footer is present");}
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@Test
	public void b1_Collaboration()
	{
  		ExtentTest test=extentreport.createTest("Collaboration","Checking the elements in Collaboration page");
  		JavascriptExecutor j1= (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,-5680)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		j1.executeScript("window.scrollBy(0,100)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//a[@class='feature_anchor collaboration ']//span[text()='Collaboration']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//Title
		String tit = d.getTitle();
	    if(tit.equals("Collaboration Tools Parental Control Software | Mobicip"))
	    {test.pass("Collaboration page title is correct");}
	    else{test.fail("Collaboration page title is incorrect");}
	    //Header
  		boolean a=true;
  		try {d.findElement(By.xpath("//span[@class='icon_menu']"));
  		d.findElement(By.xpath("//a[text()='Pricing']"));
  		d.findElement(By.xpath("//span[text()='Features']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
  		d.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
  		d.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Collaboration page Header is incorrect");}
		if(a==true){test.pass("Collaboration page Header is correct");}
		//List of features
		a=true;
  		try {d.findElement(By.xpath("//ul[@class='feature_ul']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Collaboration page List of features is present");}
		if(a==true){test.pass("Collaboration page List of features is present");}
		//Defination
		a=true;
  		try {d.findElement(By.xpath("//h1[text()='COLLABORATION']"));
  		d.findElement(By.xpath("//span[text()='Collaborate with Your Child and Guardian']"));
  		d.findElement(By.xpath("//p[contains(text(),'Invite a co-parent or a guardian to manage your family')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Collaboration page Defination is incorrect");}
		if(a==true){test.pass("Collaboration page Defination is correct");}
		//start free trail
		a=true;
  		try {d.findElement(By.xpath("//div[@class='action_container']//a[@class='primary_button' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Collaboration page Start Free Trial button is not present");}
		if(a==true){test.pass("Collaboration page Start Free Trial button is present");}
		//Features
		JavascriptExecutor j= (JavascriptExecutor) d;
		j.executeScript("window.scrollBy(0,568)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[text()='Features of Mobicip Collaboration']"));
  		d.findElement(By.xpath("//h3[text()='Guardians']"));
  		d.findElement(By.xpath("//p[contains(text(),'Share your parenting duties with trusted ')]"));
  		d.findElement(By.xpath("//h3[text()='Child Dashboard']"));
  		d.findElement(By.xpath("//p[contains(text(),'Your children can self-regulate their screen time consumption,')]"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Collaboration page Features is not present");}
		if(a==true){test.pass("Collaboration page Features is present");}
		//Importance
		j.executeScript("window.scrollBy(0,560)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//h2[contains(text(),'Benefits of Collaborating with Children')]"));
  		d.findElement(By.xpath("//p[@class='paragraph_content' and  contains(text(),'Several studies have documented the benefits of parent-child collaboration.')]")); }
  		catch(NoSuchElementException e){a=false;
		test.fail("Collaboration page Importance is not present");}
  		if(a==true){test.pass("Collaboration page Importance is present");}
  		j.executeScript("window.scrollBy(0,450)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
  		//Customer review
  		try {d.findElement(By.xpath("//p[contains(text(),'Mobicip Dad')]"));
  		d.findElement(By.xpath("//p[contains(text(),'Mobicip Mom')]"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Collaboration page - Customer review is not present");}
  		if(a==true){test.pass("Collaboration page - Customer review is present");}
  		j.executeScript("window.scrollBy(0,400)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Build better
  		try {d.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
  		d.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
  		d.findElement(By.xpath("//a[@class='primary_button sign_up']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Collaboration page - Build better is not present");}
  		if(a==true){test.pass("Collaboration page - Build better is present");}
  		j.executeScript("window.scrollBy(0,850)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Footer
  		try {d.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Collaboration page - Footer is not present");}
  		if(a==true){test.pass("Collaboration page - Footer is present");}
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	
	@Test
	public void b2_ExpertAdvice()
	{
  		ExtentTest test=extentreport.createTest("Expert Advice","Checking the elements in Expert Advice page");
  		JavascriptExecutor j1= (JavascriptExecutor)d;
		j1.executeScript("window.scrollBy(0,-5680)");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		d.findElement(By.xpath("//span[text()='Features']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
  		d.findElement(By.xpath("//span[text()='Expert Advice']")).click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

		//Title
		String tit = d.getTitle();
	    if(tit.equals("Blog | Internet Safety, Digital Citizenship & Social Media | Mobicip"))
	    {test.pass("Expert Advice page title is correct");}
	    else{test.fail("Expert Advice page title is incorrect");}
	    
	    //Header
  		boolean a=true;
  		try {d.findElement(By.xpath("//span[@class='icon_menu']"));
  		d.findElement(By.xpath("//a[text()='Pricing']"));
  		d.findElement(By.xpath("//span[text()='Features']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Support']"));
  		d.findElement(By.xpath("//a[@class='header_nav_anchor' and text()='Testimonials']"));
  		d.findElement(By.xpath("//a[@class='header_link login' and text()='Login']"));
  		d.findElement(By.xpath("//a[@class='primary_button try_free' and text()='Start Free Trial']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Expert Advice page Header is incorrect");}
		if(a==true){test.pass("Expert Advice page Header is correct");}
		
		//Blog -Title
		a=true;
  		try {d.findElement(By.xpath("//a[@title='Blog']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Expert Advice page Title is present");}
		if(a==true){test.pass("Expert Advice page Title is present");}
		
		//Share button
		a=true;
  		try {d.findElement(By.xpath("//div[@class='share_blog_wrapper']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Expert Advice page Share button is not present");}
		if(a==true){test.pass("Expert Advice page Share button is present");}
		
		//Blog container
		a=true;
  		try {d.findElement(By.xpath("//div[@class='blogs_container']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Expert Advice page Blog container is not present");}
		if(a==true){test.pass("Expert Advice page Blog container is present");}
		
		//Page Navigation
		JavascriptExecutor j=(JavascriptExecutor) d;
		j.executeScript("window.scrollBy(0,1680)");
		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}		
		a=true;
  		try {d.findElement(By.xpath("//ul[@class='pagination_bar']"));}
		catch(NoSuchElementException e){a=false;
			test.fail("Expert Advice page - Page Navigation is not present");}
		if(a==true){test.pass("Expert Advice page - Page Navigation is present");}
	
  		j.executeScript("window.scrollBy(0,100)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Build better
  		try {d.findElement(By.xpath("//h2[text()='Build Better Digital Habits With Mobicip']"));
  		d.findElement(By.xpath("//ul[@class='footer_feature_ul']"));
  		d.findElement(By.xpath("//a[@class='primary_button sign_up']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Expert Advice  page - Build better is not present");}
  		if(a==true){test.pass("Expert Advice  page - Build better is present");}
  		j.executeScript("window.scrollBy(0,850)");
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}	
  		//Footer
  		try {d.findElement(By.xpath("//div[@class='footer_section_wrapper']"));}
  		catch(NoSuchElementException e){a=false;
		test.fail("Expert Advice  page - Footer is not present");}
  		if(a==true){test.pass("Expert Advice  page - Footer is present");}
  		try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@AfterSuite
    public void teardown() 
    {
  		d.quit();
    	extentreport.flush();
    }
}