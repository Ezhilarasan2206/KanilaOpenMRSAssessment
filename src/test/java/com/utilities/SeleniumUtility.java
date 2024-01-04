package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtility {

	public static WebDriver driver;

	public static void launchBrowser(String browser) throws Throwable {
		switch (browser.toUpperCase()) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;
		case "FIREFOX":
			driver = new EdgeDriver();
			break;
		default:
			throw new Exception("Given browser name " + browser + " is not in the case");
		}
	}

	public static void openApp(String url) throws Throwable {
		if (url.isEmpty() || url.isBlank())
			throw new Exception("Given url is null: " + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(getProperty("Timeout", "System"))));
	}

	public static void enterText(WebElement ele, String name) {
		ele.sendKeys(name);
	}

	public static void enterTextUsingJS(WebElement ele, String attribute, String name) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('" + attribute + "','" + name + "')", ele);
	}

	public static void clickButton(WebElement ele) {
		ele.click();
	}

	public static String getProperty(String key, String dataType) throws Throwable, IOException {
		Properties p = new Properties();
		if (dataType.equals("System")) {
			p.load(new FileInputStream(new File(System.getProperty("user.dir") + "//config/System.property")));
		} else {
			p.load(new FileInputStream(new File(System.getProperty("user.dir") + "//TestData/Data.property")));
		}
		return p.getProperty(key);
	}

	public static void dropdownSelect(WebElement e, String name) {
		(new Select(e)).selectByVisibleText(name);
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static String screenShot() throws IOException {
		String x = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
				new File(System.getProperty("user.dir") + "//ScreenShot//" + x + ".png"));
		return x + ".png";
	}

	public static void scrollDown(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", ele);
	}
}
