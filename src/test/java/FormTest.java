import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FormTest extends TestBase{

    @Test
    public  void shouldFillFormWithSuccess(){
        driver.get("https://seleniumui.moderntester.pl/form.php");

        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("Krzysztof");
        driver.findElement(By.cssSelector("#inputLastName3")).sendKeys("Jamro");
        driver.findElement(By.cssSelector("#inputEmail3")).sendKeys("Krzysztof.jamro@gmail.com");
        driver.findElement(By.cssSelector("#gridRadiosMale")).click();
        driver.findElement(By.cssSelector("#inputAge3")).sendKeys("28");
        driver.findElement(By.cssSelector("#gridRadios1")).click();
        driver.findElement(By.cssSelector("#gridCheckOther")).click();

        WebElement continentsSelect = driver.findElement(By.id("selectContinents"));
        Select continents = new Select(continentsSelect);
        continents.selectByValue("europe");

        Select multiSelect = new Select(driver.findElement(By.cssSelector("#selectSeleniumCommands")));
        multiSelect.selectByValue("navigation-commands");
        multiSelect.selectByValue("wait-commands");

        File file = new File("src/main/resources/file.txt");
        driver.findElement(By.cssSelector("#chooseFile")).sendKeys(
                file.getAbsolutePath());

        driver.findElement(By.cssSelector("[type='submit']")).click();
        WebElement msg = driver.findElement(By.cssSelector("#validator-message"));
        Assert.assertEquals(msg.getText(),"Form send with success");
    }

}
