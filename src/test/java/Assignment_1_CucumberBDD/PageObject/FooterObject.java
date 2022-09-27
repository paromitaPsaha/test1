package Assignment_1_CucumberBDD.PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Assignment_1_CucumberBDD.Core.WebDriverFactory1;
import io.cucumber.java.Scenario;

public class FooterObject {

	private static final Logger logger = LogManager.getLogger(FooterObject.class);
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Scenario scn;

	//------Locater for footer section-------
	
	private By twitterIcon = By.xpath("//li[@class='twitter']");
	private By twitterAcName= By.xpath("(//div[@dir='auto']//span[text()='Selenium Framework'])[1]");
	
	//============= Expected Results ==========================================================//

		String twitterPageTitle= "Selenium Framework (@seleniumfrmwrk) / Twitter";
		String emailId= "abhidya295@gmail.com";
		String successedSubMsg= " Newsletter : You have successfully subscribed to this newsletter.";
		String failSubMsg= " Newsletter : This email address is already registered.";
	
	
	public FooterObject(WebDriver driver, Scenario scn) {
		
		this.driver = driver;
		this.scn = scn;
	}

	//============ 1. Method to set twitter link =================================================//
    public void setTwitterLink()
    {
    	WebElement twitterElement =driver.findElement(twitterIcon);
    	//Scroll till twitter link element available on screen using Javascript executor
		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", twitterElement);
		Assert.assertEquals(true, twitterElement.isDisplayed());
    	logger.info("Validate the twitter link");
    }
    
    //--------method to click twitter link------------------
    public void clickOnTwitterlink()
    {
    	
    	WebElement twitterElement =driver.findElement(twitterIcon);
    	twitterElement.click();
    	logger.info("Click the ltwitter link");
    	scn.log("Click the ltwitter link");
    }	
    
    //------method to validate twitter account page--------
    public void validateTwiterPage()
    {
    	WebDriverFactory1.switchWindow();
    	logger.info("Switch to Twitter Account window");
    	wait = new WebDriverWait(driver,20);
    	boolean rs = wait.until(ExpectedConditions.titleIs(twitterPageTitle));
    	Assert.assertEquals(true, rs);
    	logger.info("Validate twitter account page with its title, title is: "+ twitterPageTitle);
    	scn.log("navigate to twitter account page, page title is: "+ twitterPageTitle);
    	  	
    }
    
    //-------method to validate twitter account name-------
    public void validateTwitterAccountName(String AcName)
    {
    	WebElement twitterAcNameElement = driver.findElement(twitterAcName);
    	Assert.assertEquals(AcName, twitterAcNameElement.getText());
    	logger.info("Validate twitter account name, account name is: "+twitterAcNameElement.getText());
    	scn.log("Validate twitter account name, account name is: "+twitterAcNameElement.getText());
    }
}
