package stepDefination;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver driver;
	
	
	@Given("^open google chrome and lunch home page$")
	public void open_google_chrome_and_lunch_home_page() throws Throwable {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\14193\\eclipse-workspace\\Kayak\\Drivers\\chromedriver.exe");					
	       driver= new ChromeDriver();					
	       driver.manage().window().maximize();			
	       driver.get("https://www.kayak.com/");	
	      String actualTitle = driver.getTitle();
	       System.out.println(actualTitle);
	      String expectedTitle = "Search Flights, Hotels & Rental Cars | KAYAK";
	    Assert.assertEquals(expectedTitle, actualTitle);
	     System.out.println("matched");
	      
	      
}
	@When("^enter the details and search$")
	public void enter_the_details_and_serach()throws Throwable  {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver
				.findElement(By.xpath("//*[contains(@id,'destination-airport-display')]"))));
		// //div[@id='r-Xh-destination-airport-display']
		driver.findElement(By.xpath("//*[contains(@id,'destination-airport-display')]")).click();
		driver.findElement(By.name("destination")).sendKeys("kathmandu, Nepal");
		driver.findElement(By.id("cPYA-dateRangeInput-display-start-inner")).sendKeys("09/01/2020");
		driver.findElement(By.id("cPYA-dateRangeInput-display-end-inner")).sendKeys("09/30/2020");
		driver.findElement(By.className("v-c-p centre")).click();
	}
	@Then("^land on search result page and turn on the price alerts$")
	public void land_on_search_result_page_and_turn_on_the_price_alerts()throws Throwable {
		driver.findElement(By.id("c2SDy-toggle-label")).click();
		
	}
}
