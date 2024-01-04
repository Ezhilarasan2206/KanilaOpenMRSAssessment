package com.pages;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.SeleniumUtility;

public class PatientDetailsPage extends SeleniumUtility {
	static ExtentTest test;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	@FindBy(xpath = "//div[contains(text(), 'Start Visit')]")
	private WebElement btnstartVisit;

	@FindBy(xpath = "//button[@id='start-visit-with-visittype-confirm']")
	private WebElement btnStartVisitConfirm;

	@FindBy(xpath = "//a[@id='attachments.attachments.visitActions.default']")
	private WebElement btnAttachment;

	@FindBy(xpath = "//textarea[@placeholder='Enter a caption']")
	private WebElement txtCaption;

	@FindBy(xpath = "//button[text()='Upload file']")
	private WebElement btnUpload;

	@FindBy(xpath = "//*[text()='The attachment was successfully uploaded.']")
	private WebElement verifySuccessfulMessage;

	@FindBy(xpath = "//div[@ng-if='active']")
	private WebElement verifyAttachment;

	@FindBy(xpath = "//div[text()='Attachment Upload']//preceding-sibling::a")
	private WebElement verifyLastEntry;

	@FindBy(xpath = "(//div[contains(text(),'End Visit')])[2]")
	private WebElement btnEndVisit;

	@FindBy(xpath = "(//button[text()='Yes'])[2]")
	private WebElement btnConfirmEndVisit;

	@FindBy(xpath = "//a[@id='org.openmrs.module.coreapps.deletePatient']")
	private WebElement btnDeletepatient;

	@FindBy(xpath = "//input[@id='delete-reason']")
	private WebElement txtReasonForDelete;

	@FindBy(xpath = "(//button[text()='Confirm'])[4]")
	private WebElement btnConfirmReason;

	@FindBy(xpath = "//*[text()='Patient has been deleted successfully']")
	private WebElement verifyDeleteMessage;

	@FindBy(xpath = "//em[text() = 'Patient ID']/following-sibling::span")
	private WebElement patientId;

	@FindBy(className = "gender-age col-auto")
	private WebElement genderAndYearsOfAgeText;

	public WebElement getBtnstartVisit() {
		return btnstartVisit;
	}

	public void setBtnstartVisit(WebElement btnstartVisit) {
		this.btnstartVisit = btnstartVisit;
	}

	public WebElement getBtnStartVisitConfirm() {
		return btnStartVisitConfirm;
	}

	public void setBtnStartVisitConfirm(WebElement btnStartVisitConfirm) {
		this.btnStartVisitConfirm = btnStartVisitConfirm;
	}

	public WebElement getBtnAttachment() {
		return btnAttachment;
	}

	public void setBtnAttachment(WebElement btnAttachment) {
		this.btnAttachment = btnAttachment;
	}

	public WebElement getTxtCaption() {
		return txtCaption;
	}

	public void setTxtCaption(WebElement txtCaption) {
		this.txtCaption = txtCaption;
	}

	public WebElement getBtnUpload() {
		return btnUpload;
	}

	public void setBtnUpload(WebElement btnUpload) {
		this.btnUpload = btnUpload;
	}

	public WebElement getVerifySuccessfulMessage() {
		return verifySuccessfulMessage;
	}

	public void setVerifySuccessfulMessage(WebElement verifySuccessfulMessage) {
		this.verifySuccessfulMessage = verifySuccessfulMessage;
	}

	public WebElement getVerifyAttachment() {
		return verifyAttachment;
	}

	public void setVerifyAttachment(WebElement verifyAttachment) {
		this.verifyAttachment = verifyAttachment;
	}

	public WebElement getVerifyLastEntry() {
		return verifyLastEntry;
	}

	public void setVerifyLastEntry(WebElement verifyLastEntry) {
		this.verifyLastEntry = verifyLastEntry;
	}

	public WebElement getBtnEndVisit() {
		return btnEndVisit;
	}

	public void setBtnEndVisit(WebElement btnEndVisit) {
		this.btnEndVisit = btnEndVisit;
	}

	public WebElement getBtnConfirmEndVisit() {
		return btnConfirmEndVisit;
	}

	public void setBtnConfirmEndVisit(WebElement btnConfirmEndVisit) {
		this.btnConfirmEndVisit = btnConfirmEndVisit;
	}

	public WebElement getBtnDeletepatient() {
		return btnDeletepatient;
	}

	public void setBtnDeletepatient(WebElement btnDeletepatient) {
		this.btnDeletepatient = btnDeletepatient;
	}

	public WebElement getTxtReasonForDelete() {
		return txtReasonForDelete;
	}

	public void setTxtReasonForDelete(WebElement txtReasonForDelete) {
		this.txtReasonForDelete = txtReasonForDelete;
	}

	public WebElement getBtnConfirmReason() {
		return btnConfirmReason;
	}

	public void setBtnConfirmReason(WebElement btnConfirmReason) {
		this.btnConfirmReason = btnConfirmReason;
	}

	public WebElement getVerifyDeleteMessage() {
		return verifyDeleteMessage;
	}

	public void setVerifyDeleteMessage(WebElement verifyDeleteMessage) {
		this.verifyDeleteMessage = verifyDeleteMessage;
	}

	public PatientDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public PatientDetailsPage VerifyThePatientDetailsAfterConfirmation() throws ParseException, IOException, Throwable {
		Assert.assertTrue(patientId.getText().length()>1);
		test.log(LogStatus.INFO, "Patient Id: "+patientId.getText());
		String expectedStartDate = getProperty("Year", "Data")+"-"+ getProperty("Month", "Data")+"-"+getProperty("Date", "Data");
		SimpleDateFormat format = new SimpleDateFormat("dd.MMM.yyyy");
		LocalDate date1 = LocalDate.parse(expectedStartDate);
		LocalDate date2 = LocalDate.now();
		Period period = date1.until(date2);
		Assert.assertEquals(genderAndYearsOfAgeText.getText().trim(), period.getYears()+" year(s) ( "+format.parse(expectedStartDate)+" )");
		return this;
	}
	
	public void ClickStartVisitAndConfirmTheVisit() {
		clickButton(btnstartVisit);
		clickButton(btnConfirmEndVisit);
	}
	
	public PatientDetailsPage ClickAttachmentAndUploadTheFile() {
		wait.until(ExpectedConditions.elementToBeClickable(btnAttachment));
		btnAttachment.click();
		wait.until(ExpectedConditions.elementToBeClickable(txtCaption));
		txtCaption.sendKeys("File Upload");
		return this;
	}
}
