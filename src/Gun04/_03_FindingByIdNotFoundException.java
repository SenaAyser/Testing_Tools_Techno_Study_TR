package Gun04;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _03_FindingByIdNotFoundException {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        WebDriver driver = new ChromeDriver(opt);

        driver.get("https://chromedriver.chromium.org/");

        try {
            WebElement element = driver.findElement(By.id("ismet"));
            System.out.println("element.getText() = " + element.getText());
        }
        catch(Exception ex){
            System.out.println("Eleman bulunmaadı = " + ex.getMessage());
        }

        MyFunc.Bekle(10);
        driver.quit();
    }
}
