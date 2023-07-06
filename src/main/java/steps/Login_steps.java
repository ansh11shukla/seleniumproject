package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_steps {
	
	@Given("User launches Chrome broswer {int} on window {int}")
	public void user_launches_chrome_broswer_on_window(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions

	}

	@Given("Enter URL {string}")
	public void enter_url(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Given("Login with email as {string} and password {string}")
	public void login_with_email_as_and_password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("User should login into the portal")
	public void user_should_login_into_the_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("User should land on the application screen")
	public void user_should_land_on_the_application_screen() {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

}
