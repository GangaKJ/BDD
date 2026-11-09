package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//Locate elements
	private By username=By.xpath("//input[@id='username']");
	private By password=By.xpath("//input[@id='password']");
	private By submit=By.xpath("//button[@id='submit']");
	private By errorMsg=By.xpath("//div[@id='error']");
	
	//constructor
	public LoginPageObject(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//action methods
	public void enterUserName(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}

	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		driver.findElement(submit).click();
	}
	
	public String geturl()
	{
		return driver.getCurrentUrl();
	}
	
	public String errorMessage()
	{
		WebElement errorElement=wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
		String errorText=errorElement.getText();
		return errorText;
	}
	
}
