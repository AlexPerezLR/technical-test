package com.alex.technicaltest.infrastructure.rest;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.is;
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
            .body("price", is(35.50f));
    }

    @Test
    public void whenGetPriceWithParamsReturnMatchingPrice02(){
        // petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        String dateTimeString = "2020-06-14 16:00:00";

        given()
            .param("applicationDate", dateTimeString).and()
            .param("productId",35455L).and()
            .param("brandId",1L)
        .when()
            .get(Constants.PRICES_URL)
        .then()
            .assertThat().statusCode(HttpStatus.OK.value())
        .and()
            .body("price", is(25.45f));
    }

    @Test
    public void whenGetPriceWithParamsReturnMatchingPrice03(){
        // petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        String dateTimeString = "2020-06-14 21:00:00";

        given()
            .param("applicationDate", dateTimeString).and()
            .param("productId",35455L).and()
            .param("brandId",1L)
        .when()
            .get(Constants.PRICES_URL)
        .then()
            .assertThat().statusCode(HttpStatus.OK.value())
        .and()
            .body("price", is(35.50f));
    }

    @Test
    public void whenGetPriceWithParamsReturnMatchingPrice04(){
        // petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
        String dateTimeString = "2020-06-15 10:00:00";

        given()
            .param("applicationDate", dateTimeString).and()
            .param("productId",35455L).and()
            .param("brandId",1L)
        .when()
            .get(Constants.PRICES_URL)
        .then()
            .assertThat().statusCode(HttpStatus.OK.value())
        .and()
            .body("price", is(30.50f));
    }

    @Test
    public void whenGetPriceWithParamsReturnMatchingPrice05(){
        // petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
        String dateTimeString = "2020-06-16 21:00:00";

        given()
            .param("applicationDate", dateTimeString).and()
            .param("productId",35455L).and()
            .param("brandId",1L)
        .when()
            .get(Constants.PRICES_URL)
        .then()
            .assertThat().statusCode(HttpStatus.OK.value())
        .and()
            .body("price", is(38.95f));
    }

}
