package pages;

import org.openqa.selenium.By;
import runner.RunCucumber;
import static support.Commands.*;

public class FactorialPage extends RunCucumber {

    // elementos
    private String URL = "https://qainterview.pythonanywhere.com/";
    public By pageTitle = By.cssSelector("body > div.container.toppy > div:nth-child(1) > div > h1");
    public By inputNumber = By.id("number");
    public By btnCalculate = By.id("getFactorial");
    public By anchorTermsofService = By.cssSelector("body > div.col-md-12 > div > p:nth-child(1) > a:nth-child(1)");
    public By anchorPrivacy = By.cssSelector("body > div.col-md-12 > div > p:nth-child(1) > a:nth-child(2)");
    public By resultCalc = By.cssSelector("#resultDiv");
    public By textafterAnchor = By.cssSelector("body");

    public void openApplication() {
        String browser = System.getProperty("browser");
        getDriver(browser).get(URL);
    }

    public void calculate() {
        clickElement(btnCalculate);
    }

}
