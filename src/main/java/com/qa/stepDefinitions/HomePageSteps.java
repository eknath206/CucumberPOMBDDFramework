package com.qa.stepDefinitions;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class HomePageSteps extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	@Given("^user opens browser$")
	public void user_opens_browser() {
		TestBase.initialization();

	}

	@SuppressWarnings("deprecation")
	@Then("^user is on login page$")
	public void user_is_on_login_page() {
		loginPage = new LoginPage();
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
		

	}

	@Then("^user logs into the system$")
	public void user_logs_into_the_system() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Then("^validate home page title$")
	public void validate_home_page_title() {
		String homeTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO", homeTitle);

	}

	@Then("^validate logged in user$")
	public void validate_logged_in_user() throws InterruptedException {
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		boolean userNameFlag = homePage.verifyCorrectUserName();
		Assert.assertTrue(userNameFlag);

	}
	
	@Then("^close the browser$")
	public void close_the_browser() {
		
		driver.quit();

	}

}
