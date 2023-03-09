package BireyselCalisma.Day3_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T08_RelativeXPath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
        WebElement addButtonElement= driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        addButtonElement.click();

        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButtonElement=driver.findElement(By.xpath("//*[@onclick='deleteElement()']"));
        if (deleteButtonElement.isDisplayed()){
            System.out.println("deleteButtonElement test PASSED");
        }else System.out.println("deleteButtonElement test FAILED");

        //4- Delete tusuna basin
        deleteButtonElement.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement=driver.findElement(By.tagName("h3"));
        if (addRemoveElement.isDisplayed()){
            System.out.println("addRemoveElement test PASSED");
        }else System.out.println("addRemoveElement test FAILED");
    }
}
