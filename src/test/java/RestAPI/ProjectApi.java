package RestAPI;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProjectApi {
    String login = "vikakatestrail@mailinator.com";
    String password = "Rs5XGzbZ4VBqS5pnrs.o";

    @Test(description = "Create project with API")
    public void createProject() {
        given().
                baseUri("https://vikakatestrail.testrail.io").
                auth().basic(login, password).cookie("tr_session", "3dc6b7dc-4df6-4b4f-872a-798cd313f1b9").
                header("Content-Type", "application/json").
                body("{\n" +
                        "\t\"name\": \"API\",\n" +
                        "\t\"announcement\": \"This is the diploma project\",\n" +
                        "\t\"show_announcement\": true\n" +
                        "}").
                when().
                post("https://vikakatestrail.testrail.io/index.php?/api/v2/add_project").
                then().
                log().all().
                statusCode(200);
    }
}