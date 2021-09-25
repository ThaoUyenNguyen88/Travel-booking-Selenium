package net.phptravels.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePageObject{

	private By firstNameTxt = By.name("first_name");
	private By lastNameTxt = By.name("last_name");
	private By phoneTxt = By.name("phone");
	private By emailTxt = By.name("email");
	private By passwordTxt = By.name("password");
	private By accountTypeDrp = By.id("account_type");
	private By signupBtn = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[7]/button");
	
	public SignupPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public LoginPage signup(String firstName, String lastName, String phone, String email, String password, String accountType) {
		type(firstNameTxt, firstName);
		type(lastNameTxt, lastName);
		type(phoneTxt, phone);
		type(emailTxt, email);
		type(passwordTxt, password);
		Select dropdown = new Select(find(accountTypeDrp));
		dropdown.selectByVisibleText(accountType);
		
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", find(signupBtn));

		return new LoginPage(driver);
		
	}
}
