import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest extends TestBase{
    @BeforeMethod
    public void testSetUp(){
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
    }

    @Test
    public void testFisrtFrame(){
        driver.switchTo().frame("iframe1");

        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("Krzysztof");
        driver.findElement(By.cssSelector("#inputSurname3")).sendKeys("Jamro");
        driver.findElement(By.cssSelector("body > main > form > div:nth-child(3) > div > button")).click();
        driver.switchTo().defaultContent();
        WebElement msg = driver.findElement(By.cssSelector("body > main > div > div:nth-child(1) > p"));
        Assert.assertEquals(msg.getText(), "Iframe 1");
    }

    @Test
    public void testSecondFrame(){
        driver.switchTo().frame("iframe2");

        driver.findElement(By.cssSelector("#inputLogin")).sendKeys("Jamrok");
        driver.findElement(By.cssSelector("#inputPassword")).sendKeys("q75rUn9S");
        Select selectCountry = new Select(driver.findElement(By.cssSelector("#inlineFormCustomSelectPref")));
        selectCountry.selectByValue("europe");
        driver.findElement(By.cssSelector("#gridRadios3")).click();
        driver.findElement(By.cssSelector("body > main > form > div:nth-child(5) > div > button")).click();

        driver.switchTo().defaultContent();

        WebElement msg1 = driver.findElement(By.cssSelector("body > main > div > div:nth-child(2) > p"));
        Assert.assertEquals(msg1.getText(), "Iframe 2");
    }
}
