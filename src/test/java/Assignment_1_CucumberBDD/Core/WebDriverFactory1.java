package Assignment_1_CucumberBDD.Core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory1 {

	private static final Logger logger= LogManager.getLogger(WebDriverFactory1.class);
	private static WebDriver driver= null;

	//----------------------Getting webdriver for browser---------------------

	public static WebDriver getDriver(String browser) {


		switch(browser.toLowerCase())
		{
		case "chrome":
			driver= new ChromeDriver();
			logger.info("Chrome browser invoked");
			break;
		case "firefox":
			driver= new FirefoxDriver();
			logger.info("Firefox browser invoked");
			break;
		case "headless":
			ChromeOptions option= new ChromeOptions();
			option.addArguments("headless");
			driver= new ChromeDriver(option);
			logger.info("Headless chrome browser invoked");
		default:
			logger.fatal("No such browser is implemented, browser name is: "+ browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("browser window maximized and set timeout is 20 second");
		return driver;
	}
	
	//--------------Method to navigate to URL------------------------
	
	public static void navigateToURL(String url)
	{
		driver.get(url);
		logger.info("navigate to url");
	}

	//-------------Method to quit the browser-------------------------
	
	public static void quitBrowser() {
		
		driver.quit();
		logger.info("Quit the browser");
	}
	
	//-------------Method to switch the window----------------------
	
	public static void switchWindow() {
		
		//---Using set--
		Set <String> set = driver.getWindowHandles();
		Iterator <String> itr = set.iterator();
		String newWindowId =itr.next();
		driver.switchTo().window(newWindowId);
//		//-----using arraylist--------
//		ArrayList<String> arr = new ArrayList<String>();
//		String childWindow=	arr.get(1);
//		driver.switchTo().window(childWindow);
//		logger.info("Switch to new Window, its id is: "+ newWindowId);
	}
	
	//---------Method to get browser name--------------------------
	public static String getBrowserName()
	{
		String defaultBrowser= "chrome";                            //Set chrome as default browser
		String browserSentFromCmd= System.getProperty("browser");  //Get browser name from command line
		if(browserSentFromCmd==null)
		{
			return defaultBrowser;
		}
		else 
		{
			return browserSentFromCmd;
		}
	}
}
