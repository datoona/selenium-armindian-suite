import api.ApiHelper;
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
        JsonObject project = ApiHelper.createProject();
        JsonObject issue = ApiHelper.createIssue(project.get("id").getAsInt());

        new TaigaLoginPage();
        login("davetest@mailinator.com", "davetest");
        TaigaProjectPage projectPage = new TaigaProjectPage(project);


    }
}
