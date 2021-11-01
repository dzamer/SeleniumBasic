import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class SldierTest extends TestBase{

    @Test
    public void shouldMoveSlider(){
        driver.get("https://seleniumui.moderntester.pl/slider.php");

        WebElement slider = driver.findElement(By.cssSelector("#custom-handle"));
        for(int i=0; i<80;i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        Assert.assertEquals(slider.getText(),"80");
        for(int i=0;i<30;i++){
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        Assert.assertEquals(slider.getText(),"50");
        for(int i=0;i<49;i++){
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        Assert.assertEquals(slider.getText(), "99");
    }
}
