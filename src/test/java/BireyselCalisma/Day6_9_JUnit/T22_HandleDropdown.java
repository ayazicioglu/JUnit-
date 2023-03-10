package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class T22_HandleDropdown extends TestBase {
    @Test
    public void test01(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        WebElement signinElement= driver.findElement(By.id("signin_button"));
        signinElement.click();

        //3. Login kutusuna “username” yazin
        WebElement loginElement= driver.findElement(By.id("user_login"));
        loginElement.sendKeys("username");

        //4. Password kutusuna “password” yazin
        WebElement passwordElement= driver.findElement(By.id("user_password"));
        passwordElement.sendKeys("password");

        //5. Sign in tusuna basin
        WebElement signSubmitElement=driver.findElement(By.xpath("//input[@name='submit']"));
        signSubmitElement.click();
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        WebElement onlineBankingMenuElement=driver.findElement(By.id("onlineBankingMenu"));
        onlineBankingMenuElement.click();
        WebElement payBillElement=driver.findElement(By.id("pay_bills_link"));
        payBillElement.click();

        //7. “Purchase Foreign Currency” tusuna basin
        WebElement purchaseForeignCurrencyElement=driver.findElement(By.linkText("Purchase Foreign Currency"));
        purchaseForeignCurrencyElement.click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropElement=driver.findElement(By.id("pc_currency"));
        Select select=new Select(dropElement);
        select.selectByVisibleText("Eurozone (euro)");

        //9. “amount” kutusuna bir sayi girin
        WebElement amountElement=driver.findElement(By.id("pc_amount"));
        amountElement.sendKeys("20");

        //10. “US Dollars” in secilmedigini test edin
        WebElement dollarElement=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(dollarElement.isSelected());

        //11. “Selected currency” butonunu secin
        WebElement currencyElement=driver.findElement(By.id("pc_inDollars_false"));
        currencyElement.click();

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        WebElement calculateElement=driver.findElement(By.id("pc_calculate_costs"));
        calculateElement.click();
        WebElement purchaseElement=driver.findElement(By.id("purchase_cash"));
        purchaseElement.click();

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement alertElement=driver.findElement(By.id("alert_content"));
        String actualAlert=alertElement.getText();
        String exp="Foreign currency cash was successfully purchased.";
        Assert.assertEquals(exp,actualAlert);
        bekle(2);
    }
}
