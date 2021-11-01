import Pages.MountainTablePage;
import Pages.RowPage;
import org.testng.annotations.Test;

public class TablePopTest extends TestBase{

    @Test
    public void shouldPrintMountains(){
        driver.get("https://seleniumui.moderntester.pl/table.php");

        for(RowPage mountain : new MountainTablePage(driver).getAllMountains()){
            if(mountain.getHeight() > 4000){
                System.out.println(mountain.getMountainName());
            }
        }

    }
}
