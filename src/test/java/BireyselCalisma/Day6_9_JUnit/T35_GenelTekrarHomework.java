package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class T35_GenelTekrarHomework extends TestBase {
    @Test
    public void test01() {
        //Test01 :
        //1- amazon gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaWHD=driver.getWindowHandle();

        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownElement= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDownElement);
        List<WebElement> ddmList=select.getOptions();
        int sira=1;
        for (WebElement each:ddmList
             ) {
            System.out.println(sira+"- "+each.getText());
            sira++;
        }
        //3- dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertEquals(28,ddmList.size());



    //Test02
    //1- dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");

    //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone"+ Keys.ENTER);

    //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonucYaziElement=driver.findElement(By.xpath("//*[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String actualSonuc=sonucYaziElement.getText();
        String expectedIcerik="iphone";
        Assert.assertTrue(actualSonuc.contains(expectedIcerik));

    //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun=driver.findElement(By.xpath("(//img[@data-image-source-density='1'])[1]"));
        driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(ilkUrun)).click();

    //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        System.out.println(driver.findElement(By.xpath("//span[@class='a-color-price a-text-bold']")).getText());

        //Test03
    //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> tumWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:tumWHD
             ) {
            if (!ilkSayfaWHD.equals(each)){
                ikinciSayfaWHD=each;
            }
        }
        System.out.println("ilkSayfaWHD = " + ilkSayfaWHD);
        System.out.println("ikinciSayfaWHD = " + ikinciSayfaWHD);
        driver.switchTo().window(ikinciSayfaWHD);
        driver.get("https://www.amazon.com");

        //2-dropdown’dan bebek bölümüne secin
        bekle(3);
        WebElement dropDownElement2= driver.findElement(By.id("searchDropdownBox"));
        Select selectBaby=new Select(dropDownElement2);
        selectBaby.selectByVisibleText("Baby");

    //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement aramaKutusu2=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu2.sendKeys("bebek puset"+Keys.ENTER);
        WebElement sonucYaziElement2=driver.findElement(By.xpath("//*[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        System.out.println(sonucYaziElement2.getText());

        //4-sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(sonucYaziElement2.getText().contains("puset"));

    //5-ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrunElement=driver.findElement(By.xpath("//img[@data-image-index='1']"));
        driver.findElement(RelativeLocator.with(By.tagName("img")).below(ilkUrunElement)).click();

    //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String ikinciPusetTitle=driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String ikinciUrunFiyat=driver.findElement(By.xpath("//*[@class='a-section a-spacing-micro']")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();


    //Test 4
    //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın,
        driver.findElement(By.id("nav-cart-count-container")).click();
        String sepetTitle=driver.findElement(By.className("a-truncate-cut")).getText();
        String sepetFiyat=driver.findElement(By.className("sc-item-price-block")).getText();
        Assert.assertEquals(ikinciUrunFiyat,sepetFiyat);
        Assert.assertEquals(ikinciPusetTitle,sepetTitle);


    }
}
