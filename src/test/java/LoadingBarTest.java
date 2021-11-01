import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoadingBarTest extends TestBase {

    @Test
    public void shouldWaitForLoadingBar(){
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        new WebDriverWait(driver, 20).until(
                ExpectedConditions.textToBe(By.cssSelector(".progress-label"), "Complete!"));
    }

    @Test
    public void waitForLoadingBar2(){
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                y -> driver.findElement(By.cssSelector(".progress-label")).getText().equals("Complete!"));
    }


}
