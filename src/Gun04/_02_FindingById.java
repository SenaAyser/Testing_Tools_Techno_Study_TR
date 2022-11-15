package Gun04;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _02_FindingById {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        WebDriver driver = new ChromeDriver(opt);

        WebElement name= driver.findElement(By.id("first_8")); // elamanı bulma
        name.sendKeys("ismet"); // kutucuklara yazı gönderme

        WebElement surName= driver.findElement(By.id("last_8")); // elamanı bulma
        surName.sendKeys("temur"); // kutucuklara yazı gönderme

        WebElement labelFirstName= driver.findElement(By.id("sublabel_8_first"));
        System.out.println("labelFirstName.getText() = " + labelFirstName.getText());

        WebElement labelLastName = driver.findElement(By.id("sublabel_8_last"));
        System.out.println("labelLastName.getText() = " + labelLastName.getText());

        MyFunc.Bekle(10);
        driver.quit();
    }
}
