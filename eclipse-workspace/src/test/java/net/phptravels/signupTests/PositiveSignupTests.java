package net.phptravels.signupTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import net.phptravels.base.TestUtilities;
import net.phptravels.page.HomePage;
import net.phptravels.page.LoginPage;
import net.phptravels.page.SignupPage;

public class PositiveSignupTests extends TestUtilities{
	
	@Parameters({ "firstName", "lastName", "phone", "email", "password", "accountType"})
	@Test
	public void signupTest(String firstName, String lastName, String phone, String email, String password, String accountType) {
		HomePage homepage = new HomePage(driver);
		homepage.openHomePage();
		SignupPage signupPage = homepage.clickSignupBtn();
		LoginPage loginPage = signupPage.signup(firstName, lastName, phone, email, password, accountType);
		sleep(3000);
		//Assert.assertEquals(loginPage.getCurrentUrl(), loginPage.getPageLoginSignupUrl());
		
	}
	
}
