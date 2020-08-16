package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Zakupy {
    private static WebDriver driver;


    public Zakupy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ("//input[@class='ui-autocomplete-input']"))
    private WebElement szukanie;

    public void SearchSweater() {
        szukanie.clear();
        szukanie.sendKeys("Hummingbird printed sweater");

    }


    @FindBy(xpath = ("//article[@data-id-product='2']"))
    private WebElement produkt;

    public void ClickProdukt() {
        produkt.click();
    }

    @FindBy(xpath = ("//select[@data-product-attribute='1']"))
    private WebElement rozmiar;

    public void SetSize(String size) {

        Select roleSelect = new Select(rozmiar);
        roleSelect.selectByVisibleText(size);
    }

    @FindBy(xpath = ("//input[@id='quantity_wanted']"))
    private WebElement ilosc;

    public void SetQuantity(String x) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement iloscT = wait.until(ExpectedConditions.elementToBeClickable(ilosc));
        iloscT.clear();
        iloscT.sendKeys(x);
    }

    @FindBy(xpath=("//button[@data-button-action=\"add-to-cart\"]"))
    private WebElement koszyk;

    public void ClickAddToCard() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement koszykT = wait.until(ExpectedConditions.elementToBeClickable(koszyk));
        koszykT.click();
    }

    @FindBy(xpath = ("//a[@class='btn btn-primary']"))
    private WebElement kontynuujZakupy;

    public void ClickContinueShoping() {
        WebDriverWait wait=new WebDriverWait(driver, 3);
        WebElement kontynuujZakupyT=wait.until (ExpectedConditions.elementToBeClickable(kontynuujZakupy));
        kontynuujZakupyT.click();
    }


    @FindBy(xpath = ("//input[@name='id_address_delivery']"))
    private WebElement poprawnyAdderss;

    public void ClickCorrectAddress() {
        if (!poprawnyAdderss.isSelected()) {
            poprawnyAdderss.click();
        }

    }

    @FindBy(xpath = ("//section[@id=\"checkout-delivery-step\"]"))
    private WebElement shippingMethod;

    public void ClickShippingMethod() {
        shippingMethod.click();

    }

    @FindBy(xpath = ("//input[@id='delivery_option_1']"))
    private WebElement prestaShop;

    public void ClickPrestaShop() {
        if (!prestaShop.isSelected()) {
            prestaShop.click();
        }
    }

    @FindBy(xpath = ("//section[@id=\"checkout-payment-step\"]"))
    private WebElement paymentMethod;

    public void ClickPaymentMethod() {
        paymentMethod.click();

    }

    @FindBy(xpath = ("//input[@id='payment-option-1']"))
    private WebElement payByCheck;

    public void ClickPpayByCheck() {
        if (!payByCheck.isSelected()) {
            payByCheck.click();
        }
    }

    @FindBy(xpath = ("//input[@id=\"conditions_to_approve[terms-and-conditions]\"]"))
    private WebElement conditions;

    public void ClickConditions() {
        if (!conditions.isSelected()) {
            conditions.click();
        }
    }

    @FindBy(xpath = ("//button[@class=\"btn btn-primary center-block\"]"))
    private WebElement lastClick;

    public void ClickLastButton() {
        lastClick.click();
    }

    @FindBy(xpath = ("//dd"))
    private WebElement lastPriceOrder;

    public String  LastPrice() {
       return lastPriceOrder.getText().replace("€", "");
    }



    @FindBy(xpath = ("//span[@class='regular-price']"))
    private WebElement regularPrice;

    public String valueRegularPrice() {
        return regularPrice.getText().replace("€", "");
    }

    @FindBy(xpath = ("//span[@itemprop='price']"))
    private WebElement cuttingPrice;

    public String valueCuttingPrice() {
        return cuttingPrice.getText().replace("€", "");
    }

    @FindBy(xpath = ("//a[@class='account']"))
    private WebElement login;

    public void clickLogin() {
        login.click();
    }
    @FindBy(xpath = ("//a[@id='history-link']"))
    private WebElement history;

    public void clickHistory() {
            history.click();
    }
    @FindBy(xpath = ("//span[@class='label label-pill bright']"))
    private WebElement orderStatus;

    public String getOrderStatus() {
      return orderStatus.getText();
    }
    @FindBy(xpath = ("//td[@class='text-xs-right']"))
    private WebElement priceStatus;

    public String getActualPrice() {
      return priceStatus.getText().replace("€", "");
    }



}
