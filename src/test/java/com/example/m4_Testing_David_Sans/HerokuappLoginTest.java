package com.example.m4_Testing_David_Sans;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class HerokuappLoginTest {


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
@DisplayName("Comprobamos que no da acceso sin introducir las credenciales")
    @Test
    void WithoutFillTest() {
        // Abrir página web
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/login");
assertEquals("Login Page",driver.findElement(By.xpath("/html/body/div[2]/div/div/h2")).getText());
driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i")).click();
assertEquals("Your username is invalid!\n" +
        "×",driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText());
    }
    @DisplayName("Comprobamos que da acceso al introducir las credenciales correctamente")
    @Test
    void loginOkTest() {
        // Abrir página web
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/login");
        assertEquals("Login Page",driver.findElement(By.xpath("/html/body/div[2]/div/div/h2")).getText());

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i")).click();
        assertEquals("You logged into a secure area!\n" +
                "×",driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText());
        driver.findElement(By.xpath("/html/body/div[2]/div/div/a")).click(); // logOut
        assertEquals("Login Page",driver.findElement(By.xpath("/html/body/div[2]/div/div/h2")).getText());
    }
    @DisplayName("Comprobamos que no da acceso al introducir el login incorrecto")
    @Test
    void loginBadLogTest() {
        // Abrir página web
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/login");
        assertEquals("Login Page",driver.findElement(By.xpath("/html/body/div[2]/div/div/h2")).getText());

        driver.findElement(By.id("username")).sendKeys("fail");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i")).click();
        assertNotEquals("You logged into a secure area!\n" +
                "×",driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText());
        assertEquals("Your username is invalid!\n" +
                "×",driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText());

    }
    @DisplayName("Comprobamos que no da acceso al introducir el password incorrecto")
    @Test
    void loginBadPasswordTest() {
        // Abrir página web
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/login");
        assertEquals("Login Page",driver.findElement(By.xpath("/html/body/div[2]/div/div/h2")).getText());

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("buahhh!");

        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button/i")).click();
        assertNotEquals("You logged into a secure area!\n" +
                "×",driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText());
        assertEquals("Your password is invalid!\n" +
                "×",driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText());

    }

}
