package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class base {

	 WebDriver driver ;
	 public base(WebDriver driver)
	 {
		 this.driver =driver;
	 }
	
	public void invokeBrowser()
	{
		driver.manage().deleteAllCookies();
		String url ="https://www.amazon.in/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.get(url);	
	}
	public void closeBrowser()
	{
		driver.close();
	}
	public void closeAllsession()
	{
		driver.quit();
	}

}
