package Testing_Postman.REST;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

class Testing {

	@DisplayName("GET - запрос")
	@Test
	void testGET() {
		given() 
				.param("foo1", "bar1").param("foo2", "bar2").when().get("https://postman-echo.com/get") 

				.then() 
				.statusCode(200).body("args.foo1", equalTo("bar1")).body("args.foo2", equalTo("bar2"));
	}

	@DisplayName("POST - запрос RAW")
	@Test
	void testPOST_Raw() {
		given().contentType(ContentType.JSON).body("This is expected to be sent back as part of response body.").when()
				.post("https://postman-echo.com/post").then().statusCode(200)
				.body("data", equalTo("This is expected to be sent back as part of response body."));
	}

	@DisplayName("POST - запрос DATA")
	@Test
	void testPOST_Date() {
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("foo1", "bar1");
		requestBody.put("foo2", "bar2");
		given().contentType(ContentType.JSON).body(requestBody).when().post("https://postman-echo.com/post").then()
				.statusCode(200).body("json.foo1", equalTo("bar1")).body("json.foo2", equalTo("bar2"));
	}

	@DisplayName("PUT - запрос")
	@Test
	void testPUT() {
		given().contentType(ContentType.JSON).body("This is expected to be sent back as part of response body.").when()
				.put("https://postman-echo.com/put").then().statusCode(200)
				.body("data", equalTo("This is expected to be sent back as part of response body."));
	}

	@DisplayName("PATCH - запрос")
	@Test
	void testPATCH() {
		given().contentType(ContentType.JSON).body("This is expected to be sent back as part of response body.").when()
				.patch("https://postman-echo.com/patch").then().statusCode(200)
				.body("data", equalTo("This is expected to be sent back as part of response body."));
	}

	@DisplayName("DELETE - запрос")
	@Test
	void testDELETE() {
		given().contentType(ContentType.JSON).body("This is expected to be sent back as part of response body.").when()
				.delete("https://postman-echo.com/delete").then().statusCode(200)
				.body("data", equalTo("This is expected to be sent back as part of response body."));
	}

}
