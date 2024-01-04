package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.SeleniumUtility;

public class AdminPage extends SeleniumUtility {
	static ExtentTest test;
	
	@FindBy(xpath = "//div[@id='apps']/a")
	private List<WebElement> menuAppsList;
	
	@FindBy(id = "selected-location")
	private WebElement selectedLocation;
	
	@FindBy(tagName = "h4")
	private WebElement headerText;
	
	@FindBy(xpath = "//a[contains(@id, 'registerPatient')]")
	private WebElement registeraPatientOption;

	public List<WebElement> getListbox() {
		return menuAppsList;
	}

	public void setListbox(List<WebElement> listbox) {
		this.menuAppsList = listbox;
	}

	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTheDashboardPage(String locationType) {
		Assert.assertEquals(headerText.getText(), "Logged in as Super User (admin) at "+locationType+".");
		Assert.assertEquals(selectedLocation.getText(), locationType);
		Assert.assertTrue(getListbox().size()>1, "DashBoard meanu list size in less than 1");
		return true;
	}
	
	public AdminPage NavigateToRegisterAPatientPage(boolean flag) {
		if(flag = true)
			clickButton(registeraPatientOption);
		else
			test.log(LogStatus.INFO, "Navigate To Register A Patient Page", "Please provide the flag as 'True'");
		return this;
	}
}
