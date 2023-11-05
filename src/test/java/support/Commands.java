package support;

import cucumber.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

public class Commands extends RunCucumber {

    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void clickElement(By element) {
        System.out.println("##################################");
        try {
            System.out.println("Will click in the object: " + element);
            waitElementBeClickable(element, 10000);
            getDriver().findElement(element).click();
            System.out.println("Element clicked: " + element);
        } catch (Exception error){
            System.out.println("********** Error clicking the element: " + element);
            System.out.println(error);
        }
        System.out.println("##################################");
    }

    public static void fillField(By element, String value) {
        System.out.println("##################################");
        try {
            System.out.println("Will fill the field: " + element);
            waitElementBeVisible(element, 10000);
            getDriver().findElement(element).sendKeys(value);
            System.out.println("Field filled: " + element);
        } catch (Exception error){
            System.out.println("********** Error while filling the field: " + element);
            System.out.println(error);
        }
        System.out.println("##################################");
    }

    public static void checkMessage(By element, String expectedMessage) {
        String actualMessage = "";
        System.out.println("##################################");
        System.out.println("Will validate the message: " + expectedMessage);
        waitElementBeVisible(element, 10000);
        actualMessage = getDriver().findElement(element).getText();
        Assert.assertEquals("Error while validating messages:!", expectedMessage, actualMessage);

        System.out.println("Validated message: " + expectedMessage);
        System.out.println("##################################");
    }
    public static void addScreenshotOnScenario(Scenario scenario){
        System.out.println("Executed Test: "+scenario.getName());
        System.out.println("Status: "+scenario.getStatus());
        System.out.println("Tag: "+scenario.getSourceTagNames());
        System.out.println("ID: "+scenario.getId());
        byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot,"image/png");


    }
}
