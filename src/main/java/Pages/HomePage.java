package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
	
	WebDriver driver;
    
	//Loactors 
	By searchbox = By.id("twotabsearchtextbox");
	By seachButton = By.id("nav-search-submit-button");
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void searchOnAmazon(String searchElement)
	{
		driver.findElement(searchbox).sendKeys(searchElement);
		driver.findElement(seachButton).click();
	}
}
