package net.phptravels.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePageObject{

	private By emailTxt = By.name("email");
	private By passwordTxt = By.name("password");
	private By loginBtn = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[3]/button");
	private String loginSignupUrl = "https://www.phptravels.net/login/signup";
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getPageLoginSignupUrl() {
		return loginSignupUrl;
	}

	public AccountDashboardPage logIn(String email, String password) {
		type(emailTxt, email);
		type(passwordTxt, password);
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", find(loginBtn));
//		waitForVisibilityOf(loginBtn, 10);
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].scrollIntoView()", find(loginBtn)); 
//		waitForVisibilityOf(loginBtn, 10);
//		click(loginBtn);
		
		return new AccountDashboardPage(driver);
	}
	
}
