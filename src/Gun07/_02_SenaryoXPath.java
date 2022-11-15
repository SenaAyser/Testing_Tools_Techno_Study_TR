package Gun07;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _02_SenaryoXPath extends BaseDriver {
    //        (//*[@class='input_error form_input'])[1]
//         //*[@placeholder='Username']
//        //*[text()='Accepted usernames are:']
//
//        //*[text()='Accepted usernames are:']/..

    //WebElement element=driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div[1]/input"));
    //uzun path oldugundan kullanışsız hem yazım zorluğu ve hem de yolun bozulma ihtimali çok yüksek : ABSOLUTE XPATH

    //WebElement element=driver.findElement(By.xpath("//input[@id='user-name']" )); // Relative XPath

    @Test
    public void Test1() {

        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");


        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");


        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        //1.urun
        WebElement backPackElement = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        backPackElement.click();

        WebElement addToCard = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCard.click();

        WebElement back = driver.findElement(By.xpath("//button[text()='Back to products']"));
        back.click();

        //2.urun
        WebElement boltTshirtTextElement = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        boltTshirtTextElement.click();

        WebElement addToCard2 = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCard2.click();

        //sepete tiklattik
        WebElement sepet = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();

        WebElement checkOut = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkOut.click();

        //bilgi girisi
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys("Sena");

        WebElement secondName = driver.findElement(By.xpath("//input[@id='last-name']"));
        secondName.sendKeys("Burak");

        WebElement zip = driver.findElement(By.xpath("//input[@id='postal-code']"));
        zip.sendKeys("12354");

        WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton.click();

        //urun ucretleri
        List<WebElement> sepettekiler = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        double toplam=0;
        for (WebElement element:sepettekiler) {
            toplam+=Double.parseDouble(element.getText().substring(1)); // [$].""  veya  replace("$","")
        }
        System.out.println("toplam = " + toplam);

        WebElement webAltToplam = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        System.out.println("webAltToplam = " + webAltToplam.getText());

        double altToplam = Double.parseDouble(webAltToplam.getText().substring(13));
        System.out.println("altToplam = " + altToplam);

        Assert.assertTrue("DEGERLER ESIT DEGIL",(toplam==altToplam));

        driverBekleKapat();
    }
}
