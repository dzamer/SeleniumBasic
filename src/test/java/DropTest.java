import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class DropTest extends TestBase{

    @Test
    public void shouldDragAndDrop(){
        driver.get("https://seleniumui.moderntester.pl/droppable.php");

        WebElement toDrag = driver.findElement(By.cssSelector("#draggable"));
        WebElement areaToDrop = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(toDrag, areaToDrop).perform();

        Assert.assertEquals(areaToDrop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDrop2(){
        driver.get("https://seleniumui.moderntester.pl/droppable.php");

        WebElement toDrag = driver.findElement(By.cssSelector("#draggable"));
        WebElement areaToDrop = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(toDrag).moveToElement(areaToDrop).release().perform();

        Assert.assertEquals(areaToDrop.getText(), "Dropped!");
    }
}
