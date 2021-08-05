package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageElement.Gmail;

public class Gmail_stepdefs {
	
	Gmail screen = null;
	String id = "bdddummy@gmail.com";
	String pass = "BDD@dummy123";

	@Given("user is on the gmail website")
	public void user_is_on_the_gmail_website() throws Throwable {
		screen = new Gmail();
	}

	@When("user login to applicaton")
	public void user_login_to_applicaton() throws Throwable {
		screen.userLogin(id, pass);
	}

	@Then("verify the compose button is present")
	public void verify_the_compose_button_is_present() throws Throwable {
		screen.verifyComposeButtonPresent();
	}

	@When("user clicks compose button")
	public void user_clicks_compose_button() throws Throwable {
		screen.userLogin(id, pass);
		screen.clickComposeButton();
		screen.enterRecipients();
	}

	@And("user enters in subject {string}")
	public void user_enters_in_subject(String string) throws Throwable {
		screen.enterSubject(string);
	}

	@And("user enters in body {string}")
	public void user_enters_in_body(String string) throws Throwable {
		screen.enterBody(string);
	}

	@Then("on clicking send button pop up should be displayed with message {string}")
	public void on_clicking_send_button_pop_up_should_be_displayed_with_message(String string) throws Throwable {
		screen.clickSendButton();
		screen.verifyPopUpDisplayed(string);
	}

}
