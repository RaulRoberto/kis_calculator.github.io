package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.FactorialPage;
import runner.RunCucumber;

import static support.Commands.*;

public class FactorialSteps extends RunCucumber {

    FactorialPage FactorialPage = new FactorialPage();


    @Given("^the user access the application$")
    public void the_user_access_the_application()  {
        FactorialPage.openApplication();

    }

    @Then("^the Title is correctly shown$")
    public void the_Title_is_correctly_shown() {

        Assert.assertEquals("The greatest factorial calculator!",FactorialPage.pageTitle);

    }

    @Then("^the Tab Name is correctly shown$")
    public void the_Tab_Name_is_correctly_shown() {
        String title = getDriver().getTitle();
        Assert.assertEquals("The greatest factorial calculator!",title);

    }

    @When("^Click in the Terms of Service link$")
    public void click_in_the_Terms_of_Service_link() {
        clickElement(FactorialPage.anchorTermsofService);

    }

    @Then("^the user will redirect to Terms of Service page$")
    public void the_user_will_redirect_to_Terms_of_Service_page() {
        checkMessage(FactorialPage.textafterAnchor,"This is the terms and conditions document. We are not yet ready with it. Stay tuned!");

    }

    @When("^Click in the Privacy link$")
    public void click_in_the_Privacy_link()  {
        clickElement(FactorialPage.anchorPrivacy);
    }


    @Then("^the user will redirect to Privacy page$")
    public void the_user_will_redirect_to_Privacy_page(){
        checkMessage(FactorialPage.textafterAnchor,"This is the privacy document. We are not yet ready with it. Stay tuned!");
    }

    @Given("^enter with a$")
    public void enter_with_a(){
        fillField(FactorialPage.inputNumber,"a");

    }

    @When("^click to calculate$")
    public void click_to_calculate() {
        FactorialPage.calculate();

    }

    @Then("^the answer is \"([^\"]*)\"$")
    public void the_answer_is(String arg1) throws InterruptedException {
        Thread.sleep(2000);
        checkMessage(FactorialPage.resultCalc,arg1);

    }

    @Given("^enter with @$")
    public void enter_with()  {
        fillField(FactorialPage.inputNumber,"@");

    }

    @Given("^enter with (\\d+)$")
    public void enter_with(int arg1) {
        fillField(FactorialPage.inputNumber, String.valueOf(arg1));

    }
    @After
    public void addScreenshot(Scenario scenario){ addScreenshotOnScenario(scenario);}



}
