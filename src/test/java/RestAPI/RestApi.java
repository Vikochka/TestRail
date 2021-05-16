package RestAPI;

import com.google.gson.Gson;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestApi {
    String token = "rjIbX6dJOYj4ghNcgy5Y-fbdrx0HWLKc8sSv8Pghk";
    Gson gson = new Gson();
@Ignore
    @Test
    public void project() {
        given().
                header("Token", token).
                header("Concept-Type", "application/json").
                body("{\n" +
                        "\t\"name\": \"This is a new project\",\n" +
                        "\t\"announcement\": \"This is the description for the project\",\n" +
                        "\t\"show_announcement\": true\n" +
                        "}").
        when().
                post("https://vikakatestrail.testrail.io/index.php?/api/v2/add_project").
        then().
                log().all().
                statusCode(200);
    }
}
