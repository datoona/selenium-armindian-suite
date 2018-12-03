import base.BasePage;
import com.google.gson.JsonObject;

public class TaigaProjectPage extends BasePage {

    JsonObject project;
    public TaigaProjectPage(JsonObject project){
        super();
        this.project = project;
        driver.get(getURL());
    }

    @Override
    public String getURL() {
        return "https://tree.taiga.io/project/" + project.get("slug").getAsString();
    }

}
