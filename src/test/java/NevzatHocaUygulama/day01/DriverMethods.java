package NevzatHocaUygulama.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverMethods {

    WebDriver driver;
    String https="https://wwww.";

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to(https+"amazon.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        String amazonHandle=driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(https+"facebook.com");
        System.out.println(driver.getWindowHandles());
        driver.switchTo().window(amazonHandle);
        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    @After
    public void teardown(){
        driver.close();
        driver.quit();
    }

}
