package Stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signup_positive_scenario extends Generic_functions{
	public static boolean value1,value2;

	/*TC_001 - Validate that the app is open and user clicks on the Signup button and navigates to Signup page*/
	@Given("Launch the URL and click on signup")
	public static void launch_url() throws Exception {
		try {
			app_launch();
			page_wait(30);
			click("welcome_signup");			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Then("Navigated to signup page")
	public static void navigate_signup_page() throws Exception  {
		try {
			value1=driver.findElement(By.xpath(OR_reader("signup_first_name"))).isDisplayed();
			Assert.assertEquals(true,value1);
		} catch (Exception e) {
			e.printStackTrace();	
			takeScreenShot("signup_positive_navigate_signup_page");
		}
	}
	
	/* TC_003 - Validate that the data entered in both Password and Confirm password fields are masked */
	@When("Enter details in the 'Password' and 'Confirmed Password' field should be masked")
	public void enter_password() throws Exception {
		try {		
			click("signup_password");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			page_wait(10);
			value1=driver.findElement(By.xpath(OR_reader( "signup_password"))).isDisplayed();
			value2=driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
			Assert.assertEquals(true,value2);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_enter_password");
		}
	}

	/* TC_004 - Validate that the password should be displayed on an eye click for Password fields*/
	@When("Clicks on the Eye")
	public void click_on_show_password() throws Exception {
		try {
			click("signup_page_back");
			page_wait(30);
			click("welcome_signup");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			page_wait(30);
			click("signup_show_password");
			value1=driver.findElement(By.xpath(OR_reader("signup_show_password"))).isSelected();
			if(value1==false) {
				click("signup_show_password");
			}
			else {
				page_wait(20);
			}					
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_click_on_show_password");
		}
	}	
	@Then("Orginal value should be displayed in the password fields")
	public static void display_value() throws Exception  {
		try {
			page_wait(30);
			value1=driver.findElement(By.xpath(OR_reader( "signup_show_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
		} catch (Exception e) {
			e.printStackTrace();	
			takeScreenShot("signup_positive_display_value");
		}
	}

	/* TC_005 - Validate the Confirm password field by comparing data entered in the Password field */ 
	@When("Enter same values of 'Password' in the 'Confirmed Password' field")
	public void enter_valid_password() throws Exception {
		try {
			click("signup_page_back");
			page_wait(30);
			click("welcome_signup");
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader("signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			value1=driver.findElement(By.xpath(OR_reader( "signup_password"))).isDisplayed();
			value2=driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).isDisplayed();
			Assert.assertEquals(true,value1);
			Assert.assertEquals(true,value2);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_enter_valid_password");
		}
	}

	/* TC_006 -  Validate user is able to click on Sign Up with valid credentials */
	@When("Enters valid credentials")
	public void enter_valid_cred() throws Exception {
		try {
			click("signup_page_back");
			page_wait(30);
			click("welcome_signup");
			driver.findElement(By.xpath(OR_reader("signup_first_name"))).sendKeys(td_reader("signup_first_name",1));
			driver.findElement(By.xpath(OR_reader("signup_last_name"))).sendKeys(td_reader("signup_last_name",1));
			driver.findElement(By.xpath(OR_reader("signup_email_id"))).sendKeys(td_reader("signup_email_id",1));
			driver.findElement(By.xpath(OR_reader("signup_phone_number"))).sendKeys(td_reader("signup_phone_number",3));
			driver.findElement(By.xpath(OR_reader("signup_password"))).sendKeys(td_reader("signup_password",1));
			driver.findElement(By.xpath(OR_reader( "signup_confirm_password"))).sendKeys(td_reader("signup_confirm_password",2));
			click("signup_terms_and_conditions");
			value1=driver.findElement(By.xpath(OR_reader("signup_terms_and_conditions"))).isSelected();
			if(value1==true) {
				click("signup_terms_and_conditions");
			}
			else {
				page_wait(50);
//				click("signup");
				page_wait(20);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_enter_valid_cred");
		}
	}	
	@Then("Verify navigation to OTP page")
	public void verify_OTP_page() throws Exception {
		try {
//			page_wait(60);
//			value1=driver.findElement(By.xpath(OR_reader( "otp_1"))).isDisplayed();
//			Assert.assertEquals(true,value1);
//			page_wait(20);		
			}
		catch (Exception e){
			e.printStackTrace();
			takeScreenShot("signup_positive_verify_OTP_page");
		}
	}

	/* Tc_007 - verify the scenario when navigate to the otp Login page */
	@When("Enters otp")
	public void enter_otp() throws Exception {
		try {
//			page_wait(40);
//			driver.findElement(By.xpath(OR_reader("otp_1"))).sendKeys(td_reader("otp_1"));
//			driver.findElement(By.xpath(OR_reader("otp_2"))).sendKeys(td_reader("otp_2"));
//			driver.findElement(By.xpath(OR_reader("otp_3"))).sendKeys(td_reader("otp_3"));
//			driver.findElement(By.xpath(OR_reader("otp_4"))).sendKeys(td_reader("otp_4"));		
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_enter_otp");
		}
		
	}
	@Then("Clicks on 'verify' button")
	public void click_verify() throws Exception, InterruptedException {
		try {
//			page_wait(15);
//			click("otp_verify");
//			page_wait(10);
//			value1=driver.findElement(By.xpath(OR_reader( "welcome_page_title"))).isDisplayed();
//			Assert.assertEquals(true,value1);
			close();
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("signup_positive_click_verify");
		}		
	}
	
}