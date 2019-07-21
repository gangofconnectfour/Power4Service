package com.gangofconnectfour.powerfourservice;

import com.gangofconnectfour.powerfourservice.api.in.LoginDtoIn;
import com.gangofconnectfour.powerfourservice.api.in.UserDtoIn;
import com.gangofconnectfour.powerfourservice.model.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PowerfourserviceApplicationTests {

        @LocalServerPort
        private int port;
        private String token;

        @Before
        public void init(){
                RestAssured.port = port;
                connect();
        }

        public void connect() {
                LoginDtoIn dto = new LoginDtoIn();
                dto.setMail("admin@power4.fr");
                dto.setPassword("admin");

                String location =
                        given()
                                .log().all()
                                .contentType(ContentType.JSON)
                                .body(dto)
                                .when()
                                .post("/login")
                                .then()
                                .log().all()
                                .statusCode(200)
                                .extract()
                                .header("Authorization");
                Assert.assertFalse(location.isEmpty());
                this.token = location;
        }

        @Test
        public void getAllUser(){
                given().log().all().contentType(ContentType.JSON)
                        .header("Authorization", token)
                        .param("withAdmin", false)
                        .when().get("/api/users")
                        .then().log().all().statusCode(HttpStatus.OK.value());
        }

        @Test
        public void getUserWithId_2(){
                given().log().all().contentType(ContentType.JSON)
                        .header("Authorization", token)
                        .pathParams("uuid", 2)
                        .when().get("/api/users/{uuid}/details")
                        .then().log().all().statusCode(HttpStatus.OK.value());
        }

        @Test
        public void createUser(){

                UserDtoIn dto = new UserDtoIn();
                dto.setEmail("totototo@toto.fr");
                dto.setPassword("titi");
                dto.setNickname("tweeti");

                String location = given().log().all().contentType(ContentType.JSON)
                        .header("Authorization", token)
                        .body(dto)
                        .when()
                        .post("/api/users")
                        .then()
                        .log().all()
                        .statusCode(201).extract()
                        .header("Location");

                assertThat(location).isNotEmpty();

        }

        @Test
        public void editUser_4 (){

                UserDtoIn dto = new UserDtoIn();
                dto.setNickname("tototototo");
                dto.setUuid(4L);

                given().log().all().contentType(ContentType.JSON)
                        .header("Authorization", token)
                        .body(dto)
                        .when()
                        .put("/api/users")
                        .then()
                        .log().all()
                        .statusCode(202);
        }


}
