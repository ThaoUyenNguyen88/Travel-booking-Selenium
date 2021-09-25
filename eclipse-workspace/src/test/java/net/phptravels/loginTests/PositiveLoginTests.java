package net.phptravels.loginTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import net.phptravels.base.TestUtilities;
import net.phptravels.page.AccountDashboardPage;
import net.phptravels.page.HomePage;
import net.phptravels.page.LoginPage;

public class PositiveLoginTests extends TestUtilities{
	
	
	@Parameters({ "email", "password"})
	@Test
	public void loginTest(String email, String password) {
		HomePage homePage = new HomePage(driver);
		homePage.openHomePage();
		LoginPage loginPage = homePage.clickLoginBtn();
		AccountDashboardPage accountDashboardPage = loginPage.logIn(email, password);
		sleep(3000);
		Assert.assertEquals(accountDashboardPage.getCurrentUrl(), accountDashboardPage.getPageUrl());
	}

}
