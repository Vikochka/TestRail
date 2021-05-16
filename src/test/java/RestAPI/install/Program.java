package RestAPI.install;


import org.json.JSONObject;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class Program {
@Ignore
    @Test
    public static void main() throws Exception {
        APIClient client = new APIClient("https://vikakatestrail.testrail.io");
        client.setUser("vikakatestrail@mailinator.com");
        client.setPassword("Rs5XGzbZ4VBqS5pnrs.o");
        JSONObject c = (JSONObject) client.sendGet("add_project");
        System.out.println(c.get("title"));
    }
@Ignore
    @Test
    public static void main2() throws Exception {
        APIClient client = new APIClient("https://vikakatestrail.testrail.io");
        client.setUser("vikakatestrail@mailinator.com");
        client.setPassword("Rs5XGzbZ4VBqS5pnrs.o");
        //JSONObject r = (JSONObject) client.sendGet("add_project");
        given().
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