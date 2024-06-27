package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.base;
import Pages.HomePage;
import Pages.SearchResults;

public class test {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		HomePage homepage = new HomePage(driver);
		SearchResults searchresults = new SearchResults(driver);
		base base = new base(driver) ;

		base.invokeBrowser();
		homepage.searchOnAmazon("iphone 11");
		searchresults.clickonfirstResult();
		searchresults.switchtoNewTab(driver);
		searchresults.scroll();
		searchresults.addToCart();
		searchresults.verifyAddtoCart();
		//base.closeBrowser();
		base.closeAllsession();

	}

}
