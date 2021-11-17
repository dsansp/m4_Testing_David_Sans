package com.example.m4_Testing_David_Sans;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class DemoBlaze {
// https://www.demoblaze.com/index.html

    // Navegador
    WebDriver driver;

    @BeforeEach
    void setUp() {
        String dir = System.getProperty("user.dir"); // ruta del proyecto
        String driverUrl = "/drivers/chromedriver.exe";
        String url = dir + driverUrl;
        System.setProperty("webdriver.chrome.driver", url);
        driver = new ChromeDriver(); // Google Chrome
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void findPhoneLumiaTest() {
        // Abrir página web
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");

        //clickar sobre phones
        driver.findElement(By.cssSelector("html body div#contcont.container div.row div.col-lg-3 div.list-group a#itemc.list-group-item")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/h4/a")));

        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/h4/a")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")));
        assertEquals("The Nokia Lumia 1520 is powered by 2.2GHz quad-core Qualcomm Snapdragon 800 processor and it comes with 2GB of RAM.", driver.findElement(By.cssSelector("html body div.product-content.product-wrap.clearfix.product-deatil div.row div#tbodyid.col-md-7.col-sm-12.col-xs-12 div.description.description-tabs div#myTabContent.tab-content div#more-information.tab-pane.fade.active.in p")).getText());
        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")).getAttribute("innerHTML");
      //  driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")).click();

        // Verificar que ha sido añadido al carro

     /*   driver.findElement(By.cssSelector("html body nav.navbar.navbar-toggleable-md.bg-inverse div.container div#navbarExample.navbar-collapse ul.navbar-nav.ml-auto li.nav-item a.nav-link")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div[2]/button")));
     assertEquals(820,driver.findElements(By.id("totalp")));

       // assertEquals("STORE", title);
      //  assertFalse(driver.findElement(By.cssSelector("div.col-md-6:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h4:nth-child(1) > a:nth-child(1)")).isDisplayed());
    }


      */
    }
}
