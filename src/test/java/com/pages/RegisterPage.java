package com.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.SeleniumUtility;

public class RegisterPage extends SeleniumUtility{
	static ExtentTest test;
	
	@FindBy(xpath = "//input[@name='givenName']")
	private WebElement givenName;
	
	@FindBy(xpath = "//input[@name='middleName']")
	private WebElement middleName;
	
	@FindBy(xpath = "//input[@name='familyName']")
	private WebElement lastName;
	
	@FindBy(xpath = "(//li[@class='question-legend'])[1]")
	private WebElement btnGender;
	
	@FindBy(xpath = "//option[text()='Male']")
	private WebElement btnMale;
	
	@FindBy(xpath = "//span[text()='Birthdate']")
	private WebElement btnBirthDate;
	
	@FindBy(xpath = "//input[@name='birthdateDay']")
	private WebElement txtDate;

	@FindBy(xpath = "//select[@name='birthdateMonth']")
	private WebElement drpdwnMonth;
	
	@FindBy(xpath = "//input[@name='birthdateYear']")
	private WebElement txtYear;
	
	@FindBy(xpath = "//span[text()='Address']")
	private WebElement btnAddr;
	
	@FindBy(xpath = "//input[@id='address1']")
	private WebElement txtAddr1;
	
	@FindBy(xpath = "//input[@id='address2']")
	private WebElement txtAddr2;
	
	@FindBy(xpath = "//input[@id='cityVillage']")
	private WebElement txtCity;
	
	@FindBy(xpath = "//input[@id='stateProvince']")
	private WebElement txtState;
	
	@FindBy(xpath = "//input[@id='country']")
	private WebElement txtCountry;	
	
	@FindBy(xpath = "//input[@id='postalCode']")
	private WebElement txtPostalCode;
	
	@FindBy(xpath = "//span[text()='Phone Number']")
	private WebElement btnPhoneNum;
	
	@FindBy(xpath = "//input[@name='phoneNumber']")
	private WebElement txtPhoneNum;
	
	@FindBy(xpath = "//span[text()='Relatives']")
	private WebElement btnRelatives;
	
	@FindBy(xpath = "//span[@id='confirmation_label']")
	private WebElement btnConfirm;
	
	@FindBy(xpath = "//span[text()='Name: ']//parent::p")
	private WebElement verifyName;
	
	@FindBy(xpath = "//span[text()='Gender: ']//parent::p")
	private WebElement verifyGender;
	
	@FindBy(xpath = "//span[text()='Birthdate: ']//parent::p")
	private WebElement verifyBirthDate;
	
	@FindBy(xpath = "//span[text()='Address: ']//parent::p")
	private WebElement verifyAddrs;
	
	@FindBy(xpath = "//span[text()='Phone Number: ']//parent::p")
	private WebElement verifyPhoneNum;
	
	@FindBy(xpath = "//input[@id='submit']")
	private WebElement btnConfirm2;

	@FindBy(xpath = "//div[@id='dataCanvas']/div/p")
	private List<WebElement> listOfDetailsInConfirmSection;
	
	public WebElement getGivenName() {
		return givenName;
	}

