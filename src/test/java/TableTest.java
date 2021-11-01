import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest extends TestBase{

    @Test
    public void gettingInforFromTableTest(){
        driver.get("https://seleniumui.moderntester.pl/table.php");
        List<WebElement> allMountain = driver.findElements(By.cssSelector("tbody tr"));

        for(WebElement mountain:allMountain){
           List<WebElement> mountainRow =  mountain.findElements(By.cssSelector("td"));
           String height = mountainRow.get(3).getText();
           if(Integer.parseInt(height) > 4000){
               System.out.println(mountainRow.get(0).getText() + " | " + mountainRow.get(1).getText() + " | " +
                       mountainRow.get(2).getText());
           }
        }
    }
}
