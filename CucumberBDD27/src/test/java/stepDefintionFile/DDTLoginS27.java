package stepDefintionFile;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPageObject;

public class DDTLoginS27 {
	WebDriver driver;
	LoginPageObject obj;
	
	@Before 
	public void browsersetUp()
	{
		driver=new ChromeDriver();
		obj =new LoginPageObject(driver);
	}
	
	@Given("webpage launched")
	public void webpage_launched() {
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@When("enter {string}  and {string} and clicks submit")
	public void enter_and_and_clicks_submit(String username, String pwd) {
	    obj.enterUserName(username);
	    obj.enterPassword(pwd);
	    obj.clickSubmit();
	}

	@Then("verify {string}")
	public void verify(String expected) {
		
		if(obj.geturl().contains("logged-in-successfully/"))
		{
			Assertions.assertEquals(obj.geturl(),expected);
		}
		else
		{
			Assertions.assertEquals(obj.errorMessage(),expected);
		}
	    
	}

	@After
	public void teardown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
}