	public void setGivenName(WebElement givenName) {
		this.givenName = givenName;
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public void setMiddleName(WebElement middleName) {
		this.middleName = middleName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public void setLastName(WebElement lastName) {
		this.lastName = lastName;
	}

	public WebElement getBtnGender() {
		return btnGender;
	}

	public void setBtnGender(WebElement btnGender) {
		this.btnGender = btnGender;
	}

	public WebElement getBtnMale() {
		return btnMale;
	}

	public void setBtnMale(WebElement btnMale) {
		this.btnMale = btnMale;
	}

	public WebElement getBtnBirthDate() {
		return btnBirthDate;
	}

	public void setBtnBirthDate(WebElement btnBirthDate) {
		this.btnBirthDate = btnBirthDate;
	}

	public WebElement getTxtDate() {
		return txtDate;
	}

	public void setTxtDate(WebElement txtDate) {
		this.txtDate = txtDate;
	}

	public WebElement getDrpdwnMonth() {
		return drpdwnMonth;
	}

	public void setDrpdwnMonth(WebElement drpdwnMonth) {
		this.drpdwnMonth = drpdwnMonth;
	}

	public WebElement getTxtYear() {
		return txtYear;
	}

	public void setTxtYear(WebElement txtYear) {
		this.txtYear = txtYear;
	}

	public WebElement getBtnAddr() {
		return btnAddr;
	}

	public void setBtnAddr(WebElement btnAddr) {
		this.btnAddr = btnAddr;
	}

	public WebElement getTxtAddr1() {
		return txtAddr1;
	}

	public void setTxtAddr1(WebElement txtAddr1) {
		this.txtAddr1 = txtAddr1;
	}

	public WebElement getBtnAddr2() {
		return txtAddr2;
	}

	public void setBtnAddr2(WebElement btnAddr2) {
		this.txtAddr2 = btnAddr2;
	}

	public WebElement getTxtCity() {
		return txtCity;
	}

	public void setTxtCity(WebElement txtCity) {
		this.txtCity = txtCity;
	}

	public WebElement getTxtState() {
		return txtState;
	}

	public void setTxtState(WebElement txtState) {
		this.txtState = txtState;
	}

	public WebElement getTxtCountry() {
		return txtCountry;
	}

	public void setTxtCountry(WebElement txtCountry) {
		this.txtCountry = txtCountry;
	}

	public WebElement getTxtPostalCode() {
		return txtPostalCode;
	}

	public void setTxtPostalCode(WebElement txtPostalCode) {
		this.txtPostalCode = txtPostalCode;
	}

	public WebElement getBtnPhoneNum() {
		return btnPhoneNum;
	}

	public void setBtnPhoneNum(WebElement btnPhoneNum) {
		this.btnPhoneNum = btnPhoneNum;
	}

	public WebElement getTxtPhoneNum() {
		return txtPhoneNum;
	}

	public void setTxtPhoneNum(WebElement txtPhoneNum) {
		this.txtPhoneNum = txtPhoneNum;
	}

	public WebElement getBtnRelatives() {
		return btnRelatives;
	}

	public void setBtnRelatives(WebElement btnRelatives) {
		this.btnRelatives = btnRelatives;
	}

	public WebElement getBtnConfirm() {
		return btnConfirm;
	}

	public void setBtnConfirm(WebElement btnConfirm) {
		this.btnConfirm = btnConfirm;
	}

	public WebElement getVerifyName() {
		return verifyName;
	}

	public void setVerifyName(WebElement verifyName) {
		this.verifyName = verifyName;
	}

	public WebElement getVerifyGender() {
		return verifyGender;
	}

	public void setVerifyGender(WebElement verifyGender) {
		this.verifyGender = verifyGender;
	}

	public WebElement getVerifyBirthDate() {
		return verifyBirthDate;
	}

	public void setVerifyBirthDate(WebElement verifyBirthDate) {
		this.verifyBirthDate = verifyBirthDate;
	}

	public WebElement getVerifyAddrs() {
		return verifyAddrs;
	}

	public void setVerifyAddrs(WebElement verifyAddrs) {
		this.verifyAddrs = verifyAddrs;
	}

	public WebElement getVerifyPhoneNum() {
		return verifyPhoneNum;
	}

	public void setVerifyPhoneNum(WebElement verifyPhoneNum) {
		this.verifyPhoneNum = verifyPhoneNum;
	}

	public WebElement getBtnConfirm2() {
		return btnConfirm2;
	}

	public void setBtnConfirm2(WebElement btnConfirm2) {
		this.btnConfirm2 = btnConfirm2;
	}
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public RegisterPage NavigateToRegisterAPatient() {
		
		return this;
	}
	
	public RegisterPage ProvideDemographicDetals() throws IOException, Throwable {
		enterText(getGivenName(), getProperty("FirstName", "Data"));
		enterText(getLastName(), getProperty("Lastname", "Data"));
		clickButton(getBtnGender());
		clickButton(getBtnMale());
		clickButton(getBtnBirthDate());
		enterText(getTxtDate(), getProperty("Date", "Data"));
		dropdownSelect(getDrpdwnMonth(), getProperty("Month", "Data"));
		enterText(getTxtYear(), getProperty("Year", "Data"));
		clickButton(getBtnAddr());
		enterText(getTxtAddr1(), getProperty("Address", "Data"));
		enterText(getBtnAddr2(), getProperty("Address1", "Data"));
		clickButton(getBtnPhoneNum());
		enterText(getTxtPhoneNum(), getProperty("Phone", "Data"));
		clickButton(getBtnRelatives());
		
		return this;
	}
	
	public RegisterPage clickConfirmOption() {
		clickButton(getBtnConfirm());
		return this;
	}

	public void VerifyUserDetailsInConfirmPage() throws IOException, Throwable {
		List<String> expectedList = new ArrayList<String>();
		expectedList.add(getProperty("FirstName", "Data")+", "+ getProperty("Lastname", "Data"));
		expectedList.add("Male");
		expectedList.add(getProperty("Date", "Data")+", "+ getProperty("Month", "Data")+", "+getProperty("Year", "Data"));
		expectedList.add(getProperty("Address", "Data")+", "+ getProperty("Address1", "Data"));
		expectedList.add(getProperty("Phone", "Data"));
		int count = 0;
		List<String> act = new ArrayList<String>();
		if(listOfDetailsInConfirmSection.size()>0) {
			for(WebElement ele : listOfDetailsInConfirmSection) {
				if(expectedList.contains(ele.getText().trim())) {
					count++;
				}else {
					act.add(ele.getText().trim());
				}
			}
			Assert.assertTrue(count==expectedList.size(), "Expected adn Actul list are not met.\nExpected:" +expectedList.toString() +"\nActual List: "+ act.toString());
			if(count == expectedList.size()) {
				test.log(LogStatus.PASS, "Given values are availebel in teh Actual list");
			}
		}
	}
}
