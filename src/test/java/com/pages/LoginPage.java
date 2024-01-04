package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.SeleniumUtility;

public class LoginPage extends SeleniumUtility {

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtUserPass;

	@FindBy(xpath = "//input[@id='loginButton']")
	private WebElement btnLogin;

	@FindBy(xpath = "//ul[@id='sessionLocation']/li")
	private List<WebElement> listOfLocation;

	private By locationOfSection(String location) {
		return By.xpath("//li[@id='" + location + "']");
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(WebElement txtUserName) {
		this.txtUserName = txtUserName;
	}

	public WebElement getTxtUserPass() {
		return txtUserPass;
	}

	public List<WebElement> getListOfLocation() {
		return listOfLocation;
	}

	public void setListOfLocation(List<WebElement> listOfLocation) {
		this.listOfLocation = listOfLocation;
	}

	public void setTxtUserPass(WebElement txtUserPass) {
		this.txtUserPass = txtUserPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(WebElement btnLogin) {
		this.btnLogin = btnLogin;
	}

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage LoginWithTheUserToOpenMrsPage(String userNmae, String password, String locationType)
			throws Throwable {
		if (userNmae.isEmpty() && password.isEmpty())
			throw new Exception("Given username: " + userNmae + " or password: " + password + " is null");
		getTxtUserName().sendKeys(userNmae);
		
		getTxtUserPass().sendKeys(password);
		if (locationType.isBlank())
			throw new Exception("Given location is null");
		driver.findElement(locationOfSection(locationType)).click();
		selectTheLocationBasedOnLocationType(locationType);
		getBtnLogin().click();
		return this;
	}

	private void selectTheLocationBasedOnLocationType(String locationType) throws Throwable {
		if (locationType.isBlank())
			throw new Exception("Given location is null");
		getListOfLocation().forEach(e -> {
			if (e.getText().trim().equalsIgnoreCase(locationType)) {
				e.click();
			}
		});
	}
}
