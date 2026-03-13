package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BMIPage {

    WebDriver driver;

    public BMIPage(WebDriver driver) {
        this.driver = driver;
    }

    // Gender dropdown
    By genderDropdown = By.id("selectGender");

    // Metric and Imperial radio buttons
    By metricRadio = By.xpath("//input[@value='metric']");
    By imperialRadio = By.xpath("//input[@value='imperial']");//imperial

    // Weight and Height input fields
    By weightField = By.xpath("//input[@id='inputWeight']");
    By heightField = By.xpath("//input[@id='inputHeight']");

    // Calculate button
    By calculateButton = By.xpath("//button[normalize-space()='Calculate My BMI']");

    // Result section
    By resultBox = By.xpath("//p[@id='textBeforeResult']");

    // Methods

    public void selectGender(String gender) {
        driver.findElement(genderDropdown).sendKeys(gender);
    }

    public void selectMetric() {
        driver.findElement(metricRadio).click();
    }

    public void selectImperial() {
        driver.findElement(imperialRadio).click();
    }

    public void enterWeight(String weight) {
        driver.findElement(weightField).clear();
        driver.findElement(weightField).sendKeys(weight);
    }

    public void enterHeight(String height) {
        driver.findElement(heightField).clear();
        driver.findElement(heightField).sendKeys(height);
    }

    public void clickCalculate() {
        driver.findElement(calculateButton).click();
    }

    public String getBMIResult() {
        return driver.findElement(resultBox).getText();
    }

    public String getWeightPlaceholder() {
        return driver.findElement(weightField).getAttribute("placeholder");
    }

    public String getHeightPlaceholder() {
        return driver.findElement(heightField).getAttribute("placeholder");
    }
}
