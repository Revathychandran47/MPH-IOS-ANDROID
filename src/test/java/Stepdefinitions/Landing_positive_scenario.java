package Stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Landing_positive_scenario extends Generic_functions{
	static boolean value;

	/*TC_001 Validate that the user is navigated to Welcome page */
	@Given("launch the URL")
	public static void launch_url() throws Exception {
		try {
			app_launch();
			page_wait(40);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("navigated to Welcome page")
	public static void navigate_to_welcome_page() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_navigate_to_welcome_page");
		}		
	}

	/*TC_002 Validate that the user is able to click on 'Sign Up' button and navigate to 'Sign Up' page */
	@When("clicks on  'Sign Up' button")
	public static void clicks_signup() throws Exception {
		try {
			page_wait(60);
			click("welcome_signup");
			page_wait(10);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_clicks_signup");
		}
	}
	@Then("navigate to Sign up page")
	public static void navigate_to_signup_page() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "signup_first_name"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(50);
			click("signup_page_back");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_navigate_to_signup_page");
		}		
	}

	/*TC_003 -Validate user is able to click on 'Login' button and navigate to Login page */
	@When("clicks on the 'Login' button")
	public static void clicks_login() throws Exception {
		try {
			if (platformName.equals("iOS")) {
				page_wait(20);
				click("welcome_login");			
				click("continue");
				page_wait(30);
			}
			else if (platformName.equals("Android")) {
				page_wait(20);
				click("welcome_login");			
				page_wait(30);
			}			
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_clicks_login");
		}
	}
	@Then("navigate to Login page")
	public static void navigate_to_login_page() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader( "login_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			close();
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("landing_positive_navigate_to_login_page");
		}	
	}	
}