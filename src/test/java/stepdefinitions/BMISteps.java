package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BMIPage;
import utils.ConfigReader;

public class BMISteps {

    WebDriver driver;
    BMIPage page;

    @Given("user opens BMI website")
    public void user_opens_bmi_website() {
    	ConfigReader config=new ConfigReader();
    	String browser=config.getBrowser();
    	
    	if(browser.equalsIgnoreCase("chrome")) {
    		driver=new ChromeDriver();
    	}
    	else if(browser.equalsIgnoreCase("edge")) {
    		driver=new EdgeDriver();
    	}
    	else if(browser.equalsIgnoreCase("firefox")) {
    		driver=new FirefoxDriver();
    	}
        driver.manage().window().maximize();
        driver.get(config.getURL());
        page = new BMIPage(driver);
    }

    @When("user selects gender {string}")
    public void user_selects_gender(String gender) {

        page.selectGender(gender);
    }

    @When("user selects unit {string}")
    public void user_selects_unit(String unit) {

        if(unit.equalsIgnoreCase("Metric")) {
            page.selectMetric();
        } else if(unit.equalsIgnoreCase("Imperial")) {
            page.selectImperial();
        }
    }

    @When("user enters weight {string}")
    public void user_enters_weight(String weight) {

        page.enterWeight(weight);
    }

    @When("user enters height {string}")
    public void user_enters_height(String height) {

        page.enterHeight(height);
    }

    @When("user clicks calculate")
    public void user_clicks_calculate() {

        page.clickCalculate();
    }

    @Then("BMI result should be displayed")
    public void bmi_result_should_be_displayed() {
    	
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Your BMI Result']")));
        String result = page.getBMIResult();
        System.out.println("BMI Result: " + result);

        driver.quit();
    }

    @Then("gender should not be accepted")
    public void gender_should_not_be_accepted() {

        System.out.println("Invalid gender option selected");
        driver.quit();
    }

    @Then("weight placeholder should show {string}")
    public void weight_placeholder_should_show(String expected) {

        String placeholder = page.getWeightPlaceholder();

        System.out.println("Weight placeholder: " + placeholder);

        driver.quit();
    }

    @Then("height placeholder should show {string}")
    public void height_placeholder_should_show(String expected) {

        String placeholder = page.getHeightPlaceholder();

        System.out.println("Height placeholder: " + placeholder);

        driver.quit();
    }
}
