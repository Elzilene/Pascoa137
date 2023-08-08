package mobileTest;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyDemoApp {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "9.0");
        capabilities.setCapability("appium:deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
        capabilities.setCapability("appium:deviceOrientation", "portrait");
        capabilities.setCapability("appium:app", "storage:filename=mda-1.0.17-20.apk");
        capabilities.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.android");
        capabilities.setCapability("appium:appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        capabilities.setCapability("appium:nativeWebScreenshot", true);

        MutableCapabilities sauceOptions = new MutableCapabilities(); // conf Saucelabs
        sauceOptions.setCapability("name", "FTS137 MyDemoApp");
        capabilities.setCapability("sauce:options", sauceOptions);

        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("https://InstrutorIterasys19:7c6bd642-9a06-4e3d-b721-6df004c4e47c@ondemand.us-west-1.saucelabs.com:443/wd/hub");

        driver = new AndroidDriver(remoteUrl, capabilities);
    }

    @Test
    public void testeSelecionarProduto() {
        // Na tela inicial (Home), clicar no produto mochila
        WebElement produtoSelecionado = (WebElement) driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Sauce Lab Back Packs\"]"));
        produtoSelecionado.click();
        // Na tela de produto, verificar o nome e o preço (por enquando só está clicando)
        WebElement nomeProduto = (WebElement) driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/productTV"));
        assertEquals("Sauce Lab Back Packs",nomeProduto.getText());
        WebElement precoProduto = (WebElement) driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/priceTV"));
        assertEquals("$ 29.99", precoProduto.getText());


        // Arrasta para Cima

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 200, 500));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(new Pause(finger, Duration.ofMillis(600)));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), 200, 100));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(dragNDrop));

        // Adicione no carrinho
        // WebElement btnAdicionarNoCarrinho = (WebElement) driver.findElement(By."Tap to add product to cart");
        // btnAdicionarNoCarrinho.click();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
