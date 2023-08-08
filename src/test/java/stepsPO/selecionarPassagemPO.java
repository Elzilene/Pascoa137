package stepsPO;

import Pages.HomePage;
import Pages.ReservePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class selecionarPassagemPO {
    private  WebDriver driver;
    private HomePage homePage; // Mapeamento dos elementos da Home
    private ReservePage reservePage;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));

        // instancia as classes de mapeamento
        homePage = new HomePage(driver);
        reservePage = new ReservePage(driver);

    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    @Given("que acesso o site Blazedemo")
    public void que_acesso_o_site_Blazedemo() {
        System.out.println("Passo 1");
        driver.get("https://www.blazedemo.com");
    }
    @When("seleciono a origem como {string} e destino {string}")
    public void seleciono_a_origem_como_e_destino(String origem, String destino) {
        System.out.println("Passo 2");
        homePage.selecionarOrigemDestino(origem,destino);
    }
    @And("clico em Procurar Voo")
    public void clico_em_Procurar_Voo() {
        System.out.println("Passo 3");
        homePage.clicarBtnProcurarVoo();
    }
    @Then("exibe a frase indicando voo entre {string} e {string}")
    public void exibe_a_frase_indicando_voo_entre_e(String string, String string2) {
        System.out.println("Passo 4");
        assertEquals("Flights from S�o Paolo to Berlin:", reservePage.lerCabe�alhoListaDeVoo());
    }
}
