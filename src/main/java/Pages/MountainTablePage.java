package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MountainTablePage {
    public MountainTablePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "tbody tr")
    List<WebElement> allMountains;

    public List<RowPage> getAllMountains(){
        List<RowPage> allPeaks = new ArrayList<>();

        for(WebElement mountain: allMountains){
            allPeaks.add(new RowPage(mountain));
        }
        return allPeaks;
    }

    public List<RowPage> getAllMountains2(){
        return allMountains.stream().map(RowPage::new).collect(Collectors.toList());
    }
}
