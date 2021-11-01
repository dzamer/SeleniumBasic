import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest extends TestBase{

    @BeforeMethod
    public void testSetUp(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
    }

    @Test
    public void shouldVerifySimpleAlert(){
        driver.findElement(By.cssSelector("#simple-alert")).click();
        driver.switchTo().alert().accept(); // click -> ok
        WebElement msg = driver.findElement(By.cssSelector("#simple-alert-label"));
        Assert.assertEquals(msg.getText(),"OK button pressed");
    }

    @Test
    public void shouldVerifyPrompAlertBox(){
        driver.findElement(By.cssSelector("#prompt-alert")).click();
        driver.switchTo().alert().sendKeys("Sauron");
        driver.switchTo().alert().accept();
        WebElement msg2 = driver.findElement(By.cssSelector("#prompt-label"));
        Assert.assertEquals(msg2.getText(),"Hello Sauron! How are you today?");
    }

    @Test
    public void shouldVerifyConfirmAlertBox(){
        driver.findElement(By.cssSelector("#confirm-alert")).click();
        driver.switchTo().alert().accept();
        WebElement msg = driver.findElement(By.cssSelector("#confirm-label"));
        Assert.assertEquals(msg.getText(),"You pressed OK!");
        driver.findElement(By.cssSelector("#confirm-alert")).click();
        driver.switchTo().alert().dismiss();
        WebElement msg1 = driver.findElement(By.cssSelector("#confirm-label"));
        Assert.assertEquals(msg1.getText(),"You pressed Cancel!");
    }

    @Test
    public void shouldVerifyDelayedAlert(){
        driver.findElement(By.cssSelector("#delayed-alert")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        WebElement msg3 = driver.findElement(By.cssSelector("#delayed-alert-label"));
        Assert.assertEquals(msg3.getText(), "OK button pressed");
    }
}
