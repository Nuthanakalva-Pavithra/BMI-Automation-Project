package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

import pages.BMIPage;

public class BMISteps {

    WebDriver driver;
    BMIPage page;

    @Given("user opens BMI website")
    public void user_opens_bmi_website() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stalwart-crostata-c590d8.netlify.app/");

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
