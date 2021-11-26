package com.example.m4_Testing_David_Sans;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChromeTest {
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
@DisplayName("Verificamos que abre la web correcta con el titulo esperado")
    @Test
    void testTrueWeb(){
        // Abrir página web
        driver.get("https://www.demoblaze.com/index.html");
        // Obtener el texto de la etiqueta <title> de la página web que hemos abierto
        String title = driver.getTitle();


        // Verificar que el texto del título coincide con lo que queremos
        assertEquals("STORE", title);
    }


}
