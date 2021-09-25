package net.phptravels.page;

import org.openqa.selenium.WebDriver;

public class AccountDashboardPage extends BasePageObject{
	
	String accountDashboardUrl = "https://www.phptravels.net/account/dashboard";
	
	public AccountDashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getPageUrl() {
		return accountDashboardUrl;
	}
}
