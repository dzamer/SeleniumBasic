package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(id="inputLastName3")
    private WebElement lastNameInput;

    @FindBy(id="inputEmail3")
    private WebElement emailInput;

    @FindBy(css="#gridRadiosMale")
    private WebElement maleRbt;

    @FindBy(name="gridRadiosExperience")
    private List<WebElement> yearOfExperience;

    @FindBy(css ="#selectContinents")
    private WebElement continent;

    @FindBy(id="inputAge3")
    private WebElement age;

    @FindBy(css = ".checkbox-profession")
    private List<WebElement> profession;

    @FindBy(id = "chooseFile")
    private WebElement chooseFile;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement multiSelect;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    @FindBy(id="validator-message")
    private WebElement submitInformation;

    public void setFirstName(String firstName){
        this.firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.lastNameInput.sendKeys(lastName);
    }

    public void setEmail(String email){
        this.emailInput.sendKeys(email);
    }

    public void setAge(String age){
        this.age.sendKeys(age);
    }

    public void selectMale(){
        this.maleRbt.click();
    }

    public void selectRandomYearOfExperience(){
        yearOfExperience.get(new Random().nextInt(yearOfExperience.size())).click();
    }
    public void selectRandomProfession(){
        this.profession.get(new Random().nextInt(this.profession.size())).click();
    }

    public void selectContinent(String continent){
        new Select(this.continent).selectByValue(continent);
    }

    public void uploadFile(String relevantPath){
        File file = new File(relevantPath);
        chooseFile.sendKeys(file.getAbsolutePath());
    }
    public void selectSeleniumCommand(String command) {
        new Select(multiSelect).selectByVisibleText(command);
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public String getSubmitInformation(){
        return this.submitInformation.getText();
    }
}
