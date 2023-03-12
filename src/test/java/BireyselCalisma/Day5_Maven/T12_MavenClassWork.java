package BireyselCalisma.Day5_Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T12_MavenClassWork {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        WebElement signinElement= driver.findElement(By.id("signin_button"));
        signinElement.click();

        //3. Login alanine “username” yazdirin
        WebElement loginElement= driver.findElement(By.id("user_login"));
        loginElement.sendKeys("username");

        //4. Password alanine “password” yazdirin
        WebElement passwordElement= driver.findElement(By.id("user_password"));
        passwordElement.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        WebElement girisElement=driver.findElement(By.xpath("//*[@value='Sign in']"));
        girisElement.click();
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        WebElement payBillsElement=driver.findElement(By.id("pay_bills_link"));
        payBillsElement.click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountElement=driver.findElement(By.id("sp_amount"));
        amountElement.sendKeys("1"+Keys.ENTER);

        //8. tarih kismina “2020-09-10” yazdirin
        WebElement dateElement=driver.findElement(By.id("sp_date"));
        dateElement.sendKeys("2020-09-10"+Keys.ENTER);

        //9. Pay buttonuna tiklayin
        WebElement payButtonElement=driver.findElement(By.id("pay_saved_payees"));
        payButtonElement.click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement messageElement=driver.findElement(By.id("alert_content"));
        if (messageElement.isDisplayed()){
            System.out.println("Message test PASSED");
        }else System.out.println("Message test FAILED");

        driver.close();
    }
}
