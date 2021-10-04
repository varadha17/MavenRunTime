package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public Properties prop;

    public void setUp() throws IOException {
        String browser = setProperties().getProperty("browser");
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://ui.cogmento.com/");
    }

    public void setUserCredentialsAtRunTime() throws IOException {
        driver.findElement(By.name("email")).sendKeys(setProperties().getProperty("uName"));
        driver.findElement(By.name("password")).sendKeys(setProperties().getProperty("pwd"));
    }

    public Properties setProperties() throws IOException {
        prop = new Properties();
        prop.load(BaseTest.class.getClassLoader().getResourceAsStream("runTime.properties"));
        return prop;
    }
}
