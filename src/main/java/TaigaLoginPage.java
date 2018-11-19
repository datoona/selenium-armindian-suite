import base.BasePage;

public class TaigaLoginPage extends BasePage {

    @Override
    public String getURL() {
        return "https://tree.taiga.io/login";
    }

    public TaigaLoginPage() {
        super();
        driver.get(getURL());
    }

}
