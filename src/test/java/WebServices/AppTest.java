package WebServices;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Unit test for simple App.
 */
public class AppTest{

    @Test
    public void testRequest(){
        String actualTitle = given().
                when().
                get("https://api.nasa.gov/planetary/apod?api_key=NNKOjkoul8n1CH18TWA9gwngW1s1SmjESPjNoUFo").
                then().
                assertThat().statusCode(200).
                and().
                contentType(ContentType.JSON).
                extract().path("title");
        String expectedTitle = "Haumea of the Outer Solar System";
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

}
