// nome do pacote
package apiTest;

//Bibliotecas
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import com.google.gson.Gson;
// Classe
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteStore {// inicio da classe
    // Atributos
    static String ct = "application/json";  // content Type
    static String uriStore = "https://petstore.swagger.io/v2/store/order/";

    //Funções e Metodo
    //Funções de Apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }

    // Funções de teste
    @Test
    @Order(1)
    public void testarIncluirStoreUser() throws IOException {
        // carregar os dados do nosso json
        String jsonBody = lerArquivoJson("src/test/resources/json/store1.json");
        int UserStoreId = 1380485245;

        // realizar o teste
        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriStore) // Endpoint
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(UserStoreId))

        ;
    }
   // @ParameterizedTest
   // @CsvFileSource(resources = "/csv/massaStore.csv", numLinesToSkip = 1, delimiter = ',')
    @Test
    @Order(2)
    public void testarConsultarStoreUser() {
        // resultados esperados
        String petId = "3";
        int userStoreId = 1380485245;   // código do usuário
        String quantity = "2";



        String status = "placed";
        String complete = "true";

        given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriStore +userStoreId )
        .then()
                .log().all()
                .statusCode(200)
                //.body("id", is(userStoreId))
                //.body("petId", is(petId))
                .body("shipDate" , is("2023-04-04T23:47:30.818+0000"))


        ;
    }
}// fim do Get User