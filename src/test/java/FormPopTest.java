import Pages.FormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormPopTest extends TestBase{

    @Test
    public void shouldFillFormWithSuccess(){
        driver.get("https://seleniumui.moderntester.pl/form.php");

        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Krzysiek");
        formPage.setLastName("Jamro");
        formPage.setEmail("Krzysztof.Jamro@gmail.com");
        formPage.selectMale();
        formPage.setAge("28");
        formPage.selectRandomYearOfExperience();
        formPage.selectRandomProfession();
        formPage.selectContinent("europe");
        formPage.selectSeleniumCommand("Wait Commands");
        formPage.selectSeleniumCommand("WebElement Commands");
        formPage.uploadFile("src/main/resources/file.txt");
        formPage.clickSubmit();

        Assert.assertEquals(formPage.getSubmitInformation(),"Form send with success");
    }

}
