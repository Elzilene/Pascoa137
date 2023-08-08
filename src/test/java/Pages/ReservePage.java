package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage extends Base{
    // Construtor
    public ReservePage(WebDriver driver) {
        super(driver);
    }
    // Mapeamento dos Elementos
    // Apenas a frase que diz a origem e o destino
    public By byCabe�alhoListaDeVoos = By.cssSelector("div.container h3");

     // A��o
    public String lerCabe�alhoListaDeVoo(){
        return driver.findElement(byCabe�alhoListaDeVoos).getText();

    }
    // Ler o t�tulo da guia Reserve
    public String lerTituloGuia(){
        return driver.getTitle();
    }
}
