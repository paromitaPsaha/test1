package Assignment_1_CucumberBDD.PageObject;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class CommonPageObject {

	private static final Logger logger = LogManager.getLogger(CommonPageObject.class);
	WebDriver driver;
	Scenario scn;
	WebDriverWait wait;
	String base_url = "http://automationpractice.com/";

	private By logoImg = By.xpath("//img[@alt='My Store']");
	private By prodCatgory= By.xpath("//div[@id='block_top_menu']/ul/li");

	String expCurrentURL= "http://automationpractice.com/index.php";

	//--------------constructor--------------------------------
	public CommonPageObject(WebDriver driver, Scenario scn) {

		this.driver= driver;
		this.scn=scn;
	}

	//-----------Method to validate page URL----------------------
	public void validatePageUrl() {

		wait= new WebDriverWait(driver,20);
		boolean url = wait.until(ExpectedConditions.urlToBe(expCurrentURL));
		Assert.assertEquals(true,url);
		logger.info("validate current URL of page ,so URL is: "+ driver.getCurrentUrl());
	}

	//---------Method to validate page title-----------------------
	public void validatePageTitle(String pageTitle ) {

		Assert.assertEquals(pageTitle, driver.getTitle());
		logger.info("Validate title of page, title is:" + driver.getTitle());
	}

	//-----------Method to display logo------------------------

	public void displayLogo() {

		WebElement logo = driver.findElement(logoImg);
		Assert.assertEquals(true, logo.isDisplayed());
	}

	//============ 4. Method to fetch logo height =======================================================//   
	public void fetchLogoHeight()
	{
		WebElement logo =driver.findElement(logoImg);
		String logoHeight= logo.getAttribute("height");
		logger.info("Height of logo is: "+ logoHeight);
		scn.log("Height of logo is: "+ logoHeight);
	}

	//============ 5. Method to validate logo height =======================================================//   
	public void logoHeightValid(String height)
	{
		WebElement logo =driver.findElement(logoImg);
		Assert.assertEquals(height, logo.getAttribute("height"));
		logger.info("Validate the height of logo");
		scn.log("Validate the height of logo");
	}

	//============ 6. Method to fetch logo width =======================================================//   
	public void fetchLogoWidth()
	{
		WebElement logo =driver.findElement(logoImg);
		String logoWidth= logo.getAttribute("width");
		logger.info("Width of logo is: "+ logoWidth);
		scn.log("Width of logo is: "+ logoWidth);
	}

	//============ 7. Method to validate logo width =======================================================//   
	public void logoWidthValid(String width)
	{
		WebElement logo =driver.findElement(logoImg);
		Assert.assertEquals(width, logo.getAttribute("width"));
		logger.info("Validate the width of logo");
		scn.log("Validate the width of logo");
	}

	//=================================================================================================//
	
	 public void setProdCategory()
	    {
	    	List <WebElement> prodCategoryList =driver.findElements(prodCatgory);
	    	Assert.assertEquals(false, prodCategoryList.isEmpty());
	    	logger.info("Display the product category list, size of list is: "+ prodCategoryList.size());
	    	scn.log("Product category is displayed on page with size is: "+ prodCategoryList.size());
	    }
	  //=================================================================================================//   
	    public void validateProdCategory(List<String> prodList)
	    {
	    	List <WebElement> prodCategoryList =driver.findElements(prodCatgory);
	    	{
	    		for(int i=0; i< prodCategoryList.size(); i++)
	    		{
	    			if(prodCategoryList.get(i).getText().equals(prodList.get(i).toString()))
	        		{
	        			Assert.assertTrue(true);
	        			logger.info(prodCategoryList.get(i).getText()+ " is matched with expected "+ prodList.get(i).toString()+" product name in datatable");
	        		}
	    			else
	    			{
	    				Assert.fail();
	        			logger.fatal(prodCategoryList.get(i).getText()+ " is not matched with expected "+ prodList.get(i).toString()+" product name in datatable");
	    			}
	    		}
	    		logger.info("Validate the product category with expected datatable");
	    	}
	    }
	  //=================================================================================================//   
	    public void sizeOfProdCategory(int prodCount)
	    {
	 	   List <WebElement> prodCategoryList =driver.findElements(prodCatgory);
	 	   Assert.assertEquals(prodCount, prodCategoryList.size());
	 	   logger.info("validate the Size of product category, size is: "+ prodCategoryList.size());
	 	   scn.log("validate the Size of product category, size is: "+ prodCategoryList.size());
	    }
}

