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
    public By byCabeçalhoListaDeVoos = By.cssSelector("div.container h3");

     // Ação
    public String lerCabeçalhoListaDeVoo(){
        return driver.findElement(byCabeçalhoListaDeVoos).getText();

    }
    // Ler o título da guia Reserve
    public String lerTituloGuia(){
        return driver.getTitle();
    }
}
