package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T34_KeyboardActions2 extends TestBase {
    @Test
    public void test01(){
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        WebElement altElement= driver.findElement(By.id("Powerful_but_easy_to_misuse"));
        Actions actions=new Actions(driver);
        actions.moveToElement(altElement).perform();

        //4- videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]")));
        actions.click(driver.findElement(By.xpath("//*[@aria-label='Oynat']"))).perform();

        //5- videoyu calistirdiginizi test edin
        WebElement playSaniyeElement= driver.findElement(By.xpath("//*[@class='ytp-time-display notranslate']"));
        Assert.assertTrue(playSaniyeElement.isDisplayed());
        bekle(2);
    }
}
