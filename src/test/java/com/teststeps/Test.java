package com.teststeps;

import java.io.IOException;
import java.text.ParseException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.pages.AdminPage;
import com.pages.LoginPage;
import com.pages.PatientDetailsPage;
import com.pages.RegisterPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.SeleniumUtility;

public class Test extends SeleniumUtility {
	static ExtentTest test;
	static ExtentReports report;
	LoginPage l = null;
	AdminPage a = null;
	RegisterPage r = null;
	PatientDetailsPage p = null;

	@BeforeTest
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReport\\ExtentReportResults.html");
		test = report.startTest("Knila");
	}

	@BeforeClass
	public void beforeClass() throws Throwable {
		launchBrowser("Chrome");
		test.log(LogStatus.PASS, "Chrome Browser", "Browser lauched successfully");
		openApp(getProperty("url", "System"));
		test.log(LogStatus.PASS, "Application Launch", "Navigated to the specified URL");
	}

	@org.testng.annotations.Test(priority = 0)
	public void VerifyUserDasboardPageIsRedirected() throws IOException, Throwable {
		l = new LoginPage();
		l.LoginWithTheUserToOpenMrsPage(getProperty("username", "System"), getProperty("password", "System"),
				"Pharmacy");
		test.log(LogStatus.PASS, "Successfully logged in with the user: " + getProperty("username", "System"));
		a = new AdminPage();
		a.verifyTheDashboardPage("Pharmacy");
		test.log(LogStatus.PASS, "Dashboard page has been verified successfully.");
	}

	@org.testng.annotations.Test(priority = 1)
	public void RegisterAPatient() throws Throwable, Throwable {
		r = new RegisterPage();
		a.NavigateToRegisterAPatientPage(true);
		test.log(LogStatus.PASS, "Navigate to Patient Register Page", "Successfully navigetd to patient register page");
		r.ProvideDemographicDetals();
		test.log(LogStatus.PASS, "Provideing User details", "New patient details has been added successfully");
	}

	@org.testng.annotations.Test(priority = 2)
	public void VerifyTheDetailsBeforeConfirmationAndClickConfirm() throws IOException, Throwable {
		r.VerifyUserDetailsInConfirmPage();
		test.log(LogStatus.PASS, "Navigate to Patient Register Page", "Successfully navigetd to patient register page");
		r.clickConfirmOption();
		test.log(LogStatus.PASS, "Provideing User details", "New patient details has been added successfully");
	}

	@org.testng.annotations.Test(priority = 3)
	private void VerifyThePatientGenderAndAge() throws ParseException, IOException, Throwable {
		p = new PatientDetailsPage();
		p.VerifyThePatientDetailsAfterConfirmation();
	}
	
	@org.testng.annotations.Test(priority = 4)
	private void StartAndConfirmTheVisit() {
		p.ClickStartVisitAndConfirmTheVisit();
	}
	
	@org.testng.annotations.Test(priority = 5)
	private void ClickTheAttachamentAndUploadTheFile() {
		// TODO Auto-generated method stub

	}

	@AfterMethod
	public void after(ITestResult r) throws Throwable {
		if (r.getStartMillis() == ITestResult.FAILURE) {
			screenShot();
		}
	}

	@AfterClass
	public void afterClass() throws Throwable {
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
