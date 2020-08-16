package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddressPage {
    private static WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "alias")
    private WebElement nazwa;

    @FindBy(name = "address1")
    private WebElement addressFirstLine;

    @FindBy(name = "postcode")
    private WebElement zip;

    @FindBy(name = "city")
    private WebElement cityPage;

     @FindBy(xpath = ("//select[@class='form-control form-control-select js-country']"))
     private WebElement kraj;

    @FindBy(css = "button.btn-primary")
    private WebElement button;

    public void SetAddress(String alias, String address, String zipCode, String city, String Country) {

        addressFirstLine.click();
        addressFirstLine.clear();
        addressFirstLine.sendKeys(address);

        nazwa.click();
        nazwa.clear();
        nazwa.sendKeys(alias);

        zip.click();
        zip.clear();
        zip.sendKeys(zipCode);


        cityPage.click();
        cityPage.clear();
        cityPage.sendKeys(city);


        Select roleSelect = new Select(kraj);
        roleSelect.selectByVisibleText("United Kingdom");

        button.click();
    }

    @FindBy(css = "article.address")
    private List<WebElement> adresy;

    public String getLastAddress() {
        return adresy.get(adresy.size() - 1).getText();


    }


}

