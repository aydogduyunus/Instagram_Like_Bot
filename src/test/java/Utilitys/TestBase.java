package Utilitys;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    /*
    TestBase class'indan object olusturmanin önüne gecmek icin bu class'i abstract yapabiliriz.
    TestBase testBase = new TestBase(); yani bu şekilde object olusturmanin onune gecmis oluruz.
    Bu class'a extends yaptigimiz test class'larindan ulasabiliriz.
     */
    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

    //HARD WAIT (Bekleme Methodu)
    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //acceptAlert methodu
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //dismissAlert methodu
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //gettextAlert methodu
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    //sendKeysAlert methodu
    public void sendKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }
    //DropDown Index
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    //DropDown Value
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    //DropDown Value'nin index'li hali. Kendim oluşturdum.
    public void selectValue2(WebElement ddm, int idx) {
        Select select = new Select(ddm);
        select.selectByIndex(idx);
    }

    //SwitchTo Window-1
    public void switchToWindow (int index)
    {
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));

    }

    //SwitchTo Window-2
    public void switchTowindow2(int index)
    {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());

    }

    public void visibleWait(WebElement element, int sayi){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}