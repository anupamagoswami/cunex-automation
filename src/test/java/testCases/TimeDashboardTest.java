package testCases;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.TimeCardpage;
import pageObjects.TimeDashboardPage;

public class TimeDashboardTest extends BaseTest {
		private LoginPage loginPage;
		private DashboardPage dashboard;
		private TimeDashboardPage timedashboardPage;
		private TimeCardpage timecard;
	
		@Test(priority = 1)
		public void VerifyTimedashboard() throws InterruptedException, AWTException
		{
			loginPage= new LoginPage(driver);
			loginPage.loginPerform("Cunex Inc.", "123456");
			dashboard= new DashboardPage(driver);
			dashboard.clickHumenResource();
			timedashboardPage=new TimeDashboardPage(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			 timedashboardPage.clickTimedashboard();
			Assert.assertEquals(timedashboardPage.verifyTimedashboardtext(), "Time Dashboard", "Message not matched ");
		
			
		}
		
		@Test(priority = 2)
		public void userAbletoperformApproveButton() throws InterruptedException, AWTException
		{
			loginPage = new LoginPage(driver);
			BaseTest.normalZoom();
			BaseTest.zommout();
			loginPage.loginPerform("Cunex Inc.", "123456");
			dashboard = new DashboardPage(driver);
			dashboard.clickHumenResource();
			timedashboardPage = new TimeDashboardPage(driver);
			Thread.sleep(4000);
			timedashboardPage.clickTimedashboard();
			timedashboardPage.clickDriverName();
			switchToNWindow();
			timecard = new TimeCardpage(driver);
			timecard.interactEachday();

		



	}
	
	
	
	

}
