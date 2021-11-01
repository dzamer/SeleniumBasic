import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortTest extends TestBase{

    @Test
    public void sortingTest(){
        driver.get("https://seleniumui.moderntester.pl/sortable.php");

        List<WebElement> elementsToSort = driver.findElements(By.cssSelector(".ui-state-default.ui-sortable-handle"));

        List<Integer> sequence = new ArrayList<>();
        for(int i=1; i<8;i++){
            sequence.add(i);
        }
        Collections.shuffle(sequence);

        for(int i=0;i<elementsToSort.size();i++){
            if(!elementsToSort.get(i).getText().equals("Item "+sequence.get(i))){
                System.out.println("Element " + (i+1)+ " is not in proper location");
            }
            System.out.println(elementsToSort.get(i).getText());
            System.out.println(sequence.get(i));
        }
    }
}
