package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class RunBase {

    static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriver getDriver(String browser) {

        if (driver !=  null) {
            driver.quit();
        }

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "chrome-ci":
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--headless");
                driver = new ChromeDriver(option);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not found.");
        }

        if(driver != null){
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        }

        return driver;
    }

}
