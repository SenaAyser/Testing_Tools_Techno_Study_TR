package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;

    public static WebDriverWait wait;

    static {

        Logger logger = Logger.getLogger("");  // Sistem ait buyun loglari ureten objeye/servise e ulastim "" sayesinde
        logger.setLevel(Level.SEVERE);               // Sadece errorlari gosterir SERVE sayesinde

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // Chrome Driver Output Proerty leri susturdu sadece Error verirse bir sey yazacak
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        ChromeOptions opt = new ChromeOptions();      // web sayfasini kontrol eden gorevli

        opt.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

        driver = new ChromeDriver(opt);


        driver.manage().window().maximize();  // Ekranı max yapıyor.
        driver.manage().deleteAllCookies();  // sitenin senin bilgisayarında yaptığı ayarlar siliniyor, sayfa başlangıç ayarlarına dönüyor

        //
        Duration dr= Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr); // Sadece tüm sayfanın kodlarının bilgisyarınıza inmesi süresiyle ilgili
        //bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.: 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
        // eğer 2 sn yüklerse 30 sn. beklmez.

        driver.manage().timeouts().implicitlyWait(dr); // Bütün weblementlerin element bazında, elemente özel işlem yapılmadan önce
        // hazır hale gelmesi verilen mühlet yani süre.

        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
    }

    public static void driverBekleKapat() {
        MyFunc.Bekle(10);
        driver.quit();
    }
}
