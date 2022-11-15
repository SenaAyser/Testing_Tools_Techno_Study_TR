package Gun09;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _01_ElemaninStatusu extends BaseDriver {
    public static void main(String[] args) {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        WebElement sali = driver.findElement(By.id("gwt-debug-cwCheckBox-Tuesday-input"));

        System.out.println("sali.isDisplayed() = " + sali.isDisplayed());
        System.out.println("sali.isEnabled() = " + sali.isEnabled());
        System.out.println("sali.isSelected() = " + sali.isSelected());

        MyFunc.Bekle(2);
        sali.click();

        System.out.println("sali.isSelected() = " + sali.isSelected());
    }
}
