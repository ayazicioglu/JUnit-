package TestCase1_RegisterUser;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_TestCase1RegisterUser extends TestBase {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and email address
    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    @Test
    public void test01(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePageElement=driver.findElement(By.xpath("//a[@style='color: orange;']"));
        Assert.assertTrue(homePageElement.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
       WebElement newUserElement= driver.findElement(By.xpath("(//h2)[3]"));
       Assert.assertTrue(newUserElement.isDisplayed());

        //6. Enter name and email address
        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        WebElement nameElement=driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        actions.click(nameElement).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).perform();
        bekle(3);

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInfElement=driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountInfElement.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender1")).click();
        actions.sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).sendKeys(Keys.TAB).
                sendKeys("12").sendKeys(Keys.TAB).
                sendKeys("March").sendKeys(Keys.TAB).
                sendKeys("1997").sendKeys(Keys.TAB).perform();
        bekle(3);

        //10. Select checkbox 'Sign up for our newsletter!'
       driver.findElement(By.xpath("//input[@name='newsletter']")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@name='optin']")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameElement=driver.findElement(By.id("first_name"));
        actions.click(firstNameElement).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).sendKeys(Keys.TAB).
                sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Canada").sendKeys(Keys.TAB).
                sendKeys(faker.address().state()).sendKeys(Keys.TAB).
                sendKeys(faker.address().city()).sendKeys(Keys.TAB).
                sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).perform();
            bekle(5);

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedElement=driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreatedElement.isDisplayed());
        bekle(2);

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        bekle(2);

        //16. Verify that 'Logged in as username' is visible
        driver.navigate().back();
        driver.navigate().forward();
        WebElement loggedAsElement=driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedAsElement.isDisplayed());

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedElement=driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue(accountDeletedElement.isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        bekle(2);


















    }
}
