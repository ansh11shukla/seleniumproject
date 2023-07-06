package steps;

import org.openqa.selenium.WebDriver;

import demoqa.PracticeForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PracticeFormsteps {
	private WebDriver driver; 
		
	public PracticeFormsteps () {
		driver = Hooks.driver;
	}
	
	@Given("User is on registration page")
	public void user_is_on_registration_page() {
	PracticeForm.launchBroswer(driver);
	}

	@Given("Enter FirstName as {string} , LastName as {string} and Email as {string}")
	public void enter_first_name_as_last_name_as_and_email_as(String fname, String lname, String email) {
	PracticeForm.enterData(driver, fname , lname ,email);
	}

	@When("User click on gender as {string}")
	public void user_click_on_gender_as(String string) {
    PracticeForm.selectGender(driver);
	}

	@When("Enter Mobile number as {string}")
	public void enter_mobile_number_as(String pnum) {
	PracticeForm.enterMobile(driver, pnum);    
	}

	@When("User enters {string}, {string}, Date and {string}")
	public void user_enters_date_and(String sub, String hobbies, String adr) throws InterruptedException {
	PracticeForm.selectSubject(driver, sub);
	PracticeForm.selectHobbies(driver, hobbies);
	PracticeForm.selectDate(driver);
	PracticeForm.enterAddress(driver, adr);
	}

	@When("Upload the picture")
	public void upload_the_picture() throws InterruptedException {
	PracticeForm.uploadImage(driver);
	}

	@When("Select State as {string} and City as {string}")
	public void select_state_as_and_city_as(String state, String city) {
	PracticeForm.selectState(driver, state);
	PracticeForm.selectCity(driver, city);
	}

	@When("Click on Submit button")
	public void click_on_submit_button() {
	PracticeForm.clickSubmit(driver);
	}

	@Then("User should register successfully into the portal")
	public void user_should_register_successfully_into_the_portal() {
	PracticeForm.clickSubmit(driver);
	}

}
