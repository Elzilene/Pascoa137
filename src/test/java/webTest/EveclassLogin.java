package webTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EveclassLogin {
    // Atributos
    WebDriver driver;
    WebDriverWait wait; // objeto de espera

    // Antes do Teste
    @BeforeEach
    public void setup(){
        // WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "drivers\\chrome\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));

        // Declarar o objeto de espera explicita
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));

    }
    // Depois do Teste
    @AfterEach
    public void tearDown(){
        //driver.quit();
    }

    // Testes
    @Test
    public void testeLogin() throws InterruptedException {
        driver.get("https://testando.eveclass.com");
        driver.findElement(By.id("support-action")).click();

        // Este é um caso de "Programação Exótica"
        driver.navigate().refresh(); //atualizar a página

        // Mudança de Página - Carregar uma nova página
        // É como um alfinete - ajuda, mas deve ser removido
        // Thread.sleep(5000); // Espere por 5 segundos

        // No lugar do Thread.sleep, devemos usar uma espera explicita
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".auth-header h1")));

        // Preencher os dados de e-mail e senha
        driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys(Keys.chord("lene@teste.com"));
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("senha1234");

        // Clicar no botão Entrar
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        // Transição de Tela , pode precisar do Usuário para abrir o menu
        driver.findElement(By.cssSelector("div.user-avatar.avatar-initials")).click();
        assertEquals("Lene Soare"(driver.findElement(By.cssSelector("p.infos-text")).getText();
    }


}
