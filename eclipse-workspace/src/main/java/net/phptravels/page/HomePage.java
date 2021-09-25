package net.phptravels.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePageObject {

	String homePageUrl = "https://www.phptravels.net/";
	private By loginBtn = By.xpath("/html/body/header/div[1]/div/div/div[2]/div/div/a[2]");
	private By signupBtn = By.xpath("/html/body/header/div[1]/div/div/div[2]/div/div/a[1]");

	@FindBy(xpath = "//*[@id=\"hotels-search\"]/div/div/div[1]/div/div/div/span/span[1]/span")
	WebElement cityNameSearch;

	@FindBy(xpath = "/html/body/span/span/span[1]/input")
	WebElement cityNameTxt;

	@FindBy(id = "checkin")
	WebElement checkinInput;

	@FindBy(xpath = "/html/body/div[4]/div[1]/table/thead/tr[1]/th[2]")
	WebElement monthYearCheckinCld;

	@FindBy(xpath = "/html/body/div[4]/div[1]/table/thead/tr[1]/th[3]")
	WebElement arrowCheckinMonth;

	@FindBy(id = "checkout")
	WebElement checkoutInput;

	@FindBy(xpath = "/html/body/div[5]/div[1]/table/thead/tr[1]/th[2]")
	WebElement monthYearCheckoutCld;

	@FindBy(xpath = "/html/body/div[5]/div[1]/table/thead/tr[1]/th[3]")
	WebElement arrowCheckoutMonth;

	@FindBy(xpath = "/html/body/section[1]/div/div/div/div/div[2]/div/div[1]/form/div/div/div[3]/div/div/div/a")
	WebElement travellersElement;

	@FindBy(id = "nationality")
	WebElement nationalityDrp;

	@FindBy(id = "rooms")
	WebElement roomsTxt;

	@FindBy(id = "adults")
	WebElement adultsTxt;

	@FindBy(id = "childs")
	WebElement childsTxt;

	@FindBy(xpath = "//*[@id=\"hotels-search\"]/div/div/div[3]/div/div/div/div/div[1]/div/div/div[3]/i")
	WebElement plusRoomsBtn;

	@FindBy(xpath = "//*[@id=\"hotels-search\"]/div/div/div[3]/div/div/div/div/div[1]/div/div/div[2]/i")
	WebElement minusRoomsBtn;

	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void openHomePage() {
		openUrl(homePageUrl);
	}

	// Search Hotel
	public void searchHotel(String cityName, String monthYearCheckin, String dayCheckin, String monthYearCheckout,
			String dayCheckout, String nationality, String rooms, String adults, String childs)
			throws InterruptedException {
		cityNameSearch.click();
		cityNameTxt.sendKeys(cityName);
		By cityResult = By.xpath("//*[@id=\"select2-hotels_city-results\"]/li[contains(text(),'" + cityName + "')]");
		waitForVisibilityOf(cityResult, 20);
		click(cityResult);

		checkinInput.click();
		Thread.sleep(3000);
		dateCheckin(monthYearCheckin, dayCheckin);
		dateCheckout(monthYearCheckout, dayCheckout);
		travellers(nationality, rooms, adults, childs);
	}

	// check out calendar
	public void dateCheckout(String monthYearCheckout, String dayCheckout) {
		while (true) {
			String monthYearCheckoutDefault = monthYearCheckoutCld.getText();
			if (monthYearCheckoutDefault.equals(monthYearCheckout)) {
				break;
			} else {
				arrowCheckoutMonth.click();
			}
		}
		By dayCheckoutCld = By
				.xpath("/html/body/div[5]/div[1]/table/tbody/tr/td[contains(text(),'" + dayCheckout + "')]");
		click(dayCheckoutCld);
	}

	// check in calendar
	public void dateCheckin(String monthYearCheckin, String dayCheckin) {
		while (true) {
			String monthYearCheckinDefault = monthYearCheckinCld.getText();
			if (monthYearCheckinDefault.equals(monthYearCheckin)) {
				break;
			} else {
				arrowCheckinMonth.click();
			}
		}
		By dayCheckinCld = By
				.xpath("/html/body/div[4]/div[1]/table/tbody/tr/td[contains(text(),'" + dayCheckin + "')]");
		click(dayCheckinCld);
	}

	// travellers
	public void travellers(String nationality, String rooms, String adults, String childs) {
		travellersElement.click();
		new WebDriverWait(driver, Duration.ofMillis(3000))
				.until(ExpectedConditions.elementToBeClickable(nationalityDrp));
//		nationalityDrp.click();
		Select dropdown = new Select(nationalityDrp);
		dropdown.selectByVisibleText(nationality);
//		roomsTxt.clear();
//		roomsTxt.sendKeys(rooms);
		roomsTravellers(rooms);
		adultsTxt.clear();
		adultsTxt.sendKeys(adults);
		childsTxt.clear();
		childsTxt.sendKeys(childs);
	}

	// Action with Rooms Travellers
	public void roomsTravellers(String rooms) {
		while (true) {
//			JavascriptExecutor js = (JavascriptExecutor) driver;  
//			String roomsDefault = (String) js.executeScript("return arguments[0].value", roomsTxt);
			String roomsDefault = roomsTxt.getAttribute("value");
			if (Integer.parseInt(roomsDefault) == Integer.parseInt(rooms)) {
				break;
			} else if (Integer.parseInt(roomsDefault) > Integer.parseInt(rooms)) {
				minusRoomsBtn.click();
			} else if (Integer.parseInt(roomsDefault) < Integer.parseInt(rooms)) {
				plusRoomsBtn.click();
			}
		}
	}

	// click login button
	public LoginPage clickLoginBtn() {
		click(loginBtn);
		return new LoginPage(driver);
	}

	// click signup button
	public SignupPage clickSignupBtn() {
		click(signupBtn);
		return new SignupPage(driver);
	}
}
