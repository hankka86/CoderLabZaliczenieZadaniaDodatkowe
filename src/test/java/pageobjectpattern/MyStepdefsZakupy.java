package pageobjectpattern;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.Zakupy;
import pageobjects.LoginPage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class MyStepdefsZakupy {
    private static WebDriver driver;
    private String valCuttingPrice;

    @Given("^otwieramy przegladarke i logujemy sie na konto Antonio Banderasa$")
    public void otwieramyPrzegladarkeILogujemySieNaKontoAntonioBanderasa() {
        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("dtzkdklnudbgvvbzxt1@ttirv.org", "bardzotajnehaslo");
        // driver.get("https://prod-kurs.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s");

    }

    @When("^wybieramy sweter do zakupu$")
    public void wybieramySweterDoZakupu() {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.SearchSweater();
        zakupy.ClickProdukt();
        double doubleRegularPrice=Double.parseDouble(zakupy.valueRegularPrice());
        double doubleCuttingPrice=Double.parseDouble(zakupy.valueCuttingPrice());
        valCuttingPrice = zakupy.valueCuttingPrice();
        Assert.assertEquals((doubleRegularPrice * 0.8), doubleCuttingPrice, 0);
        //System.out.println(doubleRegularPrice+"   "+doubleCuttingPrice );


    }

    @Then("^wybieramy rozmiar \"([^\"]*)\"$")
    public void wybieramyRozmiar(String arg0)throws Throwable {
    Zakupy zakupy = new Zakupy(driver);
        zakupy.SetSize(arg0);

    }

    @Then("^wybieramy (\\d+) szt$")
    public void wybieramySzt(int arg0) {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.SetQuantity("5");
    }

    @Then("^dodajemy do koszyka$")
    public void dodajemyDoKoszyka() {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.ClickAddToCard();
        zakupy.ClickContinueShoping();
    }

    @Then("^przechodzimy do checkout$")
    public void przechodzimyDoCheckout() {

        Zakupy zakupy = new Zakupy(driver);
        zakupy.ClickContinueShoping();
    }

    @Then("^potwierdzamy adres$")
    public void potwierdzamyAdres() {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.ClickCorrectAddress();
    }

    @Then("^wybieramy metodę odbioru - PrestaShop \"([^\"]*)\"$")
    public void wybieramyMetodęOdbioruPrestaShop(String arg0) throws Throwable {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.ClickShippingMethod();
        zakupy.ClickPrestaShop();

    }

    @Then("^wybieramy metodę płatnosci \"([^\"]*)\"$")
    public void wybieramyMetodęPłatnosci(String arg0) throws Throwable {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.ClickPaymentMethod();
        zakupy.ClickPpayByCheck();
        zakupy.ClickConditions();

    }

    @Then("^klikamy w \"([^\"]*)\"$")
    public void klikamyW(String arg0) throws Throwable {
        Zakupy zakupy = new Zakupy(driver);
        valCuttingPrice=zakupy.LastPrice();
        zakupy.ClickLastButton();

    }

    @Then("^robimy screenshota$")
    public void robimyScreenshota() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String filename = now.format(formatter) + "-screenshot.png";
        try {
            FileUtils.copyFile(scrFile, new File("Hania_screenshots/" + filename));
        } catch (IOException e) {
            System.out.println("Nie ma screenshota");
            e.printStackTrace();
        }
    }

    @Then("^wchodzimy w historie zamówień i detale$")
    public void wchodzimyWHistorieZamówieńIDetale() {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.clickLogin();
        zakupy.clickHistory();
    }

    @Then("^sprawdzamy czy zamówienie ma status \"([^\"]*)\", oraz czy kwota sie zgadza$")
    public void sprawdzamyCzyZamówienieMaStatusOrazCzyKwotaSieZgadza(String arg0) throws Throwable {
        Zakupy zakupy = new Zakupy(driver);
        Assert.assertEquals("Awaiting check payment", zakupy.getOrderStatus());
        Assert.assertTrue(valCuttingPrice.contains(zakupy.getActualPrice()));

    }


    @And("^Zamykamy przeglądarkę$")
    public void zamykamyPrzeglądarkę() {
        driver.quit();
    }



}
