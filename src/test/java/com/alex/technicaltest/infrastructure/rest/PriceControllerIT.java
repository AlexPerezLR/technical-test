package com.alex.technicaltest.infrastructure.rest;

import static io.restassured.RestAssured.given;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import com.alex.technicaltest.infrastructure.util.Constants;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles({"junit"})
public class PriceControllerIT {
    

    @Test
    public void whenGetAllDestinationsReturn200OK(){
        given()
        .when()
            .get(Constants.PRODUCTS_URL+"/")
        .then()
            .assertThat().statusCode(HttpStatus.OK.value());
    }

    @Test
    public void whenGetPriceWithParamsReturnMatchingPrice(){
        // petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        String dateTimeString = "2020-06-14 10:00:00";

        given()
            .param("applicationDate", dateTimeString).and()
            .param("productId",35455L).and()
            .param("brandId",1L)
        .when()
            .get(Constants.PRICES_URL)
        .then()
            .assertThat().statusCode(HttpStatus.OK.value())
        .and()
            .body("price", Matchers.is(35.50f));
    }

    private static LocalDateTime createLocalDateTimeFromString(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTimeString, formatter);
    }
}
