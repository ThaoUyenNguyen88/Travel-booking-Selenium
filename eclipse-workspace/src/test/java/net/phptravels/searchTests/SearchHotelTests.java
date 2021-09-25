package net.phptravels.searchTests;

import org.testng.annotations.Test;

import net.phptravels.base.TestUtilities;
import net.phptravels.page.HomePage;

public class SearchHotelTests extends TestUtilities{

	@Test
	public void SearchHotelTest() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.openHomePage();
		homePage.searchHotel("New York","October 2021","23","November 2021","25","Viet Nam","0","5","5");
		sleep(12000);
	}
}
