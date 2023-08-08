
package apiTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteBooking { // início da classe
    // Atributos
    private final String uri = "https://restful-booker.herokuapp.com/";
    private final String ct = "application/json";
    private static String token;
    private static int bookingId;


    //Funções e métodos


    // Funções de Apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));


    }
    //Funções  de Testes
    @Test
    @Order(1)
    public  void testeCreateToken() throws IOException {
        String jsonBody = lerArquivoJson("src/resources/json/bookingAuth.json");
        Response resposta = (Response)  given()
                .log().all()
                .contentType(ct)
                .body(jsonBody)
        .when()
                .post(uri + "auth")
        .then()
                .log().all()
                .statusCode(200)
                .body("token", hasLength(15))
                .extract();
        token = resposta.jsonPath().getString("token");
        System.out.println("Token:" + token);

    }
    @Test
    @Order(2)
    public void testeGetBookingIds() {
        given()
                .log().all()
                .contentType(ct)
        .when()
                .get(uri + "booking")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }

    @Test
    @Order(4)
    public void testeGetBooking() {
        given()
                .log().all()
                .contentType(ct)
        .when()
                .get(uri + "booking/" + bookingId)
        .then()
                .log().all()
                .statusCode(200)
                .body("totalprice", is(804))
                .body("bookingdates.checkin", is("2022-08-14"))

        ;
    }
    @Test
    @Order(5)
    public void testeUpdateBooking() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/updateBooking.json");
        given()
                .contentType(ct)
                .log().all()
                .header("Cookie", "token=" + token) //é opcional
                .body(jsonBody)
        .when()
                .put(uri + "booking/" + bookingId)
        .then()
                .contentType(ct)
                .log().all()
                .statusCode(200)
                .body("firstname", is("James"))
                .body("bookingdates.checkin", is("2023-05-17"))
                .body("bookingdates.checkout", is("2023-05-18"))
        ;
    }

}

