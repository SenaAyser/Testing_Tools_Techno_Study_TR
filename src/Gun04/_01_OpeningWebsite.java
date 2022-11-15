package Gun04;

import Utility.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _01_OpeningWebsite {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        ChromeOptions opt = new ChromeOptions();

        opt.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

        WebDriver driver = new ChromeDriver(opt);

        driver.get("https://www.google.com/search?q=WARNING:+Unable+to+find+an+exact+match+for+CDP+version+107,+so+returning+the+closest+version+found:+106&sxsrf=ALiCzsaYjpAc7qJ-wXkLlYbemEG9zPxqmw:1667076787950&source=lnms&tbm=vid&sa=X&ved=2ahUKEwjs2oj-qIb7AhWhXfEDHdiaCC8Q_AUoA3oECAEQBQ&biw=1536&bih=796&dpr=1.25");

        MyFunc.Bekle(2);

        driver.quit();
    }
}
