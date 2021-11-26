package com.example.m4_Testing_David_Sans;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerDataBaseTest {


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
@DisplayName("Verificamos que se encuentran el numero correcto con este filtro")
    @Test
    void FindGroupTest() {
        // Abrir página web
        driver.manage().window().maximize();
        driver.get("https://computer-database.gatling.io/computers");
        /**  comprobamos que sea la web correcta
         * verificando el titulo
         */
        assertEquals("574 computers found",driver.findElement(By.xpath("/html/body/section/h1")).getText());

driver.findElement(By.id("searchbox")).sendKeys("Asci");
driver.findElement(By.cssSelector("#searchsubmit")).click();
assertEquals("6 computers found", driver.findElement(By.xpath("/html/body/section/h1")).getText());
       }

       @DisplayName("Verificamos que encuentra un producto en concreto")
    @Test
    void FindOneTest() {
        // Abrir página web
        driver.manage().window().maximize();
        driver.get("https://computer-database.gatling.io/computers");

        assertEquals("574 computers found",driver.findElement(By.xpath("/html/body/section/h1")).getText());
        /**  buscamos PowerEdge
         */
        driver.findElement(By.id("searchbox")).sendKeys("PowerEdge");
        driver.findElement(By.cssSelector("#searchsubmit")).click();
        assertEquals("One computer found", driver.findElement(By.xpath("/html/body/section/h1")).getText());
    }
    @DisplayName("Verificamos que crea un producto")
    @Test
    void AddnewTest() {
        // Abrir página web
        driver.manage().window().maximize();
        driver.get("https://computer-database.gatling.io/computers");

        assertEquals("574 computers found",driver.findElement(By.xpath("/html/body/section/h1")).getText());
        /**
         * Añadimos correctament un nuevo computer
         */
        driver.findElement(By.id("add")).click();
        assertEquals("Add a computer",driver.findElement(By.xpath("/html/body/section/h1")).getText());

        driver.findElement(By.id("name")).sendKeys("Amarok");
        driver.findElement(By.id("introduced")).sendKeys("2021-11-17");
        driver.findElement(By.id("discontinued")).sendKeys("2025-11-17");
        driver.findElement(By.id("company")).click();
        driver.findElement(By.xpath("/html/body/section/form/fieldset/div[4]/div/select/option[30]")).click();
        driver.findElement(By.cssSelector("html body section#main form div.actions input.btn.primary")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-name > a:nth-child(1)")));
        /**
         * Comprobamos que se creo correctamente
         */
        assertEquals("Done !",driver.findElement(By.xpath("/html/body/section/div[1]/strong")).getText());
    }
    @DisplayName("Comprobamos que al cancelar, no crea el producto")
    @Test
    void AddnewCanceledTest() {
        // Abrir página web
        driver.manage().window().maximize();
        driver.get("https://computer-database.gatling.io/computers");

        assertEquals("574 computers found",driver.findElement(By.xpath("/html/body/section/h1")).getText());
        driver.findElement(By.id("add")).click();
        assertEquals("Add a computer",driver.findElement(By.xpath("/html/body/section/h1")).getText());

        driver.findElement(By.id("name")).sendKeys("Amarok");
        driver.findElement(By.id("introduced")).sendKeys("2021-11-17");
        driver.findElement(By.id("discontinued")).sendKeys("2025-11-17");
        driver.findElement(By.id("company")).click();
        driver.findElement(By.xpath("/html/body/section/form/fieldset/div[4]/div/select/option[30]")).click();
        /**
         * pulsamos el boton de cancelar
         */
        driver.findElement(By.cssSelector("html body section#main form div.actions a.btn")).click();
        assertEquals("574 computers found",driver.findElement(By.xpath("/html/body/section/h1")).getText());

    }
    @DisplayName("Comprobamos que al no introducir nombre, no crea el producto")
    @Test
    void AddnewBadNameTest() {
        // Abrir página web
        driver.manage().window().maximize();
        driver.get("https://computer-database.gatling.io/computers");

        assertEquals("574 computers found",driver.findElement(By.xpath("/html/body/section/h1")).getText());
        /**  Añadimos sin el nombre requerido
         */
        driver.findElement(By.id("add")).click();
        assertEquals("Add a computer",driver.findElement(By.xpath("/html/body/section/h1")).getText());

        driver.findElement(By.id("name")).sendKeys("");
        driver.findElement(By.id("introduced")).sendKeys("2021-11-17");
        driver.findElement(By.id("discontinued")).sendKeys("2025-11-17");
        driver.findElement(By.id("company")).click();
        driver.findElement(By.xpath("/html/body/section/form/fieldset/div[4]/div/select/option[30]")).click();
        driver.findElement(By.cssSelector("html body section#main form div.actions input.btn.primary")).click();
        /**
         * comprobamos que sale el mensaje de error
         */
        assertEquals("Failed to refine type : Predicate isEmpty() did not fail.",driver.findElement(By.xpath("/html/body/section/form/fieldset/div[1]/div/span")).getText());
        driver.findElement(By.cssSelector("html body section#main form div.actions a.btn")).click();
        assertEquals("574 computers found",driver.findElement(By.xpath("/html/body/section/h1")).getText());

    }


}
