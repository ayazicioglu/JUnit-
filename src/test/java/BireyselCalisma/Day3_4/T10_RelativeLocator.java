package BireyselCalisma.Day3_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class T10_RelativeLocator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        WebElement bayAreaElement= driver.findElement(By.id("pid8_thumb"));//sol
        WebElement sailorElement= driver.findElement(By.id("pid11_thumb"));//ust
        WebElement bostonElement= driver.findElement(By.id("pid6_thumb"));//sag

        //2 ) Berlin’i 3 farkli relative locator ile locate edin
        WebElement berlinElement1= driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(bayAreaElement));
        WebElement berlinElement2= driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailorElement));
        WebElement berlinElement3= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bostonElement));

        //3 ) Relative locator’larin dogru calistigini test edin
        String actualBerlin1=berlinElement1.getAttribute("id");
        String actualBerlin2=berlinElement2.getAttribute("id");
        String actualBerlin3=berlinElement3.getAttribute("id");
        String expectedBerlin=driver.findElement(By.id("pid7_thumb")).getAttribute("id");
        System.out.println("expectedBerlin = " + expectedBerlin);

        if (actualBerlin1.equals(expectedBerlin)){
            System.out.println("berlin1 element test PASSED");
        }else System.out.println("berlin1 element test FAILED");

        if (actualBerlin2.equals(expectedBerlin)){
            System.out.println("berlin2 element test PASSED");
        }else System.out.println("berlin2 element test FAILED");

        if (actualBerlin3.equals(expectedBerlin)){
            System.out.println("berlin3 element test PASSED");
        }else System.out.println("berlin3 element test FAILED");

        driver.close();
    }
}
