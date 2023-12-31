package webTest;
// Generated by Selenium IDE

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Map;

public class LoginSide{
    // Atributos

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    // Antes do Teste
    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Apontar onde est� o Chrome Driver
      //System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver(options);      // Instancia /Liga o Chrome Driver
        //s = (JavascriptExecutor) driver;
        //vars = new HashMap<String, Object>();

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));
    }
    // Depois do Teste
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
   // Testes
    @Test
    public void login() {
        driver.get("https://testando.eveclass.com");
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("#support-action > .button-text > span > span")).click();
        driver.findElement(By.cssSelector("input[type=\"email\"]")).click();
        driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys("lenesoares.souza@gmail.com");
        driver.findElement(By.cssSelector("input[type=\"password\"]")).click();
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("081021");
        driver.findElement(By.cssSelector(".button-text>span")).click();
        driver.findElement(By.cssSelector(".context-title")).click();
        driver.findElement(By.cssSelector(".dropdown:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".dropdown_footer .infos-text")).click();
        driver.findElement(By.cssSelector(".swal2-confirm")).click();
    }
}
