import api.Client;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;
import sun.misc.Cleaner;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

public class TaigaProjectTest extends SeleniumBase {

    @Test
    public void projectPage(Method method) throws IOException {
        Client.login("davetest@mailinator.com", "davetest");
        String projectName = method.getName() + new Date().getTime();
        JsonObject prject = new JsonObject();
        prject.addProperty("name", projectName);
        prject.addProperty("description", "Test Project via API");
        prject.addProperty("create_template", "1");
        prject.addProperty("is_private", "false");

        Client.createProjetc(prject);
    }
}
