package Odevler;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class _05_Scroll_Robot extends BaseDriver {

    @Test
    public void Test1() {

/*
                Senaryo
        1- https://testsheepnz.github.io/BasicCalculator.html sitesine gidiniz.
        2- random 100 e kadar 2 sayı üretiniz.
        3- Sayıları hesap makinesinin bütün fonksiyonları için çalıştırınız.
        4- Sonuçları Assert ile kontrol ediniz.
        5- Yukarıdaki işlemi 5 kez tekrar ettiriniz.
*/
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        Random random = new Random();
        int i = random.nextInt(0,101);
        int j = random.nextInt(0,101);

        String iStr = Integer.toString(i);
        String jStr = Integer.toString(j);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstNumber = driver.findElement(By.id("number1Field"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", firstNumber);

        firstNumber.sendKeys(iStr);

        WebElement secondNumber = driver.findElement(By.id("number2Field"));
        secondNumber.sendKeys(jStr);

        WebElement islem = driver.findElement(By.id("selectOperationDropdown"));
        Select menu = new Select(islem);

        // toplama
        menu.selectByValue("0");
        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();

        WebElement answer = driver.findElement(By.id("numberAnswerField"));

        int dogruCevap = i+j;
        String dogruCevapStr = Integer.toString(dogruCevap);

        wait.until(ExpectedConditions.visibilityOf(answer));

       Assert.assertTrue("cevap dogru degil",dogruCevapStr.equals(answer.getAttribute("value")));

        //cikarma
        menu.selectByValue("1");
        calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();

        answer = driver.findElement(By.id("numberAnswerField"));

        dogruCevap = i-j;
        dogruCevapStr = Integer.toString(dogruCevap);

        wait.until(ExpectedConditions.visibilityOf(answer));

        Assert.assertTrue("cevap dogru degil",dogruCevapStr.equals(answer.getAttribute("value")));

        //carpma
        menu.selectByValue("2");
        calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();

        answer = driver.findElement(By.id("numberAnswerField"));

        dogruCevap = i*j;
        dogruCevapStr = Integer.toString(dogruCevap);

        wait.until(ExpectedConditions.visibilityOf(answer));

        Assert.assertTrue("cevap dogru degil",dogruCevapStr.equals(answer.getAttribute("value")));

        //bolme
        menu.selectByValue("3");
        calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();

        answer = driver.findElement(By.id("numberAnswerField"));

        dogruCevap = i/j;
        dogruCevapStr = Integer.toString(dogruCevap);

        WebElement integerClick = driver.findElement(By.id("integerSelect"));
        integerClick.click();
        Assert.assertTrue("cevap dogru degil",dogruCevapStr.equals(answer.getAttribute("value")));

        //concatinate

        menu.selectByValue("4");
        calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();

        answer = driver.findElement(By.id("numberAnswerField"));

        dogruCevapStr = iStr.concat(jStr);

        Assert.assertTrue("cevap dogru degil",dogruCevapStr.equals(answer.getAttribute("value")));
    }

    @Test
    public void Test2() {
    /*
                Senaryo
        1 - https://www.youtube.com/ adresine gidiniz
        2 - "Selenium" kelimesi ile video aratınız.
        3 - Listelenen sonuçlarda 80 videoaya kadar lsiteyi uzatınız.
        4 - Son videonun title ını yazdırınız.*/

       driver.get("https://www.youtube.com/");
       WebElement search = driver.findElement(By.cssSelector("[id='search'][name='search_query']"));
       search.sendKeys("Selenium");

       WebElement searchButton = driver.findElement(By.cssSelector("[id='search-icon-legacy']>yt-icon"));
       searchButton.click();

        wait.until(ExpectedConditions.urlContains("Selenium"));

        MyFunc.Bekle(2);
        List<WebElement> elements =  driver.findElements(By.cssSelector("h3[class*='style-scope']>[id='video-title']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;

       do {
           elements=driver.findElements(By.cssSelector("h3[class*='style-scope']>[id='video-title']"));
           js.executeScript("window.scrollBy(0,1000)");
       }while (elements.size()<80);

        for (WebElement e:elements) {
            System.out.println(e.getText());
        }
    }

    @Test
    public void Testdlete() {
        driver.get("https://www.youtube.com/");
        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("selenium");

        WebElement searchBtn = driver.findElement(By.cssSelector("[id='search-icon-legacy']"));
        searchBtn.click();

        wait.until(ExpectedConditions.urlContains("selenium"));
        List<WebElement> videoListeleri = driver.findElements(By.cssSelector("h3[class*='style-scope']>[id='video-title']"));
        for (WebElement e : videoListeleri) {
            System.out.println(e.getText());
        }
    }

    @Test
    public void Test3() throws AWTException {
       /*
                Senaryo
        1 - google.com ile sayfayı açınız.
        2 - Daha sonra Yeni bir TAB (ctrl + T) açınız.
        3 - Bu açılan yeni sayfada facebook.com u açınız.
        4 - Bu sayfanın açıldığını URL sinden kontrol ediniz.
        4 - Daha sonra facebook.com sayfasını kapatınız.*/

        driver.get("https://www.google.com.tr/");

        Robot robot=new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);

        StringSelection selection = new StringSelection("facebook.com");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Set<String> linkler = driver.getWindowHandles();

        for (String id:linkler) {
            driver.switchTo().window(id);
        }
        wait.until(ExpectedConditions.urlContains("facebook"));

        Assert.assertEquals(driver.getCurrentUrl(),"http://facebook.com/","yanlis url");
    }

    @Test
    public void Test4() {
       /*         Senaryo
        1) https://demoqa.com/browser-windows adresine gidin
        2) Alerts’e tiklayin
        3) On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
        4) Allert’in gorunur olmasini bekleyin
        5) Allert uzerindeki yazinin “This alert appeared after 5 seconds” oldugunu test edin
        6) Ok diyerek alerti kapatin*/

        driver.get("https://demoqa.com/browser-windows");

        WebElement alert = driver.findElement(By.xpath("(//li[@id='item-1'])[2]"));
        alert.click();

        WebElement clickme =driver.findElement(By.id("timerAlertButton"));
        clickme.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertTrue("alert yanlis",driver.switchTo().alert().getText().contains("5 seconds"));

        driver.switchTo().alert().accept();

    }

    @Test
    public void Test5() {

              /*  Senaryo

        1) https://demoqa.com/dynamic-properties adresine gidin
        2) “Will enable 5 seconds” butonunun enable olmasini bekleyin
        3) “Will enable 5 seconds” butonunun enable oldugunu test edin*/

        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));

        WebElement buton = driver.findElement(By.id("enableAfter"));
        wait.until(ExpectedConditions.elementToBeClickable(buton));

        Assert.assertTrue("sikinti var",buton.isEnabled());

    }

    @Test
    public void Test6() {

                /*Senaryo

        https://demoqa.com/dynamic-properties adresine gidin
        1) “Visible After 5 seconds” butonunun gorunur olmasini bekleyin
        2) “Visible After 5 seconds” butonunun gorunur oldugunu test edin*/

        driver.get("https://demoqa.com/dynamic-properties");

        WebElement visible = driver.findElement(By.id("visibleAfter"));
        wait.until(ExpectedConditions.visibilityOf(visible));
        Assert.assertTrue("mesaj gorunur",visible.isDisplayed());
    }

    @Test
    public void Test7() {

/*
        7-Senaryo

        https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        1) “Add Element” butona basin
        2) “Delete” butonu gorunur oluncaya kadar bekleyin
        3) “Delete” butonunun gorunur oldugunu test edin
        4) Delete butonuna basarak butonu silin
        5) Delete butonunun gorunmedigini test edin
*/

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement cl = driver.findElement(By.cssSelector("[onclick='addElement()']"));
        cl.click();

    }
}
