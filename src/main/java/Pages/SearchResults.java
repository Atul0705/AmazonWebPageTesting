package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class SearchResults {
	WebDriver driver;
	//locators 
	By firstSearchResult = By.xpath("(//h2)[1] //a");
	By verifylistname = By.xpath("//span[@class='a-truncate-cut']");
	By addToCart = By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']");
	By cartbutton = By.xpath("//span[@id='nav-cart-count']");
	public SearchResults(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickonfirstResult()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(firstSearchResult));
		driver.findElement(firstSearchResult).click();
	}
	public void switchtoNewTab(WebDriver driver)
	{
		Set<String> windowshandles = driver.getWindowHandles();
		ArrayList<String> arr = new ArrayList<String>(windowshandles);
		String childwindow = arr.get(1);
		driver.switchTo().window(childwindow);
		driver.findElement(addToCart).click();
	}
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
	}
	
	public void addToCart()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(addToCart));
		driver.findElement(addToCart).click();
		
	}
	
	public void verifyAddtoCart()
	{
		driver.findElement(cartbutton).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(verifylistname));
		String itemname = driver.findElement(verifylistname).getText();
		System.out.println(itemname);
		
	}
	

}
