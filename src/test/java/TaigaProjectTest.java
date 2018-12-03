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
        JsonObject project = new JsonObject();
        project.addProperty("name", projectName);
        project.addProperty("description", "Test Project via Api Description");
        project.addProperty("creation_template", 1);
        project.addProperty("is_private", false);
        project = Client.createProject(project);

        login("davetest@mailinator.com", "davetest");
        TaigaProjectPage projectPage = new TaigaProjectPage(project);


    }
}
