package Instagram;


import Utilitys.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class C01_instagramLikeBot extends TestBase {


    //1 - bot hesap ile giris yap
    //2 - ana sayfada instagram logosuna wait at
    //3 - arama butonuna gidecegimiz hesabi arat
    //4 - profile giris yap
    //5 - total post bilgisini al
    //6 - ilk sirada ki post'u tikla
    //7 - like butonuna bas ve right tusuna bas ( her post icin otomatize et )


    @Test
    public void test01() {

        //1)kullanici girisi yaptik
        driver.get("https://instagram.com");
        driver.findElement(By.xpath("//input[@name='username']")).
                sendKeys("enter your own account :) ", Keys.TAB, "enter your own account :) ", Keys.TAB, Keys.TAB, Keys.ENTER);



        //bildirimleri aç kutusunu kapat

        driver.findElement(By.xpath("//*[@class='_a9-- _a9_1']")).click();


        // giris bilgilerin kaydedilsin mi sorusuna simdi degili tikla

       // driver.findElement(By.xpath("//div[@class='x1i10hfl xjqpnuy xa49m3k xqeqjp1 x2hbi6w xdl72j9 x2lah0s xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r x2lwn1j xeuugli x1hl2dhg xggy1nq x1ja2u2z x1t137rt x1q0g3np x1lku1pv x1a2a7pz x6s0dn4 xjyslct x1ejq31n xd10rxx x1sy0etr x17r0tee x9f619 x1ypdohk x1i0vuye x1f6kntn xwhw2v2 xl56j7k x17ydfre x2b8uid xlyipyv x87ps6o x14atkfc x1d5wrs8 xjbqb8w xm3z3ea x1x8b98j x131883w x16mih1h x972fbf xcfux6l x1qhh985 xm0m39n xt0psk2 xt7dq6l xexx8yu x4uap5 x18d9i69 xkhd6sd x1n2onr6 x1n5bzlp x173jzuc x1yc6y37']")).click();

        bekle(2);



        //1- logo gorunene kadar beklet
        WebElement logo = driver.findElement(By.cssSelector("[aria-label='Instagram']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(logo));

        //2 - ana sayfada instagram logosununun gorunurlugunu test et
        Assert.assertTrue(logo.isDisplayed());

        //arama butonuna tıkla
        WebElement aramaButonu = driver.findElement(By.xpath("(//*[@class='x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft'])[2]"));
        aramaButonu.click();

        //arama metin kutucuguna aradıgımız kisiye gir
        driver.findElement(By.cssSelector("[aria-label='Arama Girdisi']")).sendKeys("ramozy53");

        bekle(2);

        driver.findElement(By.xpath("(//div[@class='x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1uhb9sk x1plvlek xryxfnj x1iyjqo2 x2lwn1j xeuugli xdt5ytf xqjyukv x1cy8zhl x1oa3qoh x1nhvcw1'])[1]")).click();

        //resimleri liste at

        WebElement ilkResim = driver.findElement(By.cssSelector("[class='_aagw']"));
        ilkResim.click();

        List<WebElement> resimList = driver.findElements(By.xpath("(//*[@tabindex='0'])[position()>17 and position()<35]"));

        for (int i = 0; i < resimList.size(); i++) {

            resimList = driver.findElements(By.xpath("(//*[@tabindex='0'])[position()>17 and position()<35]"));

            bekle(2);

            //begene tikla
            driver.findElement(By.xpath("(//*[@aria-label='Beğen'])[2]")).click();


            bekle(2);

            driver.findElement(By.cssSelector("[aria-label='İleri']")).click(); //yan resme git

        }













    }
}
